package pers.guzx.web.client;

import pers.guzx.web.properties.CustomProperties;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/3/30 15:14
 * @describe 用户实际操作的对象，相当于MongoTemplate，用于获取配置中的值
 */
public class CustomClient {

    private CustomProperties customProperties;

    public CustomClient(){}

    public CustomClient(CustomProperties customProperties){
        this.customProperties = customProperties;
    }

    public String getName(){
        return customProperties.getName();
    }
}
