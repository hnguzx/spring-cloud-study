package pers.guzx.ribbonnative.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pers.guzx.ribbonnative.pojo.House;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 14:08
 * @describe
 */
@RestController
@Slf4j
public class HouseController {

    @GetMapping("/houseData")
    public House getHouseInfo(@RequestParam("name") String name) {
        log.info("参数为：" + name);
        return new House(1L, "湖南省", "衡阳市", "耒阳市");
    }

    @GetMapping("/paramData/{name}")
    public String getParam(@PathVariable("name") String name) {
        return name;
    }

    @PostMapping("/saveHouse")
    public Long saveHouse(@RequestBody House house) {
        log.info(house.toString());
        return house.getId();
    }

    @DeleteMapping("/deleteHouse/{houseId}")
    public Long deleteHouse(@PathVariable("houseId") Long houseId) {
        log.info("要删除的house是：" + houseId);
        return houseId;
    }
}
