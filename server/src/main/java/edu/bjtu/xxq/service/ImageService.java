package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.ImageDao;
import edu.bjtu.xxq.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    public byte[] getImage(int id) {
        return imageDao.findImageById(id).getContent();
    }

    public int addImage(Image image){
        imageDao.addImage(image);
        return image.getId();
    }
}
