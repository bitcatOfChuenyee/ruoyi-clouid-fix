package com.ruoyi.demo.mapper;

import com.ruoyi.demo.domain.Demo;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
    Demo selectById(Long id);

    List<Demo> selectList(DemoQueryReqVo query);

    long selectCount(DemoQueryReqVo query);

    int insert(Demo demo);

    int update(Demo demo);

    int deleteById(Long id);
}
