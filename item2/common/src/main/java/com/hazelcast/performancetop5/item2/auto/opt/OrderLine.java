package com.hazelcast.performancetop5.item2.auto.opt;

import java.io.Serializable;

public class OrderLine implements Serializable{
    @Optimize
    public int amount;
    @Optimize
    public String product;
}
