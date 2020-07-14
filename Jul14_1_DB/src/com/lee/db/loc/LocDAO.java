package com.lee.db.loc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// �ѱ�ó��
//		Ŭ���̾�Ʈ -> GET -> ����(��)
//			 �ڵ�(Tomcat�� �˾Ƽ�)

//		Ŭ���̾�Ʈ -> POST -> ����(��)
//			request.setCharacterEncod ing("euc-kr);

//		�ڹ�
//			Ŭ���̾�Ʈ -GET-> ����
//				URLEncoder.encodeó���ؼ� ������
public class LocDAO {
	public static void search(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("euc-kr");

			
			// �ѱ��� ���ͳ� �ּҿ� �´� ���·�
			// Ŭ���̾�Ʈ�� �� ���ְ� euc-kr
			String what = request.getParameter("what");
			what = URLEncoder.encode(what, "utf-8");

			String s = "https://dapi.kakao.com/v2/local/search/keyword.json";
			s += "?query=" + what;
			s += "&x=127.023706&y=37.502369&radius=5000";
			s += "&sort=distance";

			URL u = new URL(s);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 00df1ed27f9258c68437812788bfbf96");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONArray d = (JSONArray) jo.get("documents");
			JSONObject l = null;
			
			ArrayList<Loc> locs = new ArrayList<Loc>();
			Loc loc = null;
			
			for (int i = 0; i < d.size(); i++) {
				l = (JSONObject) d.get(i);
				loc = new Loc();
				// �޼ҵ� get()�� return���� object�� Stringó�� ������Ѵ�.
				loc.setName(l.get("place_name") + "");
				loc.setDistance(l.get("distance") + "");
				loc.setAddress(l.get("road_address_name") + "");
				loc.setPhone(l.get("phone") + "");
				locs.add(loc);
			}
			request.setAttribute("locs", locs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
