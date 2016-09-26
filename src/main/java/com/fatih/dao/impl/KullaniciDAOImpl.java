package com.fatih.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import com.fatih.dao.KullaniciDAO;
import com.fatih.model.Kullanici;

public class KullaniciDAOImpl implements KullaniciDAO{
	
	@Resource(name="jdbc/ogryonsis")
	private DataSource dataSource;
	
	
	
	

	public DataSource getDataSource() {
		return dataSource;
	}





	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}





	public KullaniciDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}





	@Override
	public boolean kullaniciEkle(Kullanici kullanici) throws Exception {
		
		boolean isRegister=false;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			
			String sql="insert into kullanicilar(kAdi,kEmail,kParola) values(?,?,?)";
			
			conn=dataSource.getConnection();
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, kullanici.getkAdi());
			ps.setString(2, kullanici.getkEmail());
			ps.setString(3, kullanici.getkParola());
			
			int success=ps.executeUpdate();
			
			if(success>0){
				isRegister=true;
			}
			
			return isRegister;
		}finally{
			baglantiSonlandir(conn, null, ps);
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





	@Override
	public boolean kullaniciGiris(String kAdi, String kParola) throws Exception {
		
		boolean isLogin=false;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			
			String sql="select kAdi from kullanicilar where kAdi=? and kParola=?";
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, kAdi);
			ps.setString(2, kParola);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
			
//			
//			int success=ps.executeUpdate();
//			
//				
//			
//			
//			if(success>0){
//				isLogin=true;
//				return isLogin;
//			}else{
//				return false;
//			}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return false;
		
		
		
		
	}

}
