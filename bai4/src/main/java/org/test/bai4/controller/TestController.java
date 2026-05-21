package org.test.bai4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private org.test.bai4.service.TestService testService;

    @GetMapping("/test-error")
    public void trigger() {
        testService.findData();
    }
}
