import config.springConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zju.xyb.trade.common.rocketmq.TradeMQConsumer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class TradeMQConsumerTest {

    @Autowired
    private TradeMQConsumer tradeMQConsumer;

    @Test
    public void consumeMsgTest() throws Exception {
        Thread.sleep(1000);
    }
}
