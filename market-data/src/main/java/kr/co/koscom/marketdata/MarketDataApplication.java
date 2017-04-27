package kr.co.koscom.marketdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"kr.co.koscom.marketdata.controller"})
@SpringBootApplication
@EnableAutoConfiguration
public class MarketDataApplication extends SpringBootServletInitializer{
	    public static void main(String[] args) {
	        SpringApplication.run(MarketDataApplication.class, args);
	    }
}
