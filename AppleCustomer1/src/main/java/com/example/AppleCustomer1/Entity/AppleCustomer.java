package com.example.AppleCustomer1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Apple_Customer")
public class AppleCustomer {

	private int ModelNumber;

	@Id
	private int Customer_id;
	private String Customer_User_Name;
	private String Customer_Password;
	private String Customer_name;
	private long Customer_Mobile_No;
	private String Customer_Email_id;
	private int Overall_Purchased_Quantity;

	public AppleCustomer() {
	}

	public AppleCustomer(int modelNumber, int customer_id, String customer_User_Name, String customer_Password,
			String customer_name, long customer_Mobile_No, String customer_Email_id, int overall_Purchased_Quantity) {
		super();
		this.ModelNumber = modelNumber;
		this.Customer_id = customer_id;
		this.Customer_User_Name = customer_User_Name;
		this.Customer_Password = customer_Password;
		this.Customer_name = customer_name;
		this.Customer_Mobile_No = customer_Mobile_No;
		this.Customer_Email_id = customer_Email_id;
		this.Overall_Purchased_Quantity = overall_Purchased_Quantity;
	}

	public int getModelNumber() {
		return ModelNumber;
	}

	public void setModelNumber(int modelNumber) {
		ModelNumber = modelNumber;
	}

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public String getCustomer_User_Name() {
		return Customer_User_Name;
	}

	public void setCustomer_User_Name(String customer_User_Name) {
		Customer_User_Name = customer_User_Name;
	}

	public String getCustomer_Password() {
		return Customer_Password;
	}

	public void setCustomer_Password(String customer_Password) {
		Customer_Password = customer_Password;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public long getCustomer_Mobile_No() {
		return Customer_Mobile_No;
	}

	public void setCustomer_Mobile_No(long customer_Mobile_No) {
		Customer_Mobile_No = customer_Mobile_No;
	}

	public String getCustomer_Email_id() {
		return Customer_Email_id;
	}

	public void setCustomer_Email_id(String customer_Email_id) {
		Customer_Email_id = customer_Email_id;
	}

	public int getOverall_Purchased_Quantity() {
		return Overall_Purchased_Quantity;
	}

	public void setOverall_Purchased_Quantity(int overall_Purchased_Quantity) {
		Overall_Purchased_Quantity = overall_Purchased_Quantity;
	}

	@Override
	public String toString() {
		return "AppleCustomer [ModelNumber=" + ModelNumber + ", Customer_id=" + Customer_id + ", Customer_User_Name="
				+ Customer_User_Name + ", Customer_Password=" + Customer_Password + ", Customer_name=" + Customer_name
				+ ", Customer_Mobile_No=" + Customer_Mobile_No + ", Customer_Email_id=" + Customer_Email_id
				+ ", Overall_Purchased_Quantity=" + Overall_Purchased_Quantity + "]";
	}

}
