package com.example.board.response;

import com.example.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListResponse {
    private ListSetResponse data;
    private int status;
    private String messege;

}
