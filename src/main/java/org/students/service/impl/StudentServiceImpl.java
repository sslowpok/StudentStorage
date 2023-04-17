package org.students.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.students.api.dto.mapper.StudentMapper;
import org.students.api.dto.student.StudentAddRequest;
import org.students.api.dto.student.StudentResponse;
import org.students.api.dto.student.StudentUpdateRequest;
import org.students.model.Student;
import org.students.repository.StudentRepository;
import org.students.service.StudentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final StudentMapper studentMapper;

	@Override
	public List<StudentResponse> getStudents() {
		List<Student> list = studentRepository.findAll();
		return studentMapper.listEntitiesToResponse(list);
	}

	@Override
	public StudentResponse getStudentById(Long id) {
		Student entity = studentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return studentMapper.entityToResponse(entity);
	}

	@Override
	public StudentResponse addStudent(StudentAddRequest request) {
		Student entity = studentRepository.save(studentMapper.postRequestToEntity(request));
		return studentMapper.entityToResponse(entity);
	}

	@Override
	public StudentResponse updateStudent(StudentUpdateRequest request) {
		Student requestEntity = studentMapper.putRequestToEntity(request);
		Student entity = studentRepository.findById(request.getId())
				.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		studentMapper.merge(entity, requestEntity);
		return studentMapper.entityToResponse(studentRepository.save(entity));
	}

	@Override
	@Transactional
	public void deleteStudent(Long id) {
		Student entity = studentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		entity.setDeleted(true);
	}
}
