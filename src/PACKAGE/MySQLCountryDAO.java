package PACKAGE;



import PACKAGE.continent;
import PACKAGE.continent.continents;


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

        public void getDetails(){
           
        Country c= null;
        
     System.out.println("Insert Code please");
    String Code=enter.nextLine();
    
       System.out.println("Insert Name please");
    String Name=enter.nextLine();
    
       System.out.println("Insert Continent please");
       String takecontinent=enter.nextLine();
    String Continent=null;
    
    if(continent(takecontinent)){
    Continent=takecontinent;
    }
    
       System.out.println("Insert SurfaceArea, please");
    String SurfaceArea=enter.nextLine();
    
       System.out.println("Head of State, please");
    String HeadOfState=enter.nextLine();
    
    //float SurfaceArea=Float.parseFloat(SurfaceArea);
    
    c= new Country.CountryBuilder(Code, Name).setContinent(Continent).setHeadOfState(HeadOfState).build();
    
    if(saveCountry(c)){
    
        System.out.println("Your request have been successfull!!!");
    }
    }
    
  // ask a name to find a country
    public void askname(){
    
        System.out.println("enter the name");
        String name = enter.nextLine();
     
        ArrayList<Country> count=new ArrayList<Country>();
        
        count=getName(name);
    
        for(Country c:count){
            System.out.println(c);
        }
    }
      
       public void askcode(){
    
        System.out.println("enter the code");
        String code = enter.nextLine();
     
       
        Country c=null;
        c=findCountry(code);
        
           System.out.println(c);
       
    }
       
       // takes a continent and validates it into the data base
      
       public boolean continent(String continent){
       
       for(continent c:continent.values()){
          if(continent.equals(c.getContinent()) ){
             return true;
          }
       }    
          
       
        
      
    
   

