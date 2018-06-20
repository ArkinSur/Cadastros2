/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Filipe
 */
public class ola extends javax.swing.JFrame {
    //Variáveis
    String modo1;
    String modo2;
    String modo3;
    String modo4;
    String modo5;
    String modo6;
    String modo7;
    String modo8;
    ArrayList<Setores> lista = new ArrayList();
    ArrayList<Escolas> escola = new ArrayList();
    ArrayList<Administrativo> adm = new ArrayList();
    ArrayList<Professores> prof = new ArrayList();
    ArrayList<Cursos> curso = new ArrayList();
    ArrayList<Alunos> aluno = new ArrayList();
    ArrayList<Disciplinas> dip = new ArrayList();
    ArrayList<Turmas> turma = new ArrayList();
    
    //Métodos pra manipular as informações das tabelas
    public void carregaAdm () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome","Endereço","Telefone","Data de Admissão",
                                                                        "Salário","Setor"},0);
        
        for (int i=0; i<adm.size(); i++) {
            modelo.addRow(new Object[]{adm.get(i).getNome(), adm.get(i).getEndereco(), adm.get(i).getTelefone(), 
                                       adm.get(i).getData_adm(), adm.get(i).getSalario(), adm.get(i).getSetor().getNome()});
        }
        
        tbl_adm.setModel(modelo);
        tbl_adm.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbl_adm.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbl_adm.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbl_adm.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_adm.getColumnModel().getColumn(4).setPreferredWidth(60);
        tbl_adm.getColumnModel().getColumn(5).setPreferredWidth(60);
        
    }
      
    public void carregaProf () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome","Endereço","Telefone","Data de Admissão",
                                                                        "Salário","Escola"},0);
        
        for (int i=0; i<prof.size(); i++) {
            modelo.addRow(new Object[]{prof.get(i).getNome(), prof.get(i).getEndereco(), prof.get(i).getTelefone(), 
                                       prof.get(i).getData_adm(), prof.get(i).getSalario(), prof.get(i).getEscola().getNome()});
        }
        
        tbl_prof.setModel(modelo);
        tbl_prof.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbl_prof.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbl_prof.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbl_prof.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_prof.getColumnModel().getColumn(4).setPreferredWidth(60);
        tbl_prof.getColumnModel().getColumn(5).setPreferredWidth(60);
        loadCBTurma2();
    }
    
    public void carregaEscola () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código","Escola"},0);    
        
        for (int i=0; i<escola.size(); i++) {
            modelo.addRow(new Object[]{escola.get(i).getCodigo(), escola.get(i).getNome()});
        }
        
        tbl_escolas.setModel(modelo);
        tbl_escolas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_escolas.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        loadCBProf();
        loadCBCurso();
    }
    
    public void carregaSetor () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código","Setor"},0);    
        
        for (int i=0; i<lista.size(); i++) {
            modelo.addRow(new Object[]{lista.get(i).getCodigo(), lista.get(i).getNome()});
        }
        
        tabela_setor.setModel(modelo);
        tabela_setor.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_setor.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        loadCBAdm();
    }
     
    public void carregaCurso () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código","Nome", "Escola"},0);    
        
        for (int i=0; i<curso.size(); i++) {
            modelo.addRow(new Object[]{curso.get(i).getCodigo(), curso.get(i).getNome(), curso.get(i).getEscola().getNome()});
        }
        
        tbl_curso.setModel(modelo);
        tbl_curso.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_curso.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_curso.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        loadCBAluno();
        loadCBDip();
    }
    
    public void carregaAluno () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Matrícula","Nome","Endereço","Telefone","Curso"},0);
        
        for (int i=0; i<aluno.size(); i++) {
            modelo.addRow(new Object[]{aluno.get(i).getMatricula(), aluno.get(i).getNome(), aluno.get(i).getEndereco(), 
                                        aluno.get(i).getTelefone(), aluno.get(i).getCurso().getNome()});
        }
        
        tbl_alunos.setModel(modelo);
        tbl_alunos.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbl_alunos.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_alunos.getColumnModel().getColumn(2).setPreferredWidth(180);
        tbl_alunos.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_alunos.getColumnModel().getColumn(4).setPreferredWidth(80);
        loadCBTurma3();    
    }
    
    public void carregaDisciplina () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código","Nome", "Curso"},0);    
        
        for (int i=0; i<dip.size(); i++) {
            modelo.addRow(new Object[]{dip.get(i).getCodigo(), dip.get(i).getNome(), dip.get(i).getCurso().getNome()});
        }
        
        tbl_dip.setModel(modelo);
        tbl_dip.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_dip.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_dip.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        loadCBTurma1();
    }
    
    public void carregaTurma () {
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código","Nome","Disciplina","Professor","Aluno"},0);
        
        for (int i=0; i<turma.size(); i++) {
            modelo.addRow(new Object[]{turma.get(i).getCodigo(), turma.get(i).getNome(), turma.get(i).getDip().getNome(), 
                                        turma.get(i).getProf().getNome(), turma.get(i).getAluno().getNome()});
        }
        
        tbl_turma.setModel(modelo);
        tbl_turma.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_turma.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_turma.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_turma.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl_turma.getColumnModel().getColumn(4).setPreferredWidth(100);
             
    }
    
    //Métodos pra manipular as caixas de combinações
    public void loadCBAdm() {
        a_combo.removeAllItems();
        a_combo.addItem("Selecione");
        for (int i = 0; i<lista.size(); i++) {
            a_combo.addItem(lista.get(i).getNome());
        }
    }
    
    public void loadCBProf() {
        p_combo.removeAllItems();
        p_combo.addItem("Selecione");
        for (int i = 0; i<escola.size(); i++) {
            p_combo.addItem(escola.get(i).getNome());
        }
    }
    
    public void loadCBCurso() {
        c_combo.removeAllItems();
        c_combo.addItem("Selecione");
        for (int i = 0; i<escola.size(); i++) {
            c_combo.addItem(escola.get(i).getNome());
        }
    }
    
    public void loadCBAluno() {
        al_combo.removeAllItems();
        al_combo.addItem("Selecione");
        for (int i = 0; i<curso.size(); i++) {
            al_combo.addItem(curso.get(i).getNome());
        }
    }
    
    public void loadCBDip() {
        d_combo.removeAllItems();
        d_combo.addItem("Selecione");
        for (int i = 0; i<curso.size(); i++) {
            d_combo.addItem(curso.get(i).getNome());
        }
    }
    
    public void loadCBTurma1() {
        t1_combo.removeAllItems();
        t1_combo.addItem("Selecione");
        for (int i = 0; i<dip.size(); i++) {
            t1_combo.addItem(dip.get(i).getNome());
        }
    }
    
    public void loadCBTurma2() {
        t2_combo.removeAllItems();
        t2_combo.addItem("Selecione");
        for (int i = 0; i<prof.size(); i++) {
            t2_combo.addItem(prof.get(i).getNome());
        }
    }
    
    public void loadCBTurma3() {
        t3_combo.removeAllItems();
        t3_combo.addItem("Selecione");
        for (int i = 0; i<aluno.size(); i++) {
            t3_combo.addItem(aluno.get(i).getNome());
        }
    }
    
    public void iniciar() {
        manipulaInterface1();
        manipulaInterface2();
        manipulaInterface3();
        manipulaInterface4();
        manipulaInterface5();
        manipulaInterface6();
        manipulaInterface7();
        manipulaInterface8();
    }
    
    public ola() {
        
        initComponents();
        loadCBAdm();
        a_combo.addItem("Selecione");
        modo1 = "Iniciar";
        modo2 = "Iniciar";
        modo3 = "Iniciar";
        modo4 = "Iniciar";
        modo5 = "Iniciar";
        modo6 = "Iniciar";
        modo7 = "Iniciar";
        modo8 = "Iniciar";
        setLocationRelativeTo(null);
        iniciar();
    }
    
    //Métodos para manipular os elementos da interface gráfica
    public void manipulaInterface1() {
        switch(modo1) {
            case "Iniciar":
                
                adm_campo1.setEnabled(false);
                adm_campo2.setEnabled(false);
                adm_campo3.setEnabled(false);
                adm_campo4.setEnabled(false);
                adm_campo5.setEnabled(false);
                a_combo.setEnabled(false);
                b_salvar_adm.setEnabled(false);
                b_cancel_adm.setEnabled(false);
                b_editar_adm.setEnabled(false);
                b_excluir_adm.setEnabled(false);           
                break;
                
            case "Novo" :
                
                adm_campo1.setText("");
                adm_campo2.setText("");
                adm_campo3.setText("");
                adm_campo4.setText("");
                adm_campo5.setText("");
                adm_campo1.setEnabled(true);
                adm_campo2.setEnabled(true);
                adm_campo3.setEnabled(true);
                adm_campo4.setEnabled(true);
                adm_campo5.setEnabled(true);
                b_salvar_adm.setEnabled(true);
                b_cancel_adm.setEnabled(true);
                b_editar_adm.setEnabled(false);
                b_excluir_adm.setEnabled(false);
                b_novo_adm.setEnabled(true);
                a_combo.setEnabled(true);                
                break;
            
            case "Editar":
                               
                adm_campo1.setEnabled(true);
                adm_campo2.setEnabled(true);
                adm_campo3.setEnabled(true);
                adm_campo4.setEnabled(true);
                adm_campo5.setEnabled(true);
                b_salvar_adm.setEnabled(true);
                b_cancel_adm.setEnabled(true);
                b_editar_adm.setEnabled(false);
                b_excluir_adm.setEnabled(false);
                b_novo_adm.setEnabled(false);
                a_combo.setEnabled(true);                
                break;
                
            case "Seleção":
                
                adm_campo1.setEnabled(false);
                adm_campo2.setEnabled(false);
                adm_campo3.setEnabled(false);
                adm_campo4.setEnabled(false);
                adm_campo5.setEnabled(false);
                b_salvar_adm.setEnabled(false);
                b_cancel_adm.setEnabled(false);
                b_editar_adm.setEnabled(true);
                b_excluir_adm.setEnabled(true);
                b_novo_adm.setEnabled(true);                              
                break;
                
            case "Salvar":
                
                adm_campo1.setText("");
                adm_campo2.setText("");
                adm_campo3.setText("");
                adm_campo4.setText("");
                adm_campo5.setText("");
                adm_campo1.setEnabled(false);
                adm_campo2.setEnabled(false);
                adm_campo3.setEnabled(false);
                adm_campo4.setEnabled(false);
                adm_campo5.setEnabled(false);
                b_salvar_adm.setEnabled(false);
                b_cancel_adm.setEnabled(false);
                b_editar_adm.setEnabled(false);
                b_excluir_adm.setEnabled(false);
                b_novo_adm.setEnabled(true);
                a_combo.setEnabled(false);                
                break;
                
            case "Cancelar" :
                
                adm_campo1.setText("");
                adm_campo2.setText("");
                adm_campo3.setText("");
                adm_campo4.setText("");
                adm_campo5.setText("");
                adm_campo1.setEnabled(false);
                adm_campo2.setEnabled(false);
                adm_campo3.setEnabled(false);
                adm_campo4.setEnabled(false);
                adm_campo5.setEnabled(false);
                b_salvar_adm.setEnabled(false);
                b_cancel_adm.setEnabled(false);
                b_editar_adm.setEnabled(false);
                b_excluir_adm.setEnabled(false);
                b_novo_adm.setEnabled(true);
                a_combo.setEnabled(false);             
                break;
                       
        }
    }
    
    public void manipulaInterface2() {
        switch(modo2) {
            case "Iniciar":
                
                prof_campo1.setEnabled(false);
                prof_campo2.setEnabled(false);
                prof_campo3.setEnabled(false);
                prof_campo4.setEnabled(false);
                prof_campo5.setEnabled(false);
                p_combo.setEnabled(false);
                b_salvar_prof.setEnabled(false);
                b_cancel_prof.setEnabled(false);
                b_editar_prof.setEnabled(false);
                b_excluir_prof.setEnabled(false);                             
                p_combo.removeAllItems();
                break;
                
            case "Novo" :
                
                prof_campo1.setText("");
                prof_campo2.setText("");
                prof_campo3.setText("");
                prof_campo4.setText("");
                prof_campo5.setText("");
                prof_campo1.setEnabled(true);
                prof_campo2.setEnabled(true);
                prof_campo3.setEnabled(true);
                prof_campo4.setEnabled(true);
                prof_campo5.setEnabled(true);
                b_salvar_prof.setEnabled(true);
                b_cancel_prof.setEnabled(true);
                b_editar_prof.setEnabled(false);
                b_excluir_prof.setEnabled(false);
                b_novo_prof.setEnabled(true);
                p_combo.setEnabled(true);              
                break;
            
            case "Editar":
                               
                prof_campo1.setEnabled(true);
                prof_campo2.setEnabled(true);
                prof_campo3.setEnabled(true);
                prof_campo4.setEnabled(true);
                prof_campo5.setEnabled(true);
                b_salvar_prof.setEnabled(true);
                b_cancel_prof.setEnabled(true);
                b_editar_prof.setEnabled(false);
                b_excluir_prof.setEnabled(false);
                b_novo_prof.setEnabled(false);
                p_combo.setEnabled(true);                 
                break;
                
            case "Seleção":
                
                prof_campo1.setEnabled(false);
                prof_campo2.setEnabled(false);
                prof_campo3.setEnabled(false);
                prof_campo4.setEnabled(false);
                prof_campo5.setEnabled(false);
                b_salvar_prof.setEnabled(false);
                b_cancel_prof.setEnabled(false);
                b_editar_prof.setEnabled(true);
                b_excluir_prof.setEnabled(true);
                b_novo_prof.setEnabled(true);                             
                break;
                
            case "Salvar":
                
                prof_campo1.setText("");
                prof_campo2.setText("");
                prof_campo3.setText("");
                prof_campo4.setText("");
                prof_campo5.setText("");
                prof_campo1.setEnabled(false);
                prof_campo2.setEnabled(false);
                prof_campo3.setEnabled(false);
                prof_campo4.setEnabled(false);
                prof_campo5.setEnabled(false);
                b_salvar_prof.setEnabled(false);
                b_cancel_prof.setEnabled(false);
                b_editar_prof.setEnabled(false);
                b_excluir_prof.setEnabled(false);
                b_novo_prof.setEnabled(true);
                p_combo.setEnabled(false);               
                break;
                
            case "Cancelar" :
                
                prof_campo1.setText("");
                prof_campo2.setText("");
                prof_campo3.setText("");
                prof_campo4.setText("");
                prof_campo5.setText("");
                prof_campo1.setEnabled(false);
                prof_campo2.setEnabled(false);
                prof_campo3.setEnabled(false);
                prof_campo4.setEnabled(false);
                prof_campo5.setEnabled(false);
                b_salvar_prof.setEnabled(false);
                b_cancel_prof.setEnabled(false);
                b_editar_prof.setEnabled(false);
                b_excluir_prof.setEnabled(false);
                b_novo_prof.setEnabled(true);
                p_combo.setEnabled(false);             
                break;
                              
        }
    }
    
    public void manipulaInterface3(){
        
        switch(modo3) {
        
                case "Iniciar":
                
                escola_campo1.setEnabled(false);
                escola_campo2.setEnabled(false);
                b_salvar_escola.setEnabled(false);
                b_cancelar_escola.setEnabled(false);
                b_editar_escola.setEnabled(false);                
                b_novo_escola.setEnabled(true);               
                p_combo.removeAllItems();
                break;
                
            case "Novo" :
                
                escola_campo1.setText("");
                escola_campo2.setText("");
                escola_campo1.setEnabled(true);
                escola_campo2.setEnabled(true);
                b_salvar_escola.setEnabled(true);
                b_cancelar_escola.setEnabled(true);
                b_editar_escola.setEnabled(false);               
                b_novo_escola.setEnabled(true);
                break;
            
            case "Editar":
                
                escola_campo1.setEnabled(true);
                escola_campo2.setEnabled(true);
                b_salvar_escola.setEnabled(true);
                b_cancelar_escola.setEnabled(true);
                b_editar_escola.setEnabled(false);               
                b_novo_escola.setEnabled(false);               
                break;
                
                
            case "Salvar":
                
                escola_campo1.setText("");
                escola_campo2.setText("");
                escola_campo1.setEnabled(false);
                escola_campo2.setEnabled(false);
                b_salvar_escola.setEnabled(false);
                b_cancelar_escola.setEnabled(false);
                b_editar_escola.setEnabled(false);               
                b_novo_escola.setEnabled(true);             
                break;
                
            case "Cancelar" :
                
                escola_campo1.setText("");
                escola_campo2.setText("");
                escola_campo1.setEnabled(false);
                escola_campo2.setEnabled(false);
                b_salvar_escola.setEnabled(false);
                b_cancelar_escola.setEnabled(false);
                b_editar_escola.setEnabled(false);               
                b_novo_escola.setEnabled(true);               
                break;
                
                case "Seleção":
                
                escola_campo1.setEnabled(false);
                escola_campo2.setEnabled(false);
                b_salvar_escola.setEnabled(false);
                b_cancelar_escola.setEnabled(false);
                b_editar_escola.setEnabled(true);               
                b_novo_escola.setEnabled(true);
                break;
        
        }
    
    
    }
    
    public void manipulaInterface5() {
        switch(modo5) {
            case "Iniciar":
                
                al_campo1.setEnabled(false);
                al_campo2.setEnabled(false);
                al_campo3.setEnabled(false);
                al_campo4.setEnabled(false);
                al_combo.setEnabled(false);
                b_salvar_aluno.setEnabled(false);
                b_cancelar_aluno.setEnabled(false);
                b_editar_aluno.setEnabled(false);
                b_excluir_aluno.setEnabled(false);
                al_combo.removeAllItems();               
                break;
                
            case "Novo" :
                
                al_campo1.setText("");
                al_campo2.setText("");
                al_campo3.setText("");
                al_campo4.setText("");
                al_campo1.setEnabled(true);
                al_campo2.setEnabled(true);
                al_campo3.setEnabled(true);
                al_campo4.setEnabled(true);
                b_salvar_aluno.setEnabled(true);
                b_cancelar_aluno.setEnabled(true);
                b_editar_aluno.setEnabled(false);
                b_excluir_aluno.setEnabled(false);
                b_novo_aluno.setEnabled(true);
                al_combo.setEnabled(true);             
                break;
            
            case "Editar":
                               
                al_campo1.setEnabled(true);
                al_campo2.setEnabled(true);
                al_campo3.setEnabled(true);
                al_campo4.setEnabled(true);
                b_salvar_aluno.setEnabled(true);
                b_cancelar_aluno.setEnabled(true);
                b_editar_aluno.setEnabled(false);
                b_excluir_aluno.setEnabled(false);
                b_novo_aluno.setEnabled(false);
                al_combo.setEnabled(true);                
                break;
                
            case "Seleção":
                
                al_campo1.setEnabled(false);
                al_campo2.setEnabled(false);
                al_campo3.setEnabled(false);
                al_campo4.setEnabled(false);                
                b_salvar_aluno.setEnabled(false);
                b_cancelar_aluno.setEnabled(false);
                b_editar_aluno.setEnabled(true);
                b_excluir_aluno.setEnabled(true);
                b_novo_aluno.setEnabled(true);
                al_combo.setEnabled(false);              
                break;
                
            case "Salvar":
                
                al_campo1.setText("");
                al_campo2.setText("");
                al_campo3.setText("");
                al_campo4.setText("");                
                al_campo1.setEnabled(false);
                al_campo2.setEnabled(false);
                al_campo3.setEnabled(false);
                al_campo4.setEnabled(false);
                b_salvar_aluno.setEnabled(false);
                b_cancelar_aluno.setEnabled(false);
                b_editar_aluno.setEnabled(false);
                b_excluir_aluno.setEnabled(false);
                b_novo_aluno.setEnabled(true);
                al_combo.setEnabled(false);               
                break;
                
            case "Cancelar" :
                
                al_campo1.setText("");
                al_campo2.setText("");
                al_campo3.setText("");
                al_campo4.setText("");                
                al_campo1.setEnabled(false);
                al_campo2.setEnabled(false);
                al_campo3.setEnabled(false);
                al_campo4.setEnabled(false);
                b_salvar_aluno.setEnabled(false);
                b_cancelar_aluno.setEnabled(false);
                b_editar_aluno.setEnabled(false);
                b_excluir_aluno.setEnabled(false);
                b_novo_aluno.setEnabled(true);
                al_combo.setEnabled(false);             
                break;
                
                
        }
    }
     
    public void manipulaInterface6(){
        
        switch(modo6) {
        
                case "Iniciar":
                
                campo1.setEnabled(false);
                campo2.setEnabled(false);
                salvar.setEnabled(false);
                cancelar.setEnabled(false);
                editar.setEnabled(false);                
                novo.setEnabled(true);               
                a_combo.removeAllItems();
                break;
                
            case "Novo" :
                
                campo1.setText("");
                campo2.setText("");
                campo1.setEnabled(true);
                campo2.setEnabled(true);
                salvar.setEnabled(true);
                cancelar.setEnabled(true);
                editar.setEnabled(false);               
                novo.setEnabled(true);
                break;
            
            case "Editar":
                
                campo1.setEnabled(true);
                campo2.setEnabled(true);
                salvar.setEnabled(true);
                cancelar.setEnabled(true);
                editar.setEnabled(false);               
                novo.setEnabled(false);               
                break;
                
                
            case "Salvar":
                
                campo1.setText("");
                campo2.setText("");
                campo1.setEnabled(false);
                campo2.setEnabled(false);
                salvar.setEnabled(false);
                cancelar.setEnabled(false);
                editar.setEnabled(false);               
                novo.setEnabled(true);               
                break;
                
            case "Cancelar" :
                
                campo1.setText("");
                campo2.setText("");
                campo1.setEnabled(false);
                campo2.setEnabled(false);
                salvar.setEnabled(false);
                cancelar.setEnabled(false);
                editar.setEnabled(false);              
                novo.setEnabled(true);                
                break;
                
                case "Seleção":
                
                campo1.setEnabled(false);
                campo2.setEnabled(false);
                salvar.setEnabled(false);
                cancelar.setEnabled(false);
                editar.setEnabled(true);               
                novo.setEnabled(true);
                break;
        
        }
    
    
    }
    
    public void manipulaInterface4(){
        
        switch(modo4) {
        
                case "Iniciar":
                
                curso_campo1.setEnabled(false);
                curso_campo2.setEnabled(false);
                b_salvar_curso.setEnabled(false);
                b_cancelar_curso.setEnabled(false);
                b_editar_curso.setEnabled(false);                
                b_novo_curso.setEnabled(true);
                c_combo.setEnabled(false);              
                c_combo.removeAllItems();
                break;
                
            case "Novo" :
                
                curso_campo1.setText("");
                curso_campo2.setText("");
                curso_campo1.setEnabled(true);
                curso_campo2.setEnabled(true);
                b_salvar_curso.setEnabled(true);
                b_cancelar_curso.setEnabled(true);
                b_editar_curso.setEnabled(false);               
                b_novo_curso.setEnabled(true);
                c_combo.setEnabled(true);
                break;
            
            case "Editar":
                
                curso_campo1.setEnabled(true);
                curso_campo2.setEnabled(true);
                b_salvar_curso.setEnabled(true);
                b_cancelar_curso.setEnabled(true);
                b_editar_curso.setEnabled(false);               
                b_novo_curso.setEnabled(false);
                c_combo.setEnabled(true);               
                break;
                
                
            case "Salvar":
                
                curso_campo1.setText("");
                curso_campo2.setText("");
                curso_campo1.setEnabled(false);
                curso_campo2.setEnabled(false);
                b_salvar_curso.setEnabled(false);
                b_cancelar_curso.setEnabled(false);
                b_editar_curso.setEnabled(false);               
                b_novo_curso.setEnabled(true);
                c_combo.setEnabled(false);
                break;
                
            case "Cancelar" :
                
                curso_campo1.setText("");
                curso_campo2.setText("");
                curso_campo1.setEnabled(false);
                curso_campo2.setEnabled(false);
                b_salvar_curso.setEnabled(false);
                b_cancelar_curso.setEnabled(false);
                b_editar_curso.setEnabled(false);               
                b_novo_curso.setEnabled(true);
                c_combo.setEnabled(false);              
                break;
                
                case "Seleção":
                
                curso_campo1.setEnabled(false);
                curso_campo2.setEnabled(false);
                b_salvar_curso.setEnabled(false);
                b_cancelar_curso.setEnabled(false);
                b_editar_curso.setEnabled(true);               
                b_novo_curso.setEnabled(true);
                c_combo.setEnabled(false);
                break;
        
        } 
    }
    
    public void manipulaInterface7(){
        
        switch(modo7) {
        
                case "Iniciar":
                
                dip_campo1.setEnabled(false);
                dip_campo2.setEnabled(false);
                b_salvar_dip.setEnabled(false);
                b_cancelar_dip.setEnabled(false);
                b_editar_dip.setEnabled(false);                
                b_novo_dip.setEnabled(true);
                d_combo.setEnabled(false);             
                d_combo.removeAllItems();
                break;
                
            case "Novo" :
                
                dip_campo1.setText("");
                dip_campo2.setText("");
                dip_campo1.setEnabled(true);
                dip_campo2.setEnabled(true);
                b_salvar_dip.setEnabled(true);
                b_cancelar_dip.setEnabled(true);
                b_editar_dip.setEnabled(false);               
                b_novo_dip.setEnabled(true);
                d_combo.setEnabled(true);
                break;
            
            case "Editar":
                
                dip_campo1.setEnabled(true);
                dip_campo2.setEnabled(true);
                b_salvar_dip.setEnabled(true);
                b_cancelar_dip.setEnabled(true);
                b_editar_dip.setEnabled(false);               
                b_novo_dip.setEnabled(false);
                d_combo.setEnabled(true);               
                break;
                
                
            case "Salvar":
                
                dip_campo1.setText("");
                dip_campo2.setText("");
                dip_campo1.setEnabled(false);
                dip_campo2.setEnabled(false);
                b_salvar_dip.setEnabled(false);
                b_cancelar_dip.setEnabled(false);
                b_editar_dip.setEnabled(false);               
                b_novo_dip.setEnabled(true);
                d_combo.setEnabled(false);              
                break;
                
            case "Cancelar" :
                
                dip_campo1.setText("");
                dip_campo2.setText("");
                dip_campo1.setEnabled(false);
                dip_campo2.setEnabled(false);
                b_salvar_dip.setEnabled(false);
                b_cancelar_dip.setEnabled(false);
                b_editar_dip.setEnabled(false);               
                b_novo_dip.setEnabled(true);
                d_combo.setEnabled(false);                
                break;
                
            case "Seleção":
                
                dip_campo1.setEnabled(false);
                dip_campo2.setEnabled(false);
                b_salvar_dip.setEnabled(false);
                b_cancelar_dip.setEnabled(false);
                b_editar_dip.setEnabled(true);               
                b_novo_dip.setEnabled(true);
                d_combo.setEnabled(false);
                break;
        
        } 
    }
    
    public void manipulaInterface8(){
        
        switch(modo8) {
        
                case "Iniciar":
                
                tur_campo1.setEnabled(false);
                tur_campo2.setEnabled(false);
                b_salvar_tur.setEnabled(false);
                b_cancelar_tur.setEnabled(false);
                b_editar_tur.setEnabled(false);                
                b_novo_tur.setEnabled(true);
                t1_combo.setEnabled(false);
                t2_combo.setEnabled(false);
                t3_combo.setEnabled(false);                
                t1_combo.removeAllItems();
                t2_combo.removeAllItems();
                t3_combo.removeAllItems();
                break;
                
            case "Novo" :
                
                tur_campo1.setText("");
                tur_campo2.setText("");
                tur_campo1.setEnabled(true);
                tur_campo2.setEnabled(true);
                b_salvar_tur.setEnabled(true);
                b_cancelar_tur.setEnabled(true);
                b_editar_tur.setEnabled(false);               
                b_novo_tur.setEnabled(true);
                t1_combo.setEnabled(true);
                t2_combo.setEnabled(true);
                t3_combo.setEnabled(true);
                break;
            
            case "Editar":
                
                tur_campo1.setEnabled(true);
                tur_campo2.setEnabled(true);
                b_salvar_tur.setEnabled(true);
                b_cancelar_tur.setEnabled(true);
                b_editar_tur.setEnabled(false);               
                b_novo_tur.setEnabled(false);
                t1_combo.setEnabled(true);
                t2_combo.setEnabled(true);
                t3_combo.setEnabled(true);              
                break;
                
                
            case "Salvar":
                
                tur_campo1.setText("");
                tur_campo2.setText("");
                tur_campo1.setEnabled(false);
                tur_campo2.setEnabled(false);
                b_salvar_tur.setEnabled(false);
                b_cancelar_tur.setEnabled(false);
                b_editar_tur.setEnabled(false);               
                b_novo_tur.setEnabled(true);
                t1_combo.setEnabled(false);
                t2_combo.setEnabled(false);
                t3_combo.setEnabled(false);             
                break;
                
            case "Cancelar" :
                
                tur_campo1.setText("");
                tur_campo2.setText("");
                tur_campo1.setEnabled(false);
                tur_campo2.setEnabled(false);
                b_salvar_tur.setEnabled(false);
                b_cancelar_tur.setEnabled(false);
                b_editar_tur.setEnabled(false);               
                b_novo_tur.setEnabled(true);
                t1_combo.setEnabled(false);
                t2_combo.setEnabled(false);
                t3_combo.setEnabled(false);              
                break;
                
                case "Seleção":
                
                tur_campo1.setEnabled(false);
                tur_campo2.setEnabled(false);
                b_salvar_tur.setEnabled(false);
                b_cancelar_tur.setEnabled(false);
                b_editar_tur.setEnabled(true);               
                b_novo_tur.setEnabled(true);
                t1_combo.setEnabled(false);
                t2_combo.setEnabled(false);
                t3_combo.setEnabled(false);
                break;
        
        } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_adm = new javax.swing.JTable();
        b_novo_adm = new javax.swing.JButton();
        b_editar_adm = new javax.swing.JButton();
        b_excluir_adm = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        adm_campo1 = new javax.swing.JTextField();
        adm_campo2 = new javax.swing.JTextField();
        adm_campo3 = new javax.swing.JTextField();
        adm_campo4 = new javax.swing.JTextField();
        adm_campo5 = new javax.swing.JTextField();
        a_combo = new javax.swing.JComboBox<>();
        b_salvar_adm = new javax.swing.JButton();
        b_cancel_adm = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_prof = new javax.swing.JTable();
        b_novo_prof = new javax.swing.JButton();
        b_editar_prof = new javax.swing.JButton();
        b_excluir_prof = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        prof_campo1 = new javax.swing.JTextField();
        prof_campo2 = new javax.swing.JTextField();
        prof_campo3 = new javax.swing.JTextField();
        prof_campo4 = new javax.swing.JTextField();
        prof_campo5 = new javax.swing.JTextField();
        p_combo = new javax.swing.JComboBox<>();
        b_salvar_prof = new javax.swing.JButton();
        b_cancel_prof = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        escola_campo1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        escola_campo2 = new javax.swing.JTextField();
        b_salvar_escola = new javax.swing.JButton();
        b_cancelar_escola = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_prof_p = new javax.swing.JTable();
        b_ok_escola = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_escolas = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        b_novo_escola = new javax.swing.JButton();
        b_editar_escola = new javax.swing.JButton();
        b_exibir_escola = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_setor = new javax.swing.JTable();
        novo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        campo1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campo2 = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_alunos = new javax.swing.JTable();
        b_novo_aluno = new javax.swing.JButton();
        b_editar_aluno = new javax.swing.JButton();
        b_excluir_aluno = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        al_campo1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        al_campo2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        al_campo3 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        al_campo4 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        al_combo = new javax.swing.JComboBox<>();
        b_salvar_aluno = new javax.swing.JButton();
        b_cancelar_aluno = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_curso = new javax.swing.JTable();
        b_novo_curso = new javax.swing.JButton();
        b_editar_curso = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        curso_campo1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        curso_campo2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        c_combo = new javax.swing.JComboBox<>();
        b_salvar_curso = new javax.swing.JButton();
        b_cancelar_curso = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbl_turma = new javax.swing.JTable();
        b_novo_tur = new javax.swing.JButton();
        b_editar_tur = new javax.swing.JButton();
        b_excluir_tur = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        tur_campo1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tur_campo2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        t1_combo = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        t2_combo = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        t3_combo = new javax.swing.JComboBox<>();
        b_salvar_tur = new javax.swing.JButton();
        b_cancelar_tur = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_dip = new javax.swing.JTable();
        b_novo_dip = new javax.swing.JButton();
        b_editar_dip = new javax.swing.JButton();
        b_excluir_dip = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        dip_campo1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        dip_campo2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        d_combo = new javax.swing.JComboBox<>();
        b_salvar_dip = new javax.swing.JButton();
        b_cancelar_dip = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lista de Funcionários");

        tbl_adm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço", "Telefone", "Data de Admissão", "Salário", "Setor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_admMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_adm);

        b_novo_adm.setText("Novo");
        b_novo_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_admActionPerformed(evt);
            }
        });

        b_editar_adm.setText("Editar");
        b_editar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_admActionPerformed(evt);
            }
        });

        b_excluir_adm.setText("Excluir");
        b_excluir_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluir_admActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel2.setText("Nome");

        jLabel3.setText("Endereço");

        jLabel4.setText("Telefone");

        jLabel5.setText("Data de Admissão");

        jLabel6.setText("Salário");

        jLabel7.setText("Setor");

        a_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_salvar_adm.setText("Salvar");
        b_salvar_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_admActionPerformed(evt);
            }
        });

        b_cancel_adm.setText("Cancelar");
        b_cancel_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancel_admActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(adm_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(168, 168, 168)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_cancel_adm, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_salvar_adm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adm_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(adm_campo3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(adm_campo4))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(adm_campo5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(a_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(adm_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_salvar_adm))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_cancel_adm)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(adm_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(adm_campo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(adm_campo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(adm_campo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(a_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(b_novo_adm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editar_adm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_excluir_adm)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_adm)
                    .addComponent(b_editar_adm)
                    .addComponent(b_excluir_adm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Administrativo", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Lista de Professores");

        tbl_prof.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço", "Telefone", "Data de Admissão", "Salário", "Escola"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_prof.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_profMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_prof);

        b_novo_prof.setText("Novo");
        b_novo_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_profActionPerformed(evt);
            }
        });

        b_editar_prof.setText("Editar");
        b_editar_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_profActionPerformed(evt);
            }
        });

        b_excluir_prof.setText("Excluir");
        b_excluir_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluir_profActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel12.setText("Nome");

        jLabel13.setText("Endereço");

        jLabel14.setText("Telefone");

        jLabel15.setText("Data de Admissão");

        jLabel16.setText("Salário");

        jLabel17.setText("Escola");

        p_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_salvar_prof.setText("Salvar");
        b_salvar_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_profActionPerformed(evt);
            }
        });

        b_cancel_prof.setText("Cancelar");
        b_cancel_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancel_profActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(prof_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(prof_campo2))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(prof_campo3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(prof_campo4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(prof_campo5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(p_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_cancel_prof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_salvar_prof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(prof_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_salvar_prof))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(prof_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancel_prof))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(prof_campo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(prof_campo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(prof_campo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(p_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(b_novo_prof)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editar_prof)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_excluir_prof)
                        .addContainerGap(468, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_prof)
                    .addComponent(b_editar_prof)
                    .addComponent(b_excluir_prof))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Professores", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel19.setText("Código");

        jLabel20.setText("Nome");

        b_salvar_escola.setText("Salvar");
        b_salvar_escola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_escolaActionPerformed(evt);
            }
        });

        b_cancelar_escola.setText("Cancelar");
        b_cancelar_escola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelar_escolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(escola_campo2))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(escola_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(b_salvar_escola, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_cancelar_escola)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(escola_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(escola_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_salvar_escola)
                    .addComponent(b_cancelar_escola))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista de Professores"));

        tbl_prof_p.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Professores"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_prof_p);

        b_ok_escola.setText("OK");
        b_ok_escola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ok_escolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(b_ok_escola, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(b_ok_escola)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        tbl_escolas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_escolas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_escolasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_escolas);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Lista de Escolas");

        b_novo_escola.setText("Novo");
        b_novo_escola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_escolaActionPerformed(evt);
            }
        });

        b_editar_escola.setText("Editar");
        b_editar_escola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_escolaActionPerformed(evt);
            }
        });

        b_exibir_escola.setText("Exibir Lista");
        b_exibir_escola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exibir_escolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addGap(124, 124, 124))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(b_novo_escola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b_editar_escola))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_exibir_escola))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_escola)
                    .addComponent(b_editar_escola)
                    .addComponent(b_exibir_escola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Escolas", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Lista de Setores");

        tabela_setor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Setor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_setor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_setorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_setor);
        if (tabela_setor.getColumnModel().getColumnCount() > 0) {
            tabela_setor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_setor.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        novo.setText("Novo");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel9.setText("Código");

        jLabel10.setText("Setor");

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(campo1))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(cancelar))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(novo)
                        .addGap(18, 18, 18)
                        .addComponent(editar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novo)
                    .addComponent(editar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Setores", jPanel4);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Lista de Alunos");

        tbl_alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Endereço", "Telefone", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_alunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_alunosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_alunos);

        b_novo_aluno.setText("Novo");
        b_novo_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_alunoActionPerformed(evt);
            }
        });

        b_editar_aluno.setText("Editar");
        b_editar_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_alunoActionPerformed(evt);
            }
        });

        b_excluir_aluno.setText("Excluir");
        b_excluir_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluir_alunoActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel26.setText("Matrícula");

        jLabel27.setText("Nome");

        jLabel28.setText("Endereço");

        jLabel29.setText("Telefone");

        jLabel30.setText("Curso");

        al_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_salvar_aluno.setText("Salvar");
        b_salvar_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_alunoActionPerformed(evt);
            }
        });

        b_cancelar_aluno.setText("Cancelar");
        b_cancelar_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelar_alunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(al_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(al_campo2))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(al_campo3))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(al_campo4))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(al_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_cancelar_aluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_salvar_aluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(al_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_salvar_aluno))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(al_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancelar_aluno))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(al_campo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(al_campo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(al_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(b_novo_aluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editar_aluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_excluir_aluno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 283, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_aluno)
                    .addComponent(b_editar_aluno)
                    .addComponent(b_excluir_aluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Alunos", jPanel10);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Lista de Cursos");

        tbl_curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Escola"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_curso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cursoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_curso);

        b_novo_curso.setText("Novo");
        b_novo_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_cursoActionPerformed(evt);
            }
        });

        b_editar_curso.setText("Editar");
        b_editar_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_cursoActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel23.setText("Código");

        jLabel24.setText("Nome");

        jLabel25.setText("Escola");

        c_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_salvar_curso.setText("Salvar");
        b_salvar_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_cursoActionPerformed(evt);
            }
        });

        b_cancelar_curso.setText("Cancelar");
        b_cancelar_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelar_cursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(c_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(b_cancelar_curso))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(18, 18, 18)
                                        .addComponent(curso_campo2))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(curso_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(b_salvar_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(curso_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_salvar_curso))
                .addGap(18, 18, 18)
                .addComponent(b_cancelar_curso)
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(curso_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(c_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(b_novo_curso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editar_curso)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_curso)
                    .addComponent(b_editar_curso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cursos", jPanel11);

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Lista de Turmas");

        tbl_turma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Disciplina", "Professor", "Aluno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_turma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_turmaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbl_turma);

        b_novo_tur.setText("Novo");
        b_novo_tur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_turActionPerformed(evt);
            }
        });

        b_editar_tur.setText("Editar");
        b_editar_tur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_turActionPerformed(evt);
            }
        });

        b_excluir_tur.setText("Excluir");
        b_excluir_tur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluir_turActionPerformed(evt);
            }
        });

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel36.setText("Código");

        jLabel37.setText("Nome");

        jLabel38.setText("Disciplina");

        t1_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel39.setText("Professor");

        t2_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel40.setText("Aluno");

        t3_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_salvar_tur.setText("Salvar");
        b_salvar_tur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_turActionPerformed(evt);
            }
        });

        b_cancelar_tur.setText("Cancelar");
        b_cancelar_tur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelar_turActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(tur_campo2))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(tur_campo1))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(t3_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addGap(18, 18, 18)
                            .addComponent(t2_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel38)
                            .addGap(18, 18, 18)
                            .addComponent(t1_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_salvar_tur, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancelar_tur))
                .addGap(36, 36, 36))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(tur_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_salvar_tur))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(tur_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancelar_tur))
                .addGap(16, 16, 16)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(t1_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(t2_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(t3_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jButton2.setText("Exibir Lista");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(b_novo_tur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editar_tur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_excluir_tur)
                        .addGap(115, 115, 115)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_tur)
                    .addComponent(b_editar_tur)
                    .addComponent(b_excluir_tur)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Turmas", jPanel14);

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Lista de Disciplinas ");

        tbl_dip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dipMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbl_dip);

        b_novo_dip.setText("Novo");
        b_novo_dip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo_dipActionPerformed(evt);
            }
        });

        b_editar_dip.setText("Editar");
        b_editar_dip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar_dipActionPerformed(evt);
            }
        });

        b_excluir_dip.setText("Excluir");
        b_excluir_dip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluir_dipActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));

        jLabel32.setText("Código");

        jLabel33.setText("Nome");

        jLabel34.setText("Curso");

        d_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_salvar_dip.setText("Salvar");
        b_salvar_dip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salvar_dipActionPerformed(evt);
            }
        });

        b_cancelar_dip.setText("Cancelar");
        b_cancelar_dip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelar_dipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(dip_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(dip_campo2))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(d_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b_salvar_dip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_cancelar_dip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(dip_campo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_salvar_dip))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(b_cancelar_dip))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(dip_campo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(d_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(b_novo_dip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editar_dip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_excluir_dip)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_novo_dip)
                    .addComponent(b_editar_dip)
                    .addComponent(b_excluir_dip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Disciplinas", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Tratar os eventos dos botões e da tabela quando clicados
    private void b_novo_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_admActionPerformed
        
        
        modo1 = "Novo";
        manipulaInterface1();
        a_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_novo_admActionPerformed

    private void b_editar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_admActionPerformed

        modo1 = "Editar";
        manipulaInterface1();
        System.out.println(modo1);
    }//GEN-LAST:event_b_editar_admActionPerformed

    private void b_excluir_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluir_admActionPerformed
        int index = tbl_adm.getSelectedRow();
        if (index >= 0 && index<adm.size()) {
            adm.remove(index);
        }
        carregaAdm();
        adm_campo1.setText("");
        adm_campo2.setText("");
        adm_campo3.setText("");
        adm_campo4.setText("");
        adm_campo5.setText("");
        modo1 = "Iniciar";
        manipulaInterface1();
    }//GEN-LAST:event_b_excluir_admActionPerformed

    private void b_salvar_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_admActionPerformed
        int tel = Integer.parseInt(adm_campo3.getText());
        int sal = Integer.parseInt(adm_campo5.getText());
        int index = a_combo.getSelectedIndex();
        
       if (index == 0) {
             JOptionPane.showMessageDialog(this, "Selecione um Setor");            
             loadCBAdm();
       } else if (index != 0) {
            if (modo1.equals("Novo")) {
                          
            Administrativo A = new Administrativo(adm_campo1.getText(), adm_campo2.getText(), tel, adm_campo4.getText(), sal);
            
            A.setSetor(lista.get(index-1));
        
            adm.add(A);
            carregaAdm();
            modo1 = "Salvar";
            manipulaInterface1();
            
           }
        
        
        }   
            if (modo1.equals("Editar")) {
                        
            int index3 = tbl_adm.getSelectedRow();
            adm.get(index3).setNome(adm_campo1.getText());
            adm.get(index3).setEndereco(adm_campo2.getText());
            adm.get(index3).setTelefone(tel);
            adm.get(index3).setData_adm(adm_campo4.getText());
            adm.get(index3).setSalario(sal);
            if (index == 0) {
            
             adm.get(index3).setSetor(lista.get(index));
            } else {               
                adm.get(index3).setSetor(lista.get(index-1));
                carregaAdm();        
                modo1 = "Salvar";
                manipulaInterface1();
                   
            }
            
        }
        a_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_salvar_admActionPerformed

    private void b_cancel_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancel_admActionPerformed
        
        modo1 = "Cancelar";
        manipulaInterface1();
        a_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_cancel_admActionPerformed

    private void tbl_admMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_admMouseClicked
        int index = tbl_adm.getSelectedRow();
        if (index >= 0 && index<adm.size()) {
            Administrativo A = adm.get(index);

            adm_campo1.setText(A.getNome());
            adm_campo2.setText(A.getEndereco());
            adm_campo3.setText(String.valueOf(A.getTelefone()));
            adm_campo4.setText(A.getData_adm());
            adm_campo5.setText(String.valueOf(A.getSalario()));
            a_combo.setSelectedItem(A.getSetor().getNome());
            modo1 = "Seleção";
            manipulaInterface1();
        }
    }//GEN-LAST:event_tbl_admMouseClicked

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        modo6 = "Novo";
        manipulaInterface6();
    }//GEN-LAST:event_novoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        modo6 = "Editar";
        manipulaInterface6();
    }//GEN-LAST:event_editarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed

        if (modo6.equals("Novo")) {
            int cod = Integer.parseInt(campo1.getText());
            Setores S = new Setores(cod, campo2.getText());
            lista.add(S);
           
            
            
        } else if (modo6.equals("Editar")) {
            int index = tabela_setor.getSelectedRow();
            lista.get(index).setCodigo(Integer.parseInt(campo1.getText()));
            lista.get(index).setNome(campo2.getText());
        }

        
        carregaSetor();
        modo6 = "Salvar";
        manipulaInterface6();
    }//GEN-LAST:event_salvarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        modo6 = "Cancelar";
        manipulaInterface6();
    }//GEN-LAST:event_cancelarActionPerformed

    private void tabela_setorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_setorMouseClicked
        int index = tabela_setor.getSelectedRow();
        if (index >= 0 && index<lista.size()) {
            Setores S = lista.get(index);

            campo1.setText(String.valueOf(S.getCodigo()));
            campo2.setText(S.getNome());
            
            modo6 = "Seleção";
            manipulaInterface6();
        }
    }//GEN-LAST:event_tabela_setorMouseClicked

    private void b_novo_escolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_escolaActionPerformed
        modo3 = "Novo";
        manipulaInterface3();
    }//GEN-LAST:event_b_novo_escolaActionPerformed

    private void b_editar_escolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_escolaActionPerformed
        modo3 = "Editar";
        manipulaInterface3();
    }//GEN-LAST:event_b_editar_escolaActionPerformed

    private void b_salvar_escolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_escolaActionPerformed
        if (modo3.equals("Novo")) {
            int cod = Integer.parseInt(escola_campo1.getText());
            Escolas E = new Escolas(cod, escola_campo2.getText());
            escola.add(E);
           
            
            
        } else if (modo3.equals("Editar")) {
            int index = tbl_escolas.getSelectedRow();
            escola.get(index).setCodigo(Integer.parseInt(escola_campo1.getText()));
            escola.get(index).setNome(escola_campo2.getText());
        }

        
        carregaEscola();
        modo3 = "Salvar";
        manipulaInterface3();
    }//GEN-LAST:event_b_salvar_escolaActionPerformed

    private void b_cancelar_escolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelar_escolaActionPerformed
        modo3 = "Cancelar";
        manipulaInterface3();
    }//GEN-LAST:event_b_cancelar_escolaActionPerformed

    private void tbl_escolasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_escolasMouseClicked
        int index = tbl_escolas.getSelectedRow();
        if (index >= 0 && index<escola.size()) {
            Escolas E = escola.get(index);

            escola_campo1.setText(String.valueOf(E.getCodigo()));
            escola_campo2.setText(E.getNome());
            
            modo3 = "Seleção";
            manipulaInterface3();
        }
    }//GEN-LAST:event_tbl_escolasMouseClicked

    private void b_novo_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_profActionPerformed
        modo2 = "Novo";
        manipulaInterface2();
        p_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_novo_profActionPerformed
        
    private void b_editar_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_profActionPerformed
        modo2 = "Editar";
        manipulaInterface2();
    }//GEN-LAST:event_b_editar_profActionPerformed

    private void b_excluir_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluir_profActionPerformed
        int index = tbl_prof.getSelectedRow();
        if (index >= 0 && index<prof.size()) {
            prof.get(index).getEscola().deleteProf(prof.get(index));
            prof.remove(index);
        }
        carregaProf();
        prof_campo1.setText("");
        prof_campo2.setText("");
        prof_campo3.setText("");
        prof_campo4.setText("");
        prof_campo5.setText("");
        modo2 = "Iniciar";
        manipulaInterface2();
    }//GEN-LAST:event_b_excluir_profActionPerformed

    private void b_salvar_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_profActionPerformed
        int tel = Integer.parseInt(prof_campo3.getText());
        int sal = Integer.parseInt(prof_campo5.getText());
        int index = p_combo.getSelectedIndex();
        
       if (index == 0) {
             JOptionPane.showMessageDialog(this, "Selecione uma Escola");            
             loadCBProf();
       } else if (index != 0) {
            if (modo2.equals("Novo")) {
                          
            Professores P = new Professores(prof_campo1.getText(), prof_campo2.getText(), tel, prof_campo4.getText(), sal);
            
            P.setEscola(escola.get(index-1));
            
            prof.add(P);
            escola.get(index-1).addProf(P);
            carregaProf();
            
            modo2 = "Salvar";
            manipulaInterface2();
            
           }
        
        
        }   
            if (modo2.equals("Editar")) {
                        
            int index3 = tbl_prof.getSelectedRow();
            prof.get(index3).setNome(prof_campo1.getText());
            prof.get(index3).setEndereco(prof_campo2.getText());
            prof.get(index3).setTelefone(tel);
            prof.get(index3).setData_adm(adm_campo4.getText());
            prof.get(index3).setSalario(sal);
            if (index == 0) {
            
             prof.get(index3).setEscola(escola.get(index));
            } else {
                prof.get(index3).getEscola().deleteProf(prof.get(index3));
                prof.get(index3).setEscola(escola.get(index-1));               
                escola.get(index-1).addProf(prof.get(index3));
                carregaProf();        
                modo2 = "Salvar";
                manipulaInterface2();
                   
            }
            
        }
        p_combo.setSelectedIndex(0);    
    }//GEN-LAST:event_b_salvar_profActionPerformed

    private void b_cancel_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancel_profActionPerformed
        modo2 = "Cancelar";
        manipulaInterface2();
        p_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_cancel_profActionPerformed

    private void tbl_profMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_profMouseClicked
        int index = tbl_prof.getSelectedRow();
        if (index >= 0 && index<prof.size()) {
            Professores P = prof.get(index);

            prof_campo1.setText(P.getNome());
            prof_campo2.setText(P.getEndereco());
            prof_campo3.setText(String.valueOf(P.getTelefone()));
            prof_campo4.setText(P.getData_adm());
            prof_campo5.setText(String.valueOf(P.getSalario()));
            p_combo.setSelectedItem(P.getEscola().getNome());
            modo2 = "Seleção";
            manipulaInterface2();
        }
    }//GEN-LAST:event_tbl_profMouseClicked

    private void b_exibir_escolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exibir_escolaActionPerformed
        int index = tbl_escolas.getSelectedRow();
        if (index >= 0 && index<escola.size()) {
            Escolas E = escola.get(index);
            
            DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Professores"},0);    
        
            for (int i=0; i<E.getProfs().size(); i++) {
            modelo.addRow(new Object[]{E.getProfs().get(i).getNome()});
        }
            
            
         tbl_prof_p.setModel(modelo);   
            
            
        }
        
        
    }//GEN-LAST:event_b_exibir_escolaActionPerformed

    private void b_ok_escolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ok_escolaActionPerformed
       DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Professores"},0);
       tbl_prof_p.setModel(modelo);
    }//GEN-LAST:event_b_ok_escolaActionPerformed

    private void b_novo_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_cursoActionPerformed
        modo4 = "Novo";
        manipulaInterface4();
    }//GEN-LAST:event_b_novo_cursoActionPerformed

    private void b_editar_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_cursoActionPerformed
        modo4 = "Editar";
        manipulaInterface4();
    }//GEN-LAST:event_b_editar_cursoActionPerformed

    private void b_salvar_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_cursoActionPerformed
        int index = c_combo.getSelectedIndex();
      
       if (index == 0) {
             JOptionPane.showMessageDialog(this, "Selecione uma Escola");            
             loadCBCurso(); 
       } else if (index != 0) {
            if (modo4.equals("Novo")) {
            int cod = Integer.parseInt(curso_campo1.getText());
            Cursos C = new Cursos(cod, curso_campo2.getText());
            C.setEscola(escola.get(index-1));
            curso.add(C);
            
            carregaCurso();            
            modo4 = "Salvar";
            manipulaInterface4();
        } 
            
        }  
        
        if (modo4.equals("Editar")) {
            int index2 = tbl_curso.getSelectedRow();
            curso.get(index2).setCodigo(Integer.parseInt(curso_campo1.getText()));
            curso.get(index2).setNome(curso_campo2.getText());
         if (index == 0) {
            
             curso.get(index2).setEscola(escola.get(index));
            } else {
                
                curso.get(index2).setEscola(escola.get(index-1));                               
                carregaCurso();        
                modo4 = "Salvar";
                manipulaInterface4();
                   
            }

        }
        c_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_salvar_cursoActionPerformed

    private void b_cancelar_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelar_cursoActionPerformed
        modo4 = "Cancelar";
        manipulaInterface4();
        c_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_cancelar_cursoActionPerformed

    private void tbl_cursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cursoMouseClicked
        int index = tbl_curso.getSelectedRow();
        if (index >= 0 && index<curso.size()) {
            Cursos C = curso.get(index);

            curso_campo1.setText(String.valueOf(C.getCodigo()));
            curso_campo2.setText(C.getNome());            
            c_combo.setSelectedItem(C.getEscola().getNome());
            modo4 = "Seleção";
            manipulaInterface4();
        }
    }//GEN-LAST:event_tbl_cursoMouseClicked

    private void b_novo_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_alunoActionPerformed
        modo5 = "Novo";
        manipulaInterface5();
        al_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_novo_alunoActionPerformed

    private void b_editar_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_alunoActionPerformed
        modo5 = "Editar";
        manipulaInterface5();
    }//GEN-LAST:event_b_editar_alunoActionPerformed

    private void b_excluir_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluir_alunoActionPerformed
        int index = tbl_alunos.getSelectedRow();
        if (index >= 0 && index<aluno.size()) {           
            aluno.remove(index);
        }
        carregaAluno();
        al_campo1.setText("");
        al_campo2.setText("");
        al_campo3.setText("");
        al_campo4.setText("");
        modo5 = "Iniciar";
        manipulaInterface5();
        al_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_excluir_alunoActionPerformed

    private void b_salvar_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_alunoActionPerformed
        int tel = Integer.parseInt(al_campo4.getText());
        int matri = Integer.parseInt(al_campo1.getText());
        int index = al_combo.getSelectedIndex();
        
       if (index == 0) {
             JOptionPane.showMessageDialog(this, "Selecione um Curso");            
             loadCBAluno();
       } else if (index != 0) {
            if (modo5.equals("Novo")) {
                          
            Alunos A = new Alunos(matri, al_campo2.getText(), al_campo3.getText(), tel);
            
            A.setCurso(curso.get(index-1));
        
            aluno.add(A);
            carregaAluno();
            modo5 = "Salvar";
            manipulaInterface5();
            
           }
        
        
        }   
            if (modo5.equals("Editar")) {
                        
            int index3 = tbl_alunos.getSelectedRow();
            aluno.get(index3).setMatricula(matri);           
            aluno.get(index3).setNome(al_campo2.getText());
            aluno.get(index3).setEndereco(al_campo3.getText());
            aluno.get(index3).setTelefone(tel);            
            if (index == 0) {
            
             aluno.get(index3).setCurso(curso.get(index));
            } else {               
                aluno.get(index3).setCurso(curso.get(index-1));
                carregaAluno();        
                modo5 = "Salvar";
                manipulaInterface5();
                   
            }
            
        }
        al_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_salvar_alunoActionPerformed

    private void b_cancelar_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelar_alunoActionPerformed
        modo5 = "Cancelar";
        manipulaInterface5();
        al_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_cancelar_alunoActionPerformed

    private void tbl_alunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_alunosMouseClicked
        int index = tbl_alunos.getSelectedRow();
        if (index >= 0 && index<aluno.size()) {
            Alunos A = aluno.get(index);
            al_campo1.setText(String.valueOf(A.getMatricula()));
            al_campo2.setText(A.getNome());
            al_campo3.setText(A.getEndereco());
            al_campo4.setText(String.valueOf(A.getTelefone()));
            al_combo.setSelectedItem(A.getCurso().getNome());
            modo5 = "Seleção";
            manipulaInterface5();
        }
    }//GEN-LAST:event_tbl_alunosMouseClicked

    private void b_novo_dipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_dipActionPerformed
        modo7 = "Novo";
        manipulaInterface7();
        d_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_novo_dipActionPerformed

    private void b_editar_dipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_dipActionPerformed
        modo7 = "Novo";
        manipulaInterface7();
        d_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_editar_dipActionPerformed

    private void b_excluir_dipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluir_dipActionPerformed
        int index = tbl_dip.getSelectedRow();
        if (index >= 0 && index<dip.size()) {
            dip.remove(index);
        }
        carregaDisciplina();
        dip_campo1.setText("");
        dip_campo2.setText("");
        modo7 = "Iniciar";
        manipulaInterface7();
        d_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_excluir_dipActionPerformed

    private void b_salvar_dipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_dipActionPerformed
        int index = d_combo.getSelectedIndex();
      
       if (index == 0) {
             JOptionPane.showMessageDialog(this, "Selecione um Curso");            
             loadCBDip(); 
       } else if (index != 0) {
            if (modo7.equals("Novo")) {
            int cod = Integer.parseInt(dip_campo1.getText());
            Disciplinas D = new Disciplinas(cod, dip_campo2.getText());
            D.setCurso(curso.get(index-1));
            dip.add(D);
            
            carregaDisciplina();            
            modo7 = "Salvar";
            manipulaInterface7();
        } 
            
        }  
        
        if (modo7.equals("Editar")) {
            int index2 = tbl_dip.getSelectedRow();
            dip.get(index2).setCodigo(Integer.parseInt(dip_campo1.getText()));
            dip.get(index2).setNome(dip_campo2.getText());
         if (index == 0) {
            
             dip.get(index2).setCurso(curso.get(index));
            } else {
                
                dip.get(index2).setCurso(curso.get(index-1));                               
                carregaDisciplina();        
                modo7 = "Salvar";
                manipulaInterface7();
                   
            }

        }
        d_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_salvar_dipActionPerformed

    private void b_cancelar_dipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelar_dipActionPerformed
        modo7 = "Cancelar";
        manipulaInterface7();
        d_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_cancelar_dipActionPerformed

    private void tbl_dipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dipMouseClicked
        int index = tbl_dip.getSelectedRow();
        if (index >= 0 && index<dip.size()) {
            Disciplinas D = dip.get(index);

            dip_campo1.setText(String.valueOf(D.getCodigo()));
            dip_campo2.setText(D.getNome());            
            d_combo.setSelectedItem(D.getCurso().getNome());
            modo7 = "Seleção";
            manipulaInterface7();
        }
    }//GEN-LAST:event_tbl_dipMouseClicked

    private void b_novo_turActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo_turActionPerformed
        modo8 = "Novo";
        manipulaInterface8();
        t1_combo.setSelectedIndex(0);
        t2_combo.setSelectedIndex(0);
        t3_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_novo_turActionPerformed

    private void b_editar_turActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar_turActionPerformed
        modo8 = "Editar";
        manipulaInterface8();
    }//GEN-LAST:event_b_editar_turActionPerformed

    private void b_excluir_turActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluir_turActionPerformed
        int index = tbl_turma.getSelectedRow();
        if (index >= 0 && index<turma.size()) {
            turma.remove(index);
        }
        carregaTurma();
        tur_campo1.setText("");
        tur_campo2.setText("");
        modo8 = "Iniciar";
        manipulaInterface8();
        t1_combo.setSelectedIndex(0);
        t2_combo.setSelectedIndex(0);
        t3_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_excluir_turActionPerformed

    private void b_salvar_turActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salvar_turActionPerformed
        int cod = Integer.parseInt(tur_campo1.getText());
        int index1 = t1_combo.getSelectedIndex();
        int index2 = t2_combo.getSelectedIndex();
        int index3 = t3_combo.getSelectedIndex();
        
       if (index1 == 0 || index2 == 0 || index3 == 0) {
             JOptionPane.showMessageDialog(this, "Selecione todas as 3 caixas!");            
             loadCBTurma1();
             loadCBTurma2();
             loadCBTurma3();
       } else if (index1 != 0 && index2 == 0 && index3 == 0) {
            if (modo8.equals("Novo")) {
                          
            Turmas T = new Turmas(cod, tur_campo2.getText());
            
            T.setDip(dip.get(index1-1));
            T.setProf(prof.get(index2-1));
            T.setAluno(aluno.get(index3-1));
        
            turma.add(T);
            carregaTurma();
            modo8 = "Salvar";
            manipulaInterface8();
            
           }
        
        
        }   
            if (modo8.equals("Editar")) {
                        
            int index4 = tbl_turma.getSelectedRow();
            turma.get(index4).setCodigo(cod);           
            turma.get(index4).setNome(tur_campo2.getText());
            ;            
            if (index1 == 0 || index2 == 0 || index3 == 0) {
            
             turma.get(index4).setDip(dip.get(index1));
             turma.get(index4).setProf(prof.get(index2));
             turma.get(index4).setAluno(aluno.get(index3));
            } else {               
                turma.get(index4).setDip(dip.get(index1-1));
                turma.get(index4).setProf(prof.get(index2-1));
                turma.get(index4).setAluno(aluno.get(index3-1));
                carregaTurma();        
                modo8 = "Salvar";
                manipulaInterface8();
                   
            }
            
        }
        t1_combo.setSelectedIndex(0);
        t2_combo.setSelectedIndex(0);
        t3_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_salvar_turActionPerformed

    private void b_cancelar_turActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelar_turActionPerformed
        modo8 = "Cancelar";
        manipulaInterface8();
        t1_combo.setSelectedIndex(0);
        t2_combo.setSelectedIndex(0);
        t3_combo.setSelectedIndex(0);
    }//GEN-LAST:event_b_cancelar_turActionPerformed

    private void tbl_turmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_turmaMouseClicked
        int index = tbl_turma.getSelectedRow();
        if (index >= 0 && index<turma.size()) {
            Turmas T = turma.get(index);
            tur_campo1.setText(String.valueOf(T.getCodigo()));
            tur_campo2.setText(T.getNome());
            t1_combo.setSelectedItem(T.getDip().getNome());
            t2_combo.setSelectedItem(T.getProf().getNome());
            t3_combo.setSelectedItem(T.getAluno().getNome());
            modo8 = "Seleção";
            manipulaInterface8();
        }
    }//GEN-LAST:event_tbl_turmaMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set tbl_admbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> a_combo;
    private javax.swing.JTextField adm_campo1;
    private javax.swing.JTextField adm_campo2;
    private javax.swing.JTextField adm_campo3;
    private javax.swing.JTextField adm_campo4;
    private javax.swing.JTextField adm_campo5;
    private javax.swing.JTextField al_campo1;
    private javax.swing.JTextField al_campo2;
    private javax.swing.JTextField al_campo3;
    private javax.swing.JTextField al_campo4;
    private javax.swing.JComboBox<String> al_combo;
    private javax.swing.JButton b_cancel_adm;
    private javax.swing.JButton b_cancel_prof;
    private javax.swing.JButton b_cancelar_aluno;
    private javax.swing.JButton b_cancelar_curso;
    private javax.swing.JButton b_cancelar_dip;
    private javax.swing.JButton b_cancelar_escola;
    private javax.swing.JButton b_cancelar_tur;
    private javax.swing.JButton b_editar_adm;
    private javax.swing.JButton b_editar_aluno;
    private javax.swing.JButton b_editar_curso;
    private javax.swing.JButton b_editar_dip;
    private javax.swing.JButton b_editar_escola;
    private javax.swing.JButton b_editar_prof;
    private javax.swing.JButton b_editar_tur;
    private javax.swing.JButton b_excluir_adm;
    private javax.swing.JButton b_excluir_aluno;
    private javax.swing.JButton b_excluir_dip;
    private javax.swing.JButton b_excluir_prof;
    private javax.swing.JButton b_excluir_tur;
    private javax.swing.JButton b_exibir_escola;
    private javax.swing.JButton b_novo_adm;
    private javax.swing.JButton b_novo_aluno;
    private javax.swing.JButton b_novo_curso;
    private javax.swing.JButton b_novo_dip;
    private javax.swing.JButton b_novo_escola;
    private javax.swing.JButton b_novo_prof;
    private javax.swing.JButton b_novo_tur;
    private javax.swing.JButton b_ok_escola;
    private javax.swing.JButton b_salvar_adm;
    private javax.swing.JButton b_salvar_aluno;
    private javax.swing.JButton b_salvar_curso;
    private javax.swing.JButton b_salvar_dip;
    private javax.swing.JButton b_salvar_escola;
    private javax.swing.JButton b_salvar_prof;
    private javax.swing.JButton b_salvar_tur;
    private javax.swing.JComboBox<String> c_combo;
    private javax.swing.JTextField campo1;
    private javax.swing.JTextField campo2;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField curso_campo1;
    private javax.swing.JTextField curso_campo2;
    private javax.swing.JComboBox<String> d_combo;
    private javax.swing.JTextField dip_campo1;
    private javax.swing.JTextField dip_campo2;
    private javax.swing.JButton editar;
    private javax.swing.JTextField escola_campo1;
    private javax.swing.JTextField escola_campo2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton novo;
    private javax.swing.JComboBox<String> p_combo;
    private javax.swing.JTextField prof_campo1;
    private javax.swing.JTextField prof_campo2;
    private javax.swing.JTextField prof_campo3;
    private javax.swing.JTextField prof_campo4;
    private javax.swing.JTextField prof_campo5;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox<String> t1_combo;
    private javax.swing.JComboBox<String> t2_combo;
    private javax.swing.JComboBox<String> t3_combo;
    private javax.swing.JTable tabela_setor;
    private javax.swing.JTable tbl_adm;
    private javax.swing.JTable tbl_alunos;
    private javax.swing.JTable tbl_curso;
    private javax.swing.JTable tbl_dip;
    private javax.swing.JTable tbl_escolas;
    private javax.swing.JTable tbl_prof;
    private javax.swing.JTable tbl_prof_p;
    private javax.swing.JTable tbl_turma;
    private javax.swing.JTextField tur_campo1;
    private javax.swing.JTextField tur_campo2;
    // End of variables declaration//GEN-END:variables
}
