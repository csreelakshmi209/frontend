package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "needy_people")
public class NeedyPeople implements Serializable {

	// needyPeople fields

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "needy_person_id")
	private int needyPersonId;
	@NotNull
	@Column(name = "needy_person_name")
	private String needyPersonName;
	@NotNull
	private String phone;
	@NotNull
	@Column(name = "family_income")
	private double familyIncome;

	// mapping to address
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	// getters and setters

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// to string
	@Override
	public String toString() {
		return "NeedyPeople [needyPersonId=" + needyPersonId + ", needyPersonName=" + needyPersonName + ", phone="
				+ phone + ", familyIncome=" + familyIncome + ", address=" + address + "]";
	}

}