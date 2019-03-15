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
        return "HelloForm";
    }

//    @ResponseBody
//    @RequestMapping("/hello")
    @RequestMapping(value = "/calc", method = RequestMethod.POST )
    public String hello(HttpServletRequest request, Model model) {

        String result="";

        String number_A = request.getParameter("number_A");
        String number_B = request.getParameter("number_B");

        String Dodaj = request.getParameter("Dodaj");
        String Odejmij = request.getParameter("Odejmij");
        String Pomnoz = request.getParameter("Pomnoz");

        if(Dodaj!=null){
            result = String.valueOf(Integer.valueOf(number_A) + Integer.valueOf(number_B));
        }else if(Odejmij!=null){
            result = String.valueOf(Integer.valueOf(number_A) + Integer.valueOf(number_B));
        }

        model.addAttribute("message", HelloMessage.getMessage(result));

        return "Hello";

//        return "Hello/mesage";
//        return "<h1>"+ HelloMessage.getMessage("Jozek")+"</h1>";
//        return "<h1>Hello World! :)</h1>";

    }

}






