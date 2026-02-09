package com.ruoyi.demo.service;

import com.ruoyi.demo.vo.req.DemoCreateReqVo;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import com.ruoyi.demo.vo.req.DemoUpdateReqVo;
import com.ruoyi.demo.vo.res.DemoResVo;
import com.ruoyi.demo.vo.res.PageResVo;

public interface DemoService {
    DemoResVo getById(Long id);

    PageResVo<DemoResVo> page(DemoQueryReqVo query);

    Long create(DemoCreateReqVo reqVo);

    Boolean update(DemoUpdateReqVo reqVo);

    Boolean delete(Long id);
}
