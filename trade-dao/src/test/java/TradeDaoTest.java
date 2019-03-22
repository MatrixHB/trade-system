import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zju.xyb.trade.dao.config.SpringDaoConfig;
import zju.xyb.trade.dao.entity.TradeUser;
import zju.xyb.trade.dao.entity.TradeUserExample;
import zju.xyb.trade.dao.mapper.TradeUserMapper;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDaoConfig.class)
public class TradeDaoTest {

//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;

    @Autowired(required = false)
    private TradeUserMapper tradeUserMapper;

//    @Test
    public void insertUserTest() {
//        SqlSession session = sqlSessionFactory.openSession();
//        TradeUserMapper tradeUserMapper = session.getMapper(TradeUserMapper.class);
        TradeUser user = new TradeUser();
        user.setUserId(9000);
        user.setUserName("诚实的老王");
        user.setUserBalance(new BigDecimal(10000));
        user.setUserScore(100);
        user.setUserContact("18901237129");
        tradeUserMapper.insertSelective(user);
    }

    @Test
    public void selectUserByExampleTest() {
//        SqlSession session = sqlSessionFactory.openSession();
//        TradeUserMapper tradeUserMapper = session.getMapper(TradeUserMapper.class);
        TradeUserExample tradeUserExample = new TradeUserExample();
        TradeUserExample.Criteria criteria = tradeUserExample.createCriteria();
        criteria.andUserBalanceGreaterThan(new BigDecimal(9000));
        List<TradeUser> results = tradeUserMapper.selectByExample(tradeUserExample);
        for (TradeUser tradeUser : results) {
            System.out.println(tradeUser.toString());
        }
    }

}
