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

import com.mvc2.member.dao.MemberDao;
import com.mvc2.member.dao.MemberDaoImpl;
import com.mvc2.member.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String chkInKnum = null;
		String knum = null;
		String kname = null;
		String kid = null;
		String kpw = null;
		String kbirth = null;
		String kgender = null;
		String kemail = null;
		String kmobile = null;
		String kpostnum = null;
		String kaddr = null;
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
			 chkInKnum = request.getParameter("chkInKnum");
			 knum = request.getParameter("knum");
			 kname = request.getParameter("kname");
			 kid = request.getParameter("kid");
			 kpw = request.getParameter("kpw");
			 kbirth = request.getParameter("kbirth");
			 kgender = request.getParameter("kgender");
			 kemail = request.getParameter("kemail");
			 kmobile = request.getParameter("kmobile");
			 kpostnum = request.getParameter("kpostnum");
			 kaddr = request.getParameter("kaddr");
			 kimg = request.getParameter("kimg");
			 kdeleteyn = request.getParameter("kdeleteyn");
			 kinsertdate = request.getParameter("kinsertdate");
			 kupdatedate = request.getParameter("kupdatedate");
			
			 if(isudType != null) {
				 
				 MemberDao mdao = new MemberDaoImpl();
				 MemberVO mvo = new MemberVO();
				 List<MemberVO> alist = new ArrayList<>();
				 
				 if(isudType.equals("IDC")) {
					 System.out.println("isudType >>> " + isudType);
					 mvo.setKid(kid);
					 cnt = mdao.idCheck(mvo);
					 System.out.println("cnt >>>" + cnt);
					 request.setAttribute("cnt", cnt);
					 url="/member/idchk.jsp";
				 }
				 
				 else if(isudType.equals("S")) {
					 System.out.println("isudType >>> " + isudType);
					 mvo.setKnum(knum);
					 mvo.setKname(kname);
					 mvo.setKid(kid);
					 mvo.setKpw(kpw);
					 mvo.setKbirth(kbirth);
					 mvo.setKgender(kgender);
					 mvo.setKemail(kemail);
					 mvo.setKmobile(kmobile);
					 mvo.setKpostnum(kpostnum);
					 mvo.setKaddr(kaddr);
					 mvo.setKimg(downloadPath);
					 mvo.setKdeleteyn(kdeleteyn);
					 mvo.setKinsertdate(kinsertdate);
					 mvo.setKupdatedate(kupdatedate);
					 
					 alist = mdao.selectMember();
					 
					 if(alist.size() > 0) {
						 alist = mdao.selectMember();
						 request.setAttribute("alist", alist);
						 url = "/member/selectMember.jsp";
					 }
				 }
				 
				 else if(isudType.equals("U")) {
					 System.out.println("isudType >>> " + isudType);
					 mvo.setKnum(chkInKnum);
					 mvo.setKname(kname);
					 mvo.setKid(kid);
					 mvo.setKpw(kpw);
					 mvo.setKbirth(kbirth);
					 mvo.setKgender(kgender);
					 mvo.setKemail(kemail);
					 mvo.setKmobile(kmobile);
					 mvo.setKpostnum(kpostnum);
					 mvo.setKaddr(kaddr);
					 mvo.setKimg(downloadPath);
					 mvo.setKdeleteyn(kdeleteyn);
					 mvo.setKinsertdate(kinsertdate);
					 mvo.setKupdatedate(kupdatedate);
					 
					 System.out.println("chkInKnum >>>" + chkInKnum);
					 alist = mdao.searchMember(mvo);
					 if(alist.size() == 1) {
						 alist = mdao.searchMember(mvo);
						 request.setAttribute("alist", alist);
						 url = "/member/updateMember.jsp";
					 }
				 }
				 else if(isudType.equals("D")) {
					 System.out.println("isudType >>> " + isudType);
					 mvo.setKnum(chkInKnum);
					 cnt = mdao.deleteMember(mvo);
					 System.out.println("cnt servlet >>>" + cnt);
					 if(cnt ==1) {
						 cnt = mdao.deleteMember(mvo);
						 request.setAttribute("cnt", cnt);
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
				chkInKnum = mr.getParameter("chkInKnum");
				
				System.out.println("isudType >>> " + isudType);
				
				Enumeration kfiles = mr.getFileNames();
				String kpt = (String)kfiles.nextElement();
				kFilename = mr.getFilesystemName(kpt);
				downloadPath = downloadPath + kFilename;
				
				knum = mr.getParameter("knum");
				kname = mr.getParameter("kname");
				kid = mr.getParameter("kid");
				kpw = mr.getParameter("kpw");
				kbirth = mr.getParameter("kbirth");
				kgender = mr.getParameter("kgender");
				kemail = mr.getParameter("kemail");
				kmobile = mr.getParameter("kmobile");
				kpostnum = mr.getParameter("kpostnum");
				kaddr = mr.getParameter("kaddr") + " " +mr.getParameter("kaddr1");
				kimg = mr.getParameter("kimg");
				kdeleteyn = mr.getParameter("kdeleteyn");
				kinsertdate = mr.getParameter("kinsertdate");
				kupdatedate = mr.getParameter("kupdatedate");
				
				if(isudType != null) {
					MemberDao mdao = new MemberDaoImpl();
					MemberVO mvo = new MemberVO();
					List<MemberVO> alist = new ArrayList<>();
					
					if(isudType.equals("I")) {
						System.out.println("isudType >>>" + isudType);
						mvo.setKnum(knum);
						mvo.setKname(kname);
						mvo.setKid(kid);
						mvo.setKpw(kpw);
						mvo.setKbirth(kbirth);
						mvo.setKgender(kgender);
						mvo.setKemail(kemail);
						mvo.setKmobile(kmobile);
						mvo.setKpostnum(kpostnum);
						mvo.setKaddr(kaddr);
						mvo.setKimg(downloadPath);
						mvo.setKdeleteyn(kdeleteyn);
						mvo.setKinsertdate(kinsertdate);
						mvo.setKupdatedate(kupdatedate);
						
						cnt = mdao.insertMember(mvo);
						if(cnt > 0) {
							alist = mdao.selectMember();
							request.setAttribute("alist", alist);
							url = "/member/insertOKform.jsp";
							
						}else {
							System.out.println("error >>> ");
						}
					}else if(isudType.equals("UOK")) {
						System.out.println("isudType >>>" + isudType);
						mvo.setKnum(knum);
						mvo.setKname(kname);
						mvo.setKid(kid);
						mvo.setKpw(kpw);
						mvo.setKbirth(kbirth);
						mvo.setKgender(kgender);
						mvo.setKemail(kemail);
						mvo.setKmobile(kmobile);
						mvo.setKpostnum(kpostnum);
						mvo.setKaddr(kaddr);
						mvo.setKimg(downloadPath);
						mvo.setKdeleteyn(kdeleteyn);
						mvo.setKinsertdate(kinsertdate);
						mvo.setKupdatedate(kupdatedate);
						
						cnt = mdao.updateMmber(mvo);
						if(cnt >= 1) {
							alist = mdao.selectMember();
							request.setAttribute("alist", alist);
							url = "/member/selectMember.jsp";
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
