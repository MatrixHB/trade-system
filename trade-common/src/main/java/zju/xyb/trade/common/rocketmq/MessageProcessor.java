package zju.xyb.trade.common.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;

public interface MessageProcessor {

    /**
     * consumer处理消息
     * @param msg
     * @return
     */
    boolean handleMessage(MessageExt msg);
}
