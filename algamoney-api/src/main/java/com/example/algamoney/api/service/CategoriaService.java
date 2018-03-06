package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriasRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public Categoria atualizar(long codigo, Categoria categoria) {
		Categoria categoriaSalvar = categoriasRepository.findOne(codigo);
		if(categoriaSalvar == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
		return categoriasRepository.save(categoriaSalvar);
	}

}
