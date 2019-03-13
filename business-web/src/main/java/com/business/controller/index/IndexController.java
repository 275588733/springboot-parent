package com.business.controller.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author perth 〖bfcy_china@163.com〗
 * @Date 2019/3/13 19:00
 */
@RestController
public class IndexController {

    @GetMapping(value="/index")
    public String index(){
        return "hello word!";
    }
}
