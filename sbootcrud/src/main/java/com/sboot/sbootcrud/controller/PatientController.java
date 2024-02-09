package com.sboot.sbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.sbootcrud.dao.PatientDAO;
import com.sboot.sbootcrud.dto.PatientDTO;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	PatientDAO dao;

	@PostMapping
	public String insertPatient(@RequestBody PatientDTO dto) {
//		System.out.println(dto);
		return dao.insertPatient(dto);
	}

	@GetMapping("/view/{id}")
	public PatientDTO viewPatientById(@PathVariable int id) {
//		int id = dto.getId();-->@RequestBody PatientDTO dto
		return dao.viewPatientById(id);
	}

	@GetMapping("/viewall")
	public List<PatientDTO> viewAllPatient() {
		return dao.viewAllPatient();
	}

	@DeleteMapping("/delete/{id}")
	public String deletePatientBtId(@PathVariable int id) {
		return dao.deletePatientBtId(id);
	}

	@DeleteMapping("/deleteall")
	public String deleteAllPatient() {
		return dao.deleteAllPatient();
	}

	@PutMapping("/update/{id}")
	public String updatePatient(@PathVariable int id, @RequestBody PatientDTO dto) {
		return dao.updatePatient(id, dto);
	}
}