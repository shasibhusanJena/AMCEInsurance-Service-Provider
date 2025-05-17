package AMCEInsurance.AMCEClaimService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import AMCEInsurance.AMCEClaimService.config.AsyncConfig;
import AMCEInsurance.AMCEClaimService.model.ClaimRequest;

@Service
public class FraudCheckService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(FraudCheckService.class); 
	 public void performFraudCheck(ClaimRequest claimRequest) {
	        try {
	            logger.info("Starting fraud check for claim: {}", claimRequest.getClaimId());
	            Thread.sleep(5000); // Simulate delay
	            logger.info("Fraud check completed for claim: {}", claimRequest.getClaimId());
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            logger.error("Fraud check interrupted for claim: {}", claimRequest.getClaimId(), e);
	        } catch (Exception ex) {
	            logger.error("Unexpected error during fraud check", ex);
	        }
	    }
}
