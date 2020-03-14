package com.mvc2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.board.dao.BoardDao;
import com.mvc2.board.dao.BoardDaoImpl;
import com.mvc2.board.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			doPost(request, response);
		} catch (Exception e) {
			System.out.println("error doPost>>>" + e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" servelt >>>");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String isudType = null;
		String chkInKno = null;
		String kno = null;
		String ktitle = null;
		String kname = null;
		String kpw = null;
		String kcontent = null;
		String kimg = null;
		String kdeleteyn = null;
		String kinsertdate = null;
		String kupdatedate = null;
		
		int cnt = 0;
		
		isudType = request.getParameter("isudType");
		System.out.println("isudType >>>" + isudType);
		
		String url = "";
		String downloadPath = "img/";
		
		//without file upload
		if(!request.getContentType().toLowerCase().startsWith("multipart/form-data")){
			System.out.println(" (!request.getContentType().toLowerCase().startsWith(\"multipart/form-data\")) >>>");
			 isudType = request.getParameter("isudType");
			chkInKno = request.getParameter("chkInKno");
			kno = request.getParameter("kno");
			ktitle = request.getParameter("ktitle");
			kname = request.getParameter("kname");
			kpw = request.getParameter("kpw");
			kcontent = request.getParameter("kcontent");
			kimg = request.getParameter("kimg");
			kdeleteyn = request.getParameter("kdeleteyn");
			kinsertdate = request.getParameter("kinsertdate");
			kupdatedate = request.getParameter("kupdatedate");
			
			 if(isudType != null) {
				 
				BoardDao bdao = new BoardDaoImpl();
				BoardVO bvo = new BoardVO();
				List<BoardVO> alist = new ArrayList<>();
				
				if(isudType.equals("S")) {
					System.out.println("isudType >>> " + isudType);
					 bvo.setKno(kno);
					 bvo.setKname(kname);
					 bvo.setKpw(kpw);
					 bvo.setKimg(downloadPath);
					 bvo.setKdeleteyn(kdeleteyn);
					 bvo.setKinsertdate(kinsertdate);
					 bvo.setKupdatedate(kupdatedate);
					 
					 alist = bdao.selectBoard();
					 
					 if(alist.size() > 0) {
						 alist = bdao.selectBoard();
						 request.setAttribute("alist", alist);
						 url = "/board/selectBoard.jsp";
					 }
				}
				
				else if(isudType.equals("U")) {
					System.out.println("isudType >>> " + isudType);
					 bvo.setKtitle(ktitle);
					 bvo.setKname(kname);
					 bvo.setKcontent(kcontent);
					 bvo.setKimg(downloadPath);
					 bvo.setKno(chkInKno);
					 
					 alist = bdao.searchBoard(bvo);
					 if(alist.size() > 0) {
						 alist = bdao.searchBoard(bvo);
						 request.setAttribute("alist", alist);
						 url = "/board/updateBoard.jsp";
					 }
				}
				 
				else if(isudType.equals("D")) {
					System.out.println("isudType >>> " + isudType);
					bvo.setKdeleteyn(kdeleteyn);
					bvo.setKupdatedate(kupdatedate);
					bvo.setKno(chkInKno);
					 
					 cnt = bdao.deleteBoard(bvo);
					 System.out.println("cnt >>>" + cnt);
					 if(cnt == 1) {
						 cnt = bdao.deleteBoard(bvo);
						 request.setAttribute("alist", alist);
						 url = "/index.jsp";
					 }
				}
			 }	 
				 
			 System.out.println(" (!request.getContentType().toLowerCase().startsWith(\"multipart/form-data\")) <<<");
		//with file upload	
		}else if(request.getContentType().toLowerCase().startsWith("multipart/form-data")) {
			System.out.println(" (request.getContentType().toLowerCase().startsWith(\"multipart/form-data\")) >>>");
			String uploadPath = "D://00.BITCAMP//kbw_workplace//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps//mvc2Project//img";
			
			int size = 10 * 1024 * 1024;
			
			try {
				MultipartRequest mr = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
				cnt = 0;
				
				String kFilename = "";
				
				isudType = mr.getParameter("isudType");
					chkInKno = mr.getParameter("chkInKno");
					
					System.out.println("isudType >>> " + isudType);
					
					Enumeration kfiles = mr.getFileNames();
					String kpt = (String)kfiles.nextElement();
					kFilename = mr.getFilesystemName(kpt);
					downloadPath = downloadPath + kFilename;
					
					kno = mr.getParameter("kno");
					ktitle = mr.getParameter("ktitle");
					kname = mr.getParameter("kname");
					kpw = mr.getParameter("kpw");
					kcontent = mr.getParameter("kcontent");
					kimg = mr.getParameter("kimg");
					kdeleteyn = mr.getParameter("kdeleteyn");
					kinsertdate = mr.getParameter("kinsertdate");
					kupdatedate = mr.getParameter("kupdatedate");
					
				
				if(isudType != null) {
					BoardDao bdao = new BoardDaoImpl();
						BoardVO bvo = new BoardVO();
						List<BoardVO> alist = new ArrayList<>();
					
					if(isudType.equals("I")) {
						System.out.println("isudType >>>" + isudType);
							bvo.setKno(kno);
							bvo.setKtitle(ktitle);
							bvo.setKname(kname);
							bvo.setKpw(kpw);
							bvo.setKcontent(kcontent);
							bvo.setKimg(downloadPath);
							bvo.setKdeleteyn(kdeleteyn);
							bvo.setKinsertdate(kinsertdate);
							bvo.setKupdatedate(kupdatedate);
							
							cnt = bdao.insertBoard(bvo);
							System.out.println("cnt >>>" + cnt);
							if(cnt > 0) {
								alist = bdao.selectBoard();
								request.setAttribute("alist", alist);
								url = "/board/insertOKform.jsp";
							}else {
							System.out.println("error >>> ");
						}
					}else if(isudType.equals("UOK")) {
						System.out.println("isudType >>>" + isudType);
							bvo.setKno(kno);
							bvo.setKtitle(ktitle);
							bvo.setKname(kname);
							bvo.setKpw(kpw);
							bvo.setKcontent(kcontent);
							bvo.setKimg(downloadPath);
							bvo.setKdeleteyn(kdeleteyn);
							bvo.setKinsertdate(kinsertdate);
							bvo.setKupdatedate(kupdatedate);
							
							cnt = bdao.updateBoard(bvo);
							System.out.println("cnt >>>" + cnt);
							if(cnt == 1) {
								alist = bdao.selectBoard();
								request.setAttribute("alist", alist);
								url = "/board/selectBoard.jsp";
							}
					}
					
					System.out.println(" (request.getContentType().toLowerCase().startsWith(\"multipart/form-data\")) <<<");
				}
			} catch (Exception e) {
				System.out.println("error servlet>>>" + e.getMessage());
			}

		}
		System.out.println(" servelt <<<");

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
