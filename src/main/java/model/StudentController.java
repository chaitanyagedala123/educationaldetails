package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	Stdaoimpl std=new Stdaoimpl();
	@RequestMapping("/")
	public ModelAndView liststudents() {
		ModelAndView mav =new ModelAndView("listofstudents");
		List<Stddtls> student=std.allList();
		mav.addObject("studentslist", student);
		return mav;

	}
	@RequestMapping("/login")
	public ModelAndView loginGetPage() {
		ModelAndView mav =new ModelAndView("LoginPage");

		return mav;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = null; 

		String mblno=request.getParameter("mobile");
		String pswd=request.getParameter("password");
		System.out.println("mobile number:"+mblno);
		System.out.println("password is:"+pswd);
		Stddtls student =std.login(mblno);
		if (student!=null) {
			if(student.getStdPswd().equals(pswd)) {

				mav=new ModelAndView("HomePage");

			}else {
				mav=new ModelAndView("LoginPage");
				mav.addObject("errormsg", "please enter proper password");
			}
		}
		else {
			mav=new ModelAndView("LoginPage");
			mav.addObject("errormsg", "please enter proper mobilenumber");

		}
		return mav;
	}

}
