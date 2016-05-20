package com.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spr.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

	@Query("SELECT u FROM user u WHERE u.email=?1")
	User findbyEMail(String eMail);
	
	@Query("DELETE FROM user u WHERE u.email=?1")
	void deleteUserByEMail(String eMail);
	
//	@Query("INSERT INTO user WHERE u.email=?1")
//	void linkUserToCommunity(int userId, int commId);
	
}
