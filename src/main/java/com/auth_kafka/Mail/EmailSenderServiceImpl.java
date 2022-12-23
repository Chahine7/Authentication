package com.auth_kafka.Mail;

import com.auth_kafka.Dto.EmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService{

    private final JavaMailSender javaMailSender;
    @Override
    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("chahinelaater91@gmail.com");
        simpleMailMessage.setTo(emailRequest.to());
        simpleMailMessage.setSubject(emailRequest.subject());
        simpleMailMessage.setText(emailRequest.message());

        javaMailSender.send(simpleMailMessage);

        System.out.println("Email Sent Successfully!!!!!!!!!!!!");

    }
}
