package com.ers.expensesys2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.expensesys2.entity.FileEntity;

@Repository
public interface FileDao extends JpaRepository<FileEntity, Integer>{

}
