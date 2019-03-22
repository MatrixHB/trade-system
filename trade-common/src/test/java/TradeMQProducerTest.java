
import config.springConfig;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zju.xyb.trade.common.exception.TradeMQException;
import zju.xyb.trade.common.rocketmq.TradeMQProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class TradeMQProducerTest {

    @Autowired
    private TradeMQProducer tradeMQProducer;

    @Test
    public void sendMsgTest() throws TradeMQException {
        String text = "this is a test for trade system MQProducer! ";
        SendResult sendResult = tradeMQProducer.sendMsg("TopicTest", "tagA", "keyA", text);
        System.out.println(sendResult);
    }
}
