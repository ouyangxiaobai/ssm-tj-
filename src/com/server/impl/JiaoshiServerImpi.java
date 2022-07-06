package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiaoshiMapper;
import com.entity.Jiaoshi;
import com.server.JiaoshiServer;
@Service
public class JiaoshiServerImpi implements JiaoshiServer {
   @Resource
   private JiaoshiMapper gdao;
	@Override
	public int add(Jiaoshi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiaoshi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiaoshi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiaoshi> getsyjiaoshi1(Map<String, Object> map) {
		return gdao.getsyjiaoshi1(map);
	}
	public List<Jiaoshi> getsyjiaoshi2(Map<String, Object> map) {
		return gdao.getsyjiaoshi2(map);
	}
	public List<Jiaoshi> getsyjiaoshi3(Map<String, Object> map) {
		return gdao.getsyjiaoshi3(map);
	}
	
	@Override
	public Jiaoshi quchongJiaoshi(Map<String, Object> account) {
		return gdao.quchongJiaoshi(account);
	}

	@Override
	public List<Jiaoshi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiaoshi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiaoshi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

