package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Genero;
import com.example.demo.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository generoRepository;

	public GeneroRepository getGeneroRepository() {
		return generoRepository;
	}
	
	public List<Genero> getAllGenero() {
		return generoRepository.findAll();
	}
	
	public Genero getGeneroByID(Long id) {
		return generoRepository.findById(id).orElse(null);
	}
	
}
