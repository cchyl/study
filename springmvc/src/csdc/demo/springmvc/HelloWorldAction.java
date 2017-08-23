package csdc.demo.springmvc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import csdc.demo.beans.CustomerService;
import csdc.demo.domain.Customer;

@Controller
//@RequestMapping("/customer")
public class HelloWorldAction {
	/**
	 * 1.使用@RequestMapping映射请求的URL
	 * 2.返回值会通过视图解析器解析为实际的视图，对于InternalResourceViewResolver
	 *  会通过prefix+returnVal+后缀得到实际物理视图，然后转发
	 *  
	 * @return
	 */
	@Resource
	private CustomerService customerService;
	
	@SessionAttributes
	public String testSessionAttributes(){
		
	}
	@ModelAttribute("customer2")
	public Customer getCustomer(){
		System.out.println("getCustomer...");
		Customer customer=new Customer();
		customer.setId(100);
		return customer;
	}
	@RequestMapping("/add2")
	public String add2(Customer customer,ModelMap modelMap){
		
		System.out.println("add2....");
		System.out.println("customer:"+customer.toString());
		Customer customer2 =(Customer)modelMap.get("customer2");
		System.out.println("customer2:"+customer2);
		return "success";
		
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("customer") Customer customer){
		customer.setId(11);
		
		return "success";
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(@RequestParam("customerid")String custId){
		ModelAndView mav= new ModelAndView("success");
		Customer customer =new Customer();
		customer.setId(Integer.parseInt(custId));
		customer.setCustomerName("11");
		customer.setEmail("as");
		mav.addObject("customer",customer);
		return mav;
		
	}
	
	@RequestMapping("/testInputStreamAndOutputStream")
	public void testInputStreamAndOutputStream(BufferedReader reader,OutputStream out) throws IOException{
		String str=null;
		while((str=reader.readLine())!=null){
			System.out.println(str);
		}
		InputStream in =new FileInputStream("e:\\api/11.txt");
		byte [] buffer= new byte[1024*10];
		int len=0;
		while((len=in.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
		
		
	}

	@RequestMapping("/testRequest")
	public String testResquest(HttpServletRequest request){
		System.out.println("time: "+request.getParameter("time"));
		return "success";
	}
	@RequestMapping("/add")
	public String add(Customer customer,ModelMap modelMap){
		customer.setId(11);
		modelMap.put("customer",customer);
		return "success";
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("customerid") String custId, ModelMap modelMap,
			@CookieValue("JSESSIONID")String jsessionId,@RequestHeader("Accept") String accept){
		System.out.println("edit...");
		System.out.println("customerId:"+custId);
		System.out.println("JSESSIONID:"+jsessionId);
		System.out.println("accept:"+accept);
		Customer customer =new Customer();
		customer.setId(Integer.parseInt(custId));
		customer.setCustomerName("111");
		customer.setEmail("111@qq.com");
		modelMap.put("customer", customer);
		return "success";
	}
	
	@RequestMapping(value="/edit2",method=RequestMethod.GET,
			params={"customerid=100","!id"},headers={"Cookie"})
	public String edit2(@RequestParam("customerid") String custId){
		System.out.println("edit...");
		System.out.println("customerId:"+custId);
		
		
		return "success";
	}
	
	@RequestMapping("/*/hello2??")
	public String testWildCard(){
		System.out.println("test wildCard...");
		return "success";
	}
	@RequestMapping("/hello2")
	public String hello(){
		System.out.println("hello world...");
		customerService.add();
		return "success";
	}
}
