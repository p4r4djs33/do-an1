package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.service.checklist.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;
    @GetMapping("/home/checklist")
    public String index(Model model) {
        model.addAttribute("checklists", checklistService.findAll());
        return "checklist/list";
    }
}
