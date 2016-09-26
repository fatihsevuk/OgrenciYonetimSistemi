package com.fatih.model;

public class Kullanici {

	private String kAdi;
	private String kEmail;
	private String kParola;
	
	public Kullanici() {
		// TODO Auto-generated constructor stub
	}
	
	public Kullanici( String kAdi, String kEmail, String kParola) {
		super();
		
		this.kAdi = kAdi;
		this.kEmail = kEmail;
		this.kParola = kParola;
	}


	


	public String getkAdi() {
		return kAdi;
	}


	public void setkAdi(String kAdi) {
		this.kAdi = kAdi;
	}


	public String getkEmail() {
		return kEmail;
	}


	public void setkEmail(String kEmail) {
		this.kEmail = kEmail;
	}


	public String getkParola() {
		return kParola;
	}


	public void setkParola(String kParola) {
		this.kParola = kParola;
	}


	@Override
	public String toString() {
		return "Kullanici [kAdi=" + kAdi + ", kEmail=" + kEmail + ", kParola=" + kParola + "]";
	}
	
	
	

}
