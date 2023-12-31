package com.example.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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
    @JsonIgnore
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
    @JsonIgnore
    private CategoriesEntity code;
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "board")
    private List<CommentEntity> comments;
}
