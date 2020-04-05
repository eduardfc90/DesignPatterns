package PACKAGE;






import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eduar
 */
public class MySQLCountryDAO implements CountryDAO {
    
     DataSource db = new DataSource();
Scanner enter= new Scanner(System.in);
    @Override
    public ArrayList<Country> getCountry() {
     ArrayList<Country> countries= new ArrayList<Country>();
        
     
     
        String query= "SELECT * FROM country";
        
        ResultSet rs= db.select(query);
        
        
        
        try{
       while(rs.next()){
       
           String Code=rs.getString(1);
           String Name=rs.getString(2);
           String Continent=rs.getString(3);
           float SurfaceArea=rs.getFloat(4);
           String HeadOfState=rs.getString(5);
           
           Country c=null;
           
           
           
           c= new Country.CountryBuilder(Code, Name).setContinent(Continent).setSurfaceArea(SurfaceArea).setHeadOfState(HeadOfState).build();
          //Country.add(c)
           
          
           
           
                     
           
           
           
       }
        } catch (SQLException e) {
               e.printStackTrace();
        }
        
        
       return countries;  
    }

    @Override
    public Country findCountry(String countrycode) {
        
        
        String query= "SELECT * FROM country where id="+countrycode+";";
        ResultSet rs= db.select(query);
       
        String Code="";
        String Name="";
       String Continent="";
       float SurfaceArea=0;
       String HeadOfState="";
        Country c=null;
        
        try {
            if(rs.next()){
                
                Code=rs.getString(1);
                Name=rs.getString(2);
                Continent=rs.getString(3);
                SurfaceArea=rs.getFloat(4);
                HeadOfState=rs.getString(5);
                
                
                c= new Country.CountryBuilder(Code, Name).setContinent(Continent).setSurfaceArea(SurfaceArea).setHeadOfState(HeadOfState).build();
                return c;
            }
            return null;
        } catch (SQLException e) {
              e.printStackTrace();
        }
        
        
       
        
        
       return null;
    }

    @Override
    public ArrayList<Country> getName(String name) {
       
        
        ArrayList<Country> samename= new ArrayList<Country>();
        
        String query= "SELECT * FROM country where Name="+name+";";
        ResultSet rs= db.select(query);
       
        String Code="";
        String Name="";
       String Continent="";
       float SurfaceArea=0;
       String HeadOfState="";
        Country c=null;
        
        try {
            if(rs.next()){
                
               Code=rs.getString(1);
                Name=rs.getString(2);
                Continent=rs.getString(3);
                SurfaceArea=rs.getFloat(4);
                HeadOfState=rs.getString(5);
                
                
             c= new Country.CountryBuilder(Code, Name).setContinent(Continent).setSurfaceArea(SurfaceArea).setHeadOfState(HeadOfState).build();
                samename.add(c);
                
                return samename;
            }
            return null;
        } catch (SQLException e) {
              e.printStackTrace();
        }
        
        
       
        
        
       return null;
    }

    @Override
    public boolean saveCountry(Country c) {
        
        //
           String Code=c.getCode();
           String Name=c.getName();
           String Continent=c.getContinent();
           Float SurfaceArea=c.getSurfaceArea();
           String HeadOfState=c.getHeadOfState();
           
           String query="Insert into country(Code,Name,Continent,SurfaceArea,HeadOfState) Values('"+Code+"','"+Name+"','"+Continent+"',"+SurfaceArea+",'"+HeadOfState+"')";
           
          return  db.save(query);  
    }
    
      /*    public void getDetails(){
        
     System.out.println("code please");
    String code=enter.nextLine();
    
       System.out.println("name please");
    String name=enter.nextLine();
    
       System.out.println("continent please");
    String continent=enter.nextLine();
    
       System.out.println("area please");
    String area=enter.nextLine();
    
       System.out.println("cabeza please");
    String head=enter.nextLine();
    
    float Area=Float.parseFloat(area);
    
    Country c= new Country(code,name,continent,Area,head);
    
    saveCountry(c);
    }
    */
    
  
        
      
    
   
}
