package com.ruoyi.demo.service.impl;

import com.ruoyi.demo.domain.Demo;
import com.ruoyi.demo.mapper.DemoMapper;
import com.ruoyi.demo.service.DemoService;
import com.ruoyi.demo.vo.req.DemoCreateReqVo;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import com.ruoyi.demo.vo.req.DemoUpdateReqVo;
import com.ruoyi.demo.vo.res.DemoResVo;
import com.ruoyi.demo.vo.res.PageResVo;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    private final DemoMapper demoMapper;

    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    public DemoResVo getById(Long id) {
        LOGGER.info("查询详情开始, id={}", id);
        Demo demo = demoMapper.selectById(id);
        DemoResVo resVo = toResVo(demo);
        LOGGER.info("查询详情结束, id={}, resultFound={}", id, Objects.nonNull(resVo));
        return resVo;
    }

    @Override
    public PageResVo<DemoResVo> page(DemoQueryReqVo query) {
        LOGGER.info("分页查询开始, keyword={}, status={}, type={}, createTime={}, updateTime={}, pageNum={}, pageSize={}",
            query.getKeyword(), query.getStatus(), query.getType(), query.getCreateTime(), query.getUpdateTime(),
            query.getPageNum(), query.getPageSize());
        long total = demoMapper.selectCount(query);
        List<DemoResVo> records = demoMapper.selectList(query).stream()
            .map(this::toResVo)
            .collect(Collectors.toList());
        LOGGER.info("分页查询结束, total={}, size={}", total, records.size());
        return new PageResVo<>(total, records);
    }

    @Override
    public Long create(DemoCreateReqVo reqVo) {
        LOGGER.info("新增开始, name={}, code={}", reqVo.getName(), reqVo.getCode());
        Demo demo = toEntity(reqVo);
        demo.setDelFlag("0");
        int rows = demoMapper.insert(demo);
        if (rows <= 0) {
            LOGGER.error("新增失败, name={}, code={}", reqVo.getName(), reqVo.getCode());
            throw new IllegalStateException("新增失败");
        }
        LOGGER.info("新增成功, id={}", demo.getId());
        return demo.getId();
    }

    @Override
    public Boolean update(DemoUpdateReqVo reqVo) {
        LOGGER.info("更新开始, id={}", reqVo.getId());
        Demo demo = toEntity(reqVo);
        int rows = demoMapper.update(demo);
        if (rows <= 0) {
            LOGGER.error("更新失败, id={}", reqVo.getId());
            return Boolean.FALSE;
        }
        LOGGER.info("更新成功, id={}", reqVo.getId());
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Long id) {
        LOGGER.info("删除开始, id={}", id);
        int rows = demoMapper.deleteById(id);
        if (rows <= 0) {
            LOGGER.error("删除失败, id={}", id);
            return Boolean.FALSE;
        }
        LOGGER.info("删除成功, id={}", id);
        return Boolean.TRUE;
    }

    private Demo toEntity(DemoCreateReqVo reqVo) {
        Demo demo = new Demo();
        demo.setName(reqVo.getName());
        demo.setCode(reqVo.getCode());
        demo.setType(reqVo.getType());
        demo.setStatus(reqVo.getStatus());
        demo.setSort(reqVo.getSort());
        demo.setRemark(reqVo.getRemark());
        return demo;
    }

    private Demo toEntity(DemoUpdateReqVo reqVo) {
        Demo demo = new Demo();
        demo.setId(reqVo.getId());
        demo.setName(reqVo.getName());
        demo.setCode(reqVo.getCode());
        demo.setType(reqVo.getType());
        demo.setStatus(reqVo.getStatus());
        demo.setSort(reqVo.getSort());
        demo.setRemark(reqVo.getRemark());
        return demo;
    }

    private DemoResVo toResVo(Demo demo) {
        if (demo == null) {
            return null;
        }
        DemoResVo resVo = new DemoResVo();
        resVo.setId(demo.getId());
        resVo.setName(demo.getName());
        resVo.setCode(demo.getCode());
        resVo.setType(demo.getType());
        resVo.setStatus(demo.getStatus());
        resVo.setSort(demo.getSort());
        resVo.setRemark(demo.getRemark());
        resVo.setCreateTime(demo.getCreateTime());
        resVo.setUpdateTime(demo.getUpdateTime());
        return resVo;
    }
}
