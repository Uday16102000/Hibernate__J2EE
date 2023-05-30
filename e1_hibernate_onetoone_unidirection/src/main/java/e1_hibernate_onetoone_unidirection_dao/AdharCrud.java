package e1_hibernate_onetoone_unidirection_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import e1_hibernate_onetoone_unidirection_dto.AdharCard;

public class AdharCrud {

	
	public void saveAdhar(AdharCard card)
	{
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("uday");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(card);
		transaction.commit();
		
	}
	
	public void updateAdhar(int id,AdharCard card) {
		
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("uday");
		EntityManager manager= factory.createEntityManager();
		 AdharCard carddb= manager.find(AdharCard.class, id);
		 if(carddb!=null)
		 {
			 carddb.setName(card.getName());
			EntityTransaction  t= manager.getTransaction();
			t.begin();
			manager.merge(carddb);
			t.commit();
			 
		 }
	}
	
	public void deleteAdhar(int id)
	{
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("uday");
		EntityManager manager= factory.createEntityManager();
		AdharCard card= manager.find(AdharCard.class, id);
			if(card!=null) {
		EntityTransaction t= manager.getTransaction();
		t.begin();
		manager.remove(card);
		t.commit();
			}
		}
	
	public void getAdharById(int id)
	{
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("uday");
		EntityManager manager= factory.createEntityManager();
		AdharCard card= manager.find(AdharCard.class, id);
		if(card!=null)
		{
			System.out.println(card);
		}else
		{
			System.out.println("id not found");
		}
	}
	}

