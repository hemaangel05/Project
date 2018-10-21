package com.verizon.brs.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="pricing")
public class Pricing {
	
	@Id
	//@GeneratedValue(generator="mygen")
	//@GenericGenerator(name="mygen",strategy="foreign",
	//parameters= {@Parameter(name="property",value="order")})
	private long oid;
	//@Enumerated(EnumType.STRING )
	//private Freight freight;
	@Enumerated(EnumType.STRING )
	private Area deliveryarea;
	@Enumerated(EnumType.STRING )
	private Type deliverytype;
	private double price;
	@ColumnDefault(value="false")
	private boolean isCancel;
	private double cancelcharges;
	
	//@OneToOne
	//@PrimaryKeyJoinColumn
	//private Order order;
	
	
	public Pricing() {
	}
	
	
	public Pricing(long oid, Type deliverytype, Area deliveryarea, double price, boolean isCancel,
			double cancelcharges) {
		super();
		this.oid = oid;
		//this.freight = freight;
		this.deliveryarea = deliveryarea;
		this.deliverytype = deliverytype;
		this.price = price;
		this.isCancel = isCancel;
		this.cancelcharges = cancelcharges;
	}

	
	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	/*public Freight getFreight() {
		return freight;
	}

	public void setFreight(Freight freight) {
		this.freight = freight;
	}*/

	public Area getDeliveryarea() {
		return deliveryarea;
	}

	public void setDeliveryarea(Area deliveryarea) {
		this.deliveryarea = deliveryarea;
	}

	public Type getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(Type deliverytype) {
		this.deliverytype = deliverytype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public boolean isCancel() {
		return isCancel;
	}


	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}


	public double getCancelcharges() {
		return cancelcharges;
	}

	public void setCancelcharges(double cancelcharges) {
		this.cancelcharges = cancelcharges;
	}

	/*public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}*/


	@Override
	public String toString() {
		return "Pricing [oid=" + oid + ", deliveryarea=" + deliveryarea + ", deliverytype="
				+ deliverytype + ", price=" + price + ", isCancel=" + isCancel + ", cancelcharges=" + cancelcharges
				+ "]";
	}
	
	
}
