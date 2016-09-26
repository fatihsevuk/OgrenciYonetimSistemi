package com.fatih.dao;

import com.fatih.model.Kullanici;

public interface KullaniciDAO {
	
	
	public boolean kullaniciEkle(Kullanici kullanici) throws Exception;
	
	public boolean kullaniciGiris(String kAdi , String kParola) throws Exception;
	
	
	
	
	

}
