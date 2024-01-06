package com.example.board.service;

import com.example.board.DTO.BoardDTO;
import com.example.board.DTO.CommentDTO;
import com.example.board.DTO.DetailedDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.entity.CategoriesEntity;
import com.example.board.mapper.BoardMapper;
import com.example.board.repository.BoardRepository;
import com.example.board.response.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardMapper boardMapper;

    public ResponseEntity<ListResponse> findList(){
        List<BoardEntity> boardEntities = boardMapper.findList();
        ListSetResponse response1 = new ListSetResponse(boardEntities);
        ListResponse response = new ListResponse(response1, HttpStatus.OK.value(), "");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }
    public ResponseEntity<CategoryResponse> findAll(){
        List<CategoriesEntity> categoriesEntities = boardMapper.findAll();
        CategoryResponse response = new CategoryResponse(categoriesEntities, HttpStatus.OK.value(),"");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }
    public ResponseEntity<ListResponse> findByCode(int code) {
        List<BoardEntity> boardEntities = boardMapper.findByCode(code);
        ListSetResponse response1 = new ListSetResponse(boardEntities);
        ListResponse response = new ListResponse(response1, HttpStatus.OK.value(), "");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }

    public ResponseEntity<BoardResponse> findById(int code){
        DetailedDTO detailedDTO = boardMapper.findById(code);
        BoardResponse response = new BoardResponse(detailedDTO, HttpStatus.OK.value(), "");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }
    public void regist(BoardDTO boardDTO){
        boardDTO.setCreated_at(LocalDateTime.now());
        boardMapper.regist(boardDTO);
    }

    public BoardDTO modify(BoardDTO boardDTO){
        return boardMapper.modify(boardDTO);
    }

    public void comment(CommentDTO commentDTO){
        boardMapper.comment(commentDTO);
    }
}
