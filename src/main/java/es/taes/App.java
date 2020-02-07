package es.taes;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class App {
  
  



    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
    static final String DB_URL = "jdbc:mysql://localhost:3306/army";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(final String[] args) throws Exception {
       int anyos;
   String nombre;
   String apellidos;
   int opcion=1; 
    final String miMensaje = "Mi hola mundo";
    System.out.println(miMensaje);

    // final Persona persona = new Persona();
    // persona.setEdad(45);
    // persona.setNombre("Alfonso");
    // System.out.println(persona);

    Connection conn = null;
    Statement stmt = null;

    // Register JDBC driver
    Class.forName(JDBC_DRIVER);

    // Open a connection
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    // Execute a query
    System.out.println("Creating statement...");
    stmt = conn.createStatement();
    String sql;
    sql = "SELECT id, first, last, age FROM Employees";
    stmt.executeUpdate(
        "CREATE TABLE if not exists Employees ( id INT(11) PRIMARY KEY, first VARCHAR(256),  last VARCHAR(256),age INTEGER)");
    stmt.executeUpdate("INSERT ignore INTO Employees VALUES(1,'Jack','Smith', 100) ");
//TODO meter datos por teclado 
//declaro vbles
//mientras introducido distinto de 0 
      //pedir datos empleado
      //hacer insert 
  //fin mientras

      

Scanner scan =new Scanner(System.in);
while (opcion!=0) {
  System.out.println("1.-Introducir empleado");
  System.out.println("0.-Salir");
  opcion=Integer.parseInt(scan.nextLine());
  if (opcion==1) {
    System.out.print("Introduce nombre: " );
    nombre=scan.nextLine();
    System.out.print("Introduce apellidos: " );
    apellidos=scan.nextLine();
    System.out.print("Introduce edad: " );
    anyos=Integer.parseInt(scan.nextLine());
    //grabo a piñon
    stmt.executeUpdate("INSERT INTO `employees`(first,last,age) VALUE ('"+nombre+"','"+apellidos+"','"+anyos+"')");
    
    System.out.println("Introduce opcion");
  opcion=Integer.parseInt(scan.nextLine());
  }//end if
  
}//end while
  //rs.close();
      stmt.close();
      conn.close();
      scan.close();

    //final ResultSet rs = stmt.executeQuery(sql);
    // Extract data from result set
    //while (rs.next()) {
      // Retrieve by column name
      /*final int id = rs.getInt("id");
      final int age = rs.getInt("age");
      final String first = rs.getString("first");
      final String last = rs.getString("last");

        System.out.print("ID: " + id);
        System.out.print(", Age: " + age);
        System.out.print(", First: " + first);
        System.out.println(", Last: " + last);*/
    //  }
      // Clean-up environment
      

    }
}
