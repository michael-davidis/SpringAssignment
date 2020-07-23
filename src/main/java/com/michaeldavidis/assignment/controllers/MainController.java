package com.michaeldavidis.assignment.controllers;

import com.michaeldavidis.assignment.models.Trainer;
import com.michaeldavidis.assignment.repos.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TrainerRepository trainerRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(ModelMap mm) {
        List<Trainer> trainerList = trainerRepository.findAll();

        mm.addAttribute("trainerList", trainerList);

        return "trainers";
    }


}
