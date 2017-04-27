package kr.co.koscom.marketdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"kr.co.koscom.marketdata.controller"})
public class MarketDataApplication {
	    public static void main(String[] args) {
	        SpringApplication.run(MarketDataApplication.class, args);
	    }
}
