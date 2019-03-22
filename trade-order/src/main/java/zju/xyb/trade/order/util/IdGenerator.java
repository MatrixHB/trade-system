package zju.xyb.trade.order.util;

import java.util.UUID;

public class IdGenerator {

    public static String generateOrderId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
