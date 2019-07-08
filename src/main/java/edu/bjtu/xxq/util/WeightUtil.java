package edu.bjtu.xxq.util;

public class WeightUtil {
    public static final int QUERY = 0;
    public static final int CART = 1;
    public static final int ORDER = 2;
    public static final int RATE = 3;
    public static final int QUERY_WEIGHT = 1;
    public static final int CART_WEIGHT = 3;
    public static final int ORDER_WEIGHT = 10;
    public static final int RATE_WEIGHT = 6;

    public static Integer weight(int action) {
        switch (action) {
            case QUERY:
                return QUERY_WEIGHT;
            case CART:
                return CART_WEIGHT;
            case ORDER:
                return ORDER_WEIGHT;
            case RATE:
                return RATE_WEIGHT;
            default:
                return null;
        }
    }
}
