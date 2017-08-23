package csdc.demo.beans;



//import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import csdc.demo.springmvc.HelloWorldAction;

@Service
public class CustomerService {
	/*@Resource
	private HelloWorldAction helloWorldAction;*/
	public void add(){
		System.out.println("customer service add");
	//	System.out.println(helloWorldAction);
	}
}
