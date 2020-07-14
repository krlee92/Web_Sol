package com.lee.db.weather;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// DB���� select�ؿ� ���
// ArrayList<DTO>�� ����
// attribute�� ���
public class WeatherDAO {
	public static void getWeather(HttpServletRequest request) {
		// �ֿܼ� ���

		try {
			String addr = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2818585000";
			URL u = new URL(addr);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream(); // import java.io

			// XML(eXtended Markup Language)
			// �����͸� HTML������� ǥ���س�����
			// <hour> : �����±�
			// ���� : �ؽ�Ʈ
			// </temp> : �����±�

			// �޾ƿ� ������ ����/���� => parsing
			// ���û ������ ���� : XML => XML Parsing
			// XML Parsing : �⺻ JAVA�� ����
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			// �� AL
			ArrayList<Weather> weathers = new ArrayList<Weather>();
			// �ӽú��� w
			Weather w = null;

			String tagName = null;
			int what = xpp.getEventType(); // ���� ���� �ִ°� ����?
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					// System.out.println(xpp.getName()); //�±׸� ����
					tagName = xpp.getName();
					if (tagName.equals("data")) { // <data seq="?">
						w = new Weather(); // ���ο� ���� ��ü ����
					}
				} else if (what == XmlPullParser.TEXT) {
					// System.out.println(xpp.getText()); //�±׸��� �˸��� ����
					if (tagName.equals("hour")) {
						w.setHour("~" + xpp.getText() + "�� ����");
//						System.out.println("~" + xpp.getText() + "�� ����"); // �ð��� �ߴ°�
					} else if (tagName.equals("temp")) {
						w.setTemp(xpp.getText() + "��");
//						System.out.println(xpp.getText() + "");
					} else if (tagName.equals("wfKor")) {
						w.setWeather(xpp.getText());
//						System.out.println(xpp.getText());
//						System.out.println("------");
						if (w.getWeather().equals("����")) {
							w.setImg("sun.gif");
						} else if (w.getWeather().contains("����") || w.getWeather().equals("�帲")) {
							w.setImg("cloud.png");
						} else if (w.getWeather().contains("��") || w.getWeather().contains("�ҳ���")
								|| w.getWeather().contains("��")) {
							w.setImg("rain.png");
						} else {
							w.setWeather("snow.png");
						}
					}
					

				} else if (what == XmlPullParser.END_TAG) { // </>�����͵�
					// System.out.println(xpp.getName()); // /���� ���ڸ� ����
					// --------XML�Ľ� �⺻����
					tagName = "";
					if(xpp.getName().equals("data")) { //</data>
						// �Ӽ����� �� ���õǾ����� w�� AL�� �߰�
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
