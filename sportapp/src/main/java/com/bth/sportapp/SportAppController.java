package com.bth.sportapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class SportAppController {

    RestTemplate restTemplate =  new RestTemplate();

    @Value("${WORKER_URI:http://localhost:8001/}")
    private String API_URL;

    @GetMapping("/index")
    public String homePage(){
        return "index";
    }

    @GetMapping("/search")
    public String showSearchPage(Sport sport){
        return "search-page";
    }

    @GetMapping("/add")
    public String showAddPage(Sport sport){
        return "add-sport";
    }

    @PostMapping("/insert")
    public String addSport(Sport sport, RedirectAttributes redirectAttributes, Model model){
        HttpEntity<Sport> request = new HttpEntity<>(sport);
        restTemplate.exchange(API_URL + "add", HttpMethod.POST, request, Sport.class);
        redirectAttributes.addFlashAttribute("successMessage", "Sport Added Successfully");
        return "redirect:/index";
    }

    @GetMapping("/showAll")
    public String showAll(Sport sport, Model model){
        ResponseEntity<Sport[]> response = restTemplate.getForEntity(API_URL + "sports", Sport[].class);
        List<Sport> sports = new ArrayList<>(List.of(Objects.requireNonNull(response.getBody())));
        if (sports.isEmpty()) {
            model.addAttribute("sports", null);
        } else {
            model.addAttribute("sports", sports);
        }
        return "show-sport";
    }

    @PostMapping("/search")
    public String showSearchPage(Sport sport, Model model){
        ResponseEntity<Sport[]> response = restTemplate.getForEntity(API_URL + "search/" + sport.getSportName(), Sport[].class);
        List<Sport> sports = new ArrayList<>(List.of(Objects.requireNonNull(response.getBody())));
        if (sports.isEmpty()) {
            model.addAttribute("sports", null);
        } else {
            model.addAttribute("sports", sports);
        }
        return "show-sport";
    }

}
