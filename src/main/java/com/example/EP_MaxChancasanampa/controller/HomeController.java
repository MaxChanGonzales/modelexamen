/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_MaxChancasanampa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Angel
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String mensaje(Model model) {
        model.addAttribute("mensaje", "Bienvenido");
        return "index";
    }
        @RequestMapping("/main")
    public String main(Model model) {
        model.addAttribute("mensaje", "Bienvenido");
        return "main";
    }
}
