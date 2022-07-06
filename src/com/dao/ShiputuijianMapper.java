package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shiputuijian;

public interface ShiputuijianMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shiputuijian record);

    int insertSelective(Shiputuijian record);

    Shiputuijian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shiputuijian record);
	
    int updateByPrimaryKey(Shiputuijian record);
	public Shiputuijian quchongShiputuijian(Map<String, Object> gonghao);
	public List<Shiputuijian> getAll(Map<String, Object> map);
	public List<Shiputuijian> getsyshiputuijian1(Map<String, Object> map);
	public List<Shiputuijian> getsyshiputuijian3(Map<String, Object> map);
	public List<Shiputuijian> getsyshiputuijian2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shiputuijian> getByPage(Map<String, Object> map);
	public List<Shiputuijian> select(Map<String, Object> map);
//	所有List
}

