package com.prjempresa.empresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Funcionario")
public class Funcionario {

	@ManyToOne
	private Departamento departamento;

	//inserir os metodos get e o set
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Funcodigo;

	private String Funnome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate Funnascimento;
	
	private Double Funsalario;
	
	public Funcionario() {
	}

	public Funcionario(Long funcodigo, String funnome, LocalDate funnascimento, Double funsalario) {
		super();
		this.Funcodigo = Funcodigo;
		this.Funnome = Funnome;
		this.Funnascimento = Funnascimento;
		this.Funsalario = Funsalario;
	}

	public Long getFuncodigo() {
		return Funcodigo;
	}

	public void setFuncodigo(Long Funcodigo) {
		this.Funcodigo = Funcodigo;
	}

	public String getFunnome() {
		return Funnome;
	}

	public void setFunnome(String Funnome) {
		this.Funnome = Funnome;
	}

	public LocalDate getFunnascimento() {
		return Funnascimento;
	}

	public void setFunnascimento(LocalDate Funnascimento) {
		this.Funnascimento = Funnascimento;
	}

	public Double getFunsalario() {
		return Funsalario;
	}

	public void setFunsalario(Double Funsalario) {
		this.Funsalario = Funsalario;
	}
}

	
