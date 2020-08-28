import com.ypw.batis.core.config.YpwBatisConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextTest {
    @Test
    public void name() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(YpwBatisConfig.class);
        Object o = annotationConfigApplicationContext.getBean("testMapper");
        System.out.println(o.getClass());
    }
}
