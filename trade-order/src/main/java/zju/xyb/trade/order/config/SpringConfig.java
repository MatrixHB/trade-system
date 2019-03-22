package zju.xyb.trade.order.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "zju.xyb.trade.order")
@ImportResource(value = {"classpath:dubbo-order.xml"})
@Import(value = {zju.xyb.trade.dao.config.SpringDaoConfig.class})
public class SpringConfig {

}
