/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EP_MaxChancasanampa.repository;

import com.example.EP_MaxChancasanampa.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Object> {
    
}
