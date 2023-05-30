package e1_oneToMany_PTC.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
@OneToMany(cascade = CascadeType.ALL)
private List<Car> car;

public Person(String name, List<Car> car) {
	this.name = name;
	this.car = car;
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

public List<Car> getCar() {
	return car;
}

public void setCar(List<Car> car) {
	this.car = car;
}

@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", car=" + car + "]";
}

public Person() {
}


}

