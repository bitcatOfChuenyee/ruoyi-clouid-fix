package com.ruoyi.demo.service;

import com.ruoyi.demo.dto.DemoDto;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import com.ruoyi.demo.vo.res.DemoResVo;
import com.ruoyi.demo.vo.res.PageResVo;

public interface DemoService {
    DemoResVo getById(Long id);

    PageResVo<DemoResVo> page(DemoQueryReqVo query);

    Long create(DemoDto dto);

    Boolean update(DemoDto dto);

    Boolean delete(Long id);
}
