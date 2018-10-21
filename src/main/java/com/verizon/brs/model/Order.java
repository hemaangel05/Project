package com.verizon.brs.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@Column(name="oid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	private LocalDate dor;
	private LocalDate dod;
	private double weight;
	private int qty;
	@Enumerated(EnumType.STRING )
	private Type deliverytype;
	
	@Enumerated(EnumType.STRING)
	private Area deliveryarea;
	
	private String locality;
	private String city;
	private String state;
	private String country;
	private double price;
	
	//@OneToOne(mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//private Pricing pricing;
	
	public Order() {
		super();
	}
	
	
	public Order(long oid, LocalDate dor, LocalDate dod, double weight, int qty, Type deliverytype, Area deliveryarea,
			String locality, String city, String state, String country, double price) {
		super();
		this.oid = oid;
		this.dor = dor;
		this.dod = dod;
		this.weight = weight;
		this.qty = qty;
		this.deliverytype = deliverytype;
		this.deliveryarea = deliveryarea;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.country = country;
		this.price = price;
	}


	public LocalDate getDod() {
		return dod;
	}
	public void setDod(LocalDate dod) {
		this.dod = dod;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public LocalDate getDor() {
		return dor;
	}
	public void setDor(LocalDate dor) {
		this.dor = dor;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Type getDeliverytype() {
		return deliverytype;
	}
	public void setDeliverytype(Type deliverytype) {
		this.deliverytype = deliverytype;
	}
	public Area getDeliveryarea() {
		return deliveryarea;
	}
	public void setDeliveryarea(Area deliveryarea) {
		this.deliveryarea = deliveryarea;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/*public Pricing getPricing() {
		return pricing;
	}
	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}*/


	@Override
	public String toString() {
		return "Order [oid=" + oid + ", dor=" + dor + ", dod=" + dod + ", weight=" + weight + ", qty=" + qty
				+ ", deliverytype=" + deliverytype + ", deliveryarea=" + deliveryarea + ", locality=" + locality
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", price=" + price + "]";
	}
	
	
}
