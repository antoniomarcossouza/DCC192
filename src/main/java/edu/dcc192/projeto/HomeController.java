package edu.dcc192.projeto;

import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private GeradorSenha senha;

    @GetMapping("/")
    public ModelAndView home(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @Autowired
    UsuarioRepository ur;

    @GetMapping("/usuarios")
    public ModelAndView usuarios() {
        List<Usuario> lu = ur.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuarios");
        mv.addObject("usuarios", lu);
        return mv;
    }

    public class CreateUserEntity {
        public String login;
        public String senha;
    }

    @PostMapping("/addUsuarios")
    public ModelAndView adicionaUsuarios(@RequestParam String login, @RequestParam String senha) {
        ur.save(new Usuario(login, senha));
        return usuarios();
    }

    @GetMapping("/captcha")
    public ModelAndView captcha_home(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("captcha");
        String senhaGerada = senha.GerarSenha();
        session.setAttribute("senha", senhaGerada);
        mv.addObject("senha", senhaGerada);
        return mv;
    }

    @GetMapping("login")
    public ModelAndView login(@RequestParam String codigo, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        String senhaGerada = (String) session.getAttribute("senha");

        if (senhaGerada != null && senhaGerada.equals(codigo)) {
            mv.setViewName("login");
            mv.addObject("captcha_message", "Acesso permitido!");
        } else {
            mv.setViewName("captcha");
            senhaGerada = senha.GerarSenha();
            session.setAttribute("senha", senhaGerada);
            mv.addObject("senha", senhaGerada);
            mv.addObject("captcha_message", "Captcha Errado. Tente novamente.");
        }

        return mv;
    }

    @Autowired
    private Dados dados;

    @GetMapping("menu")
    public ModelAndView menu(@RequestParam(required = false) String name, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu");

        if (name != null) {
            session.setAttribute("userName", name);
        } else {
            name = (String) session.getAttribute("userName");
        }

        mv.addObject("userName", name);
        mv.addObject("dados", dados.pegaDados());
        return mv;
    }

    @GetMapping("info")
    public ModelAndView menu() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("info");
        return mv;
    }

    @GetMapping("sair")
    public ModelAndView captcha_logout(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("captcha");
        String senhaGerada = senha.GerarSenha();
        session.setAttribute("senha", senhaGerada);
        mv.addObject("senha", senhaGerada);
        mv.addObject("logout", true);
        return mv;
    }
}