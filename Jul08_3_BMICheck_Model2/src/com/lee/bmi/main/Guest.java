package com.lee.bmi.main;

// �����ڸ� M

// Window - Preferences
//		General - keys
//			generate constructor using fields
//			generate getters and setters
//			desc�� fields�� �����°�

public class Guest {
	//�̸�
	//Ű
	//������
	//bmi
	//����
	private String name; // ���ڿ��� �̸��Ӽ� ǥ����
	private int height;
	private int weight;
	private double bmi;
	private String result;
	private String photo;
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(String name, int height, int weight, double bmi, String result, String photo) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.result = result;
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	
	
	
}
