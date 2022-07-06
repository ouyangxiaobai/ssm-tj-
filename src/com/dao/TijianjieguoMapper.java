package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tijianjieguo;

public interface TijianjieguoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tijianjieguo record);

    int insertSelective(Tijianjieguo record);

    Tijianjieguo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tijianjieguo record);
	
    int updateByPrimaryKey(Tijianjieguo record);
	public Tijianjieguo quchongTijianjieguo(Map<String, Object> gonghao);
	public List<Tijianjieguo> getAll(Map<String, Object> map);
	public List<Tijianjieguo> getsytijianjieguo1(Map<String, Object> map);
	public List<Tijianjieguo> getsytijianjieguo3(Map<String, Object> map);
	public List<Tijianjieguo> getsytijianjieguo2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tijianjieguo> getByPage(Map<String, Object> map);
	public List<Tijianjieguo> select(Map<String, Object> map);
//	所有List
}

