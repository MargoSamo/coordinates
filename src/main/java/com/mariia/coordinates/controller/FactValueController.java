package com.mariia.coordinates.controller;

import com.mariia.coordinates.model.FactValue;
import com.mariia.coordinates.service.FactValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FactValueController {

    private final FactValueService factValueService;

    @Autowired
    public FactValueController(FactValueService factValueService) {
        this.factValueService = factValueService;
    }

    @GetMapping("/factValues")
    public String findAll(Model model){
        List<FactValue> factValues = factValueService.findAll();
        model.addAttribute("factValues", factValues);
        return "factValue-list";
    }

    @GetMapping("/factValue-create")
    public String createFactValueForm(FactValue factValue){
        return "factValue-create";
    }

    @PostMapping("/factValue-create")
    public String createFactValue(FactValue factValue){
        factValueService.saveFactValue(factValue);
        return "redirect:/factValues";
    }

    @GetMapping("factValue-delete/{id}")
    public String deleteFactValue(@PathVariable("id") Long id){
        factValueService.deleteById(id);
        return "redirect:/factValues";
    }

    @GetMapping("/factValue-update/{id}")
    public String updateFactValueForm(@PathVariable("id") Long id, Model model){
        FactValue factValue = factValueService.findById(id);
        model.addAttribute("factValue", factValue);
        return "factValue-update";
    }

    @PostMapping("/factValue-update")
    public String updateFactValue(FactValue factValue){
        factValueService.saveFactValue(factValue);
        return "redirect:/factValues";
    }

}
