package com.example.dailydates;

/**
 * Esta clase es un singleton que mantiene una instancia de la categoría seleccionada.
 * Se utiliza para compartir la categoría seleccionada entre diferentes partes de la aplicación.
 */

public class CategoriaHolder {

    // La categoría seleccionada

    private Categoria categoria;

    // La instancia única de CategoriaHolder

    public static final CategoriaHolder INSTANCE = new CategoriaHolder();

    /**
     * Constructor privado para evitar la creación de nuevas instancias.
     */

    public CategoriaHolder() {

        /**
         * Obtiene la instancia única de CategoriaHolder.
         *
         * @return la instancia de CategoriaHolder
         */

    }
    public static CategoriaHolder getInstance(){
        return INSTANCE;
    }

    /**
     * Obtiene la categoría seleccionada.
     *
     * @return la categoría actual
     */

    public Categoria getCategoria() {
        return this.categoria;
    }

    /**
     * Establece la categoría seleccionada.
     *
     * @param categoria la nueva categoría a establecer
     */

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
