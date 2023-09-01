package com.jsp.airlines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.dto.UserDto;
import com.jsp.airlines.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT user FROM User user WHERE user.userName = :uName AND user.password = :password")
	List<User> findByUsernameAndPassword(@Param("uName") String userName,@Param("password") String password);
	
	@Query("SELECT user FROM User user WHERE user.user_Id= :uId")
	List<User> findByUserById(@Param("uId") int id);
	

}
