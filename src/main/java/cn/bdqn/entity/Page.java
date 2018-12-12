package cn.bdqn.entity;

import java.util.List;

public class Page {
	private Integer zongTiao;
	private Integer myTiao = 5;
	private Integer zongYe;
	private Integer suoYin;
	private Integer pageNum;

	private List<User> pageUserList;

	private List<Provider> pageProciderList;

	private List<Bill> pageBillList;

	public Page(Integer zongTiao, Integer pageNum) {
		zongYe = zongTiao % myTiao == 0 ? (zongTiao / myTiao) : (zongTiao/ myTiao + 1);
		suoYin = (pageNum - 1) * myTiao;
	}

	public List<Bill> getPageBillList() {
		return pageBillList;
	}

	public void setPageBillList(List<Bill> pageBillList) {
		this.pageBillList = pageBillList;
	}

	public List<Provider> getPageProciderList() {
		return pageProciderList;
	}

	public void setPageProciderList(List<Provider> pageProciderList) {
		this.pageProciderList = pageProciderList;
	}

	public List<User> getPageUserList() {
		return pageUserList;
	}

	public void setPageUserList(List<User> pageUserList) {
		this.pageUserList = pageUserList;
	}

	public Integer getZongTiao() {
		return zongTiao;
	}

	public void setZongTiao(Integer zongTiao) {
		this.zongTiao = zongTiao;
	}

	public Integer getMyTiao() {
		return myTiao;
	}

	public void setMyTiao(Integer myTiao) {
		this.myTiao = myTiao;
	}

	public Integer getZongYe() {
		return zongYe;
	}

	public void setZongYe(Integer zongYe) {
		this.zongYe = zongYe;
	}

	public Integer getSuoYin() {
		return suoYin;
	}

	public void setSuoYin(Integer suoYin) {
		this.suoYin = suoYin;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

}
