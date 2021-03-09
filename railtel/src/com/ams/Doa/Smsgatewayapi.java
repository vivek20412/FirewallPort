package com.ams.Doa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ams.bean.SmsLogs;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Smsgatewayapi {

	@Autowired
	Doa DoaId;

	@Autowired
	SmsLogs sms;

	public void sendmessage1(String otp, String mobileno) {
		try {
			Date mydate = new Date(System.currentTimeMillis());

			String message = "Dear%20RailTel%20Zimbra%20mail%20user%20%2C+" + otp
					+ "+%20is%20your%20OTP%20for%20Password%20Change%20request%20valid%20for%201%20minutes.%20Please%20do%20not%20share%20this%20OTP%20with%20anyone.";
			String data = "";
			data += "UserName=RailTel_DC_mail";
			data += "&password=389285"; // your loginId
			data += "&MobileNo=+" + mobileno + "";
			data += "&SenderID=Railwr";
			data += "&CDMAHeader=RailTel_DC_mail";
			data += "&Message=+" + message + "";

			URL url = new URL("http://hapi.smsapi.org/SendSMS.aspx?" + URLEncoder.encode(data, "UTF-8"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Cookie", "ASP.NET_SessionId=kxiogtkp2mzqcxu1nxplw2qh");

			conn.connect();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				buffer.append(line).append("\n");

			}
			System.out.println(buffer.toString());
			rd.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendmessage(String otp, String mobile) {

		String message = "Dear%20RailTel%20Zimbra%20mail%20user%20%2C+" + otp
				+ "+%20is%20your%20OTP%20for%20Password%20Change%20request%20valid%20for%201%20minutes.%20Please%20do%20not%20share%20this%20OTP%20with%20anyone.";
		String data = "";
		data += "UserName=RailTel_DC_mail";
		data += "&password=389285"; // your loginId
		data += "&MobileNo=+" + mobile + "";
		data += "&SenderID=Railwr";
		data += "&CDMAHeader=RailTel_DC_mail";
		data += "&Message=+" + message + "";

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder().url("http://hapi.smsapi.org/SendSMS.aspx?" + data).method("GET", null)
				.addHeader("Cookie", "ASP.NET_SessionId=kxiogtkp2mzqcxu1nxplw2qh").build();
		try {
			Response response = client.newCall(request).execute();
			String res = response.body().string();
			String[] resgui = res.split(" ");

			System.out.println(resgui[1].toString());
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
