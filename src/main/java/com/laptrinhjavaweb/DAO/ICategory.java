package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.Category;

public interface ICategory extends GenericDAO <Category> {
	List<Category> findAll ();
	Long save(Category category);
	void update(Category category);
	void delete(Long id);
	Category findOneByCode(String code);
	Category findOne(Long id);
}
