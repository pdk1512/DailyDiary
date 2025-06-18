package com.example.DailyDiary.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipient;
    private String emailSubject;
    private List<String> foods;
    private List<String> drinks;
}
