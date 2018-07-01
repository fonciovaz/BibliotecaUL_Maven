package servicos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexao.JPA;
import controladores.entidades.UsersJpaController;
import entidades.Users;
import java.text.ParseException;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manhique
 */
public class AcessoTest {
    private Acesso acesso = new Acesso();
    
    public AcessoTest() {
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
     @Test
     public void isbloqueadoTest() {
         String nm = "mjunior";
         acesso.isbloqueado(nm);
         boolean expResult = false;
         boolean result = acesso.isbloqueado(nm);
         assertEquals(expResult, result);        
     }
     
    @Test
    public void bloquearTest() throws ParseException{
        String nm = "mjunior";
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        String expResult = "utilizador bloqueado com sucesso";
        String result =acesso.bloquear(user);
        assertEquals(expResult, result);
        
     }
    
    @Test
    public void bloquearTest1() throws ParseException{
        String nm = "mjunior";
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        String expResult = "o usuario ja foi bloqueado";
        String result =acesso.bloquear(user);
        assertEquals(expResult, result);
        
     }
    
    public void bloquearTest2() throws ParseException{
        String nm = "mjunior";
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        String expResult = "o usuario nao fez nenhum emprestimo ate o momento";
        String result =acesso.bloquear(user);
        assertEquals(expResult, result);
        
     }
    
    public void bloquearTest3() throws ParseException{
        String nm = "mjunior";
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        String expResult = "situacao regularizada";
        String result =acesso.bloquear(user);
        assertEquals(expResult, result);
        
     }
    
    public void desbloquearTest() throws ParseException{
        String nm = "mjunior";
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        String expResult = "situacao regularizada";
        String result =acesso.desbloquear(user);
        assertEquals(expResult, result);
        
     }
    
    public void desbloquearTest1() throws ParseException{
        String nm = "mjunior";
        Users user = new UsersJpaController(new JPA().getEmf()).findUsers(nm);
        String expResult = "situacao regularizada";
        String result =acesso.desbloquear(user);
        assertEquals(expResult, result);
        
     }
    
}
