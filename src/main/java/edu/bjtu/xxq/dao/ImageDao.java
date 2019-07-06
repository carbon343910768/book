package edu.bjtu.xxq.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao {

    byte[] findImageById(int id);

    // 生成image自增id
    int addImage(byte[] content);
}
