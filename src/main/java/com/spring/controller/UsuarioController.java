package com.spring.controller;

import com.spring.model.Usuario;
import com.spring.service.UsuarioService;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller("usuarioController")
public class UsuarioController {
    private UsuarioService usuarioService;
    @Autowired(required = true)
    @Qualifier(value = "usuarioService")
    public void setRolService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @RequestMapping(value="/usuario/new")
    public ModelAndView newPage() {
        ModelAndView modelAndView = new ModelAndView("/usuario/new");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }
    @RequestMapping(value="/usuario/edit")
    public ModelAndView new1Page() {
        ModelAndView modelAndView = new ModelAndView("/usuario/new");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }
    
    @RequestMapping(value="/usuario/save")
    public ModelAndView save(@ModelAttribute @Valid Usuario usuario,BindingResult result) {
        if(result.hasErrors()){
            ModelAndView error = new ModelAndView("/usuario/new");
            return error;
        }
        
        ModelAndView modelAndView = new ModelAndView("/usuario/home");
        usuarioService.save(usuario);
        return modelAndView;
    }
    
    
    @RequestMapping(value="/usuario/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("usuario/list");
        List<Usuario> usuario = usuarioService.list();
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }
    
    @RequestMapping(value="/usuario/detail/{id}",method=RequestMethod.GET)
    public ModelAndView detailPage(@PathVariable int id) {
        System.out.println("Detalle ID:"+id);
        Usuario u=new Usuario();
        u.setId(id);
        ModelAndView modelAndView = new ModelAndView("/usuario/detail");
        Usuario usuario= usuarioService.search(u);
        modelAndView.addObject("usuario",usuario);
        return modelAndView;
    }
    
    @RequestMapping(value="/usuario/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/usuario/edit");
        Usuario u=new Usuario();
        u.setId(id);
        Usuario usuario=usuarioService.search(u);
        modelAndView.addObject("usuario",usuario);
        return modelAndView;
    }
    
    @RequestMapping(value="/usuario/edit/{id}",method = RequestMethod.POST)
    public String edit( @ModelAttribute @Valid Usuario usuario,@PathVariable int id,BindingResult result) {
        if(result.hasErrors()){
            //ModelAndView modelAndView = new ModelAndView("/usuario/edit");
            usuario.setId(id);
            //modelAndView.addObject("usuario",usuario);
            return "/usuario/edit";
        }else{
        usuario.setId(id);
        //ModelAndView modelAndView = new ModelAndView("/usuario/home");
        usuarioService.edit(usuario);
        return "/usuario/home";// modelAndView;
        }
    }
    
    @RequestMapping(value="/usuario/delete/{id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        Usuario u=new Usuario();
        u.setId(id);
        ModelAndView modelAndView=new ModelAndView("/usuario/home");
        usuarioService.delete(u);
        return modelAndView;
    }
    
    
}
