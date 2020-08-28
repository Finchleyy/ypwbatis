import com.ypw.batis.core.mapper.TestMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class AutoTest extends BaseTest {
    @Resource
    TestMapper testMapper;

    @Test
    public void getMapper() {
        String s = testMapper.selectTemp("1212");
        System.out.println(s);
    }
}
