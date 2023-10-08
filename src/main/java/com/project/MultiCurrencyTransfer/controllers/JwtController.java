package com.project.MultiCurrencyTransfer.controllers;

import com.project.MultiCurrencyTransfer.entities.JwtRequest;
import com.project.MultiCurrencyTransfer.entities.JwtResponse;
import com.project.MultiCurrencyTransfer.helpers.JwtUtil;
import com.project.MultiCurrencyTransfer.services.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/jwt/")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println("Inside Controller");
        System.out.println(jwtRequest);
        try {

            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        // fine area..
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getEmail());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT " + token);

        // {"token":"value"}

        return ResponseEntity.ok(new JwtResponse(token));

    }
}
