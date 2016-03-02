/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.controller;

import com.budiana.irpan.belajar.dao.PesertaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Irpan Budiana
 */
@Controller
@RequestMapping("/peserta")
public class PesertaHtmlController {
    @Autowired private PesertaDao pd;
    
    @RequestMapping("/list")
    public void daftarPeserta(Model m) {
        m.addAttribute("daftarPeserta", pd.findAll());
    }
}
