package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gerenxinxi;

public interface GerenxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gerenxinxi record);

    int insertSelective(Gerenxinxi record);

    Gerenxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gerenxinxi record);
	
    int updateByPrimaryKey(Gerenxinxi record);
	public Gerenxinxi quchongGerenxinxi(Map<String, Object> gonghao);
	public List<Gerenxinxi> getAll(Map<String, Object> map);
	public List<Gerenxinxi> getsygerenxinxi1(Map<String, Object> map);
	public List<Gerenxinxi> getsygerenxinxi3(Map<String, Object> map);
	public List<Gerenxinxi> getsygerenxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gerenxinxi> getByPage(Map<String, Object> map);
	public List<Gerenxinxi> select(Map<String, Object> map);
//	所有List
}

