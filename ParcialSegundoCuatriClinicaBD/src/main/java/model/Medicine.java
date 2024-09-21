package model;

import java.math.BigDecimal;

public class Medicine {
	private int medicine;
	private String name;
	private BigDecimal unitPrice;
	
	public Medicine(int medicine, String name, BigDecimal unitPrice) {
		super();
		this.medicine = medicine;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	public int getMedicine() {
		return medicine;
	}
	public void setMedicine(int medicine) {
		this.medicine = medicine;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return  name + " ($" + unitPrice + ")";
	}
	
}
