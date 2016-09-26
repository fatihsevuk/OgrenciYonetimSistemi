package com.fatih.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.fatih.dao.impl.KullaniciDAOImpl;
import com.fatih.model.Kullanici;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/ogryonsis")
	private DataSource dataSource;
       
	private KullaniciDAOImpl kullaniciDAOImpl;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try{
			kullaniciDAOImpl=new KullaniciDAOImpl(dataSource);
		}catch(Exception e){
			new ServletException(e);
		}
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("ISO-8859-9");
		
		
		
		try {
			
			String komut=request.getParameter("command");
			
			switch (komut) {
			case "REGISTER":
				kullaniciEkle(request,response);
				break;

			default:
				break;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}


	private void kullaniciEkle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kAdi=request.getParameter("kAdi");
		String kEmail=request.getParameter("kEmail");
		String kParola=request.getParameter("kParola");
		
		PrintWriter pw=response.getWriter();
		
		
		Kullanici kullanici=new Kullanici( kAdi, kEmail, kParola);
		
		if(kullaniciDAOImpl.kullaniciEkle(kullanici)){
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Registered.jsp");
			dispatcher.forward(request, response);
			
		}else{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/NotRegistered.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
