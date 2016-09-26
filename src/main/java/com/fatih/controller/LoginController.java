package com.fatih.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.fatih.dao.impl.KullaniciDAOImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KullaniciDAOImpl kullaniciDAOImpl;
	
	@Resource(name="jdbc/ogryonsis")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			kullaniciDAOImpl=new KullaniciDAOImpl(dataSource); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		try{
			
			kullaniciGiris(request,response);
			
			
		}catch(Exception e){
			
			new ServletException(e);
			
		}
	}

	private void kullaniciGiris(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kAdi=request.getParameter("kAdi");
		String kParola=request.getParameter("kParola");
		
		if(kullaniciDAOImpl.kullaniciGiris(kAdi, kParola)){
			RequestDispatcher dispatcher=request.getRequestDispatcher("/OgrenciController");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/NotLogin.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
