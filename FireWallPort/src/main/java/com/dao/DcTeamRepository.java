package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Customer;
import com.bean.ServerDetails;

@Repository
public interface DcTeamRepository extends CrudRepository<Customer, Integer> {
	
	  @Query("FROM Customer c where c.id=:id") 
	  public Customer getCustomerByUserName(@Param("id") Integer id);
	  @Query("FROM Customer c where c.username=:username") 
	  public List<Customer> getCustomerDetailsByUserName(@Param("username") String username);
	  @Query("FROM Customer c where c.username=:username") 
	  public Customer getOneCustomerByUserName(@Param("username") String username);
		
	   @Query(value="from ServerDetails sd where sd.id= :id") 
	   public ServerDetails getServerDetailsSingleRow(@Param("id")int id);
		 

}
