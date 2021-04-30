package com.laptrinhjavaweb.service.Ipl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.ICategory;
//import com.laptrinhjavaweb.DAO.INewsDao;
import com.laptrinhjavaweb.model.Category;
import com.laptrinhjavaweb.service.ICategoryService;
public class categoryServiceIpl implements ICategoryService {
	@Inject
	private ICategory categoryDAO;
//	@Inject
//	private INewsDao newDao;
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	@Override
	public Category save(Category category) {
		category.setCreateDate(new Timestamp(System.currentTimeMillis()));
		category.setCreatedBy("");
		category.setModifiedBy("");
		category.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Long categoryId = categoryDAO.save(category);
		return categoryDAO.findOne(categoryId);
	}
	@Override
	public Category update(Category category) {
		Category oldcatgory = categoryDAO.findOne(category.getId());
		category.setCreateDate(oldcatgory.getCreateDate());
		category.setCreatedBy(oldcatgory.getCreatedBy());
		category.setModifiedBy("");
		category.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		categoryDAO.update(category);
		return categoryDAO.findOne(category.getId());
	}
	@Override
	public void delete(Long[] ids) {
		
		for (Long id : ids) {
//			newDao.deleteByCategoryId(id);
			categoryDAO.delete(id);
		}
		
	}


}
