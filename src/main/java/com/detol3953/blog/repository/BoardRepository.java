package com.detol3953.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.detol3953.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
