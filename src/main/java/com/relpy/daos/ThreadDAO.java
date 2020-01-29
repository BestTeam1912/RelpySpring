package com.relpy.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.relpy.models.Thread;

public interface ThreadDAO extends JpaRepository<Thread, Long>{}
