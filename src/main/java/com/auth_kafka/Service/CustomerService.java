package com.auth_kafka.Service;

import com.auth_kafka.Dto.EmailRequest;
import com.auth_kafka.Dto.RegistrationRequest;
import com.auth_kafka.Entity.Customer;
import com.auth_kafka.Mail.EmailSenderService;
import com.auth_kafka.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final EmailSenderService emailSenderService;

    private final KafkaTemplate<String, EmailRequest> kafkaTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signUp(RegistrationRequest request) {
        boolean isPresent = customerRepository.findByEmail(request.getEmail()).isPresent();

        if(isPresent){
            throw new RuntimeException(String.format("Customer with email %s already Exist!!", request.getEmail()));
        }else {
            Customer customer = Customer.builder().email(request.getEmail())
                    .username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).build();
            customerRepository.save(customer);
            EmailRequest emailRequest = new EmailRequest(request.getEmail(), "Registration Confirmation", "You have successfully joined us ! \n" +
                    "Welcome aboard");
            kafkaTemplate.send("gmail", emailRequest);

        }

    }
}

