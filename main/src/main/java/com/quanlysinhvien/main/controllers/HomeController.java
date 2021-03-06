/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlysinhvien.main.controllers;

import com.quanlysinhvien.main.model.Lop;
import com.quanlysinhvien.main.model.LopRepository;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author locng
 */
@Controller
public class HomeController {

    @Autowired
    private LopRepository lopRepository;

    @RequestMapping("/")
    public String home(Model model, HttpSession session) {
        List<Lop> ds = (List<Lop>) lopRepository.findAll();
        model.addAttribute("classes", ds);
        return "home";
    }

    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
    public String saveClass(@RequestParam String classname,
            Model model, RedirectAttributes redirAttrs) {
        Lop lop = new Lop();
        lop.setTenlop(classname);
        lopRepository.save(lop);
        redirAttrs.addFlashAttribute("success", "Thêm thành công");
        return "redirect:/";
    }

    /**
     *
     * @param classID
     * @param redirAttrs
     * @return
     */
    @PostMapping("/delete")
    public String deleteClass(@RequestParam Integer classID, RedirectAttributes redirAttrs) {
        lopRepository.deleteById(classID);
        redirAttrs.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/";
    }

    @RequestMapping(value = "/updateclass", method = RequestMethod.POST)
    public String editClass(@RequestParam String updateID, @RequestParam String updateClassname,
            Model model, RedirectAttributes redirAttrs) {
        Lop lop = lopRepository.findById(Integer.parseInt(updateID)).orElse(null);
        if (lop != null) {
            lop.setTenlop(updateClassname);
            lopRepository.save(lop);
            redirAttrs.addFlashAttribute("success", "Cập nhật thành công");
        } else {
            redirAttrs.addFlashAttribute("error", "Cập nhật không thành công");
        }

        return "redirect:/";
    }

}
