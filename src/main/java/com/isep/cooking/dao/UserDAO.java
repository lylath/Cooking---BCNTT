package com.isep.cooking.dao;

import com.isep.cooking.entities.CookingUser;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import org.apache.commons.codec.digest.DigestUtils;

public class UserDAO {

	public List<CookingUser> getCookingUser() {

		EntityManager em = TransactionManager.initTransaction();

		List<CookingUser> user = em.createQuery("SELECT u FROM CookingUser u",
				CookingUser.class)
				.getResultList();
		
		TransactionManager.closeTransaction();

		return user;

	}

	public CookingUser getCookingUserById(String id) {

		EntityManager em = TransactionManager.initTransaction();

		CookingUser user = em.find(CookingUser.class, id);

		TransactionManager.closeTransaction();

		return user;

	}

	public void persist(CookingUser cookingUser) {

		EntityManager em = TransactionManager.initTransaction();

		em.persist(cookingUser);

		TransactionManager.closeTransaction();

	}

	public CookingUser getUserByMail(String mail) {

		EntityManager em = TransactionManager.initTransaction();

		CookingUser user = em.createQuery(
				"SELECT u FROM CookingUser u WHERE u.Email = :mail", CookingUser.class)
				.setParameter("mail", mail)
				.getSingleResult();

		TransactionManager.closeTransaction();

		return user;
		
	}
	
	public String generateSessionId(CookingUser user) {
		
		EntityManager em = TransactionManager.initTransaction();
		
		String sessionId = UUID.randomUUID().toString();
		
		user.setHashedSessionId(new String(DigestUtils.sha512(sessionId)));
		
		TransactionManager.closeTransaction();
		
		return sessionId;
		
	}

}
