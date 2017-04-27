package kr.co.koscom.marketdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MarketDataApplication {
	
	    public static void main(String[] args) {
	        SpringApplication.run(MarketDataApplication.class, args);
	    }
}
