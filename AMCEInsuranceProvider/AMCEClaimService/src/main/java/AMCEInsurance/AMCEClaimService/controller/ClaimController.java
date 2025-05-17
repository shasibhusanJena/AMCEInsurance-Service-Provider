package AMCEInsurance.AMCEClaimService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AMCEInsurance.AMCEClaimService.model.ClaimRequest;
import AMCEInsurance.AMCEClaimService.service.ClaimService;

@RestController
@RequestMapping("/claim")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	public ResponseEntity<String> submitClaim(@RequestBody ClaimRequest claimRequest){
		claimService.saveClaim(claimRequest);
		claimService.initiateFraudCheck(claimRequest);
		return  ResponseEntity.ok("Claim submitted. Fraud check in progress");
	} 
}
