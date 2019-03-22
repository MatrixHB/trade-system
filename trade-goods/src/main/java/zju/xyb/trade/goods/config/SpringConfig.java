package zju.xyb.trade.goods.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(value = {zju.xyb.trade.dao.config.SpringDaoConfig.class})
@ImportResource(value = {"classpath:dubbo-goods.xml"})
public class SpringConfig {

}
