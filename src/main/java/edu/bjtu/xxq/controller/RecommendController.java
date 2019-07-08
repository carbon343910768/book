package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.service.RecommendService;
import edu.bjtu.xxq.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    private Gson gson = new Gson();

    @GetMapping(value = "/recommend", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String recommend(
            @RequestParam(value = "bookId", required = false) Integer bookId,
            @RequestParam(value = "count") int count
    ) {
        if (bookId == null) {
            Integer userId = UserUtil.getUserId();
            if (userId == null) userId = 1;
            return gson.toJson(recommendService.recommendByUser(userId, count));
        }
        return gson.toJson(recommendService.recommendByBook(bookId, count));
    }
}
