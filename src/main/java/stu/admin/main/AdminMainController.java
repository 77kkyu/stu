package stu.admin.main;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import stu.common.common.CommandMap;

@Controller
public class AdminMainController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminMainService")
	private AdminMainService adminMainService;
	
	/* mvc:annotation-driven을 선언하면 HandlerMethodArgumentResolver가 Map형식일때 동작을 못함 해서
	 * 기본 Map형식이 아닌 map을 가지는 클래스를 만들어 사용 commandMap */
	// adminMain
	@RequestMapping(value="/adminMain.do", method = RequestMethod.GET)
	public ModelAndView adminView(CommandMap commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView("admin/adminMain");
		
		List<Map<String,Object>> dashList = adminMainService.dashBoard(commandMap);
		mv.addObject("dashList", dashList);
			
		return mv;
	}
	
	// order_admin_a
	@RequestMapping(value="/order_admin_a.do")
	public ModelAndView order_admin_a(CommandMap commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView("admin/order_admin_a");
		
		List<Map<String,Object>> order_a = adminMainService.order_admin_a(commandMap);
		System.out.println(order_a);
		
		mv.addObject("order_a", order_a);
			
		return mv;
	}
	
	
}











