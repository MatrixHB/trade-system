package zju.xyb.trade.common.rocketmq;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zju.xyb.trade.common.exception.TradeMQException;

public class TradeMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeMQConsumer.class);

    private String consumerGroupName;
    private String namesrvAddr;
    private String topic;
    private String tag = "*";

    private MessageProcessor messageProcessor;

    public void init() throws TradeMQException {

        // 校验字段合法性
        if (StringUtils.isBlank(this.consumerGroupName)) {
            throw new TradeMQException("ConsumerGroupName is Blank!");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new TradeMQException("NamesrvAddr for Consumer is Blank!");
        }
        if (StringUtils.isBlank(this.topic)) {
            throw new TradeMQException("Subscription Topic for Consumer is Blank!");
        }

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(this.consumerGroupName);
        consumer.setNamesrvAddr(this.namesrvAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        try {
            consumer.subscribe(this.topic, this.tag);
            TradeMessageListener listener = new TradeMessageListener();
            listener.setMessageProcessor(messageProcessor);
            consumer.registerMessageListener(listener);
            consumer.start();
            LOGGER.info("MQConsumer is Started. GroupName: {}. NamesrvAddr: {} ", this.consumerGroupName, this.namesrvAddr);
        } catch (MQClientException e) {
            LOGGER.error("MQConsumer Exception. GroupName: {}. NamesrvAddr: {} ", this.consumerGroupName, this.namesrvAddr);
            throw new TradeMQException();
        }
    }

    public void setConsumerGroupName(String consumerGroupName) {
        this.consumerGroupName = consumerGroupName;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setMessageProcessor(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }
}
