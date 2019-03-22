import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zju.xyb.trade.common.protocol.order.ConfirmOrderReq;
import zju.xyb.trade.common.protocol.order.ConfirmOrderRes;
import zju.xyb.trade.order.config.SpringConfig;
import zju.xyb.trade.order.service.OrderServiceImpl;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OrderServiceTest {

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void confirmOrderTest() {
        ConfirmOrderReq confirmOrderReq = new ConfirmOrderReq();
        confirmOrderReq.setGoodsId("10086");
        confirmOrderReq.setUserId(9000);
        confirmOrderReq.setGoodsPrice(new BigDecimal(20));
        confirmOrderReq.setGoodsNum(10);
        confirmOrderReq.setAddress("广东省某个角落");
        confirmOrderReq.setConsignee("张先生");
        confirmOrderReq.setCouponId("2080");
        ConfirmOrderRes confirmOrderRes = orderService.confirmOrder(confirmOrderReq);
    }
}
