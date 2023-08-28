package com.lld.inventry.locker.management.entity;

import com.lld.inventry.locker.management.enums.Size;

import java.util.List;
import java.util.Map;

public class System {
    Map<String, Locker> lockerMap;
    Map<String, Product> productMap;
    Map<Product, List<Item>> productItemMap;
    BasicStrategryToAddItemInLocker basicStrategryToAddItemInLocker;

    public Locker findLocker(Product product) {
        return null;
    }

    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public void addItem(Item item, Map<String, Locker> lockerMap) {
        basicStrategryToAddItemInLocker.addItemInLocker(item, lockerMap);
        productItemMap.get(item.getProduct()).add(item);
    }
}

class Locker {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private String id;
    private Size size;
    private Integer distance;
    private Item item;
}

class Product {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

}

class Item {
    private String id;
    private Size size;
    private Locker locker;
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

interface Strategy {
    public void addItemInLocker(Item item, Map<String, Locker> locker);
}

class BasicStrategryToAddItemInLocker implements Strategy {
    public void addItemInLocker(Item item, Map<String, Locker> lockerMap){
        Locker locker = findBestLocker(item.getSize(), lockerMap);
        locker.setItem(item);
        item.setLocker(locker);
    }

    Locker findBestLocker(Size size, Map<String, Locker> lockerMap) {
        return null;
    }
}