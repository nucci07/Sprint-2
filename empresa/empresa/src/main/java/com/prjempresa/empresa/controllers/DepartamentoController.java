package com.prjempresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjempresa.empresa.entities.Departamento;
import com.prjempresa.empresa.services.DepartamentoService;

@RestController
@RequestMapping("/Departamento")
public class DepartamentoController {

	private final DepartamentoService Departamentoservice;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	@Autowired
	public DepartamentoController(DepartamentoService Departamentoservice) {
		this.Departamentoservice = Departamentoservice;
	}

	@PostMapping
	public Departamento createDepartamentos(@RequestBody Departamento Departamento) {
		return Departamentoservice.saveDepartamento(Departamento);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long Depcodigo) {
		Departamento Departamento = Departamentoservice.getdepartamentoById(Depcodigo);
		if (Departamento != null) {
			return ResponseEntity.ok(Departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long Depcodigo) {
		Departamentoservice.deletedepartamento(Depcodigo);
	}

	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> Departamento = Departamentoservice.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(Departamento);
	}

	@PutMapping("/{id}")
	public Departamento updateDepartamento(@PathVariable Long Depcodigo, @RequestBody Departamento departamento) {
		return Departamentoservice.updatedepartamento(Depcodigo, departamento);
	}

}
