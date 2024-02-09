package com.sboot.sbootcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sboot.sbootcrud.dto.PatientDTO;
import com.sboot.sbootcrud.repository.PatientRepository;

@Component
public class PatientDAO {
	@Autowired
	PatientRepository pr;

	public String insertPatient(PatientDTO dto) {
		pr.save(dto);
		return "Inserted Successfully";
	}

	public PatientDTO viewPatientById(int id) {
		Optional<PatientDTO> op = pr.findById(id);
		if (op.isPresent()) {
			PatientDTO dto = op.get();
			return dto;
		} else
			return null;
	}

	public List<PatientDTO> viewAllPatient() {
		List<PatientDTO> list = pr.findAll();
		if (list.isEmpty())
			return null;
		else
			return list;
	}

	public String deletePatientBtId(int id) {
		Optional<PatientDTO> op = pr.findById(id);
		if (op.isPresent()) {
			pr.deleteById(id);
			return "Deleted Successfully";
		} else {
			return "No Data Found To Delete";
		}
	}

	public String deleteAllPatient() {
		pr.deleteAll();
		return "All Data Deleted";
	}

	public String updatePatient(int id, PatientDTO dto) {
		Optional<PatientDTO> op = pr.findById(id);
		if (op.isPresent()) {
			PatientDTO data = op.get();
			data.setName(dto.getName());
			pr.save(data);
			return "Updated Successfully";
		} else
			return "No Data Found To Update";
	}
}