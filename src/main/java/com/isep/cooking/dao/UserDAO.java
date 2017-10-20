package com.isep.cooking.dao;

import com.isep.cooking.entities.CookingUser;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;

public class UserDAO {

	public List<CookingUser> getCookingUser() {

		EntityManager em = TransactionManager.initTransaction();

		List<CookingUser> user = em.createQuery("SELECT u FROM CookingUser u", CookingUser.class)
				.getResultList();
		TransactionManager.closeTransaction();

		return user;

	}

	public CookingUser getCookingUserById(UUID id) {

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

}
