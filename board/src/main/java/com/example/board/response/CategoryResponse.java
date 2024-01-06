package com.example.board.response;

import com.example.board.entity.CategoriesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class CategoryResponse {
    private List
            <CategoriesEntity> data;
    private int status;
    private String messege;
}
