package com.ruoyi.demo.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DemoUpdateReqVo {
    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ID不能为空")
    private Long id;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "编码")
    private String code;
    @Schema(description = "类型")
    private String type;
    @Schema(description = "状态")
    private String status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "备注")
    private String remark;
}
