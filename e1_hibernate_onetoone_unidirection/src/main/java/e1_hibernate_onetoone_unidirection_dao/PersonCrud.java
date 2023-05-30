package e1_hibernate_onetoone_unidirection_dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import e1_hibernate_onetoone_unidirection_dto.Person;
import e1_hibernate_onetoone_unidirection_dto.AdharCard;
public class PersonCrud 

{
  public void savePerson(Person person,int id) {
EntityManagerFactory factory= Persistence.createEntityManagerFactory("uday");	
EntityManager manager= factory.createEntityManager();
AdharCard carddb =manager.find(AdharCard.class, id);
if(carddb!=null) {
	person.setCard(carddb);
	EntityTransaction transaction= manager.getTransaction();
	transaction.begin();
	manager.persist(person);
	transaction.commit();
}




	
  }
  public void savePerson(Person person)
  {
	  EntityManagerFactory factory= Persistence.createEntityManagerFactory("uday");	
	  EntityManager manager= factory.createEntityManager();
	  
	  EntityTransaction transaction= manager.getTransaction();
		transaction.begin();
		manager.persist(person);
		transaction.commit();
  }
  
  public void updatePerson(int id,Person person)
  {
	  EntityManagerFactory factory=Persistence.createEntityManagerFactory("uday");
	  EntityManager manager=factory.createEntityManager();
	  Person persondb= manager.find(Person.class, id);
	  if(persondb!=null) {
		  persondb.setName(person.getName());
		  EntityTransaction t=manager.getTransaction();
		  
		  t.begin();
		  manager.merge(persondb);
		  t.commit();
	  }
  }
  
  public void deletePerson(int id)
  {
	  
	  EntityManagerFactory factory=Persistence.createEntityManagerFactory("uday");
	  EntityManager manager=factory.createEntityManager();
	  Person persondb= manager.find(Person.class, id);
	  if(persondb!=null)
	  {
		  EntityTransaction t=manager.getTransaction();
		  t.begin();
		  manager.remove(persondb);
		  t.commit();
		  
	  }
	  
	  
	  
	  
  }
  
  public void getPersonById(int id)
  {
	  
	  EntityManagerFactory factory=Persistence.createEntityManagerFactory("uday");
	  EntityManager manager=factory.createEntityManager();
	  Person persondb= manager.find(Person.class, id);
	  if(persondb!=null)
	  {
    System.out.println(persondb);
		  
	  }
	  else {
		  System.out.println("persondb not found by given id");
	  }
	  
	  
  }
}
