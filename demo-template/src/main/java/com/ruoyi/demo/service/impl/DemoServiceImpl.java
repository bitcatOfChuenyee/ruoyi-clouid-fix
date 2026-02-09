package com.ruoyi.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.demo.domain.Demo;
import com.ruoyi.demo.dto.DemoDto;
import com.ruoyi.demo.mapper.DemoMapper;
import com.ruoyi.demo.service.DemoService;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import com.ruoyi.demo.vo.res.DemoResVo;
import com.ruoyi.demo.vo.res.PageResVo;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public DemoResVo getById(Long id) {
        LOGGER.info("查询详情开始, id={}", id);
        Demo demo = getBaseMapper().selectById(id);
        DemoResVo resVo = toResVo(demo);
        LOGGER.info("查询详情结束, id={}, resultFound={}", id, Objects.nonNull(resVo));
        return resVo;
    }

    @Override
    public PageResVo<DemoResVo> page(DemoQueryReqVo query) {
        LOGGER.info("分页查询开始, keyword={}, status={}, type={}, pageNum={}, pageSize={}",
            query.getKeyword(), query.getStatus(), query.getType(), query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<Demo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Demo::getDelFlag, "0");
        if (StringUtils.hasText(query.getStatus())) {
            wrapper.eq(Demo::getStatus, query.getStatus());
        }
        if (StringUtils.hasText(query.getType())) {
            wrapper.eq(Demo::getType, query.getType());
        }
        if (StringUtils.hasText(query.getKeyword())) {
            wrapper.and(condition -> condition
                .like(Demo::getName, query.getKeyword())
                .or()
                .like(Demo::getCode, query.getKeyword())
                .or()
                .like(Demo::getType, query.getKeyword()));
        }
        Page<Demo> page = new Page<>(query.getPageNum(), query.getPageSize());
        Page<Demo> result = getBaseMapper().selectPage(page, wrapper);
        List<DemoResVo> records = result.getRecords().stream()
            .map(this::toResVo)
            .collect(Collectors.toList());
        LOGGER.info("分页查询结束, total={}, size={}", result.getTotal(), records.size());
        return new PageResVo<>(result.getTotal(), records);
    }

    @Override
    public Long create(DemoDto dto) {
        LOGGER.info("新增开始, name={}, code={}", dto.getName(), dto.getCode());
        Demo demo = toEntity(dto);
        demo.setDelFlag("0");
        int rows = getBaseMapper().insert(demo);
        if (rows <= 0) {
            LOGGER.error("新增失败, name={}, code={}", dto.getName(), dto.getCode());
            throw new IllegalStateException("新增失败");
        }
        LOGGER.info("新增成功, id={}", demo.getId());
        return demo.getId();
    }

    @Override
    public Boolean update(DemoDto dto) {
        LOGGER.info("更新开始, id={}", dto.getId());
        Demo demo = toEntity(dto);
        int rows = getBaseMapper().updateById(demo);
        if (rows <= 0) {
            LOGGER.error("更新失败, id={}", dto.getId());
            return Boolean.FALSE;
        }
        LOGGER.info("更新成功, id={}", dto.getId());
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Long id) {
        LOGGER.info("删除开始, id={}", id);
        Demo demo = new Demo();
        demo.setId(id);
        demo.setDelFlag("2");
        int rows = getBaseMapper().updateById(demo);
        if (rows <= 0) {
            LOGGER.error("删除失败, id={}", id);
            return Boolean.FALSE;
        }
        LOGGER.info("删除成功, id={}", id);
        return Boolean.TRUE;
    }

    private Demo toEntity(DemoDto dto) {
        Demo demo = new Demo();
        demo.setId(dto.getId());
        demo.setName(dto.getName());
        demo.setCode(dto.getCode());
        demo.setType(dto.getType());
        demo.setStatus(dto.getStatus());
        demo.setSort(dto.getSort());
        demo.setRemark(dto.getRemark());
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
