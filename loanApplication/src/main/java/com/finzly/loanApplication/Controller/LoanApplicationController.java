package com.finzly.loanApplication.Controller;
import java.util.List;
import com.finzly.loanApplication.Entity.LoanEntity;
import com.finzly.loanApplication.Entity.PaymentSchedule;
import com.finzly.loanApplication.Service.LoanServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoanApplicationController {
	@Autowired
	private LoanServiceImplementation loanServiceImplementation;
	
	@GetMapping("/loan")
	public List<LoanEntity> print(){
		return loanServiceImplementation.loanDisplay();
	}
	
	@PostMapping("/createLoan")
	public String loanCreate(@RequestBody LoanEntity value) {
		return loanServiceImplementation.loanCreation(value);
	}
	
	@GetMapping("/schedule/{id}")
	public LoanEntity printSchedule(@PathVariable  int id){
		return loanServiceImplementation.loanSchedule(id);
	}
	
	@GetMapping("/schedule/payment/{id}")
	public List<PaymentSchedule> paySchedule(@PathVariable  int id){
		return loanServiceImplementation.payment(id);
	}
}
