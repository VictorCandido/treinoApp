package com.treinoApp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotEmpty(message = "Nome não preenchido")
	private String Nome;
	
	private Boolean Ativo;
	
	private Date DataNascimento;
	
	@NotEmpty(message = "CPF não preenchido")
	@CPF(message = "CPF inválido")
	private String Cpf;
	
	@NotNull(message = "A idade deve ser inserida")
	@Min(value = 18, message = "A idade não deve ser menor do que 18 anos")
	private Long Idade;
	
	private String Genero;
	
	private String Nacionalidade;
	
	private String Senha;
	
	@NotEmpty(message = "Campo E-mail não pode ser vazio")
	@Email(message = "E-mail inválido")
	private String Email;
	
	public List<Endereco> getEnderecos() {
		return Enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		Enderecos = enderecos;
	}
	@OneToMany(targetEntity=Endereco.class, mappedBy="Usuarios",cascade=CascadeType.ALL, fetch = FetchType.LAZY)   
	private List<Endereco> Enderecos = new ArrayList<>();
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Boolean getAtivo() {
		return Ativo;
	}
	public void setAtivo(Boolean ativo) {
		Ativo = ativo;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public Long getIdade() {
		return Idade;
	}
	public void setIdade(Long idade) {
		Idade = idade;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getNacionalidade() {
		return Nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
