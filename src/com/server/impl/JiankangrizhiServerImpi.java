package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiankangrizhiMapper;
import com.entity.Jiankangrizhi;
import com.server.JiankangrizhiServer;
@Service
public class JiankangrizhiServerImpi implements JiankangrizhiServer {
   @Resource
   private JiankangrizhiMapper gdao;
	@Override
	public int add(Jiankangrizhi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiankangrizhi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Jiankangrizhi po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiankangrizhi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiankangrizhi> getsyjiankangrizhi1(Map<String, Object> map) {
		return gdao.getsyjiankangrizhi1(map);
	}
	public List<Jiankangrizhi> getsyjiankangrizhi2(Map<String, Object> map) {
		return gdao.getsyjiankangrizhi2(map);
	}
	public List<Jiankangrizhi> getsyjiankangrizhi3(Map<String, Object> map) {
		return gdao.getsyjiankangrizhi3(map);
	}
	
	@Override
	public Jiankangrizhi quchongJiankangrizhi(Map<String, Object> account) {
		return gdao.quchongJiankangrizhi(account);
	}

	@Override
	public List<Jiankangrizhi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiankangrizhi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiankangrizhi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

