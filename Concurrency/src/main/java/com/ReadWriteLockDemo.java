package com;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReadWriteLockDemo {

}
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();

}