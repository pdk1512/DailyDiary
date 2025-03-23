package com.example.DailyDiary.controller;

import com.example.DailyDiary.dto.EmailDetails;
import com.example.DailyDiary.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDetails emailDetails) {
        return emailService.sendEmail(emailDetails);
    }
}
