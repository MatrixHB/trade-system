package zju.xyb.trade.common.rocketmq;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zju.xyb.trade.common.exception.TradeMQException;

public class TradeMQProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeMQProducer.class);

    private DefaultMQProducer producer;

    private String producerGroupName;

    private String namesrvAddr;

    public void init() throws TradeMQException {
        // 校验字段合法性
        if (StringUtils.isBlank(this.producerGroupName)) {
            throw new TradeMQException("ProducerGroupName is Blank!");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new TradeMQException("NamesrvAddr for Producer is Blank!");
        }

        this.producer = new DefaultMQProducer(this.producerGroupName);
        this.producer.setNamesrvAddr(this.namesrvAddr);
        try {
            this.producer.start();
            LOGGER.info("MQProducer is Started. GroupName: {}. NamesrvAddr: {} ", this.producerGroupName, this.namesrvAddr);
        } catch (MQClientException e) {
            LOGGER.error("MQProducer Exception. GroupName: {}. NamesrvAddr: {} ", this.producerGroupName, this.namesrvAddr);
            throw new TradeMQException();
        }
    }

    public SendResult sendMsg(String topic, String tag, String key, String text) throws TradeMQException {
        // topic和消息ID不能为空
        if (StringUtils.isBlank(topic)) {
            throw new TradeMQException("The topic of message is Blank!");
        }
        if (StringUtils.isBlank(key)) {
            throw new TradeMQException("The key of message is Blank!");
        }

        Message msg = new Message(topic, tag, key, text.getBytes());
        try {
            SendResult sendResult = this.producer.send(msg);
            return sendResult;
        } catch (Exception e) {
            LOGGER.error("MQProducer Send Message Failed: ", e);
            throw new TradeMQException();
        }
    }

    public void setProducerGroupName(String producerGroupName) {
        this.producerGroupName = producerGroupName;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }
}
