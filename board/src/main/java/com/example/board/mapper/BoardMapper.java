package com.example.board.mapper;

import com.example.board.DTO.BoardDTO;
import com.example.board.DTO.CommentDTO;
import com.example.board.DTO.DetailedDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.entity.CategoriesEntity;
import com.example.board.response.ListSetResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardEntity>findList();
    List<CategoriesEntity>findAll();
    List<BoardEntity> findByCode(int code);

    @ResultMap("com.example.board.DTO.DetailedDTOMap")
    DetailedDTO findById(int code);

    void regist(BoardDTO boardDTO);
    BoardDTO modify(BoardDTO boardDTO);

    void comment(CommentDTO commentDTO);
}
