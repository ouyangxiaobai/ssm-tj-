package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jibingyucepinggu;

public interface JibingyucepingguServer {

  public int add(Jibingyucepinggu po);

  public int update(Jibingyucepinggu po);
  
  
  
  public int delete(int id);

  public List<Jibingyucepinggu> getAll(Map<String,Object> map);
  public List<Jibingyucepinggu> getsyjibingyucepinggu1(Map<String,Object> map);
  public List<Jibingyucepinggu> getsyjibingyucepinggu2(Map<String,Object> map);
  public List<Jibingyucepinggu> getsyjibingyucepinggu3(Map<String,Object> map);
  public Jibingyucepinggu quchongJibingyucepinggu(Map<String, Object> acount);

  public Jibingyucepinggu getById( int id);

  public List<Jibingyucepinggu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jibingyucepinggu> select(Map<String, Object> map);
}
//	所有List
