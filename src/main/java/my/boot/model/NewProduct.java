package my.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="NEW_PRODUCT")
public class NewProduct {
	
	@Override
	public String toString() {
		return "color: "+ color+" quantity: "+quantity;
	}

	@Id
	@Column(name ="COLOR")
	private String color;
	
	@Column(name ="QUANTITY")
	private int quantity;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
