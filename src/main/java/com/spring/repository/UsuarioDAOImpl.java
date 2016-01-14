package com.spring.repository;
import com.spring.model.Usuario;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;

import org.springframework.stereotype.Repository;
@Repository("usuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    @Transactional 
    public void save(Usuario u) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         tx.begin();
         em.persist(u);
         tx.commit();
         em.close();
         
    }
    public List<Usuario> list() {
        EntityManager em = emf.createEntityManager();
        String sql="select u from Usuario u";
        Query query=em.createQuery(sql);
        List<Usuario> usuario=query.getResultList();
        em.close();
        return usuario;
    }

    @Override
    public Usuario search(Usuario u) {
        EntityManager em = emf.createEntityManager();
        String sql="select u from Usuario u WHERE u.id =" + u.getId();
        Query query=em.createQuery(sql);
        Usuario usuario=(Usuario) query.getSingleResult();
        em.close();
        return usuario;
    }

    @Transactional
    public void delete(Usuario u) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         System.out.println("ID"+u.getId());
         tx.begin();
         Usuario user =em.find(Usuario.class, u.getId()); 
         em.remove(user);
         tx.commit();
         em.close();
    }

    @Transactional
    public void edit(Usuario u) {
         EntityManager em = emf.createEntityManager();
         EntityTransaction tx=em.getTransaction();
         tx.begin();
         em.merge(u);
         tx.commit();
         em.close();
    }
    
}
