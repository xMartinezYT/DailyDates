package com.example.dailydates;

import java.io.File;

public class EmpresarioHolder {

    private Empresario empresario;
    private File img;

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

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
