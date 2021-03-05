package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public interface EmpRepository extends CrudRepository<User, String> {

}
