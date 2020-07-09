package com.lee.jm2.main;

public class Result {
	private int tasu;
	private int anta;
	private String tayul;
	private String img;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(int tasu, int anta, String tayul, String img) {
		super();
		this.tasu = tasu;
		this.anta = anta;
		this.tayul = tayul;
		this.img = img;
	}

	public int getTasu() {
		return tasu;
	}

	public void setTasu(int tasu) {
		this.tasu = tasu;
	}

	public int getAnta() {
		return anta;
	}

	public void setAnta(int anta) {
		this.anta = anta;
	}

	public String getTayul() {
		return tayul;
	}

	public void setTayul(String tayul) {
		this.tayul = tayul;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
