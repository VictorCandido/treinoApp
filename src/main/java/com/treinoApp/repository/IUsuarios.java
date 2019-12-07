package com.treinoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinoApp.model.Usuarios;

public interface IUsuarios extends JpaRepository<Usuarios, Long>{
	
}
