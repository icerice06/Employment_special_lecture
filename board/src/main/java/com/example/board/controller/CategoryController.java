package com.example.board.controller;

import com.example.board.DTO.CategoryDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.service.BoardService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryDTO categoryDTO = new CategoryDTO();

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public int main(@RequestParam String category) {
        categoryDTO.setCode(Integer.parseInt(category));
        return categoryDTO.getCode();
    }

    // Example URL: /list?cate=1
    @GetMapping("/list")
    public List<BoardEntity> list(int cate){
        return boardService.findByCategory(cate);
    }
}
