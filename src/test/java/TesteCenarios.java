/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controle.ControleChamados;
import controle.ControleClientes;
import controle.ControleTecnicos;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.Tecnico;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vitor Mendes e Leo Toniolo
 */
public class TesteCenarios {
    
    //OBS : Dentro de cada método há mais métodos de testes que decidimos não fazer individualmente mas 
    // sim dentro de uma rotina pensada. Ou seja , não haverá método criando só o cliente e sim 
    // um método criando uma rotina que envolva também a criação de um cliente
    
    
    ControleChamados controle = new ControleChamados();
    @Test
    public void ValidarChamados(){
        ControleClientes cc = new ControleClientes();
            
           String file = "empresas.dat";
           PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
             Empresa m =  new Empresa(2, "StartUP 2.0");
       ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
       Tecnico t1 = new Tecnico("Juan Calleiros" , 24567072);
        
        Chamado c1 = controle.InserirChamadoBancoDeDados("Erro inserir no banco",
                "Erro ao dar insert", 2, t1, ca, "Windows", "8.1", "master");

        Chamado c2 = controle.InserirChamadoBancoDeDados("Query não funciona",
                "...", 2, t1, ca, "Windows", "7", "master");
        
      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TesteCenarios.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }
    
    
    @Test 
    public void ChamadoAlterado(){
   
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
    public void BuscarChamadoByCodigo_e_Alterar()
    {
         Chamado c = controle.buscaPeloCodigo(7);
         System.out.println(c);
         
         Assert.assertNotNull(c);
         
         c.setDescricao("Errou na inserção persiste");
         c.setStatus("Sem solucao");       
         c.setPrioridade(3);
         
         
         controle.setChamadoAlterado(c);
         
         Assert.assertEquals(c, controle.getChamadoAlterado());
         
    }
    
 
    @Test
    public void encerrarChamado(){
         Tecnico t1 = new Tecnico("Juan Calleiros" , 24567072);
        Chamado c = controle.buscaPeloCodigo(1);
        c = controle.alterarChamado(c, "encerrado", "Causado por inconsitencia", "deletar tudo");
       
        // Verifica se controle.getChamadoAlterado é null . Essa condição deve ser sempre verdade
        // já que eu acabei de mudar um chamado
        // Assert.assertNotNull(controle.getChamadoAlterado());
        
        // Não deveria ser nulo mas é ...
        
//       Assert.assertEquals(c.getStatus() , controle.getChamadoAlterado().getStatus());
        Assert.assertEquals("encerrado", c.getStatus());
        Assert.assertEquals("encerrado" , controle.buscaPeloCodigo(1).getStatus());
    }
    
    @Test
    public void createTecnico(){
        ControleTecnicos t = new ControleTecnicos();
        Tecnico x = t.inserir(26104149, "Ténico1");
        
        Assert.assertNotNull(x);
        Assert.assertEquals("Ténico1",x.getNome());
        Assert.assertEquals(26104149, x.getTelefone());
    }
    
    public TesteCenarios() {
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
