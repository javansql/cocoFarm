package cocoFarm.Sign.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cocoFarm.dao.AccountDao;
import cocoFarm.dto.Account;

@Controller
public class Sign {
	
	@Autowired AccountDao accDao;
	private static final Logger logger= LoggerFactory.getLogger(Sign.class);
	
	@RequestMapping(value="/Sign/In", method=RequestMethod.GET)
	public ModelAndView SignInGet (ModelAndView m) {
		
		m.setViewName("/Sign/In");
		return m;
	}
	
	@RequestMapping(value="/Sign/In", method=RequestMethod.POST)
	public ModelAndView SignInPost (ModelAndView m, Account account, HttpServletRequest request) {
		
		Account getAcc = accDao.signIn(account);
		if(account.equals(getAcc)) {
			request.getSession().setAttribute("idx", getAcc.getIdx());
			m.setViewName("redirect:/Main");
		}else {
			m.setViewName("/Sign/In");
		}
		return m;
	}
	
	@RequestMapping(value="/Sign/Up", method=RequestMethod.GET)
	public ModelAndView SignUpGet (ModelAndView m) {
		
		m.setViewName("/Sign/Up");
		return m;
	}
	
	@RequestMapping(value="/Sign/Up", method=RequestMethod.POST)
	public ModelAndView SignUpPost (ModelAndView m, Account account) {
		
//		System.out.println(account);//-------------------test
		if(account.getPw()!=null&&account.getId()!=null&&account.getPw().length()>7) {
			accDao.signUp(account);
			m.setViewName("redirect:/Door");
		} else {
			m.setViewName("/Sign/Up");
		}
		return m;
	}
	
	@RequestMapping(value="/Sign/Out", method=RequestMethod.GET)
	public ModelAndView SignOut(ModelAndView m, HttpServletRequest request) {
		
		request.getSession().invalidate();
		m.setViewName("redirect:/Door");
		return m;
	}
	
}
