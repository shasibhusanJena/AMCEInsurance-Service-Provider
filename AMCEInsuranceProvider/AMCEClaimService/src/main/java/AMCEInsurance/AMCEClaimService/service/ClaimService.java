package AMCEInsurance.AMCEClaimService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import AMCEInsurance.AMCEClaimService.model.ClaimRequest;

@Service
public class ClaimService {

	@Autowired
	private FraudCheckService fraudCheckService;
	
	public void saveClaim(ClaimRequest claimRequest) {
	        // Simulate saving to DB
	        System.out.println("Claim saved: " + claimRequest.getClaimId());
	    }
	@Async("asyncExecutor")
	public void initiateFraudCheck(ClaimRequest claimRequest) {
		fraudCheckService.performFraudCheck(claimRequest);
	}
	
}
