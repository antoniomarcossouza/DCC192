package edu.dcc192.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private GeradorSenha senha;

    @GetMapping("/")
    public ModelAndView captcha_home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("captcha");
        mv.addObject("senha", senha.GerarSenha());
        return mv;
    }

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @Autowired
    private Dados dados;

    @GetMapping("menu")
    public ModelAndView menu(@RequestParam String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu");
        mv.addObject("userName", name);
        mv.addObject("dados", dados.pegaDados());
        return mv;
    }

    @GetMapping("sair")
    public ModelAndView captcha_logout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("captcha");
        mv.addObject("logout", true);
        mv.addObject("senha", senha.GerarSenha());
        return mv;
    }
}