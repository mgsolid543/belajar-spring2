/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author user
 */
@Entity
public class Sesi {
    @Id @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
      
    @Temporal(TemporalType.DATE)
    private Date mulai;
    
    @Temporal(TemporalType.DATE)
    private Date sampai;
    
    @ManyToOne
    @JoinColumn(name = "id_materi", nullable = false)
    private Materi materi;
    
    @ManyToMany
    private List<Peserta> daftarPeserta = new ArrayList<>();
}
