package com.hazelcast.performancetop5.item2.auto.medium;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Order implements Serializable {

    public long orderId;
    @Faster
    public Date date;
    @Faster
    public List<OrderLine> orderLines = new LinkedList<OrderLine>();

}
