package wx.simple;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index.jsp");
        mav.addObject("msg", "我的第一个Spring MVC 程序！！！");
        return mav;
    }
}
