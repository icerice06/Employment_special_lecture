package com.example.board.response;

import com.example.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ListSetResponse {
    private List<BoardEntity> list;
}
