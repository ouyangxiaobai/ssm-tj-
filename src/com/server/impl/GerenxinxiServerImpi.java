package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GerenxinxiMapper;
import com.entity.Gerenxinxi;
import com.server.GerenxinxiServer;
@Service
public class GerenxinxiServerImpi implements GerenxinxiServer {
   @Resource
   private GerenxinxiMapper gdao;
	@Override
	public int add(Gerenxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gerenxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gerenxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gerenxinxi> getsygerenxinxi1(Map<String, Object> map) {
		return gdao.getsygerenxinxi1(map);
	}
	public List<Gerenxinxi> getsygerenxinxi2(Map<String, Object> map) {
		return gdao.getsygerenxinxi2(map);
	}
	public List<Gerenxinxi> getsygerenxinxi3(Map<String, Object> map) {
		return gdao.getsygerenxinxi3(map);
	}
	
	@Override
	public Gerenxinxi quchongGerenxinxi(Map<String, Object> account) {
		return gdao.quchongGerenxinxi(account);
	}

	@Override
	public List<Gerenxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gerenxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gerenxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

