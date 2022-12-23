package com.auth_kafka.Controller;

import com.auth_kafka.Dto.RegistrationRequest;
import com.auth_kafka.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final CustomerService customerService;

    @PostMapping

    public ResponseEntity<String> signUp(@RequestBody RegistrationRequest request){
        customerService.signUp(request);
        return new ResponseEntity<>("Customer Added Successfully", HttpStatus.CREATED);

    }
}
