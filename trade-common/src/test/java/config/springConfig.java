package config;

import impl.MessageProcessorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zju.xyb.trade.common.rocketmq.TradeMQConsumer;
import zju.xyb.trade.common.rocketmq.TradeMQProducer;

@Configuration
public class springConfig {

    @Bean(initMethod="init")
    public TradeMQProducer tradeMQProducer() {
        TradeMQProducer tradeMQProducer = new TradeMQProducer();
        tradeMQProducer.setProducerGroupName("trade_test_producer_group");
        tradeMQProducer.setNamesrvAddr("10.15.194.44:9876");
        return tradeMQProducer;
    }

    @Bean(initMethod = "init")
    public TradeMQConsumer tradeMQConsumer() {
        TradeMQConsumer tradeMQConsumer = new TradeMQConsumer();
        tradeMQConsumer.setConsumerGroupName("trade_test_consumer_group");
        tradeMQConsumer.setNamesrvAddr("10.15.194.44:9876");
        tradeMQConsumer.setTopic("TopicTest");
        tradeMQConsumer.setMessageProcessor(new MessageProcessorImpl());
        return tradeMQConsumer;
    }
}
