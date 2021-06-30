package com.purchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purchase.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
