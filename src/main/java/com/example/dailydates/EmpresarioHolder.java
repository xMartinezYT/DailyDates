package com.example.dailydates;

/**
 * La clase EmpresarioHolder actúa como un contenedor singleton para un objeto Empresario.
 * Esta clase asegura que solo exista una instancia de EmpresarioHolder, proporcionando un acceso global a esta instancia.
 */
public class EmpresarioHolder {

    private Empresario empresario;

    /**
     * La única instancia de EmpresarioHolder.
     */
    public static final EmpresarioHolder INSTANCE = new EmpresarioHolder();

    /**
     * Constructor privado para prevenir la creación de múltiples instancias de EmpresarioHolder.
     */
    public EmpresarioHolder() {
    }

    /**
     * Obtiene la instancia única de EmpresarioHolder.
     *
     * @return la instancia única de EmpresarioHolder
     */
    public static EmpresarioHolder getInstance(){
        return INSTANCE;
    }

    /**
     * Obtiene el objeto Empresario almacenado.
     *
     * @return el objeto Empresario
     */
    public Empresario getEmpresario() {
        return this.empresario;
    }

    /**
     * Establece el objeto Empresario a almacenar.
     *
     * @param empresariopa el objeto Empresario a almacenar
     */
    public void setEmpresario(Empresario empresariopa) {
        this.empresario = empresariopa;
    }

}

