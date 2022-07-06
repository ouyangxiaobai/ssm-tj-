package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiaoshi;

public interface JiaoshiServer {

  public int add(Jiaoshi po);

  public int update(Jiaoshi po);
  
  
  
  public int delete(int id);

  public List<Jiaoshi> getAll(Map<String,Object> map);
  public List<Jiaoshi> getsyjiaoshi1(Map<String,Object> map);
  public List<Jiaoshi> getsyjiaoshi2(Map<String,Object> map);
  public List<Jiaoshi> getsyjiaoshi3(Map<String,Object> map);
  public Jiaoshi quchongJiaoshi(Map<String, Object> acount);

  public Jiaoshi getById( int id);

  public List<Jiaoshi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiaoshi> select(Map<String, Object> map);
}
//	所有List
