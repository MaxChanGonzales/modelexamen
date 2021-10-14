/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_MaxChancasanampa.controller;

import com.example.EP_MaxChancasanampa.entity.Producto;
import com.example.EP_MaxChancasanampa.repository.ProductoRepository;
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
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @RequestMapping("/productos")
    public String producto(Model model){
        model.addAttribute("productos", productoRepository.findAll());
        return "producto";
    }
    @RequestMapping("/formProd")
    public String create(Model model) {
        return "addProd";
    }
    @RequestMapping("/add")
    public String guardar(@RequestParam String Producto ,@RequestParam int Precio, @RequestParam String Stock, @RequestParam String Accion, Model model) {
        Producto producto = new Producto();
        producto.setProducto(Producto);
        producto.setPrecio(Precio);
        producto.setStock(Stock);
        producto.setAccion(Accion);
        System.out.println("sout:"+producto.getProducto()+"/"+producto.getPrecio()+"/"+producto.getStock()+"/"+producto.getAccion());
        productoRepository.save(producto);
        return "redirect:/producto";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        System.out.println("ID: "+id);
        Producto producto = productoRepository.findById(id).orElse(null);
        productoRepository.delete(producto);
        return "redirect:/producto";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("producto", productoRepository.findById(id).orElse(null));
        return "editProd";
    }
    @RequestMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String Producto ,@RequestParam int Precio, @RequestParam String Stock, @RequestParam String Accion) {
        Producto producto = productoRepository.findById(id).orElse(null);
        producto.setProducto(Producto);
        producto.setPrecio(Precio);
        producto.setStock(Stock);
        producto.setAccion(Accion);
        productoRepository.save(producto);
        return "redirect:/producto";
    }
}   

