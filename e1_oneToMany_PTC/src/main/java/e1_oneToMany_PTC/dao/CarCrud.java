package e1_oneToMany_PTC.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.plaf.metal.OceanTheme;

import e1_oneToMany_PTC.dto.Car;
import e1_oneToMany_PTC.dto.Person;

public class CarCrud 
{
	public EntityManager getManager()
	{
	EntityManager manager=Persistence.createEntityManagerFactory("uday").createEntityManager();
	return manager;
	}
	public void  saveCar(Car car,int id)
	{
		EntityManager manager= getManager();
		Person person= manager.find(Person.class,id);
		if(person!=null) {
			EntityTransaction transaction = manager.getTransaction();
			List<Car> carl= new ArrayList<Car>();
			carl.add(car);
			carl.addAll(person.getCar());
			person.setCar(carl);
			person.setCar(carl);
			
//			person.setCar(car);
			
			transaction.begin();
			manager.merge(person);
			transaction.commit();
		}else {
			System.out.println("Person does not exist");
		}
				
	}
	
	public void updateCar(int id,Car car)
	{
		EntityManager manager= getManager();
		Car c= manager.find(Car.class, id);
				if(c!=null)
				{
					c.setName(car.getName());
					EntityTransaction t= manager.getTransaction();
					t.begin();
					manager.merge(c);
					t.commit();
					}
	}
	
	
	public void deleteCar(int pid,int cid)
	{
		EntityManager m= getManager();
		Person pdb= m.find(Person.class, pid);
				{
			if(pdb!=null) {
				Car c2=m.find(Car.class,cid);
				if(c2!=null) {
				List<Car> c=pdb.getCar();
				Iterator<Car> iterator = c.iterator();
                while (iterator.hasNext()) {
                    Car car = iterator.next();
                    if (car.equals(c2)) {
                        iterator.remove();
                        break;
                    }
                }
				 pdb.setCar(c);
				 EntityTransaction  t= m.getTransaction();
				 t.begin();
				 m.merge(pdb);
				 m.remove(c2);
				 t.commit();
			
				}else {
					System.out.println("car not preswent");
				}
	}else {
		System.out.println("person not present");
	}
	}
}
	public void fetchCarById(int id) {
		EntityManager m=getManager();
		
		Car c= m.find(Car.class,id);
		if(c!=null) {
		System.out.println(c);
	}else {
		System.out.println("car not present");
	}
		
	}

}
