package com.spring.service;
import com.spring.model.Usuario;
import com.spring.repository.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioDAO usuarioDAO;
    @Autowired(required=true)
    @Qualifier(value="usuarioDAO")
    @Override
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO=usuarioDAO;
    }

    @Override
    public void save(Usuario u) {
        this.usuarioDAO.save(u);
    }

    @Override
    public List<Usuario> list() {
        return this.usuarioDAO.list();
    }

    @Override
    public Usuario search(Usuario u) {
        return this.usuarioDAO.search(u);
    }

    @Override
    public void delete(Usuario u) {
        this.usuarioDAO.delete(u);
    }

    @Override
    public void edit(Usuario u) {
        this.usuarioDAO.edit(u);
    }
    
    
}
