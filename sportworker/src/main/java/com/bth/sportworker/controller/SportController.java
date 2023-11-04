package com.bth.sportworker.controller;

import com.bth.sportworker.dao.SportRepository;
import com.bth.sportworker.entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SportController {
    @Autowired
    private SportRepository sportRepo;

    @GetMapping("sports")
    public List<Sport> allSports(){
        return sportRepo.findAll();
    }

    @GetMapping("search/{name}")
    public List<Sport> allSports(@PathVariable String name){
        return sportRepo.findBySportName(name);
    }

    @PostMapping("add")
    public void addSport(@RequestBody Sport sport){
        sportRepo.save(sport);
    }
}
