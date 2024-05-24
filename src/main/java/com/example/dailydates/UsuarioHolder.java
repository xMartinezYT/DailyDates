package com.example.dailydates;

public class UsuarioHolder {

      private Usuario usuario;


           public static final UsuarioHolder INSTANCE = new UsuarioHolder();

           public static UsuarioHolder getInstance(){
               return INSTANCE;
           }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
