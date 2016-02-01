/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.dao;

import com.budiana.irpan.belajar.AplikasiBelajarApplication;
import com.budiana.irpan.belajar.entity.Materi;
import com.budiana.irpan.belajar.entity.Sesi;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author user
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AplikasiBelajarApplication.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"/data/peserta.sql", "/data/materi.sql", "/data/sesi.sql"}
)
public class SesiDaoTest {
    
    @Autowired
    private SesiDao sd;
    
    @Test
    public void testCariByMateri() {
        Materi m = new Materi();
        m.setId("m4");
         
        PageRequest page = new PageRequest(0, 5);
        
        Page<Sesi> hasilQuery = sd.findByMateri(m, page);
        Assert.assertEquals(1L, hasilQuery.getTotalElements());
        
        Assert.assertFalse(hasilQuery.getContent().isEmpty()); 
        Sesi s = hasilQuery.getContent().get(0);
        Assert.assertNotNull(s);
        Assert.assertEquals("Rekayasa Perangkat Lunak", s.getMateri().getNama());
    }
    
    @Test
    public void testCariBerdasarakanTanggalDanKodeMateri() throws Exception {
        PageRequest page = new PageRequest(0, 5);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sejak = formatter.parse("2015-02-01");
        Date sampai = formatter.parse("2015-02-05");
        Page<Sesi> hasil = sd.cariBerdasarkanTanggalDanKodeMateri(
                sejak, sampai, "MA-001", page);
        
        Assert.assertEquals(1L, hasil.getTotalElements());
        Assert.assertFalse(hasil.getContent().isEmpty());
        
        Sesi s = hasil.getContent().get(0);
        Assert.assertEquals("Rekayasa Perangkat Lunak", s.getMateri().getNama());
    }
}
