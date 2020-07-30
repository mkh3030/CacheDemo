package com.example.cacheh2;

import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<String, Object>{


    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<String, Object> eldest) {
        // TODO Auto-generated method stub
        return super.removeEldestEntry(eldest);
    }
    
}