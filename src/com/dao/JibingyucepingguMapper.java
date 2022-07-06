package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jibingyucepinggu;

public interface JibingyucepingguMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jibingyucepinggu record);

    int insertSelective(Jibingyucepinggu record);

    Jibingyucepinggu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jibingyucepinggu record);
	
    int updateByPrimaryKey(Jibingyucepinggu record);
	public Jibingyucepinggu quchongJibingyucepinggu(Map<String, Object> gonghao);
	public List<Jibingyucepinggu> getAll(Map<String, Object> map);
	public List<Jibingyucepinggu> getsyjibingyucepinggu1(Map<String, Object> map);
	public List<Jibingyucepinggu> getsyjibingyucepinggu3(Map<String, Object> map);
	public List<Jibingyucepinggu> getsyjibingyucepinggu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jibingyucepinggu> getByPage(Map<String, Object> map);
	public List<Jibingyucepinggu> select(Map<String, Object> map);
//	所有List
}

