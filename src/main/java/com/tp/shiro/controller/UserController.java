package com.tp.shiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public Map<String, Object> greeting() {
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        jsonObject.put("hello", "world");
        return jsonObject;
    }

}
