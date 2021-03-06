/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_MaxChancasanampa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Angel
 */
@Data //Generamos los metodos Set y getter
@AllArgsConstructor //creamos un contructor con parametros
@NoArgsConstructor //creamos un contructor sin parametros
@Entity //Dice que La clase Post es una tabla en BD
@Table(name="productos")
public class Producto implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Producto;
    private int Precio;
    private String Stock;
    private String Accion;
    
}
