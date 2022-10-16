package com.finzly.loanApplication.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class LoanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private double loanAmount;
	@CreationTimestamp
	private LocalDate tradeDate;
	private LocalDate loanStartDate;
	private LocalDate maturityDate;
	private int paymentFrequency;
	private double interestRate;
	@Enumerated(EnumType.STRING)
	private PaymentTerm payment ;
	private int totalMonth;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "paymentIdFk",referencedColumnName = "customerId")
	public List<PaymentSchedule> schedule= new ArrayList<>();
	
	
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public double getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}


	public LocalDate getTradeDate() {
		return tradeDate;
	}


	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}


	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}


	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}


	public LocalDate getMaturityDate() {
		return maturityDate;
	}


	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}


	public int getPaymentFrequency() {
		return paymentFrequency;
	}


	public void setPaymentFrequency(int paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public PaymentTerm getPayment() {
		return payment;
	}


	public void setPayment(PaymentTerm payment) {
		this.payment = payment;
	}


	public int getTotalMonth() {
		return totalMonth;
	}


	public void setTotalMonth(int totalMonth) {
		this.totalMonth = totalMonth;
	}


	public List<PaymentSchedule> getSchedule() {
		return schedule;
	}


	public void setSchedule(List<PaymentSchedule> schedule) {
		this.schedule = schedule;
	}


	public LoanEntity(int customerId, int loanAmount, LocalDate tradeDate, LocalDate loanStartDate,
			LocalDate maturityDate, int paymentFrequency, double interestRate, PaymentTerm payment) {
		super();
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.tradeDate = tradeDate;
		this.loanStartDate = loanStartDate;
		this.maturityDate = maturityDate;
		this.paymentFrequency = paymentFrequency;
		this.interestRate = interestRate;
		this.payment = payment;
	}
	
	
	public LoanEntity() {
		super();
		//TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoanEntity [customerId=" + customerId + ", loanAmount=" + loanAmount + ", tradeDate=" + tradeDate
				+ ", loanStartDate=" + loanStartDate + ", maturityDate=" + maturityDate + ", paymentFrequency="
				+ paymentFrequency + ", interestRate=" + interestRate + ", payment=" + payment + "]";
	}
	

}
