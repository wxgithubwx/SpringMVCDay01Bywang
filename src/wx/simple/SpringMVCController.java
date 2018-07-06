package wx.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import wx.bean.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class SpringMVCController {

    /**
     * 1. 在web.xml 里面配置DispatcherServlet
     *    并通过<init-param>节点配置初始化文件springmvc.xml
     *    classpath:springmvc.xml
     * 2. 添加类
     *     @Controller     在方法上添加@RequestMapping
     * 3. 配置注解扫描和注解驱动
     *    <context:component-scan base-package="com.jf.weidong.simple01" />
     *    <mvc:annotation-driven />
     */
    @RequestMapping("/first")
    public ModelAndView first(){
        ModelAndView view=new ModelAndView();
        view.setViewName("/index.jsp");
        view.addObject("msg","the first");
        return view;
    }

    /**
     * 方法的参数
     * spring会将对象正确的传入
     * @param request
     */
    @RequestMapping("/param")
    public void param(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp");
    }

    /**
     * 将参数输出到页面上
     *     TODO http://localhost:8080/responseBody?id=9
     *     int 的参数类型 如果不传参数报错
     *     为什么方法是int类型不可以
     *     为什么url允许有相同
     */
    @RequestMapping("/responseBody1")
    @ResponseBody
    public String responseBody(int id){
        return id+"";
    }

    /**
     * 绑定包装类型
     * TODO http://localhost:8080/responseBody2
     * 包装类下不传参数默认为空
     * 如果参数有可能为空，建议使用包装类
     */
    @RequestMapping("/responseBody2")
    @ResponseBody
    public String bindInteger(Integer id){
        return id+"";
    }

    /**
     * 绑定String类型
     * TODO http://localhost:8080/bindString?name=lisi
     */
    @RequestMapping("/bindString")
    @ResponseBody
    public String bindString(String name){

        return name;
    }

    /**
     * 绑定自定义类型
     * TODO http://localhost:8080/bindBook?bookId=11&bookName=java
     */
    @RequestMapping("/bindBook")
    @ResponseBody
    public String bindBook(Book book){

        return book.toString();
    }

    /**
     * 绑定自定义类型
     * TODO http://localhost:8080/bindObject?name=lisi&id=101&book.bookId=8&book.bookName=java
     * @param user
     * @return
     */
    @RequestMapping("/bindObject")
    @ResponseBody
    public String bindObject(User user){
        return user.toString();
    }

    /**
     * 绑定同属性多对象
     * TODO http://localhost:8080/bindObject2?name=lisi&id=101&bookId=7&bookName=lll
     */
    @RequestMapping("/bindObject2")
    @ResponseBody
    public String bindObject2(User user,Book book){
        return user.toString()+"    "+book.toString();
    }


    /**
     *绑定两个自定义对象属性完全相同
     * TODO http://localhost:8080/bindObject3?id=111&name=tom
     * Dog{id=111, name='tom'} Cat{id=111, name='tom'}
     *
     * 加上InitBinder注解之后
     * TODO http://localhost:8080/bindObject3?dog.id=101&dog.name=zzz&cat.name=mimi&cat.id=202
     * Dog{id=101, name='zzz'} Cat{id=202, name='mimi'}
     */
    @RequestMapping("/bindObject3")
    @ResponseBody
    public String bindObject3(Dog dog, Cat cat){
        return dog.toString()+"    "+cat.toString();
    }

    /**
     * 为解决上面问题
     */
    @InitBinder("dog")
    public void initBindDog(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("dog.");
    }

    @InitBinder("cat")
    public void initBindCat(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("cat.");
    }


    /**
     * 绑定数组
     * Todo http://localhost:8080/bindArr?name=lisi&name=zhangsan&name=wx
     */
    @RequestMapping("/bindArr")
    @ResponseBody
    public String bindArr(String[] name){
        return Arrays.toString(name);
    }

    /**
     * 绑定集合
     * 绑定集合需要做一个操作【数据收集】
     *      * 新建一个类UserListVO
     *      *
     *      todo http://localhost:8080/bindList?users%5B0%5D.name=lisi&users%5B0%5D.id=11&users%5B1%5D.name=zhangsan&users%5B1%5D.id=22
     *      *  [:%5B
     *      *  ]:%5D
     *      * 下标跨越： 0   10
            todo http://localhost:8080/bindList?users%5B0%5D.name=lisi&users%5B0%5D.id=11&users%5B10%5D.name=zhangsan&users%5B10%5D.id=22
     * */

    @RequestMapping("/bindList")
    @ResponseBody
    public String bindList(UserListVo users){
        System.out.println(users.toString());
        return users.toString();
    }


    /**
     * 参数名和方法形参不一致
     *  如果参数名和在地址栏输入的参数名不一致则结果为null
     *  采用RequestParam注解可解决
     */
    @RequestMapping("/bindParam")
    @ResponseBody
    public String bindParam(@RequestParam(value = "ad") Integer id){
        return id+"";
    }

    /**
     * 绑定时间类型   要在日期那里用注解格式化
     * todo http://localhost:8080/bindDate?date=2018-6-25%2014:34:57
     * User{name='null', id=0, book=null, date=Mon Jun 25 14:34:57 CST 2018}
     * @param user
     * @return
     */
    @RequestMapping("/bindDate")
    @ResponseBody
    public String bindDate(User user){
        return user.toString();
    }

    /**
     * 重定向
     */
    @RequestMapping("/redirect")
    public void redirect(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp?msg=aaa");
    }

    /**
     * 重定向：RedirectView
     * 自动将参数拼接到请求的url后面
     */
    @RequestMapping("/redirectView")
    public RedirectView redirectView(RedirectAttributes attributes){
        //方式一：
        //return new RedirectView("/index.jsp?msg=aaa");
        //方式二：
        attributes.addAttribute("msg","bbbb");
        return new RedirectView("/index.jsp");
    }

    /**
     * 转发
     */
    @RequestMapping("forward")
    public String forward(HttpServletRequest request,HttpServletResponse response){
        //return "forward:/index.jsp?msg=aaaa";
        return "first";//在xml文件中配置
    }


    //转发：  return "index.jsp"




}
