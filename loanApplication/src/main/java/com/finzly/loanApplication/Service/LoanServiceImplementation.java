package com.finzly.loanApplication.Service;

import java.time.LocalDate;
import java.util.List;
import com.finzly.loanApplication.Dao.LoanApplicationDao;
import com.finzly.loanApplication.Dao.LoanScheduleDao;
import com.finzly.loanApplication.Entity.LoanEntity;
import com.finzly.loanApplication.Entity.PaymentSchedule;
import com.finzly.loanApplication.Entity.PaymentTerm;
import com.finzly.loanApplication.Entity.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImplementation {

	@Autowired
	LoanApplicationDao repository;
	@Autowired
	LoanScheduleDao ScheduleRepository;

	public String loanCreation(LoanEntity loanDetails) {
		List<PaymentSchedule> listLoanSchedule = loanDetails.getSchedule();
		double loanAmount = loanDetails.getLoanAmount();
		loanDetails.setLoanAmount(loanDetails.getLoanAmount());
		loanDetails.setTradeDate(LocalDate.now());

		int schedule = loanDetails.getTotalMonth() / loanDetails.getPaymentFrequency();
		loanDetails.setMaturityDate(loanDetails.getLoanStartDate().plusMonths(loanDetails.getTotalMonth()));
		LocalDate paymentDate = loanDetails.getLoanStartDate();
		for (int i = 0; i < schedule; i++) {
			PaymentSchedule paymentSchedule = new PaymentSchedule();
			paymentDate = paymentDate.plusMonths(loanDetails.getPaymentFrequency());
			paymentSchedule.setPaymentDate(paymentDate);
			if (loanDetails.getPayment().equals(PaymentTerm.EvenPrincipal)) {
				paymentSchedule.setStatus(Status.PROJECTED);
				paymentSchedule.setPrincipalAmount(loanAmount / schedule);
				paymentSchedule.setProjectedInterest(loanAmount / loanDetails.getInterestRate());
				loanAmount = loanAmount - paymentSchedule.getPrincipalAmount();
				paymentSchedule.setPaymentAmount(
						paymentSchedule.getProjectedInterest() + paymentSchedule.getPrincipalAmount());
			} else {
				paymentSchedule.setStatus(Status.PROJECTED);
				if (paymentSchedule.getPaymentDate().equals(loanDetails.getMaturityDate())) {
					paymentSchedule.setPaymentAmount(loanDetails.getLoanAmount());
				} else {
					paymentSchedule.setPrincipalAmount(0);
				}
				double payment;
				paymentSchedule.setProjectedInterest(
						((loanDetails.getLoanAmount() * loanDetails.getInterestRate()) / 100) * loanDetails.getPaymentFrequency());
				payment = (paymentSchedule.getPaymentDate().equals(loanDetails.getMaturityDate()))
						? paymentSchedule.getProjectedInterest() + loanDetails.getLoanAmount()
						: paymentSchedule.getProjectedInterest();
				paymentSchedule.setPaymentAmount(payment);
			}
			if(paymentSchedule.getPaymentDate().compareTo(LocalDate.now())<0) {
				paymentSchedule.setStatus(Status.PAID);
			}
			else if(paymentSchedule.getPaymentDate().equals(LocalDate.now()) && paymentSchedule.getStatus().equals(Status.PROJECTED)) {
				paymentSchedule.setStatus(Status.AWAITINGPAYMENT);
			}

			listLoanSchedule.add(paymentSchedule);
		}

		loanDetails.setSchedule(listLoanSchedule);

		repository.save(loanDetails);
		return "The Loan is Created";

	}

	public List<LoanEntity> loanDisplay() {
		return repository.findAll();
	}
	 
	public List<PaymentSchedule> payment(int id) {
		LoanEntity loan = repository.findById(id).get();
		for(PaymentSchedule schedule : loan.schedule) {
			if(schedule.getPaymentDate().compareTo(LocalDate.now())<0 || schedule.getStatus().equals(Status.AWAITINGPAYMENT)) {
				schedule.setStatus(Status.PAID);
			}
			else if(schedule.getPaymentDate().equals(LocalDate.now()) && schedule.getStatus().equals(Status.PROJECTED)) {
				schedule.setStatus(Status.AWAITINGPAYMENT);
			}
			ScheduleRepository.save(schedule);
		}
		return loan.getSchedule();
	}

	public LoanEntity loanSchedule(int id) {
		LoanEntity loanDetails = repository.findById(id).get();
		System.out.println(loanDetails);
		List<PaymentSchedule> schedule = loanDetails.getSchedule();
		for (PaymentSchedule paymentSchedule : schedule) {
			if (paymentSchedule.getPaymentDate().equals(LocalDate.now())
					&& paymentSchedule.getStatus().equals(Status.PROJECTED)) {
				paymentSchedule.setStatus(Status.AWAITINGPAYMENT);
			}

		}
		repository.save(loanDetails);
		return repository.findById(id).get();

	}
}
