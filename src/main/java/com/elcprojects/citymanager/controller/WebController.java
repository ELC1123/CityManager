package com.elcprojects.citymanager.controller;

import com.elcprojects.citymanager.domain.City;
import com.elcprojects.citymanager.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/delete-city/{id}")
    public String deleteCity(@PathVariable int id) {
        cityService.deleteCityById(id);
        return "redirect:/";
    }

    @GetMapping("/edit-city/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        City city = cityService.findCityById(id);
        model.addAttribute("city", city);
        return "add-city";
    }
}
