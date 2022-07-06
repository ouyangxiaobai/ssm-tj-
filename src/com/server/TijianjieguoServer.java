package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tijianjieguo;

public interface TijianjieguoServer {

  public int add(Tijianjieguo po);

  public int update(Tijianjieguo po);
  
  
  
  public int delete(int id);

  public List<Tijianjieguo> getAll(Map<String,Object> map);
  public List<Tijianjieguo> getsytijianjieguo1(Map<String,Object> map);
  public List<Tijianjieguo> getsytijianjieguo2(Map<String,Object> map);
  public List<Tijianjieguo> getsytijianjieguo3(Map<String,Object> map);
  public Tijianjieguo quchongTijianjieguo(Map<String, Object> acount);

  public Tijianjieguo getById( int id);

  public List<Tijianjieguo> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tijianjieguo> select(Map<String, Object> map);
}
//	所有List
