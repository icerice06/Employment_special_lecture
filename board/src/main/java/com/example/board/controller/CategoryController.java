package com.example.board.controller;

import com.example.board.DTO.BoardDTO;
import com.example.board.DTO.CategoryDTO;
import com.example.board.DTO.CommentDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.entity.CategoriesEntity;
import com.example.board.response.BoardResponse;
import com.example.board.response.CategoryResponse;
import com.example.board.response.ListResponse;
import com.example.board.service.BoardService;
import lombok.extern.flogger.Flogger;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryDTO categoryDTO = new CategoryDTO();

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public ResponseEntity<ListResponse> main(){
        return boardService.findList();
    }
    
//    @GetMapping("/category")
//    public ResponseEntity<CategoryResponse> category() {
//        return boardService.findAll();
//    }

    @GetMapping("/category/{code}")
    public ResponseEntity<ListResponse> list(@PathVariable("code") int code) {
        return boardService.findByCode(code);
    }

    @GetMapping("/detailed/{detailed_code}")
    public ResponseEntity<BoardResponse> detailed(@PathVariable("detailed_code") int code){
        return boardService.findById(code);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody BoardDTO boardDTO){
        boardService.regist(boardDTO);
    }

    @PutMapping("/modify")
    public void modify(@RequestBody BoardDTO boardDTO){
        boardService.modify(boardDTO);
    }

    @PutMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void comment(@RequestBody CommentDTO commentDTO){
        boardService.comment(commentDTO);
    }

}
