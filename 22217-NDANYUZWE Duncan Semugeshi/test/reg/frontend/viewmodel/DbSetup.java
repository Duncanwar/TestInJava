/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewmodel;

import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import java.sql.DriverManager;

/**
 *
 * @author duncan
 */
public class DbSetup {
      public static void prepare(Operation ops) throws Exception {
                
       DriverManager.registerDriver(new org.postgresql.Driver());
       DriverManagerDestination driver = new DriverManagerDestination("jdbc:postgresql://localhost:5432/postgres",
       "duncan","1212");
       com.ninja_squad.dbsetup.DbSetup ds = new com.ninja_squad.dbsetup.DbSetup(driver, ops);
       ds.launch();
    }   
}
