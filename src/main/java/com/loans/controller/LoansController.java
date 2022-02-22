package com.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loans.model.Customer;
import com.loans.model.Loans;
import com.loans.repository.LoansRepository;

@RestController
public class LoansController {

	@Autowired
	LoansRepository loansRepository ;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestBody Customer customer){
		List<Loans> loanList = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if(loanList!=null) {
			return loanList;
		}else {
			return null;
		}
	}
}
