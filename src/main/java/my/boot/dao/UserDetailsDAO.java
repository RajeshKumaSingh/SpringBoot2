package my.boot.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.boot.model.UserDetails;

@Repository
@Transactional
public class UserDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDAO.class);

	public boolean checkExistingEmail(String email) {
		UserDetails user = (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, email);
		logger.info("User is : "+user);
		if (user != null)
			return true;
		else
			return false;
	}

	
	public void save(UserDetails userDetial) {
		logger.info("Inside save");
		Serializable email = sessionFactory.getCurrentSession().save(userDetial);
		logger.info("After save: "+email);
	}
}
