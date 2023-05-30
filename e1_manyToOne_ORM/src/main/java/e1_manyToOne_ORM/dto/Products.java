package e1_manyToOne_ORM.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String productName;
	private String productCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCost() {
		return productCost;
	}
	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	private Brand brand;
	public Products() {
	}
	public Products(String productName, String productCost, Brand brand) {
		this.productName = productName;
		this.productCost = productCost;
		this.brand = brand;
	}
	public Products(String productName, String productCost) {
		this.productName = productName;
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", productCost=" + productCost + ", brand="
				+ brand + "]";
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	

}
