package pers.guzx.clientservice.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 14:06
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "pers.guzx.clientservice.pojo.House",description = "房子")
public class House {
    @ApiModelProperty(value = "ID")
    private long id;
    @ApiModelProperty(value = "省份")
    private String provinces;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "地区")
    private String area;
}
