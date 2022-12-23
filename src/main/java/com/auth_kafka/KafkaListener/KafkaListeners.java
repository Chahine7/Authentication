package com.auth_kafka.KafkaListener;

import com.auth_kafka.Dto.EmailRequest;
import com.auth_kafka.Mail.EmailSenderService;
import com.auth_kafka.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final EmailSenderService emailSenderService;

    @KafkaListener(topics = "gmail",
            groupId = "groupId",
            containerFactory = "messageFactory")

    void listener(EmailRequest emailRequest){
        emailSenderService.sendEmail(emailRequest);

        System.out.println("Listener received: " + emailRequest );
    }
}
