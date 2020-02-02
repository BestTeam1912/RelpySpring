package com.relpy.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relpy.models.Comment;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {
}
