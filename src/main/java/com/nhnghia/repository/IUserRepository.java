package com.nhnghia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhnghia.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findOneByUserNameAndStatus(String username, int status);

}
