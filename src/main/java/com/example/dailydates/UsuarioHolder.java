package com.example.dailydates;


public final class UsuarioHolder {

      private Usuario usuario;


           public static final UsuarioHolder INSTANCE = new UsuarioHolder();

    public UsuarioHolder() {
    }

    public static UsuarioHolder getInstance(){
               return INSTANCE;
           }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuariopa) {
        this.usuario = usuariopa;
    }

}
