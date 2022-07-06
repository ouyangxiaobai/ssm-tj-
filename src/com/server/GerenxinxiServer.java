package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gerenxinxi;

public interface GerenxinxiServer {

  public int add(Gerenxinxi po);

  public int update(Gerenxinxi po);
  
  
  
  public int delete(int id);

  public List<Gerenxinxi> getAll(Map<String,Object> map);
  public List<Gerenxinxi> getsygerenxinxi1(Map<String,Object> map);
  public List<Gerenxinxi> getsygerenxinxi2(Map<String,Object> map);
  public List<Gerenxinxi> getsygerenxinxi3(Map<String,Object> map);
  public Gerenxinxi quchongGerenxinxi(Map<String, Object> acount);

  public Gerenxinxi getById( int id);

  public List<Gerenxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gerenxinxi> select(Map<String, Object> map);
}
//	所有List
