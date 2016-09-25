package com.fatih.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.fatih.dao.impl.OgrenciDAOImpl;
import com.fatih.model.Ogrenci;


import javax.annotation.*;

/**
 * Servlet implementation class OgrenciController
 */
public class OgrenciController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Resource(name="jdbc/ogryonsis")
	private DataSource dataSource;
	
	//private OgrenciService ogrenciService;
	private OgrenciDAOImpl ogrenciDAOImpl;
	
    public OgrenciController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    public void init() throws ServletException  {
    	// TODO Auto-generated method stub
    	super.init();
    	try{
    	
    		ogrenciDAOImpl=new OgrenciDAOImpl(dataSource);
    	}catch(Exception e){
    		new ServletException(e);
    	}
    	
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String komut=request.getParameter("command");
			
			if(komut==null){
				komut="LIST";
			}
			
			switch (komut) {
			case "LIST":
				ogrenciListele(request, response);
				break;
			case "ADD"	:
				ogrenciEkle(request, response);
				break;
			
			case "LOAD" :
				ogrenciYukle(request,response);
				break;
				
			case "UPDATE" :
				ogrenciGuncelle(request,response);
				break;
				
			case "DELETE" :
				ogrenciSil(request,response);
				break;
				
			default:
				ogrenciListele(request, response);
				break;
			}
			
			
			
		} catch (Exception e) {
			new ServletException(e);
		}
		
		
		
		
		
		
	}
	
	private void ogrenciSil(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int  OgrenciId=Integer.parseInt(request.getParameter("ogrenciId"));
		
		ogrenciDAOImpl.ogrenciSil(OgrenciId);
		
		ogrenciListele(request, response);
		
		
		
		
		
		
		
		
		
	}

	private void ogrenciYukle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ogrenciId=request.getParameter("ogrenciId");
		
		Ogrenci ogrenci=ogrenciDAOImpl.ogrenciGetir(ogrenciId);
		
		request.setAttribute("gelenOgrenci", ogrenci);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/OgrenciGuncelle.jsp");
		
		dispatcher.forward(request, response);
	}

	private void ogrenciGuncelle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id=Integer.parseInt(request.getParameter("ogrenciId"));
		String ad=request.getParameter("ad");
		String soyad=request.getParameter("soyad");
		String email=request.getParameter("email");
		
		Ogrenci ogrenci=new Ogrenci(id, ad, soyad, email);
		
		ogrenciDAOImpl.ogrenciGuncelle(ogrenci);
		
		ogrenciListele(request, response);
	}

	private void ogrenciEkle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id=Integer.valueOf(request.getParameter("no"));
		String ad=request.getParameter("ad");
		String soyad=request.getParameter("soyad");
		String email=request.getParameter("email");
		
		Ogrenci ogrenci=new Ogrenci(id, ad, soyad, email);
		
		ogrenciDAOImpl.ogrenciEkle(ogrenci);
		
		ogrenciListele(request, response);
		
		
		
		
	}

	private void ogrenciListele(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	
		
		List<Ogrenci> ogrenciListesi=ogrenciDAOImpl.ogrenciListele();
		
		request.setAttribute("ogrenciListesi",ogrenciListesi);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/OgrenciGoster.jsp");
		
		dispatcher.forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
