package com.isep.cooking.dao;

import com.isep.cooking.entities.Tool;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;

public class ToolDAO {
    
     public List<Tool> getTool() {

        EntityManager em = TransactionManager.initTransaction();

        List<Tool> tool = em.createQuery("SELECT t FROM Tool t", Tool.class)
                .getResultList();
        TransactionManager.closeTransaction();

        return tool;

    }
    
     public Tool getToolById(UUID id) {

        EntityManager em = TransactionManager.initTransaction();

		Tool tool = em.find(Tool.class, id);
		
        TransactionManager.closeTransaction();

        return tool;

    }
	 
	public void persist(Tool tool) {

		EntityManager em = TransactionManager.initTransaction();

		em.persist(tool);

		TransactionManager.closeTransaction();

	}

}
