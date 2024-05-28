package com.example.dailydates;

public class EmpresarioHolder {

    private Empresario empresario;

    public static final EmpresarioHolder INSTANCE = new EmpresarioHolder();

    public EmpresarioHolder() {
    }

    public static EmpresarioHolder getInstance(){
        return INSTANCE;
    }

    public Empresario getEmpresario() {
        return this.empresario;
    }

    public void setEmpresario(Empresario empresariopa) {
        this.empresario = empresariopa;
    }

}
