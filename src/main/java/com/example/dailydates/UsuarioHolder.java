package com.example.dailydates;

/**
 * Clase que actúa como un contenedor para almacenar un objeto Usuario.
 * Utiliza el patrón Singleton para garantizar una única instancia en toda la aplicación.
 */
public final class UsuarioHolder {

    /** Objeto Usuario almacenado en el contenedor */
      private Usuario usuario;

    /** Instancia única de UsuarioHolder */
        public static final UsuarioHolder INSTANCE = new UsuarioHolder();

    /** Constructor privado para evitar instanciación externa */
    public UsuarioHolder() {
    }
    /**
     * Método estático para obtener la instancia única de UsuarioHolder.
     * @return La instancia única de UsuarioHolder.
     */
    public static UsuarioHolder getInstance(){
               return INSTANCE;
           }

    /**
     * Obtiene el objeto Usuario almacenado en el contenedor.
     * @return El objeto Usuario almacenado.
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * Establece el objeto Usuario en el contenedor.
     * @param usuariopa El objeto Usuario a almacenar.
     */
    public void setUsuario(Usuario usuariopa) {
        this.usuario = usuariopa;
    }

}
