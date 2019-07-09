package edu.bjtu.xxq.service;


import edu.bjtu.xxq.dao.RecommendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {
    @Autowired
    private RecommendDao recommendDao;

    public List<Integer> recommendByUser(int id, int count) {
        return recommendDao.recommendByUser(id, count);
    }

    public List<Integer> recommendByBook(int id, int count) {
        return recommendDao.recommendByBook(id, count);
    }
}
