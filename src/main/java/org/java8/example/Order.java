package org.java8.example;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

public class Order implements Comparable<Order>{
    public static int orderCounter;
    int orderId;
    int userId;
    double amount;
    Date timestamp;
    Order(int orderId, int userId,double amount,Date timestamp) {
        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public static Order get_order_snapshot() {
        int orderId = orderCounter;
        Random ran = new Random();
        orderCounter = orderCounter+1;
        int userId = 0 + ran.nextInt(100 - 0 + 1);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);


        double amount = new Double(df.format(ran.nextDouble() * 1000));
        long unixtime=(long) (1293861599+ran.nextDouble()*60*60*24*365*1000 + 49*60*60*24*365*1000L);
        Date timestamp = new Date(unixtime);
        return new Order(orderId, userId, amount, timestamp);
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return 0;
    }
}
