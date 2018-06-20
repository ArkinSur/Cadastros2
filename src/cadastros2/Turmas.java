/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros2;

import java.util.ArrayList;

/**
 *
 * @author Filipe
 */
public class Turmas {
    private int codigo;
    private String nome;
    private Disciplinas dip;
    private Professores prof;
    private Alunos aluno;

    public Turmas(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;       
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplinas getDip() {
        return dip;
    }

    public void setDip(Disciplinas dip) {
        this.dip = dip;
    }

    public Professores getProf() {
        return prof;
    }

    public void setProf(Professores prof) {
        this.prof = prof;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }
}
