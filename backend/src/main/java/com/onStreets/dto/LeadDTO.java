package com.onStreets.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LeadDTO {
	private String name;
    private String email;
    private String phone;
    private String message;
    private LocalDateTime createdAt;
}
