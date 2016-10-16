/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Persistencia.ClienteDAO;
import controle.ControleClientes;
import controle.ControleEmpresas;
import entidade.ClienteEmpresa;
import entidade.Empresa;
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
public class ControleClientesTest {
//    
//    @Test 
//    public void CadastrarEmpresa_e_Cliente(){
//        
//        ControleEmpresas ce = new ControleEmpresas();
//        ControleClientes cc = new ControleClientes();
//        
//       Empresa m =  ce.inserir(4, "StartUP 3.0"); //Tem que ficar mudando o index que está com 4, pois 
//       // quando eu testo ele cadastra uma empresa com index 4 e ai não pode mais ser usado , testar com 5 e assim por diante
//       ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
//    
//       Assert.assertNotNull(m);
//       Assert.assertNotNull(ca);
//       Assert.assertEquals(43166637, ca.getCpf());
//       Assert.assertEquals(26104041 , ca.getTelefone());
//       Assert.assertEquals("Vitor Mendes", ca.getNome());
//       
//    
//    }
    
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
