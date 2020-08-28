package com.ypw.batis.core.mapper;

import com.ypw.batis.core.annotation.YpwSql;

/**
 * @author yupengwu
 */
public interface TestMapper {
    @YpwSql(sql = "select * from tb")
    String selectTemp(String source);
}
