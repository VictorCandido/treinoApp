package com.treinoApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.treinoApp.model.Usuarios;

public interface IUsuarios extends JpaRepository<Usuarios, Long>{
	
	@Query(value = "SELECT * FROM usuarios WHERE Ativo = true", nativeQuery = true)
	public List<Usuarios> getUsersAtivos();
}
