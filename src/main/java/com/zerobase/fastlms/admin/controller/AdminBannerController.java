package com.zerobase.fastlms.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AdminBannerController {


    @GetMapping("/admin/main/banner/list.do")
    public String banner() {
        return "/admin/banner/list";
    }

}
