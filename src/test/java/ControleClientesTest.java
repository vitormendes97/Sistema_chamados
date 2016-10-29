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
import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.io.File;
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

    @Test 
    public void CadastrarEmpresa_e_Cliente(){
        
        
            ControleEmpresas ce = new ControleEmpresas();
            Empresa m =  ce.inserir(1, "StartUPsvip 10.0"); 
            
            ControleClientes cc = new ControleClientes();
           
            ClienteEmpresa ca = cc.incluiNovoCliente(m, 43166637, "Vitor Mendes", 26104041);
            Assert.assertNotNull(m);
            Assert.assertNotNull(ca);
            Assert.assertEquals(43166637, ca.getCpf());
            Assert.assertEquals(26104041 , ca.getTelefone());
            Assert.assertEquals("Vitor Mendes", ca.getNome());
            
            System.out.println(m);
            
            }

    
    
   @Test
   public void VerificarClientePorCPF(){
   ControleClientes cc = new ControleClientes();
   ClienteEmpresa c1 = cc.incluiNovoCliente(null, 431666389, "Vitor Mendes", 26104041);
    ClienteEmpresa c2 = cc.incluiNovoCliente(null, 1234, "João", 26104041);
   
   ClienteDAO dao = new ClienteDAO();
   
    Assert.assertFalse(dao.validarCPF(431666389));
    
      
    Assert.assertTrue(dao.validarCPF(2182178));  // Não há cliente com esse cpf
   }

    
    @BeforeClass
    public static void setUpClass() {
            
            
          
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
                File file = new File ("C:\\Users\\Rosangela\\Documents\\NetBeansProjects\\Sistem de Chamados\\empresas.dat");
               PrintWriter printWriter = new PrintWriter (file);
               printWriter.println ("");
               printWriter.close ();       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControleClientesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    @After
    public void tearDown() {
    }

}
