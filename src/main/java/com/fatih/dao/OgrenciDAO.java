package com.fatih.dao;

import java.sql.SQLException;
import java.util.List;

import com.fatih.model.Ogrenci;

public interface OgrenciDAO {
	
	public List<Ogrenci> ogrenciListele() throws Exception;
	public void ogrenciEkle(Ogrenci ogrenci) throws SQLException;
	public void ogrenciSil(int id) throws SQLException;
	public void ogrenciGuncelle(Ogrenci ogrenci) throws SQLException;

}
