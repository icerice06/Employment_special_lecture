package com.example.board.DTO;

import com.example.board.entity.CategoriesEntity;
import com.example.board.entity.CommentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long detailed_code;
    private String password;
    private String title;
    private String writer;
    private String content;
    private int category;

    @CreationTimestamp
    private LocalDateTime created_at;
}
