package com.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;
    @NotNull
    @Size(min=2)
    @Column(name="nombre")
    private String nombre;
    @NotNull
    @Size(min=2)
    @Column(name="apepat")
    private String apepat;
    @NotNull
    @Size(min=2)
    @Column(name="apemat")
    private String apemat;
    @NotNull
    @Column(name="fecnac")
    private String fecnac;

    
    
    
    @NotNull
    @Size(min=2)
    @Column(name="estado")
    private String estado;
    
    
    @NotNull
    @Email
    @Column(name="correo")
    private String correo;

   
    
    
    public Usuario() {
    }

    public Usuario(int id, String nombre, String apepat, String apemat,String estado,String correo,String fecnac) {
        this.id = id;
        this.nombre = nombre;
        this.apepat = apepat;
        this.apemat = apemat;
        this.estado = estado;
        this.correo=correo;
        this.fecnac=fecnac;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
