package com.example.board.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListDTO {
    private String title;
    private String writer;
    private Long detailed_code;
    private LocalDateTime created_at;
}
