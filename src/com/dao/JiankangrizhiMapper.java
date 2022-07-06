package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiankangrizhi;

public interface JiankangrizhiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiankangrizhi record);

    int insertSelective(Jiankangrizhi record);

    Jiankangrizhi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiankangrizhi record);
	int updateByPrimaryKeySelectivelb(Jiankangrizhi record);
    int updateByPrimaryKey(Jiankangrizhi record);
	public Jiankangrizhi quchongJiankangrizhi(Map<String, Object> gonghao);
	public List<Jiankangrizhi> getAll(Map<String, Object> map);
	public List<Jiankangrizhi> getsyjiankangrizhi1(Map<String, Object> map);
	public List<Jiankangrizhi> getsyjiankangrizhi3(Map<String, Object> map);
	public List<Jiankangrizhi> getsyjiankangrizhi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiankangrizhi> getByPage(Map<String, Object> map);
	public List<Jiankangrizhi> select(Map<String, Object> map);
//	所有List
}

