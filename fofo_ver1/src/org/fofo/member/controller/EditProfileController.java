package org.fofo.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.dao.ProfileDAO;
import org.fofo.member.vo.Member;
import org.fofo.member.vo.School;

public class EditProfileController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/home.jsp";
		int result=0;
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		School sVo = new School();
		ProfileDAO pDao = new ProfileDAO();
		HttpSession session=request.getSession();
		
		
		String email=(String) session.getAttribute("email");
		int uid=(int) session.getAttribute("uid");
		
		String action=request.getParameter("formName");

		try {
			switch(action){
			
			case "school":
				vo.setUEmail(email);
				vo.setUSchoolIds(request.getParameter("schoolId"));
				sVo.setMySchoolId(Integer.parseInt(request.getParameter("schoolId")));
				sVo.setDegree(request.getParameter("degree"));
				sVo.setMajor(request.getParameter("major"));
				sVo.setEntrance(Integer.parseInt(request.getParameter("entrance")));
				sVo.setUserId(uid);
				pDao.addSchool(vo, sVo);
				System.out.println("DAO : school");
				System.out.println("SchoolID : "+request.getParameter("schoolId"));
				System.out.println("Degree : "+request.getParameter("degree"));
				System.out.println("Major : "+request.getParameter("major"));
				System.out.println("Entrance ~ Graduation : "+request.getParameter("entrance")+" ~ "+request.getParameter("graduation"));
				break;
				
			case "career":
				System.out.println("DAO : career");
				System.out.println("CareerId : "+request.getParameter("careerId"));
				System.out.println("Position : "+request.getParameter("position"));
				System.out.println("Start , End date : "+request.getParameter("startDate") +" to " +request.getParameter("endDate"));
				break;

			case "skill":
				System.out.println("DAO : skill");
				System.out.println("Skill : "+request.getParameter("skillId"));
				System.out.println("Level : "+request.getParameter("level"));
				break;

			case "award":
				//dao.addAward(vo);
				System.out.println("DAO : award");
				System.out.println("Award Name : "+request.getParameter("awardName"));
				System.out.println("Institution : "+request.getParameter("institution"));
				System.out.println("Award Date : "+request.getParameter("awardDate"));
				
				break;

			case "language":
				//dao.addLanguage(vo);
				System.out.println("DAO : language");
				System.out.println("Language Name : "+request.getParameter("languageName"));
				
				break;
				
			default:
				System.out.println("DAO : ??");
				break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==0){
			returnURL="/user/editProfile.jsp";
		}

		return returnURL;
	}

}
