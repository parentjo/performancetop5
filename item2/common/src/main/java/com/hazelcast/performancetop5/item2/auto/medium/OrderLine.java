package com.hazelcast.performancetop5.item2.auto.medium;

import java.io.Serializable;

public class OrderLine implements Serializable{
    @Faster
    public String product;
    public int amount;
}
