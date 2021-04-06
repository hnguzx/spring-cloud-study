package pers.guzx.consumerservice.utils;

import feign.Feign;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/6 16:09
 * @describe
 */
public class RestApiCallUtils {

    public static <T> T getRestClient(Class<T> apiType, String url) {
        return Feign.builder().target(apiType, url);
    }
}
