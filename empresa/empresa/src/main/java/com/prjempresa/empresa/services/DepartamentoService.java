package com.prjempresa.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prjempresa.empresa.entities.Departamento;
import com.prjempresa.empresa.repositories.DepartamentoRepository;

@Service
	public class DepartamentoService{
		private DepartamentoRepository Departamentorepository;

	public DepartamentoService(DepartamentoRepository departamentorepository) {
		this.Departamentorepository = departamentorepository;
	}

	public Departamento savedepartamento(Departamento departamento) {
		return Departamentorepository.save(departamento);
	}

	public Departamento getdepartamentoById(Long depcodigo) {
		return Departamentorepository.findById(depcodigo).orElse(null);
	}

	public List<Departamento> getAllDepartamento() {
		return Departamentorepository.findAll();
	}

	public void deletedepartamento(Long depcodigo) {
		Departamentorepository.deleteById(depcodigo);
	}

	public Departamento saveDepartamento(Departamento departamento) {
		return Departamentorepository.save(departamento);
	}

	public Departamento updatedepartamento(Long depcodigo, Departamento departamento) {
		Optional<Departamento> departamentoOptional = Departamentorepository.findById(depcodigo);

		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepnome(departamento.getDepnome());
			return Departamentorepository.save(departamentoExistente);
		} else {
			return null;
		}
	}
	}
