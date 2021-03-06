package simplewebcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import simplewebcrawler.CrawlerPort;
import simplewebcrawler.provides.Crawler;
import simplewebcrawler.validator.URLStringValidator;

import java.io.IOException;
import java.net.URL;

@RestController
public class CrawlerController {

    @Autowired
    private CrawlerPort crawlerPort;

    @Autowired
    private URLStringValidator urlStringValidator;

    @RequestMapping("/crawl")
    @ResponseBody
    public HttpEntity<Crawler> crawl(@RequestParam(value = "url") String url) throws IOException {
        if (!urlStringValidator.isValid(url)) {
            throw new IllegalStateException("");
        }
        Crawler crawler = crawlerPort.crawlURL(new URL(url));
        return new ResponseEntity<>(crawler, HttpStatus.OK);

    }
}
