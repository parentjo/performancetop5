package com.hazelcast.performancetop5.item2.auto.identifiedOpt;

import com.hazelcast.performancetop5.item2.auto.opt.Optimize;

import java.io.Serializable;

public class OrderLine implements Serializable{


    public int getFactoryId() {
        return OrderDataSerializableFactory.ID;
    }

    public int getId() {
        return OrderDataSerializableFactory.ORDERLINE_TYPE;
    }

    @Optimize
    public int amount;
    @Optimize
    public String product;
}
