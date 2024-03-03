package com.vektorel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vektorel.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
