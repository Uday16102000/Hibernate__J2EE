package e1_oneToMany_PTC.dcontroller;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import e1_oneToMany_PTC.dto.*;
import e1_oneToMany_PTC.dao.*;
public class PersonCar

{
	public static void main(String[] args) {
		
Scanner s= new Scanner(System.in);

PersonCrud crud= new PersonCrud();
CarCrud crud2= new CarCrud();
boolean check= true;
do {
	
	System.out.println("Choose option \n 1.save Person and Car via cascade \n 2. save Car \n 3.update Person \n 4.updateCar \n 5.deleteCar \n 6.deletePers"
		+"\n 7.ftechPersonById \n 8.ftechCarById	");
	int  choice=s.nextInt();
	
	switch(choice) {
	case 1:{
		System.out.println("Enter person name");
		String pName=s.next();
		
		System.out.println("Enter car name");
		String cname=s.next();
		System.out.println("Enter car number");
		String cnumber=s.next();
		
		Car c1= new Car(cname,cnumber);
		 
		List<Car> car= new ArrayList<Car>();
		car.add(c1);
		Person person= new Person(pName,car);
		crud.savePerson(person);
		
		
	}break;
	
	case 2:{
		System.out.println("Enter the car name");
		String cname=s.next();
		System.out.println("Enter the car Number");
		String cnumber=s.next();
		
		System.out.println("Enter the person id with whom you want to link the Car");
		int id=s.nextInt();
		
		Car c2= new Car(cname,cnumber);
//		List<Car> car = new ArrayList<Car>();
//		car.add(c2);
		
		crud2.saveCar( c2, id);
	}break;
	case 3:{
		System.out.println("Enter name of person to be updated");
		String pname=s.next();
		
		Person person= new Person();
		person.setName(pname);
		crud.updatePerson(1, person);
	}
	case 4:{
		System.out.println("Enter name of car to be updated");
		String cname=s.next();
		System.out.println("Enter id to be updated");
		int id=s.nextInt();
	Car c= new Car();
	c.setName(cname);
	crud2.updateCar(id, c);
	
		
	}
	case 5:{
		System.out.println("Enter id of person associated with car ");
		int pid=s.nextInt();
		
		System.out.println("Enter id of car to be deleted");
		int cid=s.nextInt();
		

		crud2.deleteCar(pid, cid);
	}
	case 6:{
		System.out.println("Enter id of car to be deleted");
		int pid=s.nextInt();
		

		crud.deletePerson(pid);
	}break;
	case 7:{
		System.out.println("Enter id of person to be fetch");
		int id=s.nextInt();
		crud.fetchPersonById(id);
	}break;
	case 8:{
		System.out.println("Enter id of car to be fetch");
		int id=s.nextInt();
		crud2.fetchCarById(id);
	}
	}
	
}while(check);
	
	
		
	
}
}