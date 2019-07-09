package edu.bjtu.xxq.model;

public class Store {
    private String storeName;
    private String storeId;
    private String userId;
    private String storeContent;
    private Object goods;
    public Store(){}
    public Store(String storeContent,String storeId,String storeName ,String storeOwner,Object goods){
        this.storeContent = storeContent;
        this.storeId = storeId;
        this.storeName = storeName;
        this.userId = storeOwner;
        this.goods = goods;
    }

}
