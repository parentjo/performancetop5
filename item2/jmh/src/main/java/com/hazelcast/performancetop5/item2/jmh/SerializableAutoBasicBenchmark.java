package com.hazelcast.performancetop5.item2.jmh;


import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.performancetop5.item2.auto.basic.Order;
import com.hazelcast.performancetop5.item2.auto.basic.OrderLine;
import org.openjdk.jmh.annotations.*;

import java.util.Date;
import java.util.Random;

@State(value = Scope.Thread)
@OperationsPerInvocation(SerializableAutoBasicBenchmark.OPERATIONS_PER_INVOCATION)
public class SerializableAutoBasicBenchmark {
    public static final int OPERATIONS_PER_INVOCATION = 500000;

    private HazelcastInstance hz;
    private IMap<Object, Object> orderMap;
    private int maxOrders = 100 * 1000;
    private int maxOrderLines = 5;
    private String[] products;

    @Setup
    public void setUp() {
        Config config = new Config();
      //  config.getSerializationConfig().setAllowUnsafe(true).setUseNativeByteOrder(true);
        hz = Hazelcast.newHazelcastInstance(config);
        orderMap = hz.getMap("orders");
        products = new String[100];
        for (int k = 0; k < 100; k++) {
            products[k] = "product-" + k;
        }

        Random random = new Random();
        for (int k = 0; k < maxOrders; k++) {
            Order order = createNewOrder(random);
            orderMap.put(order.orderId, order);
        }
    }

    @TearDown
    public void tearDown() {
        Hazelcast.shutdownAll();
    }

    @GenerateMicroBenchmark
    public void writePerformance() {
        Random random = new Random();
        for (int k = 0; k < OPERATIONS_PER_INVOCATION; k++) {
            Order order = createNewOrder(random);
            orderMap.set(order.orderId, order);
        }
    }

    @GenerateMicroBenchmark
    public void readPerformance() {
        Random random = new Random();
        for (int k = 0; k < OPERATIONS_PER_INVOCATION; k++) {
            long orderId = random.nextInt(maxOrders);
            orderMap.get(orderId);
        }
    }

    private Order createNewOrder(Random random) {
        Order order = new Order();
        order.orderId = random.nextInt(maxOrders);
        order.date = new Date();

        int orderlineCount = random.nextInt(maxOrderLines);
        for (int k = 0; k < orderlineCount; k++) {
            OrderLine orderLine = new OrderLine();
            orderLine.amount = random.nextInt(100);
            orderLine.product = products[random.nextInt(products.length)];
            order.orderLines.add(orderLine);
        }

        return order;
    }
}
