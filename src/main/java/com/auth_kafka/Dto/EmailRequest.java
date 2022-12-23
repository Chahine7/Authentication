package com.auth_kafka.Dto;

public record EmailRequest(String to, String subject, String message) {
}