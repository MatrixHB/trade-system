import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zju.xyb.trade.common.protocol.coupon.QueryCouponReq;
import zju.xyb.trade.common.protocol.coupon.QueryCouponRes;
import zju.xyb.trade.coupon.config.SpringConfig;
import zju.xyb.trade.dao.entity.TradeCoupon;
import zju.xyb.trade.dao.mapper.TradeCouponMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CouponServiceTest {

    @Autowired(required = false)
    TradeCouponMapper tradeCouponMapper;

    @Test
    public void queryCouponTest() {
        QueryCouponRes queryCouponRes = new QueryCouponRes();
        TradeCoupon tradeCoupon = tradeCouponMapper.selectByPrimaryKey("2080");
        BeanUtils.copyProperties(tradeCoupon, queryCouponRes);
        System.out.println(queryCouponRes.toString());
    }
}
