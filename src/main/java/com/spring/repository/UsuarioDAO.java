/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.model.Usuario;
import java.util.List;

/**
 *
 * @author ricardotoledo
 */
public interface UsuarioDAO {
     public void save(Usuario u);
    public List<Usuario> list();
    public Usuario search(Usuario u);
    public void delete(Usuario u);
    public void edit(Usuario u);
}
