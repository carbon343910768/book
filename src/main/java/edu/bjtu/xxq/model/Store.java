package edu.bjtu.xxq.model;

public class Store {
    private String storeName;
    private String storeId;
    private String storeOwner;
    private String storeContext;
    private Object goods;
    public Store(){}
    public Store(String storeContext,String storeId,String storeName ,String storeOwner,Object goods){
        this.storeContext = storeContext;
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeOwner = storeOwner;
        this.goods = goods;
    }

    public Object getGoods() {
        return goods;
    }

    public void setGoods(Object goods) {
        this.goods = goods;
    }

    public String getStoreContext() {
        return storeContext;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreContext(String storeContext) {
        this.storeContext = storeContext;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }
}
