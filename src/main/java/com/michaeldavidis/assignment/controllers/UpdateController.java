package com.michaeldavidis.assignment.controllers;


import com.michaeldavidis.assignment.models.Trainer;
import com.michaeldavidis.assignment.repos.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import javax.validation.Valid;

@Controller
public class UpdateController {

    @Autowired
    TrainerRepository trainerRepository;

    @GetMapping("update")
    public String updateTrainer(ModelMap mm, @RequestParam Long id) {

        Trainer trainer = trainerRepository.getOne(id);
        mm.addAttribute("id", trainer.getId());
        mm.addAttribute("firstName", trainer.getFirstName());
        mm.addAttribute("lastName", trainer.getLastName());
        mm.addAttribute("subject", trainer.getSubject());
        return "updateTrainer";
    }

    @PostMapping("doUpdate")
    public ModelAndView doUpdate(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String subject, ModelMap mm) {

        if (lastName.isEmpty() || lastName.length() < 3 || hasLetters(lastName)) {
            mm.addAttribute("invalidInputMessage", "INVALID SURNAME REGISTRATION");
            return (new ModelAndView("send:/error"));
        } else if (firstName.isEmpty() || firstName.length() < 3 || hasLetters(firstName)) {
            mm.addAttribute("invalidInputMessage", "INVALID NAME REGISTRATION");
            return (new ModelAndView("send:/error"));
        } else {
            Trainer trainer = trainerRepository.getOne(id);

            trainer.setFirstName(firstName);
            trainer.setLastName(lastName);
            trainer.setSubject(subject);

            trainerRepository.save(trainer);
            return (new ModelAndView("redirect:/"));
        }
    }

    @GetMapping("delete")
    public ModelAndView delete(@RequestParam Long id) {

        trainerRepository.delete(trainerRepository.getOne(id));

        return (new ModelAndView("redirect:/"));
    }

    @GetMapping("create")
    public String create() {
        return "createTrainer";
    }

    @PostMapping("doCreate")
    public ModelAndView create(Trainer trainer, @RequestParam String firstName, @RequestParam String lastName, ModelMap mm) {

        if (lastName.isEmpty() || lastName.length() < 3 || hasLetters(lastName)) {
            mm.addAttribute("invalidInputMessage", "INVALID SURNAME REGISTRATION");
            return (new ModelAndView("send:/error"));
        } else if (firstName.isEmpty() || firstName.length() < 3 || hasLetters(firstName)) {
            mm.addAttribute("invalidInputMessage", "INVALID NAME REGISTRATION");
            return (new ModelAndView("send:/error"));
        } else {
            trainerRepository.save(trainer);
            return (new ModelAndView("redirect:/"));
        }
    }

    @GetMapping("redirectFromError")
    public ModelAndView backToMainPage() {
        return (new ModelAndView("redirect:/"));
    }

    private boolean hasLetters(String string){

        return (string.matches(".*\\d.*"));
    }
}