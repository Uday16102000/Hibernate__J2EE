package e1_oneToMany_PTC.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import e1_oneToMany_PTC.dto.*;
import e1_oneToMany_PTC.dto.Person;
import java.util.List;
import java.util.ArrayList;
public class PersonCrud 
{
public EntityManager getManager()
{
EntityManager manager=Persistence.createEntityManagerFactory("uday").createEntityManager();
return manager;
}



public void savePerson(Person person)
{
	EntityManager manager=getManager();
	EntityTransaction t= manager.getTransaction();
	t.begin();
	manager.persist(person);
	t.commit();
}

public void updatePerson(int id,Person person)
{
	EntityManager m=getManager();
	Person persondb= m.find(Person.class, id);
	if(person!=null) 
	{
		persondb.setName("Rohit");
		EntityTransaction t= m.getTransaction();
		t.begin();
		m.merge(persondb);
		t.commit();
	}
}

public void deletePerson(int id) {
	EntityManager m=getManager();
	Person person=m.find(Person.class, id);
			{
		if(person!=null)
		{
			EntityTransaction t= m.getTransaction();
			t.begin();
			m.remove(person);
			t.commit();
		}
			}
}

public void fetchPersonById(int id)
{
	EntityManager m=getManager();
	Person p=m.find(Person.class, id);
	if(p!=null)
	{
		System.out.println(p);
	}
}

			
}
