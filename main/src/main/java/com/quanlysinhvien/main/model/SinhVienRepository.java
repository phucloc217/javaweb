/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlysinhvien.main.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author locng
 */
public interface SinhVienRepository extends CrudRepository<SinhVien, Integer>  {

    @Query(value = "SELECT c FROM SinhVien c WHERE c.masv LIKE :keyword")
    public SinhVien findById(@Param("keyword") String keyword);

    
    
}
