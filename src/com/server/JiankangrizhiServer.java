package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiankangrizhi;

public interface JiankangrizhiServer {

  public int add(Jiankangrizhi po);

  public int update(Jiankangrizhi po);
  
  public int updatelb(Jiankangrizhi po);
  
  public int delete(int id);

  public List<Jiankangrizhi> getAll(Map<String,Object> map);
  public List<Jiankangrizhi> getsyjiankangrizhi1(Map<String,Object> map);
  public List<Jiankangrizhi> getsyjiankangrizhi2(Map<String,Object> map);
  public List<Jiankangrizhi> getsyjiankangrizhi3(Map<String,Object> map);
  public Jiankangrizhi quchongJiankangrizhi(Map<String, Object> acount);

  public Jiankangrizhi getById( int id);

  public List<Jiankangrizhi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiankangrizhi> select(Map<String, Object> map);
}
//	所有List
