

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;;





/**
 *
 * @author eduar
 */
public class DataSource {
    
    
    private String db= "jdbc:mysql://apontejaj.com:3306/world";
    private String un= "cctstudent";
    private String pw="Pass1234!";
    
    
   private  Connection conn;
   private  Statement stmt;
   private ResultSet rs=null;
   
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public DataSource(){
        try{
            //get a connection to the database
            Connection conn= DriverManager.getConnection(db,un,pw);
            //get a statement fro the connection
            Statement stmt = conn.createStatement();
            
            // #Execute the query
            ResultSet rs= stmt.executeQuery("SELECT * FROM country");
            //loop the result
            while (rs.next())
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            
            //close everything
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se ){
            System.out.println("SQL Exception:");
            
            ///loop through the SQL Exception
            
            while (se!= null)
            {
                 System.out.println("State:"+se.getSQLState());
                  System.out.println("Message:"+ se.getMessage());
                   System.out.println("Error:"+ se.getErrorCode());
                   
                   se= se.getNextException();
            }
            
        }
        
        catch(Exception e ){
             System.out.println(e);
        }
    }
    
    public boolean save( String query)
    {
          try {
            stmt.execute(query);
              return true;
        } catch (SQLException e) {
           e.printStackTrace();
           return false;
        }
    }
    
    public ResultSet select (String query){
            // #Execute the query
            
        try {
            rs = stmt.executeQuery(query);
                        
        } catch (SQLException e) {
           e.printStackTrace();
        }
           return rs;
    }
           public void closing(){
        try {
            //close everything
            rs.close();
             stmt.close();
            conn.close();
        } catch (SQLException e) {
               e.printStackTrace();
        }}
           
           
          public String CheckIfEmpty(String Required) {

        System.out.println("Please enter " + Required);
        boolean Empty = false;
        String UserInput = "";
        do {
            try {
                UserInput = br.readLine().toUpperCase();
                if (UserInput.equals("")) {
                    Empty = false;
                    System.out.println(Required + "  " + "required, Please enter a valid one");
                } else {
                    Empty = true;
                }
            } catch (Exception input) {
            }

        } while (Empty == false);

        return UserInput;
    }}
/*
      public int question() {

        int Answer = 0;

        System.out.println("1 List all countries in the database"+"\n");
        System.out.println("2 Find a country by country code"+"\n");
        System.out.println("3 Find a country by name"+"\n");
        System.out.println("4 Save a new country in the database "+"\n");

        String optionSelected = useful.CheckIfEmpty("the number of the option you want");

        Answer = Integer.parseInt(optionSelected);

        return Answer;
    }
           
}*/
