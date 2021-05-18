package com.laptrinhjavaweb.DAO.Ipl;

import java.util.List;

import com.laptrinhjavaweb.DAO.ICategory;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.Category;

public class categoryDAO extends AbstractDAO<Category> implements ICategory {

    @Override
    public List<Category> findAll() {
        String sql = "select * from category ";
        return query(sql, new CategoryMapper());
    }

    @Override
    public Long save(Category category) {
        String sql = "Insert into category ( name, code, createDate, modifiedDate, createdBy, modifiedBy) VALUES (?,?,?,?,?,?)";
        return insert(sql, category.getName(), category.getCode(),
                category.getCreateDate(), category.getModifiedDate(), category.getCreatedBy(), category.getModifiedBy());
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE category SET name = ?,code= ?, createDate = ?, modifiedDate = ?, createdBy = ?, modifiedBy = ? WHERE (id = ?)";
        insert(sql, category.getName(), category.getCode(), category.getCreateDate(), category.getModifiedDate(), category.getCreatedBy(), category.getModifiedBy(), category.getId());

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM category WHERE id = ?";
        this.update(sql, id);

    }

    @Override
    public Category findOneByCode(String code) {
        String sql = "SELECT * FROM category WHERE code = ?";
        List<Category> category = query(sql, new CategoryMapper(), code);
        return category.isEmpty() ? null : category.get(0);
    }

    @Override
    public Category findOne(Long id) {
        String sql = "select * from category where Id = ?";
        List<Category> category = query(sql, new CategoryMapper(), id);
        return category.isEmpty() ? null : category.get(0);
    }

}
