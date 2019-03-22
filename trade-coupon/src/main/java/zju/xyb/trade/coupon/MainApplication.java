package zju.xyb.trade.coupon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zju.xyb.trade.coupon.config.SpringConfig;
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
