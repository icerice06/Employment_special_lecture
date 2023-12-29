package com.example.board.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListDTO {
    private int detailed_code;
    private String password;
    private String title;
    private String writer;
    private String content;
    private int category_code;
    private Date created_at;
}
