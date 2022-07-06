package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TijianjieguoMapper;
import com.entity.Tijianjieguo;
import com.server.TijianjieguoServer;
@Service
public class TijianjieguoServerImpi implements TijianjieguoServer {
   @Resource
   private TijianjieguoMapper gdao;
	@Override
	public int add(Tijianjieguo po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tijianjieguo po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tijianjieguo> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tijianjieguo> getsytijianjieguo1(Map<String, Object> map) {
		return gdao.getsytijianjieguo1(map);
	}
	public List<Tijianjieguo> getsytijianjieguo2(Map<String, Object> map) {
		return gdao.getsytijianjieguo2(map);
	}
	public List<Tijianjieguo> getsytijianjieguo3(Map<String, Object> map) {
		return gdao.getsytijianjieguo3(map);
	}
	
	@Override
	public Tijianjieguo quchongTijianjieguo(Map<String, Object> account) {
		return gdao.quchongTijianjieguo(account);
	}

	@Override
	public List<Tijianjieguo> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tijianjieguo> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tijianjieguo getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

