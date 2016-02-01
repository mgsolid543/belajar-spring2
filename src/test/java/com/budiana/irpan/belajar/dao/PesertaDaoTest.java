/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budiana.irpan.belajar.dao;

import com.budiana.irpan.belajar.AplikasiBelajarApplication;
import com.budiana.irpan.belajar.entity.Peserta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author user
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AplikasiBelajarApplication.class)
public class PesertaDaoTest {
    
    @Autowired
    private PesertaDao pd;
    
    @Autowired
    private DataSource ds;
    
    @Test
    public void testInsert() throws SQLException {
        Peserta p = new Peserta();
        p.setNama("Peserta 01");
        p.setEmail("peserta01@gmail.com");
        p.setTanggalLahir(new Date());
        
        pd.save(p);
        
        
        String sql = "select count(*) as jumlah from peserta where email = 'peserta01@gmail.com'";
        try (Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            
            Long jumlahRow = rs.getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
            c.close();
        }
    }
}
