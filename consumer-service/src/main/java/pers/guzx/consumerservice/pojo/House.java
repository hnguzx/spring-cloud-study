package pers.guzx.consumerservice.pojo;

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
public class House {
    private long id;
    private String provinces;
    private String city;
    private String area;
}
