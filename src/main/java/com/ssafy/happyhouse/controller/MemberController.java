package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.dto.Member;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/mem")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService service;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv) {
		logger.info("/root 입니다.....");
		mv.addObject("msg", "good......");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("inputEmail") String id, @RequestParam("inputPassword") String pw,
			ModelAndView mv, HttpSession session) {
		try {
			Member member = service.login(id, pw);
			session.setAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		session.invalidate();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/signup_form")
	public ModelAndView go_signup(ModelAndView mv, HttpSession session) {
		mv.setViewName("user/signup");
		return mv;
	}

	@RequestMapping("/user_info")
	public ModelAndView go_user_info(ModelAndView mv, HttpSession session) {
		mv.setViewName("user/user-info");
		return mv;
	}

	@RequestMapping("/user-info-modi")
	public ModelAndView go_user_info_del(ModelAndView mv, HttpSession session) {
		mv.setViewName("user/user-info-modi");
		return mv;
	}

	@RequestMapping("/forget-form")
	public ModelAndView go_forget_form(ModelAndView mv, HttpSession session) {
		mv.setViewName("user/forget_form");

		return mv;
	}

	@RequestMapping("/forget")
	public ModelAndView forget(@RequestParam("inputEmail") String id, @RequestParam("inputName") String name,
			@RequestParam("inputTel") String tel, ModelAndView mv, HttpSession session) {
		Member member = new Member();

		member.setEmail(id);
		member.setName(name);
		member.setTel(tel);

		boolean check;
		try {
			check = service.check(member);
			if (check) {
				mv.addObject("member", member);
				mv.setViewName("user/changePw");
			} else {
				mv.setViewName("user/forget_form");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/changePw")
	public ModelAndView go_changePw(ModelAndView mv, HttpSession session) {
		mv.setViewName("user/changePw");
		return mv;
	}

	@RequestMapping("/modi")
	public ModelAndView modi(@RequestParam("userEmail") String id, @RequestParam("userPw") String pw,
			@RequestParam("userName") String name, @RequestParam("userTel") String tel, ModelAndView mv,
			HttpSession session) {
		try {
			service.update(id, pw, name, tel);
			Member member = service.login(id, pw);
			session.invalidate();
			session.setAttribute("member", member);
			mv.setViewName("index");
		} catch (Exception e) {
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping("/user-del")
	public ModelAndView user_del(@RequestParam("userEmail") String id, ModelAndView mv, HttpSession session) {
		try {
			session.invalidate();
			service.delete(id);
			mv.setViewName("index");
		} catch (Exception e) {
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping("/signup")
	public ModelAndView insert(@RequestParam("signupEmail") String id, @RequestParam("signupPassword") String pw,
			@RequestParam("signupName") String name, @RequestParam("signupTel") String tel, ModelAndView mv,
			HttpSession session) {
		try {
			service.insert(id, pw, name, tel);
			mv.setViewName("index");
		} catch (Exception e) {
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping("/user_search")
	public ModelAndView user_search(@RequestParam String input, ModelAndView mv, HttpSession session) {
		List<Member> list;
		try {
			list = service.list(input);
			mv.addObject("list", list);
			mv.setViewName("user/user_search");
		} catch (Exception e) {
			mv.setViewName("user/user_search");
		}
		return mv;
	}

	@RequestMapping("/modip")
	public ModelAndView modiP(@RequestParam("userEmail") String id, @RequestParam("userPw") String pw, ModelAndView mv,
			HttpSession session) {
		try {
			service.update(id, pw);
			mv.setViewName("index");
		} catch (Exception e) {
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping("/member")
	public ModelAndView list(ModelAndView mv, HttpSession session) {
		List<Member> list;
		try {
			list = service.list();
			mv.addObject("list", list);
			mv.setViewName("user/member");
		} catch (Exception e) {
			mv.setViewName("user/member");
			e.printStackTrace();
		}

		return mv;
	}

}
