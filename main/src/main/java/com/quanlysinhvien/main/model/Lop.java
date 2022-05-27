/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlysinhvien.main.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author locng
 */
@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @Column(name = "malop")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer malop;
    
    private String tenlop;
    
    @OneToMany(mappedBy="lop")
    private List<SinhVien> dssv;

    public Lop() {
    }

    public Lop(Integer malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public Integer getMalop() {
        return malop;
    }

    public void setMalop(Integer malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public List<SinhVien> getDssv() {
        return dssv;
    }

    public void setDssv(List<SinhVien> dssv) {
        this.dssv = dssv;
    }
    
}
