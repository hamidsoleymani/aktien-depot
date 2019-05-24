package com.boostmedia.aktiendepot.controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@EnableAutoConfiguration
public class AktienController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
