package com.elcprojects.citymanager.controller;

import com.elcprojects.citymanager.domain.City;
import com.elcprojects.citymanager.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/add-city")
    public String showAddCityForm(Model model) {
        model.addAttribute("city", new City());
        return "add-city";
    }

    @PostMapping("/save-city")
    public String saveCity(@ModelAttribute City city) {
        cityService.saveCity(city);
        return "redirect:/";
    }
}
