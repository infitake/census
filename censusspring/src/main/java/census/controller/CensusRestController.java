package census.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import census.entity.Member;
import census.exceptions.MemberNotFoundException;
import census.services.MemberService;

/**
For Spring Boot App Your Main File must be on the root
if Using @Controller Annotations then using model and view and show the result
on jsp pages
if using @RestController than your directly return from contoller method show on
the webpage w/o jsp pages


**/

@RestController
public class CensusRestController {
	
	static Logger log = Logger.getLogger(CensusRestController.class.getName());
	@Autowired
	private MemberService memberservice;	
	
//	@RequestMapping("home")
//	public ModelAndView home(@RequestParam("name") String myname) {
//		System.out.println("name is :"+ myname);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name", myname);
//		mv.setViewName("home");
//		return mv;
////		return "home.jsp";
//		
//	}
	
//	@RequestMapping("param")
//	public ModelAndView getParam(@RequestParam("name") String name) {
//		System.out.println("name is :"+name);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name", name);
//		mv.setViewName("showname");
//		return mv;
//	}
	 @GetMapping("/members")
	  List<Member> all() {
	    return memberservice.findAllMembers();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/members")
	  Member newMember(@RequestBody Member newEmployee) {
	    return memberservice.saveNewMember(newEmployee);
	  }
	  
	  @RequestMapping("greeting")
	  public String greetings() {
			System.out.println("this is the contrller");
		  log.info("greeting is writeable");
		  return "Hello How are you?";
	  }

;	  @GetMapping("/membersbyid/{id}")
	  public Optional<Member> getMembersById(@RequestBody Member newEmployee, @PathVariable Integer id) throws MemberNotFoundException {
		  System.out.println("inside get memeber by id");
		  
		  Optional<Member> member = memberservice.getMembersById(id);
		  System.out.println("here is value"+member);
				  if(!member.isEmpty()) {
					  return member;
				  }else {
					  log.error("This particular id is not present");
				  throw new MemberNotFoundException(id);
				  }
		  
	  }
	  


}