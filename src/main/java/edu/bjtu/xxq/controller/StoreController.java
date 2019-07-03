package edu.bjtu.xxq.controller;

import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.model.Store;
import com.google.gson.Gson;
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

        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,s));

    }

}
