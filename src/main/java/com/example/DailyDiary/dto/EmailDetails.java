package com.example.DailyDiary.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String emailContent;
    private String emailSubject;
    private String emailAttachment;
}
