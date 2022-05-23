package com.spring.AnimeList.controllers;

import com.spring.AnimeList.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // This Annotation makes the class a Spring Controller. This is different from @RestController
public class HomeController {

    @Autowired  // Annotation to access member variables and methods from a service class
    AnimeService animeService;

    @GetMapping("/")    // Call this method when / route is hit
    public String home(Model model) {
        System.out.println(animeService.getAnimeList());
        model.addAttribute("animeList", animeService.getAnimeList());
        return "home"; // This has to return the name of the view it wants to render
    }
}
