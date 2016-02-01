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
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
        scripts = "/data/peserta.sql"
)
public class PesertaDaoTest {
    
    @Autowired
    private PesertaDao pd;
    
    @Autowired
    private DataSource ds;
    
    @Before
    public void insertSampleData() {
        
    }
    
    @After
    public void hapusData() throws Exception{
        String sql = "delete from peserta where email = 'peserta01@gmail.com'";
        try (Connection c = ds.getConnection()) {
            c.createStatement().executeUpdate(sql);
        }
    }
    
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
    
    @Test
    public void testHitung(){
        Long jumlah = pd.count();
        Assert.assertEquals(3L, jumlah.longValue());
    }
    
    @Test 
    public void testCariById(){
        Peserta p = pd.findOne("a1");
        Assert.assertNotNull(p);
        Assert.assertEquals("Peserta Test 1", p.getNama());
        Assert.assertEquals("peserta.test1@gmail.com", p.getEmail());
        
        Peserta px = pd.findOne("xx");
        Assert.assertNull(px);
    }
    
}
