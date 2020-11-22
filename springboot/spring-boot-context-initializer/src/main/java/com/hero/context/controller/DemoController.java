package com.hero.context.controller;

import com.hero.context.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: DemoController
 * @date: 2020/11/22
 * @author: bear
 * @version: 1.0
 */
@RestController
public class DemoController {
    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/property/get/{propertyName}")
    public String getPropertyValue(@PathVariable("propertyName") String propertyName) {
        return demoService.getProperty(propertyName);
    }
}
