package com.cibertec.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {

	@Override
	public T save(T entity) {
		
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().deleteById(id);
		
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		return getDao().findAll();
	}
	
	public abstract JpaRepository<T, ID> getDao();

}
