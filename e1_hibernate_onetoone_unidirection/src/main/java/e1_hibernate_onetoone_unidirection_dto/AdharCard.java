package e1_hibernate_onetoone_unidirection_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdharCard {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
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
	public String getAdharNum() {
		return adharNum;
	}
	public void setAdharNum(String adharNum) {
		this.adharNum = adharNum;
	}
	private String name;
	private String adharNum;
	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", name=" + name + ", adharNum=" + adharNum + "]";
	}
	public AdharCard() {
	}
	public AdharCard(String name, String adharNum) {
		this.name = name;
		this.adharNum = adharNum;
	}
	
	
	
	
	
	

}
