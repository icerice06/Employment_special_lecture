package com.example.board.response;


import com.example.board.DTO.DetailedDTO;
import com.example.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoardResponse {
    private DetailedDTO data;
    private int status;
    private String messege;
}
