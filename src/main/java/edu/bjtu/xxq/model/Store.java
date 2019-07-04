package edu.bjtu.xxq.model;

public class Store {
    private String storeName;
    private String storeId;
    private String userId;
    private String storeContext;
    private Object goods;
    public Store(){}
    public Store(String storeContext,String storeId,String storeName ,String storeOwner,Object goods){
        this.storeContext = storeContext;
        this.storeId = storeId;
        this.storeName = storeName;
        this.userId = storeOwner;
        this.goods = goods;
    }

}
