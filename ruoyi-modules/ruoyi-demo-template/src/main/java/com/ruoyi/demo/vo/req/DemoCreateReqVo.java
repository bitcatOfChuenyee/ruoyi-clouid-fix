package com.ruoyi.demo.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DemoCreateReqVo {
    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "名称不能为空")
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
