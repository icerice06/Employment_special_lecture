package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
