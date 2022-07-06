package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiaoshi;

public interface JiaoshiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiaoshi record);

    int insertSelective(Jiaoshi record);

    Jiaoshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiaoshi record);
	
    int updateByPrimaryKey(Jiaoshi record);
	public Jiaoshi quchongJiaoshi(Map<String, Object> gonghao);
	public List<Jiaoshi> getAll(Map<String, Object> map);
	public List<Jiaoshi> getsyjiaoshi1(Map<String, Object> map);
	public List<Jiaoshi> getsyjiaoshi3(Map<String, Object> map);
	public List<Jiaoshi> getsyjiaoshi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiaoshi> getByPage(Map<String, Object> map);
	public List<Jiaoshi> select(Map<String, Object> map);
//	所有List
}

