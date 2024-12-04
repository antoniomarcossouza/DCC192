package edu.dcc192.projeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("menu")
    public ModelAndView getMethodName(@RequestParam String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("userName", name);
        return mv;
    }

    @GetMapping("sair")
    public ModelAndView getMethodLogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        mv.addObject("logout", true);
        return mv;
    }

}