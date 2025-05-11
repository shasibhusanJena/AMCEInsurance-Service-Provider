package AMCEInsurance.AMCEUserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import AMCEInsurance.AMCEUserService.Entity.AuthRequest;
import AMCEInsurance.AMCEUserService.Entity.AuthResponse;
import AMCEInsurance.AMCEUserService.security.JwtUtil;
import AMCEInsurance.AMCEUserService.service.CustomUserDetailsService;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        // Authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Load user details from the database
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        // Generate JWT token
        String jwt = jwtUtil.generateToken(userDetails.getUsername(), ((org.springframework.security.core.userdetails.User) userDetails).getAuthorities().toString());

        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
