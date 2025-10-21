package br.com.despesa.model;

import java.time.LocalDate;

public class Despesa {
    private int id;
    private int usuario_id;
    private String categoria;
    private LocalDate dataDespesa;
    
    public Despesa() {}
    
    public Despesa(int id, int usuario_id, String categoria, LocalDate dataDespesa) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.categoria = categoria;
        this.dataDespesa = dataDespesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }
}
