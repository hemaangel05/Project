package com.verizon.brs.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tracking")
public class Tracking {
	
	@Id
	private String cntNo;
	private long oid;
	@Enumerated(EnumType.STRING)
	private Freight mode; 
	private double weight;
	private int qty;
	private boolean delstrt;
	private boolean deldpt;
	
	public Tracking() {
	}

	public Tracking(String cntNo, long oid, Freight mode, double weight, int qty, boolean delstrt, boolean deldpt) {
		super();
		this.cntNo = cntNo;
		this.oid = oid;
		this.mode = mode;
		this.weight = weight;
		this.qty = qty;
		this.delstrt = delstrt;
		this.deldpt = deldpt;
	}

	public String getCntNo() {
		return cntNo;
	}

	public void setCntNo(String cntNo) {
		this.cntNo = cntNo;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public Freight getMode() {
		return mode;
	}

	public void setMode(Freight mode) {
		this.mode = mode;
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

	public boolean isDelstrt() {
		return delstrt;
	}

	public void setDelstrt(boolean delstrt) {
		this.delstrt = delstrt;
	}

	public boolean isDeldpt() {
		return deldpt;
	}

	public void setDeldpt(boolean deldpt) {
		this.deldpt = deldpt;
	}

	@Override
	public String toString() {
		return "Tracking [cntNo=" + cntNo + ", oid=" + oid + ", mode=" + mode + ", weight=" + weight + ", qty=" + qty
				+ ", delstrt=" + delstrt + ", deldpt=" + deldpt + "]";
	}
	
	
}
