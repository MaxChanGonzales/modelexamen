/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_MaxChancasanampa.controller;

import com.example.EP_MaxChancasanampa.entity.Categoria;
import com.example.EP_MaxChancasanampa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Angel
 */
@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping("/categorias")
    public String categoria(Model model){
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categoria";
    }
    @RequestMapping("/formCat")
    public String create(Model model) {
        return "addCat";
    }
    @RequestMapping("/add")
    public String guardar(@RequestParam String Categoria, @RequestParam String Accion, Model model) {
        Categoria categoria = new Categoria();
        categoria.setCategoria(Categoria);
        categoria.setAccion(Accion);
        System.out.println("sout:"+categoria.getCategoria()+"/"+categoria.getAccion());
        categoriaRepository.save(categoria);
        return "redirect:/categoria";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        System.out.println("ID: "+id);
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        categoriaRepository.delete(categoria);
        return "redirect:/categoria";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("categoria", categoriaRepository.findById(id).orElse(null));
        return "editCat";
    }
    @RequestMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String Categoria, @RequestParam String Accion) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        categoria.setCategoria(Categoria);
        categoria.setAccion(Accion);
        categoriaRepository.save(categoria);
        return "redirect:/categoria";
    }
}

