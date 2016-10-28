/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Persistencia.ClienteDAO;
import controle.ControleChamados;
import controle.ControleClientes;
import controle.ControleEmpresas;
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
public class ControleClientesTest {
    
    //OBS : Dentro de cada método há mais métodos de testes que decidimos não fazer individualmente mas 
    // sim dentro de uma rotina pensada. Ou seja , não haverá método criando só o cliente e sim 
    // um método criando uma rotina que envolva também a criação de um cliente
    
    
    @Test 
    public void CadastrarEmpresa_e_Cliente(){
        
        
        // Garante que nunca vai dar erro de que a empresa já foi cadastrada
//        try {
//            
//           String file = "empresas.dat";
//            try (PrintWriter writer = new PrintWriter(file)) {
//                writer.print("");
                
            ControleEmpresas ce = new ControleEmpresas();
            ControleClientes cc = new ControleClientes();
            Empresa m =  ce.inserir(15, "StartUPsvip 10.0");
            ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
            Assert.assertNotNull(m);
            Assert.assertNotNull(ca);
            Assert.assertEquals(43166637, ca.getCpf());
            Assert.assertEquals(26104041 , ca.getTelefone());
            Assert.assertEquals("Vitor Mendes", ca.getNome());
            
            System.out.println(m);
            
            }
  
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ControleClientesTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
          
    
    
   @Test
   public void VerificarClientePorCPF(){
   ControleClientes cc = new ControleClientes();
   ClienteEmpresa c1 = cc.incluiNovoCliente(null, 431666389, "Vitor Mendes", 26104041);
    ClienteEmpresa c2 = cc.incluiNovoCliente(null, 1234, "João", 26104041);
   
   ClienteDAO dao = new ClienteDAO();
   
    Assert.assertFalse(dao.validarCPF(431666389));
    //Método retorna true se não cliente = null e false se cliente != null , acho que a lógica é ao contrário
      
    Assert.assertTrue(dao.validarCPF(2182178));  // Não há cliente com esse cpf
   }
    
   
//   @Test
//   public void emitirRelatório(){
//        ControleChamados  controle = new  ControleChamados();
//        ControleClientes cc = new ControleClientes();
//            
//           String file = "empresas.dat";
//           PrintWriter writer;
//        try {
//            writer = new PrintWriter(file);
////            writer.print("");
////            writer.close();
//             Empresa m =  new Empresa(2, "StartUP 2.0");
//       ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
//       Tecnico t1 = new Tecnico("Juan Calleiros" , 24567072);
//        
//       Chamado c2 = controle.InserirChamadoBancoDeDados("Windows Corrompido",
//                "...", 2, t1, ca, "Windows", "10", "beta");
//        
//       
//             boolean flag = false;
//        if(controle.emitirRelatorios(1) instanceof String){
//            flag = true;
//        }
//        
//            Assert.assertEquals(true,flag);
//
//    }
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(TesteCenarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   }
    
    
    public ControleClientesTest() {
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
