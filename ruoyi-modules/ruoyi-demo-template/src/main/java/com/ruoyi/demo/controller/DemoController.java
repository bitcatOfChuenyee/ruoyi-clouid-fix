package com.ruoyi.demo.controller;

import com.ruoyi.demo.service.DemoService;
import com.ruoyi.demo.vo.req.DemoCreateReqVo;
import com.ruoyi.demo.vo.req.DemoQueryReqVo;
import com.ruoyi.demo.vo.req.DemoUpdateReqVo;
import com.ruoyi.demo.vo.res.DemoResVo;
import com.ruoyi.demo.vo.res.PageResVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Tag(name = "示例管理")
@RestController
@RequestMapping("/demo")
@Validated
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @Operation(summary = "分页查询")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermi('demo:demo:list')")
    public PageResVo<DemoResVo> page(
        @Parameter(description = "关键字(name/code/type)")
        @RequestParam(value = "keyword", required = false) String keyword,
        @Parameter(description = "状态")
        @RequestParam(value = "status", required = false) String status,
        @Parameter(description = "类型")
        @RequestParam(value = "type", required = false) String type,
        @Parameter(description = "创建时间")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @RequestParam(value = "create_time", required = false) Date createTime,
        @Parameter(description = "更新时间")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @RequestParam(value = "update_time", required = false) Date updateTime,
        @Parameter(description = "页码")
        @RequestParam(value = "page_num", required = false) Integer pageNum,
        @Parameter(description = "每页大小")
        @RequestParam(value = "page_size", required = false) Integer pageSize) {
        DemoQueryReqVo query = new DemoQueryReqVo();
        query.setKeyword(keyword);
        query.setStatus(status);
        query.setType(type);
        query.setCreateTime(createTime);
        query.setUpdateTime(updateTime);
        if (pageNum != null) {
            query.setPageNum(pageNum);
        }
        if (pageSize != null) {
            query.setPageSize(pageSize);
        }
        return demoService.page(query);
    }

    @Operation(summary = "查询详情")
    @GetMapping("/{id}")
    @PreAuthorize("@ss.hasPermi('demo:demo:query')")
    public DemoResVo detail(@Parameter(description = "主键ID") @PathVariable Long id) {
        return demoService.getById(id);
    }

    @Operation(summary = "新增")
    @PostMapping
    @PreAuthorize("@ss.hasPermi('demo:demo:add')")
    public Long create(@Valid @RequestBody DemoCreateReqVo reqVo) {
        return demoService.create(reqVo);
    }

    @Operation(summary = "更新")
    @PutMapping
    @PreAuthorize("@ss.hasPermi('demo:demo:edit')")
    public Boolean update(@Valid @RequestBody DemoUpdateReqVo reqVo) {
        return demoService.update(reqVo);
    }

    @Operation(summary = "删除")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermi('demo:demo:remove')")
    public Boolean delete(@Parameter(description = "主键ID") @PathVariable Long id) {
        return demoService.delete(id);
    }

}
