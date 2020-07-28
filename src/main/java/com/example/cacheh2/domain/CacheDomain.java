package com.example.cacheh2.domain;

public class CacheDomain {

    private String key;
    private long time;
    private ProductDomain item;
    private int callCnt;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ProductDomain getItem() {
        return item;
    }

    public void setItem(ProductDomain item) {
        this.item = item;
    }
    public int getCallCnt() {
        return callCnt;
    }

    public void setCallCnt(int callCnt) {
        this.callCnt = callCnt;
    }

    @Override
    public String toString() {
        return "CacheDomain [callCnt=" + callCnt + ", item=" + item + ", key=" + key + ", time=" + time + "]";
    }

    

    
    
}