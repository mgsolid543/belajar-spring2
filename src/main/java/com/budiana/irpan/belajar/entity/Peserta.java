/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class Peserta {
    @Id
    private String id;
    private String nama;
    private String email;
}
