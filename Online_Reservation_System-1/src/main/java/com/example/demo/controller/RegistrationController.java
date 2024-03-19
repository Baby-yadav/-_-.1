package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.ReservationDetails;
import com.example.demo.entity.User;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;





@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReservationService reserveService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user",new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(User reg,Model model) {
	String msg=	userService.saveUser(reg);
	model.addAttribute("msg",msg);
		 
		
		return"register";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user",new User());
		
		return"login";
	}
		
	@PostMapping("/login")  
	public String login(User user, Model model ) {
		
		 User saveUser=userService.loginCheck(user.getName(), user.getPassword());
		 if(saveUser==null) {
			 model.addAttribute("msg","Invalid Credentials");
			 return"login";
		    }
		  return "redirect:dashboard";
	    }
	
	@GetMapping("/dashboard")
	public String ReservationInfo(ReservationDetails reservDetails, Model model) {
		   model.addAttribute("reserve",new ReservationDetails());
		return"reservationForm";
	}
		
		
    @PostMapping("/reservationForm")
    public String  saveReservationInfo(ReservationDetails reserve, Model model) {
    	
    	ReservationDetails reservDetail=reserveService.saveReservationDetails(reserve);
    	model.addAttribute("reservation",reservDetail);
    	
    return "successfull";
    	
    }
    
    @GetMapping("/cancel")
    public String reservHandle() {
    	
    	return"cancel";
    	
    }
		
    @PostMapping("/cancel")
    public String cancelReservation(@RequestParam("pnrNumber") Integer pnrNumber, Model model) {
    	    try {
    	        reserveService.cancelReservation(pnrNumber);
    	        model.addAttribute("msg", "Your reservation has been cancelled successfully.");
    	    } catch (Exception e) {
    	        model.addAttribute("msg", "Failed to cancel reservation. Please try again later.");
    	    }
    	    return "cancel"; // Return the view name
    	}
    	
  }


	
	
		
	

