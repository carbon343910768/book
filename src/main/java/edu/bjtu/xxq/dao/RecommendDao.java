package edu.bjtu.xxq.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendDao {

    List<Integer> recommendByUser(int id, int count);

    List<Integer> recommendByBook(int id, int count);
}
