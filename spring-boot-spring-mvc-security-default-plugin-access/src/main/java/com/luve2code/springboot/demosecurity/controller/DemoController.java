package com.luve2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
        //that is the home.html template
    }

    //leaders view URL
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
        //that is the leaders.html template view
    }

    //add request mapping for systems view URL
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
        //that is the systems.html template view
    }



}
