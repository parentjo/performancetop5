package com.hazelcast.performancetop5.item2.auto.identifiedOpt;

import com.hazelcast.performancetop5.item2.auto.opt.Optimize;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Order implements Serializable {

    public int getFactoryId() {
        return OrderDataSerializableFactory.ID;
    }

    public int getId() {
        return OrderDataSerializableFactory.ORDER_TYPE;
    }


    public long orderId;
    @Optimize
    public List<OrderLine> orderLines = new LinkedList<OrderLine>();
    @Optimize
    public Date date;

}
