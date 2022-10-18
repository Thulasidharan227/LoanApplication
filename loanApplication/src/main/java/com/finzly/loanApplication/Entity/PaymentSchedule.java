package com.finzly.loanApplication.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PaymentSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private LocalDate paymentDate;
	private double principalAmount;
	private double projectedInterest;
	@Enumerated(EnumType.STRING)
	private Status status;
	private double paymentAmount;
	
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	public double getProjectedInterest() {
		return projectedInterest;
	}
	public void setProjectedInterest(double projectedInterest) {
		this.projectedInterest = projectedInterest;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	@Override
	public String toString() {
		return "PaymentSchedule [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", principalAmount="
				+ principalAmount + ", projectedInterest=" + projectedInterest + ", status=" + status
				+ ", paymentAmount=" + paymentAmount + "]";
	}
	public PaymentSchedule(int paymentId, LocalDate paymentDate, double principalAmount, double projectedInterest,
			Status status, double paymentAmount) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.principalAmount = principalAmount;
		this.projectedInterest = projectedInterest;
		this.status = status;
		this.paymentAmount = paymentAmount;
	}
	public PaymentSchedule() {
		
	}
	
	

}
