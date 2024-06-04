package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/")
    public @ResponseBody String index() {
        return "OK!";
    }

    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("msg", "조엘!");
        return "hello";
    }



}
