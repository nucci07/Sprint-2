package com.prjempresa.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjempresa.empresa.entities.Funcionario;
import com.prjempresa.empresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private FuncionarioRepository Funcionariorepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}
 
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> getFuncionariosByFunnomeAproximado(String funnome) {
        return funcionarioRepository.findByNomeContaining(funnome);
    }

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());

			// Atualize o departamento
			if (novoFuncionario.getDepartamento() != null) {
				funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
			}		
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}

public FuncionarioService(FuncionarioRepository funcionariorepository) {
	this.Funcionariorepository = funcionariorepository;
}

public Funcionario savefuncionario(Funcionario funcionario) {
	return Funcionariorepository.save(funcionario);
}

public Funcionario getfuncionarioById(Long Funcodigo) {
	return Funcionariorepository.findById(Funcodigo).orElse(null);
}

public List<Funcionario> getAllFuncionario() {
	return Funcionariorepository.findAll();
}

public void deletefuncionario(Long Funcodigo) {
	Funcionariorepository.deleteById(Funcodigo);
}


public Funcionario updatefuncionario(Long Funcodigo, Funcionario novofuncionario) {
	Optional<Funcionario> funcionarioOptional = Funcionariorepository.findById(Funcodigo);

	if (funcionarioOptional.isPresent()) {
		Funcionario funcionarioExistente = funcionarioOptional.get();
		funcionarioExistente.setFunnome(novofuncionario.getFunnome());
		funcionarioExistente.setFunnascimento(novofuncionario.getFunnascimento());
		funcionarioExistente.setFunsalario(novofuncionario.getFunsalario());
		return Funcionariorepository.save(funcionarioExistente);
	} else {
		return null;
	}
}
}
