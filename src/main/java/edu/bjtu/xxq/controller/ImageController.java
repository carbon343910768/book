package edu.bjtu.xxq.controller;

import edu.bjtu.xxq.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/image")
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable("id") int id) {
        return imageService.getImage(id);
    }
}
