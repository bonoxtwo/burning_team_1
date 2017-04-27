package kr.co.koscom.marketdata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MarketDataController {
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView MarketData() throws IOException, Exception{
	    String js = GetApi();
	    JSONObject jsonObject = new JSONObject(js);
        ModelMap model = new ModelMap();
        model.addAttribute("marketList", jsonObject.get("isuLists"));
        return new ModelAndView("MarketData", model);
	}
	
	String GetApi() throws IOException, Exception{
		 StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/lists".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")));
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("apikey", "l7xx4095939d6b2647d08567d7b4218e9ba8");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        return sb.toString();
	}
}