package com.ge.data.analytic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ge.data.analytic.entity.UserData;

@Repository
public interface DataAnalyticRepository extends JpaRepository<UserData, Long>{
	String CHECK_AVIALABLE_USER = "from UserData user where user.userName=?1";
	
	@Query(CHECK_AVIALABLE_USER)
	UserData findUser(String userName);

}
