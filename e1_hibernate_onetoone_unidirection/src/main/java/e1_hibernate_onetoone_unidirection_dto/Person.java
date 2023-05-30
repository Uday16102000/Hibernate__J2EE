package e1_hibernate_onetoone_unidirection_dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String contact;
	 
	@OneToOne(cascade=CascadeType.ALL)
	private AdharCard card;
	public AdharCard getCard() {
		return card;
	}
	
	
	public Person(String name, String contact, AdharCard card) {
		this.name = name;
		this.contact = contact;
		this.card = card;
	}


	public void setCard(AdharCard card) {
		this.card = card;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Person() {
	}
	public Person( String name, String contact) {
		
		this.name = name;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", contact=" + contact + ", card=" + card + "]";
	}
	
	
	
}
