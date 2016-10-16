/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controle.ControleChamados;
import controle.ControleClientes;
import controle.ControleEmpresas;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Tecnico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rosangela
 */
public class Chamados {
    
    @Test
    public void ValidarChamados(){
    
        ControleChamados controle = new ControleChamados();
        ControleEmpresas ce = new ControleEmpresas();
        ControleClientes cc = new ControleClientes();
        
       Empresa m =  new Empresa(2, "StartUP 2.0");
       ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
       Tecnico t1 = new Tecnico("Juan Calleiros" , 24567072);
        
        Chamado c1 = controle.InserirChamadoBancoDeDados("Erro inserir no banco",
                "Erro ao dar insert", 2, t1, ca, "Windows", "8.1", "master");

        Chamado c2 = controle.InserirChamadoBancoDeDados("Query não funciona",
                "...", 2, t1, ca, "Windows", "7", "master");
        
        
        Assert.assertEquals(2 , controle.validarQtdChamados(ca));
    }
    
    
    @Test 
    public void ChamadoAlterado(){
    
    
        ControleChamados controle = new ControleChamados();
        ControleEmpresas ce = new ControleEmpresas();
        ControleClientes cc = new ControleClientes();
        
       Empresa m =  new Empresa(2, "StartUP 2.0");
       ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
       Tecnico t1 = new Tecnico("Juan Calleiros" , 24567072);
        
        Chamado c1 = controle.InserirChamadoBancoDeDados("Erro inserir no banco",
                "Erro ao dar insert", 2, t1, ca, "Windows", "8.1", "master");

        Chamado c2 = controle.InserirChamadoBancoDeDados("Query não funciona",
                "...", 2, t1, ca, "Windows", "7", "master");
        
        c2.setBancoDeDados("db4");
        c2.setSistemaOperacional("Linux");
        
        controle.setChamadoAlterado(c2);
        
        Assert.assertEquals(c2, controle.getChamadoAlterado());
    }
    
    @Test
    public void BuscarChamadoCodigo_e_Alterar()
    {
         ControleChamados controle = new ControleChamados();
         Chamado c = controle.buscaPeloCodigo(7);
         System.out.println(c);
         
         Assert.assertNotNull(c);
         
         c.setDescricao("Errou na inserção persiste");
         c.setPrioridade(3);
         
         controle.setChamadoAlterado(c);
         
         System.out.println(c);
         
         Assert.assertEquals(c, controle.getChamadoAlterado());
         
    }
    
    
    public Chamados() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
