package com.mthree.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"session_email"})
public class MyController {
	
	
	// Request Mapping methods
	
	@GetMapping(path="/")
	//@RequestMapping(path="/",method=RequestMethod.GET)
	public String hello() {
		
		return "hello"; //  Return value is name of "view" 
	}

	
	
	
	@GetMapping(path="/hi")
	public void hello2(HttpServletResponse response)  {
		
		try {
			
			response.getWriter().println("<h1> Welcome to Spring Web!!! </h1>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
		
	@GetMapping(path="/hi2")
	public void hello3(HttpServletRequest request,HttpServletResponse response)  {
		
		try {
			
			RequestDispatcher rd = request.getRequestDispatcher("/hello2.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	@GetMapping(path="/hi3")
	public ModelAndView hello3(HttpServletRequest request)  {
		// Here "display" is the name of the page/view
		// username is a "lookup/key"
		// Kishore is a value object
		ModelAndView mv = new ModelAndView("display","username","Kishore");
		// We can add more model objecs using addObject method
		// Here "date" is lookup/key and LocalDate.now() will give today's date as object
		mv.addObject("date",LocalDate.now());
		
		HttpSession session = request.getSession();
		
		session.setAttribute("http_session_email", "kishore@gmail.com");
		
		return mv;
		
	}
	
	
	
	@GetMapping(path="/hi4")
	public ModelAndView hello4()  {
		
		ModelAndView mv = new ModelAndView("display","username","Kishore");
		mv.addObject("date",LocalDate.now());
		mv.addObject("session_email","kishore@gmail.com");
		
		return mv;
		
	}
	
	@GetMapping(path="/login")
	public ModelAndView login(@RequestParam("email") String email,@RequestParam("password") String password)  {
		
		
		ModelAndView mv = new ModelAndView();
		
		if(email.equals("kishore@gmail.com") && password.equals("1234")) {
		
			mv.setViewName("success");
		}
		else {
			mv.setViewName("failure");
		}
		return mv;
		
	}
	
	
}
