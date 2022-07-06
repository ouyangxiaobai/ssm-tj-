package com.entity;

public class Tijianjieguo {
    private Integer id;
	private String gonghao;	private String xingming;	private String xiangmumingcheng;	private String xiangguanfujian;	private String jieguo;	private String jieguofenxi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao == null ? null : gonghao.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getXiangmumingcheng() {
        return xiangmumingcheng;
    }
    public void setXiangmumingcheng(String xiangmumingcheng) {
        this.xiangmumingcheng = xiangmumingcheng == null ? null : xiangmumingcheng.trim();
    }	public String getXiangguanfujian() {
        return xiangguanfujian;
    }
    public void setXiangguanfujian(String xiangguanfujian) {
        this.xiangguanfujian = xiangguanfujian == null ? null : xiangguanfujian.trim();
    }	public String getJieguo() {
        return jieguo;
    }
    public void setJieguo(String jieguo) {
        this.jieguo = jieguo == null ? null : jieguo.trim();
    }	public String getJieguofenxi() {
        return jieguofenxi;
    }
    public void setJieguofenxi(String jieguofenxi) {
        this.jieguofenxi = jieguofenxi == null ? null : jieguofenxi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
