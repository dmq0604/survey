package com.learn.survey.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Survey {

	private Integer id;
	private String title = "δ����";
	private String preText = "��һ��";
	private String nextText = "��һ��";
	private String existText = "�˳�";
	private String doneText = "���";
	private boolean closed;
	private Date createTime = new Date();
	
	private String logoPhotoPath;//ͼƬ·��
	//���һӳ���ϵ
	private User user;
	//������Survey��Page֮��һ�Զ������ϵ
    private Set<Page> pages = new HashSet<Page>();
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreText() {
		return preText;
	}
	public void setPreText(String preText) {
		this.preText = preText;
	}
	public String getNextText() {
		return nextText;
	}
	public void setNextText(String nextText) {
		this.nextText = nextText;
	}
	public String getExistText() {
		return existText;
	}
	public void setExistText(String existText) {
		this.existText = existText;
	}
	public String getDoneText() {
		return doneText;
	}
	public void setDoneText(String doneText) {
		this.doneText = doneText;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set<Page> getPages() {
		return pages;
	}
	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	public String getLogoPhotoPath() {
		return logoPhotoPath;
	}
	public void setLogoPhotoPath(String logoPhotoPath) {
		this.logoPhotoPath = logoPhotoPath;
	}
	
}