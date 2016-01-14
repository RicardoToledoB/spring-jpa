/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service;

import com.spring.model.Usuario;
import com.spring.repository.UsuarioDAO;
import java.util.List;

/**
 *
 * @author ricardotoledo
 */
public interface UsuarioService {
    public void setUsuarioDAO(UsuarioDAO usuarioDAO);
    public void save(Usuario u);
    public List<Usuario> list();
    public Usuario search(Usuario u);
    public void delete(Usuario u);
    public void edit(Usuario u);
}
