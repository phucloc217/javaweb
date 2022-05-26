/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlysinhvien.main.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author locng
 */
@Entity
@Table(name = "sinhvien")
public class SinhVien {

    @Id
    @Column(name = "masv")
    private String masv;

    @Column(length = 50, nullable = false)
    private String hoten;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaysinh;

    @ManyToOne
    @JoinColumn(name = "malop", nullable = true)
    private Lop lop;

    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, Date ngaysinh, Lop malop) {
        this.masv = masv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.lop = malop;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
}
