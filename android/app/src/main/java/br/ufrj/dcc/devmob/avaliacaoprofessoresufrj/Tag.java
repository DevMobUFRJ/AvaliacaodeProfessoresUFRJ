package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj;

/**
 * Created by devmob on 04/04/17.
 */

public class Tag{
    private int id;
    private String nome;
    private int clique;
    private int dit_valor = 0;

    public int getDid() {return dit_valor;}

    public void setDidatica (int didatica) { this.dit_valor = didatica; }

    public int getId() {
        return id;
    }

    public int getClique() { return clique;}

    public void setClique(int clique) { this.clique = clique; }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
