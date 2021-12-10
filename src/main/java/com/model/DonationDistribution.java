package com.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "donation_distributions")
public class DonationDistribution implements Serializable {

	// donation distribution fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "distribution_id")
	private int distributionId;
	@Column(name = "amount_distributed")
	private double amountDistributed;
	@Column(name = "date_of_distribution")
	private Date dateOfDistribution;
	@NotNull
	@Column(name = "approvalOrRejectedDate")
	private Date approvalOrRejectedDate;

	// mapping of enum class
	@Enumerated(EnumType.STRING)
	private DonationDistributionStatus status;

	// mapping to needy people
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "needy_person_id")
	private NeedyPeople person;

	// mapping to employee
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	// mapping to donation items
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private DonationItem item;

	// getters and setters
	public int getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public NeedyPeople getPerson() {
		return person;
	}

	public void setPerson(NeedyPeople person) {
		this.person = person;
	}

	public DonationItem getItem() {
		return item;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public Employee getDistributedBy() {
		return employee;
	}

	public void setDistributedBy(Employee employee) {
		this.employee = employee;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public Date getDateOfDistribution() {
		return dateOfDistribution;
	}

	public void setDateOfDistribution(Date dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public Date getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}

	// to string
	@Override
	public String toString() {
		return "DonationDistribution [distributionId=" + distributionId + ", amountDistributed=" + amountDistributed
				+ ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate=" + approvalOrRejectedDate
				+ ", status=" + status + ", person=" + person + ", employee=" + employee + ", item=" + item + "]";
	}

}