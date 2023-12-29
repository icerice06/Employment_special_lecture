package com.example.board.entity;

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
@Entity
@Table(name = "List")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailed_code;
    @NotBlank
    private String password;
    @NotBlank
    private String title;
    @NotBlank
    private String writer;
    @NotBlank
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    @NotBlank
    private CategoriesEntity category_code;

    @CreationTimestamp
    private LocalDateTime created_at;

    @OneToOne(mappedBy = "list_detailed_code")
    private CommentEntity comments;
}
