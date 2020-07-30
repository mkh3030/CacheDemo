package com.example.cacheh2.domain;

import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<String, Object>{

    private final int maxsize;

    public LRUCache(int maxsize){
        super(maxsize, 0.75F, true);
        this.maxsize = maxsize;
    }

    //오래된 값 찾음
    public Object getEldestEntry(){
        if(this.size()==0){
            return null;
        }
        return this.entrySet().toArray()[this.size() - 1];
    }    

    @Override
    public boolean removeEldestEntry(java.util.Map.Entry eldest) {
        // TODO Auto-generated method stub
        return size()>maxsize;
    }
}