package com.lee.jm2.main;

public class Result {
	private int m;
	private int t;
	
	private int r;
	private String s;
	
	// 기본생성자
	// 오버로딩된 생성자
	// getter, setter
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(int m, int t, int r, String s) {
		super();
		this.m = m;
		this.t = t;
		this.r = r;
		this.s = s;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
	
}
