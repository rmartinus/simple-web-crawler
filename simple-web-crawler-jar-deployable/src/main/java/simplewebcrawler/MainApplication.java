package simplewebcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import simplewebcrawler.config.AdapterConfig;
import simplewebcrawler.config.CrawlerConfig;

@SpringBootApplication
@Import({ AdapterConfig.class, CrawlerConfig.class })
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
