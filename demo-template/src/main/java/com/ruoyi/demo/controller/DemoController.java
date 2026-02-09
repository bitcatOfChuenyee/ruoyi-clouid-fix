package com.ruoyi.demo.controller;

import com.ruoyi.demo.dto.DemoDto;
import com.ruoyi.demo.service.DemoService;
import com.ruoyi.demo.vo.req.DemoCreateReqVo;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import com.ruoyi.demo.vo.req.DemoUpdateReqVo;
import com.ruoyi.demo.vo.res.DemoResVo;
import com.ruoyi.demo.vo.res.PageResVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "示例管理")
@RestController
@RequestMapping("/demo")
@Validated
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public PageResVo<DemoResVo> page(DemoQueryReqVo query) {
        return demoService.page(query);
    }

    @ApiOperation("查询详情")
    @GetMapping("/{id}")
    public DemoResVo detail(@PathVariable Long id) {
        return demoService.getById(id);
    }

    @ApiOperation("新增")
    @PostMapping
    public Long create(@Valid @RequestBody DemoCreateReqVo reqVo) {
        return demoService.create(toDto(reqVo));
    }

    @ApiOperation("更新")
    @PutMapping
    public Boolean update(@Valid @RequestBody DemoUpdateReqVo reqVo) {
        return demoService.update(toDto(reqVo));
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return demoService.delete(id);
    }

    private DemoDto toDto(DemoCreateReqVo reqVo) {
        DemoDto dto = new DemoDto();
        dto.setName(reqVo.getName());
        dto.setCode(reqVo.getCode());
        dto.setType(reqVo.getType());
        dto.setStatus(reqVo.getStatus());
        dto.setSort(reqVo.getSort());
        dto.setRemark(reqVo.getRemark());
        return dto;
    }

    private DemoDto toDto(DemoUpdateReqVo reqVo) {
        DemoDto dto = new DemoDto();
        dto.setId(reqVo.getId());
        dto.setName(reqVo.getName());
        dto.setCode(reqVo.getCode());
        dto.setType(reqVo.getType());
        dto.setStatus(reqVo.getStatus());
        dto.setSort(reqVo.getSort());
        dto.setRemark(reqVo.getRemark());
        return dto;
    }
}
