package com.onStreets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onStreets.dto.LeadDTO;
import com.onStreets.entity.Lead;
import com.onStreets.service.LeadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {
	@Autowired
	public LeadService leadService;
	
	@PostMapping
	public ResponseEntity<Lead> createLead(@Valid @RequestBody LeadDTO dto) {
	    return new ResponseEntity<>(leadService.saveLead(dto), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<LeadDTO>> getLeads(){
		return new ResponseEntity<>(leadService.getAllLeads(), HttpStatus.OK);
	}
	
}
