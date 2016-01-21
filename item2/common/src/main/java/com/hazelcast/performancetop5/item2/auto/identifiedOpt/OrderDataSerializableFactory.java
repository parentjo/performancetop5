package com.hazelcast.performancetop5.item2.auto.identifiedOpt;

import com.hazelcast.nio.serialization.DataSerializableFactory;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;

public class OrderDataSerializableFactory implements DataSerializableFactory {

    public static final int ID = 1;

    public static final int ORDER_TYPE = 1;
    public static final int ORDERLINE_TYPE = 2;

    @Override
    public IdentifiedDataSerializable create(int typeId) {
        switch (typeId) {
            case ORDER_TYPE:
                return (IdentifiedDataSerializable) new Order();
            case ORDERLINE_TYPE:
                return (IdentifiedDataSerializable) new OrderLine();
            default:
                return null;
        }
    }
}