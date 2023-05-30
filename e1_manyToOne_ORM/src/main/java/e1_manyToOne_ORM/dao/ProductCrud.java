package e1_manyToOne_ORM.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import e1_manyToOne_ORM.dto.*;
import javax.persistence.Persistence;

public class ProductCrud 
{
  public EntityManager getManager()
  {
	  EntityManager manager= Persistence.createEntityManagerFactory("uday").createEntityManager();
	return manager;
	  
  }
  
  public void saveProduct(Products product,int id)
  {
	  EntityManager manager=getManager();
	  EntityTransaction tran=manager.getTransaction();
	  Brand brand=manager.find(Brand.class, id);
	  if(brand!=null)
	  {
		 product.setBrand(brand);
		 tran.begin();
		 manager.persist(product);
		 tran.commit();
		  
	  }else {
		  System.out.println("Brand with "+ id + "not present");
	  }
	  
  }
  
  public void saveproductWithBrand(Products p)
  {
	  EntityManager manager=getManager();
	  EntityTransaction tran=manager.getTransaction();
	 tran.begin();
	 manager.persist(p);
	 tran.commit();
  }
  
  
  public void deleteProduct(int id)
  {

	  EntityManager manager=getManager();
	  EntityTransaction tran=manager.getTransaction();
	  Products pdb=manager.find(Products.class, id);
	  if(pdb!=null)
	  {
		  pdb.setBrand(null);
		  tran.begin();
		  manager.remove(pdb);
		  tran.commit();
	  }else {
		  System.out.println("product with "+ id + "not present");
	  }
  }
  
  
  public void updateProduct(Products p,int id)
  {

	  EntityManager manager=getManager();
	  EntityTransaction tran=manager.getTransaction();
	  Products pdb=manager.find(Products.class, id);
	  if(pdb!=null)
	  {
		  pdb.setProductCost(p.getProductCost());
		  tran.begin();
		  manager.merge(pdb);
		  tran.commit();
	  }else {
		  System.out.println("Product not present with " + id);
	  }
  }
  
  public void fetchProductById(int id) {
	  EntityManager manager=getManager();
	  Products p= manager.find(Products.class, id);
	  System.out.println(p);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
