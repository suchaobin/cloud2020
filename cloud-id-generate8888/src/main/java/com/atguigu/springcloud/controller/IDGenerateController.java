package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.IDGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author suchaobin
 * @description id生成controller
 * @date 2020/12/21 23:14
 **/
@RestController
public class IDGenerateController {
    @Autowired
    private IDGenerateService idGenerateService;

    @RequestMapping("/generate/id/{num}")
    public CommonResult<List<Long>> generateIds(@PathVariable("num") int num) {
        List<Long> ids = idGenerateService.generateIds(num);
        return new CommonResult<>(200, "生成成功", ids);
    }
}
