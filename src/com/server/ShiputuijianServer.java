package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shiputuijian;

public interface ShiputuijianServer {

  public int add(Shiputuijian po);

  public int update(Shiputuijian po);
  
  
  
  public int delete(int id);

  public List<Shiputuijian> getAll(Map<String,Object> map);
  public List<Shiputuijian> getsyshiputuijian1(Map<String,Object> map);
  public List<Shiputuijian> getsyshiputuijian2(Map<String,Object> map);
  public List<Shiputuijian> getsyshiputuijian3(Map<String,Object> map);
  public Shiputuijian quchongShiputuijian(Map<String, Object> acount);

  public Shiputuijian getById( int id);

  public List<Shiputuijian> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shiputuijian> select(Map<String, Object> map);
}
//	所有List
