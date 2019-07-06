package edu.bjtu.xxq.model;

public class Image {
    private int id;
    private byte[] content;

    public int getId() {
        return id;
    }

    public Image setId(int id) {
        this.id = id;
        return this;
    }

    public byte[] getContent() {
        return content;
    }

    public Image setContent(byte[] content) {
        this.content = content;
        return this;
    }
}
