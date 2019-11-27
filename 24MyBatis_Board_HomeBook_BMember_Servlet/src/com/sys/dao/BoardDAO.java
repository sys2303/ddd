package com.sys.dao;
import com.sys.dto.Board;
public interface BoardDAO extends IDAO<Board,Long>{
	public long countRows(); 
}