/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros2;

/**
 *
 * @author Filipe
 */
public abstract class Funcionarios {
    protected String nome;
    protected String endereco;
    protected int telefone;
    protected String data_adm;
    protected int salario;
       
    
    public Funcionarios (String nome, String endereco, int telefone, String data, int salario) {
       this.nome = nome;
       this.endereco = endereco;
       this.telefone = telefone;
       this.data_adm = data;
       this.salario = salario;
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getData_adm() {
        return data_adm;
    }

    public void setData_adm(String data_adm) {
        this.data_adm = data_adm;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
