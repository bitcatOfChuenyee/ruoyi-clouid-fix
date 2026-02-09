package com.ruoyi.demo.vo.req;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class DemoQueryReqVo {
    @Schema(description = "关键字(name/code/type)")
    @Parameter(description = "关键字(name/code/type)")
    private String keyword;
    @Schema(description = "状态")
    @Parameter(description = "状态")
    private String status;
    @Schema(description = "类型")
    @Parameter(description = "类型")
    private String type;
    @Schema(description = "创建时间")
    @Parameter(description = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Schema(description = "更新时间")
    @Parameter(description = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @Schema(description = "页码")
    @Parameter(description = "页码")
    private Integer pageNum = 1;
    @Schema(description = "每页大小")
    @Parameter(description = "每页大小")
    private Integer pageSize = 10;
}
