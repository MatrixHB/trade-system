package zju.xyb.trade.user.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"zju.xyb.trade.user"})
@Import(value= {zju.xyb.trade.dao.config.SpringDaoConfig.class})
public class SpringMvcConfig {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.jsp");
    }
}
