package kr.co.koscom.marketdata.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MarketDataController {
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView MarketData() throws IOException, Exception{
		ModelMap model = new ModelMap();
		JSONArray moneylist = new JSONArray();
		JSONObject json = new JSONObject();
		
		/*  주식 시세 /{marketcode}/lists api 호출  */
		String listUrl = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/lists".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8"));
	    String jsList = GetApi(listUrl);
	    JSONObject jsonObject1 = new JSONObject(jsList);
        model.addAttribute("marketList", jsonObject1.get("isuLists"));

        /*  주식 시세 /{marketcode}/{issuecode}/price api 호출  */
        JSONObject jsonObject2=null;
        org.json.JSONArray arrList = jsonObject1.getJSONArray("isuLists");
        for (int i = 0; i < 30; i++)
        {
            String issuecode = arrList.getJSONObject(i).getString("isuSrtCd");
            String priceList = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")).replace("{issuecode}", URLEncoder.encode(issuecode, "UTF-8"));
            String jsPrice = GetApi(priceList);
            jsonObject2 = new JSONObject(jsPrice);
            moneylist.put(jsonObject2.getJSONObject("result"));
        }
        json.put("priceList",moneylist);
        String st=json.toString();
        model.addAttribute("priceList", json.getJSONArray("priceList"));
        
        
        return new ModelAndView("MarketData", model);
	}
	
	//API 호출 메소드
	String GetApi(String link) throws IOException, Exception{
		 StringBuilder urlBuilder = new StringBuilder(link);
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("apikey", "l7xx4095939d6b2647d08567d7b4218e9ba8");
	       // System.out.println("Response code: " + conn.getResponseCode());
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