package impl;

import org.apache.rocketmq.common.message.MessageExt;
import zju.xyb.trade.common.rocketmq.MessageProcessor;

public class MessageProcessorImpl implements MessageProcessor {

    public boolean handleMessage(MessageExt msg) {
        System.out.println("QueueId: " + msg.getQueueId() + "---Offset: " + msg.getQueueOffset() +"---Text: " + new String(msg.getBody()));
        return true;
    }
}
