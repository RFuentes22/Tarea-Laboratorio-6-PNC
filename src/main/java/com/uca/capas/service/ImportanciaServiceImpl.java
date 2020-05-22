package com.uca.capas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService{

	@Autowired
	ImportanciaDAO importanciaDAO;

	public List<Importancia> findAll() throws DataAccessException {
		return importanciaDAO.findAll();
	}

	
	@Transactional
	public void save(Importancia importancia) throws DataAccessException {
		importanciaDAO.save(importancia);
	}
	
	
}
