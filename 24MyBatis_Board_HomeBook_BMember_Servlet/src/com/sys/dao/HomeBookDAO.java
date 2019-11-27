package com.sys.dao;

import java.util.List;

import com.sys.dto.HomeBook;
public interface HomeBookDAO extends IDAO<HomeBook, Long> {
	List<HomeBook> selectAllById(String id);
}