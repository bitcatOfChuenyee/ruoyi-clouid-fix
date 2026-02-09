package com.ruoyi.demo.vo.res;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class PageResVo<T> {
    @Schema(description = "总数")
    private Long total;
    @Schema(description = "列表数据")
    private List<T> records;

    public PageResVo(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }
}
