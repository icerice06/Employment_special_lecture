package com.example.board.DTO;

import com.example.board.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailedDTO {
    private String title;
    private String writer;
    private String content;
    private int category;
    private List<CommentEntity> comments;
}
