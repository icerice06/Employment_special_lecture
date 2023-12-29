package com.example.board.service;

import com.example.board.DTO.CategoryDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.mapper.BoardMapper;
import com.example.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardMapper boardMapper;

    public List<BoardEntity> findByCategory(int cate) {
        return boardMapper.findByCategory(cate);
    }
}
