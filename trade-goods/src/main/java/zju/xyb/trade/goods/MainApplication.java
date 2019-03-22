package zju.xyb.trade.goods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zju.xyb.trade.goods.config.SpringConfig;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.start();

        //使程序处于运行状态
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
