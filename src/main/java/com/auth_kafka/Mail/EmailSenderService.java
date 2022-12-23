package com.auth_kafka.Mail;

import com.auth_kafka.Dto.EmailRequest;

public interface EmailSenderService {
    void sendEmail(EmailRequest emailRequest);
}
