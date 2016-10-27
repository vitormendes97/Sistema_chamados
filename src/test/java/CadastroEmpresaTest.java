/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;


import controle.ControleEmpresas;
import entidade.Empresa;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author leo_f
 */
public class CadastroEmpresaTest {
    
//    @Rule
//    public TemporaryFolder folder = new TemporaryFolder();
//
//    @Test
//    public void testUsingTempFolder() throws IOException {
//        File createdFolder = folder.newFolder("newfolder");
//        File createdFile = folder.newFile("myfilefile.txt");
//        assertTrue(createdFile.exists());
//    }

//    @Test
//    public void cadastroEmpresaCorreto() {
//        
//        ControleEmpresas ce = new ControleEmpresas();        
//        
//        Empresa e = ce.inserir(0, "nome");
//
//        assertNotNull(e);
//
//    }
    
    @Test
    public void cadastroEmpresaIncorretoId_e_nome_Existentes() {
        
        ControleEmpresas ce = new ControleEmpresas();        
        
//        Empresa e = ce.inserir(0, "nome");
//        int retorno = ce.validar(1, "toniolo");
//        System.out.println(retorno);
//        Assert.assertEquals(1, retorno);



           Empresa e = new Empresa(1, "toniolo");
           
           Empresa retorno = ce.retorna(1, "toniolo");
           
           Assert.assertEquals(e.getNomeEmpresa(),retorno.getNomeEmpresa());
           





    }

//    @Test
//    public void cadastroEmpresaIncorretoNome() {
//        
//        ControleEmpresas ce = new ControleEmpresas();        
//        
//        int retorno = ce.validar(0, null);
//        
//        Assert.assertEquals( ,retorno);
//    }
    
}
