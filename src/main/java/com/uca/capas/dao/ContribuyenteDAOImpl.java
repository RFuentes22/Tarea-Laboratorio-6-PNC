package com.uca.capas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{

	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> res = query.getResultList();
		
		return res;
	}


    @Transactional
    public void save(Contribuyente contribuyente) throws DataAccessException{
        entityManager.persist(contribuyente);
    }

}
