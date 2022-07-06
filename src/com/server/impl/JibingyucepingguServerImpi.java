package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JibingyucepingguMapper;
import com.entity.Jibingyucepinggu;
import com.server.JibingyucepingguServer;
@Service
public class JibingyucepingguServerImpi implements JibingyucepingguServer {
   @Resource
   private JibingyucepingguMapper gdao;
	@Override
	public int add(Jibingyucepinggu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jibingyucepinggu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jibingyucepinggu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jibingyucepinggu> getsyjibingyucepinggu1(Map<String, Object> map) {
		return gdao.getsyjibingyucepinggu1(map);
	}
	public List<Jibingyucepinggu> getsyjibingyucepinggu2(Map<String, Object> map) {
		return gdao.getsyjibingyucepinggu2(map);
	}
	public List<Jibingyucepinggu> getsyjibingyucepinggu3(Map<String, Object> map) {
		return gdao.getsyjibingyucepinggu3(map);
	}
	
	@Override
	public Jibingyucepinggu quchongJibingyucepinggu(Map<String, Object> account) {
		return gdao.quchongJibingyucepinggu(account);
	}

	@Override
	public List<Jibingyucepinggu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jibingyucepinggu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jibingyucepinggu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

