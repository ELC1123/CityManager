package com.elcprojects.citymanager.controller;

import com.elcprojects.citymanager.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private final CityService cityService;

    public WebController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public String showCityList(Model model) {
        var cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }
}
