package com.example.dailydates;

public class CategoriaHolder {

    private Categoria categoria;

    public static final CategoriaHolder INSTANCE = new CategoriaHolder();

    public CategoriaHolder() {
    }
    public static CategoriaHolder getInstance(){
        return INSTANCE;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
