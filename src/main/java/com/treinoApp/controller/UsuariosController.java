package com.treinoApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinoApp.model.Usuarios;
import com.treinoApp.repository.IUsuarios;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuarios usuariosRepository;
	
	@GetMapping("/getAllUsers")
	public List<Usuarios> getAllUsers() {
		return usuariosRepository.findAll();
	}
	
	@GetMapping("/getUser/{id}")
	public Optional<Usuarios> getUser(@PathVariable("id") Long id) {
		return usuariosRepository.findById(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		usuariosRepository.deleteById(id);
	}
	
	@PostMapping("/saveNewUser")
	public ResponseEntity saveNewUser(@RequestBody @Valid Usuarios user) {
		Usuarios insertUser = usuariosRepository.save(user);
		return new ResponseEntity<Usuarios>(insertUser, HttpStatus.CREATED);
	}
}
