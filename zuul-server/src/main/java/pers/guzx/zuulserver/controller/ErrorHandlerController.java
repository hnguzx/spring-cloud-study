package pers.guzx.zuulserver.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import pers.guzx.zuulserver.base.ResponseCode;
import pers.guzx.zuulserver.base.ResponseData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/14 16:52
 * @describe
 */
@RestController
public class ErrorHandlerController implements ErrorController {

    @Resource
    private ErrorAttributes errorAttributes;


    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ResponseData error(HttpServletRequest request){
        Map<String,Object> errorAttributes = getErrorAttributes(request);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if (StringUtils.isNotBlank(trace)){
            message+=String.format(" and trace %s",trace);
        }
        return ResponseData.fail(message, ResponseCode.SERVER_ERROR_CODE.getCode());
    }

    private Map<String,Object> getErrorAttributes(HttpServletRequest request){
        return errorAttributes.getErrorAttributes(new ServletWebRequest(request),true);
    }
}
