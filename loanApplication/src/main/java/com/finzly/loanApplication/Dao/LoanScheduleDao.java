package com.finzly.loanApplication.Dao;

import com.finzly.loanApplication.Entity.PaymentSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanScheduleDao extends JpaRepository<PaymentSchedule ,Integer> {

}
