package com.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "request_for_help")
public class RequestForHelp implements Serializable  {
	//request for help field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id")
	private int requestId;
	
	@NotNull
	@Column(name = "needy_person_name")
	private String needyPersonName;
	
	@NotNull
	private String phone;
	@NotNull
	private String item;
	@NotNull
    private String status;
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
 public String getStatus() {
	 return status;
 }
	public void setStatus(String status) {
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
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

	
	@Override
	public String toString() {
		return "RequestForHelp [requestId=" + requestId + ", needyPersonName=" + needyPersonName + ", phone=" + phone
				+ ", item=" + item + ", status=" + status + "]";
	}
	
	
}