/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.controller;

import com.budiana.irpan.belajar.dao.PesertaDao;
import com.budiana.irpan.belajar.entity.Peserta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Irpan Budiana
 */
@RestController
public class PesertaController {
    
    @Autowired
    private PesertaDao pd;
    
    @RequestMapping("/peserta")
    public Page<Peserta> cariPeserta(Pageable page) {
        return pd.findAll(page);
    } 
}
