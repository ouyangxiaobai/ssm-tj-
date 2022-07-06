package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShiputuijianMapper;
import com.entity.Shiputuijian;
import com.server.ShiputuijianServer;
@Service
public class ShiputuijianServerImpi implements ShiputuijianServer {
   @Resource
   private ShiputuijianMapper gdao;
	@Override
	public int add(Shiputuijian po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shiputuijian po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shiputuijian> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shiputuijian> getsyshiputuijian1(Map<String, Object> map) {
		return gdao.getsyshiputuijian1(map);
	}
	public List<Shiputuijian> getsyshiputuijian2(Map<String, Object> map) {
		return gdao.getsyshiputuijian2(map);
	}
	public List<Shiputuijian> getsyshiputuijian3(Map<String, Object> map) {
		return gdao.getsyshiputuijian3(map);
	}
	
	@Override
	public Shiputuijian quchongShiputuijian(Map<String, Object> account) {
		return gdao.quchongShiputuijian(account);
	}

	@Override
	public List<Shiputuijian> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shiputuijian> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shiputuijian getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

