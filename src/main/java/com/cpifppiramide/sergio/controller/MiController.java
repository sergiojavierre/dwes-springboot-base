package com.cpifppiramide.sergio.controller;

import com.cpifppiramide.sergio.entities.Cosa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MiController {

    List<Cosa> cosas = new ArrayList<>();

    public MiController(){
        this.cosas.add(new Cosa("Primera cosa"));
    }

    @GetMapping("/")
    public String web(Model model){
        model.addAttribute("cosas", cosas);
        return "index";
    }

    @GetMapping("/formulario")
    public String formulario(){
        return "formulario";
    }

    @PostMapping("/guarda")
    public String save(Cosa cosa){
        this.cosas.add(cosa);
        return "redirect:/";
    }

}
