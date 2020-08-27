import com.ypw.batis.core.config.YpwBatisConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test
    void name() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(YpwBatisConfig.class);
        Object bean = annotationConfigApplicationContext.getBean("com.ypw.batis.core.mapper.TestMapper");
        System.out.println(bean);
    }
}
