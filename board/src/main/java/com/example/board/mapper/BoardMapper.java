package com.example.board.mapper;

import com.example.board.entity.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardEntity> findByCategory(int code);
}
