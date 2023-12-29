package com.example.board.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.LongFunction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Commnet")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String comment_writer;
    @NotBlank
    private String comment;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "detailed_code")
    private BoardEntity list_detailed_code;
}
