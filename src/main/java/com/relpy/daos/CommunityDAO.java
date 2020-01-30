package com.relpy.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relpy.models.Community;


@Repository
public interface CommunityDAO extends JpaRepository<Community, Long> {

	Community findByTitle(String title);
//	Long deleteByTitle(String title);

}
