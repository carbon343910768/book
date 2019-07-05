package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Gson gson = new Gson();

    @RequestMapping("/test")
    public String test(@RequestParam("a[]") int[] a) {
        System.out.println(gson.toJson(a));
        return "test";
    }

}
