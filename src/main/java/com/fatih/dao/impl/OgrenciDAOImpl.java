package com.fatih.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.*;

import javax.sql.DataSource;

import com.fatih.dao.OgrenciDAO;
import com.fatih.model.Ogrenci;

public class OgrenciDAOImpl implements OgrenciDAO{
	
	@Resource(name="jdbc/ogryonsis")
	private DataSource dataSource;
	
	
	
	public OgrenciDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OgrenciDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public List<Ogrenci> ogrenciListele() throws Exception{
		
		List<Ogrenci> ogrenciList=new ArrayList<Ogrenci>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			
			conn=dataSource.getConnection();
			
			String sql="select*from ogrenciler";
			
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				int id=rs.getInt("id");
				String ad=rs.getString("ad");
				String soyad=rs.getString("soyad");
				String email=rs.getString("email");
				
				Ogrenci ogrenci=new Ogrenci(id, ad, soyad, email);
				
				ogrenciList.add(ogrenci);			}
			
			
			
			
					
			return ogrenciList;
			
		
		} 
		finally{
			baglantiSonlandir(conn, rs, ps);
			
		}
		
		
		
	}
	
	private void baglantiSonlandir(Connection conn , ResultSet rs , PreparedStatement ps){
		try{
			
			if(conn!=null){
				conn.close();
			}
			if (rs!=null) {
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void ogrenciEkle(Ogrenci ogrenci) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			conn=dataSource.getConnection();
			
			String sql="insert into ogrenciler(id,ad,soyad,email) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ogrenci.getId());
			ps.setString(2, ogrenci.getAd());
			ps.setString(3, ogrenci.getSoyad());
			ps.setString(4, ogrenci.getEmail());
			
			ps.execute();
		}finally{
			baglantiSonlandir(conn, null, ps);
		}
			
		
		
	}

	public void ogrenciSil(int id) throws SQLException {
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			
			int ogrenciId=id;
			conn=dataSource.getConnection();
			String sql="delete from ogrenciler where id=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, ogrenciId);
			
			ps.execute();
			
			
			
		}finally{
			baglantiSonlandir(conn, null, ps);
		}
		
		
		
		
		
	}

	public void ogrenciGuncelle(Ogrenci ogrenci) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=dataSource.getConnection();
		
		String sql="update ogrenciler "
				+ "set id=? , ad=? , soyad=? , email=? "
				+ "where id=?";
		
		ps=conn.prepareStatement(sql);
		
		ps.setInt(1,ogrenci.getId());
		ps.setString(2, ogrenci.getAd());
		ps.setString(3, ogrenci.getSoyad());
		ps.setString(4, ogrenci.getEmail());
		ps.setInt(5, ogrenci.getId());
		
		ps.execute();
		}finally{
			baglantiSonlandir(conn, null, ps);
		}
	}


	public Ogrenci ogrenciGetir(String ogrenciId) throws Exception {
		Ogrenci ogrenci=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int OgrenciId;
		
		try{
			OgrenciId=Integer.parseInt(ogrenciId);
			
			conn=dataSource.getConnection();
			
			String sql="select*from ogrenciler where id=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1,OgrenciId);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				int id=rs.getInt("id");
				String ad=rs.getString("ad");
				String soyad=rs.getString("soyad");
				String email=rs.getString("email");
				
				ogrenci=new Ogrenci(id, ad, soyad, email);
				
			}else{
				throw new Exception("Öğrenci id'si bulunamadı: "+OgrenciId);
			}
			
			
			return ogrenci;
		}finally{
			
		}
		
		
	}

}
