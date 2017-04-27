package kr.co.koscom.marketdata.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MarketDataController {
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView MarketData(){
		ModelMap model = new ModelMap();
		return new ModelAndView("MarketData", model);
	}
}