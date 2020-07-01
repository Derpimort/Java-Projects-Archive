package com.legendbois.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String fname;
	private String path;
	@Lob
	@Column(name="content", length=511)
	private String content;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "FileModel [id=" + id + ", fname=" + fname + ", path=" + path + ", content=" + content + "]";
	}
	
	

}
