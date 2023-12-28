package com.example.board.controller;

import com.example.board.DTO.CategoryDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    CategoryDTO categoryDTO = new CategoryDTO();

    @GetMapping("/")
    public String main(@RequestParam String category){
        categoryDTO.setId(category);
        return "category="+categoryDTO.getId();
    }
}
