package com.buulean.rom;

import Model.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalcController {

    @RequestMapping(value = "/calc", method = RequestMethod.GET )
    public  String helloForm(){
        return "Form";
    }

//    @ResponseBody
//    @RequestMapping("/hello")
    @RequestMapping(value = "/calc", method = RequestMethod.POST )
    public String hello(HttpServletRequest request, Model model) {

        String result="";

        String number_A = request.getParameter("number_A");
        String number_B = request.getParameter("number_B");

        String count = request.getParameter("count");

        if( count.equals("add") ){
            result = String.valueOf(Integer.valueOf(number_A) + Integer.valueOf(number_B));
        }else if( count.equals("subtract")){
            result = String.valueOf(Integer.valueOf(number_A) - Integer.valueOf(number_B));
        }else if( count.equals("multiply")){
            result = String.valueOf(Integer.valueOf(number_A) * Integer.valueOf(number_B));
        }else if( count.equals("divide")){
            result = String.valueOf(Integer.valueOf(number_A) / Integer.valueOf(number_B));
        }
        model.addAttribute("message", HelloMessage.getMessage(result));
        return "Result";

    }
}






