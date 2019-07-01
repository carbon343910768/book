package com.bjtuxxq.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
//@RequestMapping(method=GET)
public class helloController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/hello")
    public String Hello(@RequestParam(value="name", defaultValue="World") String name){
        return "hello";
    }
}
