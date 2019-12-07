package com.treinoApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinoApp.model.Endereco;
import com.treinoApp.repository.IEndereco;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	@Autowired
	private IEndereco enderecosRepository;
	
	@GetMapping("/getAllEnderecos")
	public List<Endereco> getAllEnderecos () {
		return enderecosRepository.findAll();
	}
	
	@GetMapping("/getEndereco/{id}")
	public Optional<Endereco> getEndereco(@PathVariable("id") Long id) {
		return enderecosRepository.findById(id);
	}
	
	@DeleteMapping("/deleteEndereco/{id}")
	public void deleteEndereco (@PathVariable("id") Long id) {
		enderecosRepository.deleteById(id);
	}
	
	@PostMapping("/saveNewEndereco")
	public Endereco saveNewEndereco(@RequestBody Endereco endereco) {
		return enderecosRepository.save(endereco);
	}
}
