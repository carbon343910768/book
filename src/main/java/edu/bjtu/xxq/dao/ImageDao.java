package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao {

    byte[] findImageById(int id);

    void addImage(Image image);
}
