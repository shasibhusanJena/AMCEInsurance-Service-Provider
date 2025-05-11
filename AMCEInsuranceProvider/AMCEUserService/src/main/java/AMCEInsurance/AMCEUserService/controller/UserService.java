package AMCEInsurance.AMCEUserService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AMCEInsurance.AMCEUserService.service.HelloService;

@RestController
@RequestMapping("/api")
public class UserService {
	

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }
    
	@GetMapping(value = "/hi")
	public ResponseEntity<String> getHelloMethod(){
		return new ResponseEntity<>(new HelloService().getHelloMsg(), HttpStatus.OK );
	}
}
