package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Code;
import com.example.demo.entity.CodeId;

public interface CodeService {
	public List<Code> selectList();
	public List<Code> selectPCList();
	public Code selectOne(CodeId id);
	public void save(Code entity);
	public void delete(CodeId id);
}
