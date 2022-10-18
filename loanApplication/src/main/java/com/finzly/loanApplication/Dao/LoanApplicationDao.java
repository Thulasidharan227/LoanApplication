package com.finzly.loanApplication.Dao;


import com.finzly.loanApplication.Entity.LoanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoanApplicationDao extends JpaRepository<LoanEntity ,Integer> {
	

}
