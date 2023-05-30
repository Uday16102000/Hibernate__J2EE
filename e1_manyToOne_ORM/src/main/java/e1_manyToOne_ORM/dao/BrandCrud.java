package e1_manyToOne_ORM.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import e1_manyToOne_ORM.dto.Brand;

public class BrandCrud {
	
	
	public EntityManager getmanager()
	{
		EntityManager manager =Persistence.createEntityManagerFactory("uday").createEntityManager();
		return manager;
	}
	
	public void saveBrand(Brand brand) {
		
		
		EntityManager manager= getmanager();
		EntityTransaction t= manager.getTransaction();
		t.begin();
		manager.persist(brand);
		t.commit();
	}
	
	public void deleetBrand(int id) {
		EntityManager manager= getmanager();
		EntityTransaction t= manager.getTransaction();
		Brand b= manager.find(Brand.class, id);
		if(b!=null)
		{
			t.begin();
			manager.remove(b);
			t.commit();
		}else {
			System.out.println("Brand with "+ id + "is not present");
		}
		
	}
	
	public void updateBrand(Brand b,int id)
	{
		EntityManager manager= getmanager();
		EntityTransaction t= manager.getTransaction();
		Brand bdb=manager.find(Brand.class, id);
		if(bdb!=null) {
			bdb.setBrandName(b.getBrandName());
			t.begin();
			manager.merge(bdb);
			t.commit();
		}else {
			System.out.println("No such brand exist");
		}
		
	}
	
	public void fetchBrandById(int id)
	{
		EntityManager manager= getmanager();
		Brand b=manager.find(Brand.class, id);
		System.out.println(b);
		
	}

}
