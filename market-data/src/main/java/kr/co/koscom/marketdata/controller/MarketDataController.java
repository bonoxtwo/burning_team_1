package kr.co.koscom.marketdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MarketDataController {
	@RequestMapping("/MarketData")
	public String MarketData() {
		// TODO Auto-generated method stub
		return "MarketData";
	}

}
