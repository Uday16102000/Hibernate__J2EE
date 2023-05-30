package e1_hibernate_onetoone_unidirection_controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
import e1_hibernate_onetoone_unidirection_dto.AdharCard;
import e1_hibernate_onetoone_unidirection_dto.Person;
import e1_hibernate_onetoone_unidirection_dao.AdharCrud;
import e1_hibernate_onetoone_unidirection_dao.PersonCrud;

public class PersonAdhar {

	public static void main(String[] args) {
		PersonCrud crud2=new PersonCrud();
		AdharCrud crud= new AdharCrud();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter phone");
		String phone=s.next();
		AdharCard card= new AdharCard(name,phone);
	
		System.out.println("Enter name");
		String name1=s.next();
		System.out.println("Enter phone");
		String phone2=s.next();
		Person person= new Person(name1,phone2,card);
		
		crud2.savePerson(person);
		
		
//Scanner s= new Scanner(System.in);
//		boolean check=true;
//		do {
//			System.out.println("choose option \n 1.saveAdhar \n 2.savePerson \n 3.update adhar \n 4.update person \n 5.deletePerson \n 6.deleteAdhar \n 7.getPerson \n 8.fetch Adhar");
//			int choice =s.nextInt();
//			
//			switch(choice) {
//			case 1:{
//				System.out.println("Enter name");
//				String name=s.next();
//				System.out.println("Enter adharnumber");
//				String adharnum=s.next();
//				
//				AdharCard card=new AdharCard(name,adharnum);
//				crud.saveAdhar(card);
//			} break;
//			case 2:{
//				System.out.println("ëneter name");
//				String name=s.next();
//				System.out.println("ëneter contact");
//				String contact=s.next();
//				
//				System.out.println("eneter id");
//				int id=s.nextInt();
//				
//				Person person = new Person(name,contact);
//				crud2.savePerson(person, id);
//				
//			} break;
//			case 3:{
//				System.out.println("eneter name");
//				String name=s.next();
//				System.out.println("eneter id");
//				int id=s.nextInt();
//				
//				AdharCard card= new AdharCard();
//				card.setName(name);
//				crud.updateAdhar(id, card);
//				
//			} break;
//			case 4:{
//				System.out.println("Enter name");
//				String name=s.next();
//				System.out.println("Enter id");
//				int id=s.nextInt();
//				
//				Person person= new Person();
//				person.setName(name);
//				crud2.updatePerson(id, person);
//			} break;
//			case 5:{
//				System.out.println("Enter id");
//				int id=s.nextInt();
////			 AdharCard card= new AdharCard();
//			  crud2.deletePerson(id);
//			
//			} break;
//			case 6:{
//				System.out.println("Enter id");
//				int id=s.nextInt();
////				 AdharCard card= new AdharCard();
//				  crud.deleteAdhar(id);
//			} break;
//			case 7:{
//				System.out.println("Enter id");
//				int id=s.nextInt();
//				crud2.getPersonById(id);
//			} break;
//			case 8:{
//				System.out.println("Enter id");
//				int id=s.nextInt();
//			crud.getAdharById(id);
//			}break;
//		default:
//			System.out.println("Invalid input");
//			break;
//				
//			}
//			
//			
//		}while(check);
	}
}
