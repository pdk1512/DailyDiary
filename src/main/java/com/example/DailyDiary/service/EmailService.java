package com.example.DailyDiary.service;

import com.example.DailyDiary.dto.EmailDetails;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity<String> sendEmail(EmailDetails emailDetails);
}
