package com.treinoApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Optional<Usuarios> getUser(@PathVariable("id") Long idUser) {
		return usuariosRepository.findById(idUser);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Long idUser) {
		usuariosRepository.deleteById(idUser);
	}
}
