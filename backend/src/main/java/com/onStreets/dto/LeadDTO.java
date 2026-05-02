package com.onStreets.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeadDTO {
	@NotBlank(message = "Name is required")
	private String name;
	
	@Email(message = "Invalid email")
    private String email;
	
	@NotBlank(message = "Phone is required")
    private String phone;
	
	@Column(length = 1000)
    private String message;
	
    private LocalDateTime createdAt;
}
