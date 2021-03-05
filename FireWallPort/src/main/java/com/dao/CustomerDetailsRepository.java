package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.CustomerDetails;
import com.bean.User;

@Repository
public interface CustomerDetailsRepository extends CrudRepository<CustomerDetails, Integer> {

	@Query(" FROM CustomerDetails c WHERE c.username_cust_details = :username")
	public List<CustomerDetails> getDetailsByUsername(@Param("username") String username);

	@Query(" FROM CustomerDetails c WHERE c.id = :id")
	public List<CustomerDetails> getDetailsByUsername1(@Param("id") int id);

	@Query(" FROM CustomerDetails c WHERE c.service_no = :service_no")
	public CustomerDetails getDetailsByServiceno(@Param("service_no") String service_no);

	@Query(" FROM CustomerDetails c WHERE c.service_no = :service_no")
	public CustomerDetails getDetailsByServicenoLastFive(@Param("service_no") String service_no);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update CustomerDetails cd set cd.ticketStatus = :ticketStatus where cd.id = :id")
	void updateTicketStatus(@Param(value = "id") int id, @Param(value = "ticketStatus") String ticketStatus);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update CustomerDetails cd set cd.configurationDesc = :configurationDesc where cd.id = :id")
	void updateTicketDesc(@Param(value = "id") int id, @Param(value = "configurationDesc") String configurationDesc);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update CustomerDetails cd set cd.adminComment = :adminComment where cd.id = :id")
	void updateAdminComments(@Param(value = "id") int id, @Param(value = "adminComment") String adminComment);

}
