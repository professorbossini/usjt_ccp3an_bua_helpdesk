package br.com.bossini.usjt_ccp3an_bua_helpdesk;

import java.io.Serializable;
import java.util.List;

public class Fila implements Serializable {

    private String nome;
    private int iconId;

    public Fila(String nome, int iconId) {
        this.nome = nome;
        this.iconId = iconId;
    }

    private List <Chamado> chamados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
