/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Irpan Budiana
 */
@Controller
public class HaloController {
    
    @RequestMapping("/halorest")
    @ResponseBody
    public Map<String, Object> halo(
            @RequestParam(value="nama", required=false) String nama) {
        Map<String, Object> hasil = new HashMap<>(); 
        hasil.put("nama", nama);
        hasil.put("waktu", new Date()); 
        return hasil;
    }
    
    @RequestMapping("/halo")
    public void haloHtml(@RequestParam(value="nama", required=false) String nama, Model hasil) {
        hasil.addAttribute("nama", nama);
        hasil.addAttribute("waktu", new Date());
    }
}
