package com.onStreets.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onStreets.dto.LeadDTO;
import com.onStreets.entity.Lead;
import com.onStreets.repository.LeadRepository;

@Service
public class LeadService {
	@Autowired
	public LeadRepository leadRepository;
	
	@Autowired
	private EmailService emailService;

	public Lead saveLead(LeadDTO dto) {
		
		Lead toStore = new Lead();
		
		toStore.setName(dto.getName());
		toStore.setEmail(dto.getEmail());
		toStore.setPhone(dto.getPhone());
		toStore.setMessage(dto.getMessage());
		toStore.setCreatedAt(LocalDateTime.now());
		Lead saved = leadRepository.save(toStore);
		String content = "New Lead:\n"
	            + "Name: " + saved.getName() + "\n"
	            + "Email: " + saved.getEmail() + "\n"
	            + "Phone: " + saved.getPhone() + "\n"
	            + "Message: " + saved.getMessage();
		
		emailService.sendLeadEmail("karthik.chirukuri2005@gmail.com", content);
		
		return saved;
		
	}
	
	public List<LeadDTO> getAllLeads() {
		List<Lead> list = leadRepository.findAll();
		return list.stream().map(lead -> {
			LeadDTO dto = new LeadDTO();
			dto.setName(lead.getName());
			dto.setEmail(lead.getEmail());
			dto.setPhone(lead.getPhone());
			dto.setMessage(lead.getMessage());
			dto.setCreatedAt(lead.getCreatedAt());
			return dto;
		}).toList();
	}
}
