
package com.delivery.checker;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.checker.getResult;




@Controller
public class restEndpoint {





@Autowired
getResult get ;


String numb ; 



String getnumber () {
return get.getNumber();
}

String getfilename() {
return get.getFilename();
}

String getnumberitle() {
return get.getNumbertitle() ; 
}

String filedescription() {
return get.getFiledescription();
}



public String getNumb() {
	return numb;
}

public void setNumb(String numb) {
	this.numb = numb;
}

public restEndpoint() {
	super();
}
	
@RequestMapping("/console")
public String index (Model model, @ModelAttribute("getresult") getResult getresult) {

	

return "home";
}

//

@RequestMapping(value="/search", method=RequestMethod.GET)
public String search(  Model model, @ModelAttribute("getresult") getResult getresult, @RequestParam(name = "number") String number, BindingResult errors) throws IOException {


getResult  getr = new getResult() ; 
getr.search(number);
model.addAttribute("filename", getr.getFilename());
model.addAttribute("numbertitle" , getnumberitle());
model.addAttribute("filedescription" , filedescription()) ;
model.addAttribute("getresult" , getresult);

 
return "home"; 

	}



	
	
	

}
