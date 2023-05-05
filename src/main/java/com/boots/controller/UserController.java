package com.boots.controller;

import com.boots.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    RegionService regionService;

    @GetMapping("/RegionTable")
    public String bossList(Model model) {
        model.addAttribute("allRegion", regionService.allRegion());
        return "RegionTable";
    }
}
