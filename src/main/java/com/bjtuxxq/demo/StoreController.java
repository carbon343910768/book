package com.bjtuxxq.demo;

import com.bjtuxxq.demo.entity.Entity;
import com.bjtuxxq.demo.entity.RespCode;
import com.bjtuxxq.demo.entity.Store;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    /*
    我的商店
     */
    @RequestMapping("/myStore")
    public String myStore(@RequestParam("username") String username){
        Gson gson = new Gson();
        Store s = new Store();

        return gson.toJson(new Entity(RespCode.REGISTWARN_PASSWORD,s));

    }

}
