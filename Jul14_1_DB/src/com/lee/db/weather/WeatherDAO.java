package com.lee.db.weather;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// DB에서 select해온 결과
// ArrayList<DTO>로 만들어서
// attribute로 출력
public class WeatherDAO {
	public static void getWeather(HttpServletRequest request) {
		// 콘솔에 출력

		try {
			String addr = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2818585000";
			URL u = new URL(addr);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream(); // import java.io

			// XML(eXtended Markup Language)
			// 데이터를 HTML모양으로 표현해놓은거
			// <hour> : 시작태그
			// 맑음 : 텍스트
			// </temp> : 종료태그

			// 받아온 데이터 가공/정리 => parsing
			// 기상청 데이터 형식 : XML => XML Parsing
			// XML Parsing : 기본 JAVA에 없음
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			// 빈 AL
			ArrayList<Weather> weathers = new ArrayList<Weather>();
			// 임시변수 w
			Weather w = null;

			String tagName = null;
			int what = xpp.getEventType(); // 현재 보고 있는게 뭐임?
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					// System.out.println(xpp.getName()); //태그명만 띄우기
					tagName = xpp.getName();
					if (tagName.equals("data")) { // <data seq="?">
						w = new Weather(); // 새로운 날씨 객체 생성
					}
				} else if (what == XmlPullParser.TEXT) {
					// System.out.println(xpp.getText()); //태그말고 알맹이 띄우기
					if (tagName.equals("hour")) {
						w.setHour("~" + xpp.getText() + "시 까지");
//						System.out.println("~" + xpp.getText() + "시 까지"); // 시간만 뜨는것
					} else if (tagName.equals("temp")) {
						w.setTemp(xpp.getText() + "℃");
//						System.out.println(xpp.getText() + "");
					} else if (tagName.equals("wfKor")) {
						w.setWeather(xpp.getText());
//						System.out.println(xpp.getText());
//						System.out.println("------");
						if (w.getWeather().equals("맑음")) {
							w.setImg("sun.gif");
						} else if (w.getWeather().contains("구름") || w.getWeather().equals("흐림")) {
							w.setImg("cloud.png");
						} else if (w.getWeather().contains("비") || w.getWeather().contains("소나기")
								|| w.getWeather().contains("우")) {
							w.setImg("rain.png");
						} else {
							w.setWeather("snow.png");
						}
					}
					

				} else if (what == XmlPullParser.END_TAG) { // </>붙은것들
					// System.out.println(xpp.getName()); // /빼고 글자만 나옴
					// --------XML파싱 기본패턴
					tagName = "";
					if(xpp.getName().equals("data")) { //</data>
						// 속성값이 다 세팅되어있을 w를 AL에 추가
						weathers.add(w);
					}
				}
				xpp.next();
				what = xpp.getEventType();
			}
			 
			request.setAttribute("weathers", weathers);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
