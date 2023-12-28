package com.example.board.entity;

import com.example.board.DTO.ListDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardEntity {
    @Id
    private String code;
    private String title;
    private String writer;
    private Date time;
}
