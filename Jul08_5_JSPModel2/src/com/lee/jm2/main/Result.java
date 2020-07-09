package com.lee.jm2.main;

import java.util.ArrayList;

public class Result {
	private int money;
	private int tomorrow;
	private int remain;
	private ArrayList<String> al;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(int money, int tomorrow, int remain, ArrayList<String> al) {
		super();
		this.money = money;
		this.tomorrow = tomorrow;
		this.remain = remain;
		this.al = al;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getTomorrow() {
		return tomorrow;
	}

	public void setTomorrow(int tomorrow) {
		this.tomorrow = tomorrow;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public ArrayList<String> getAl() {
		return al;
	}

	public void setAl(ArrayList<String> al) {
		this.al = al;
	}

}
