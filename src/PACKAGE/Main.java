package PACKAGE;



import PACKAGE.Country;
import PACKAGE.MySQLCountryDAO;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
public class Main {

    /**
     * @param args the command line arguments
     */

    /// main method and menu main program
    public static void main(String[] args) {
        
             Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int option; //saving  the option del user
 
        while(!exit) {
        
        System.out.println("WELCOME!!!");
        System.out.println("What would  you like to do?\n");
        
        System.out.println("1.List all countries in the database.");
	System.out.println("2.Find a country by country code.");
	System.out.println("3.Find a country by name.");
	System.out.println("4.Save a new country in the database.\n");
    
        
 
            try {
 ///menu options
                System.out.println("Select an option , please :");
                option = sn.nextInt();
 
                switch (option) {
                    case 1:///showing all the list
                        System.out.println("Showing  ALL list");
                         CountryDAO dao= new MySQLCountryDAO();
                        ArrayList<Country> countries = dao.getCountry();
                        System.out.println(countries);
                        
                        
                        break;
                    case 2://// checking the country by code
                       System.out.println("Showing  Country by Code");
                      
                        MySQLCountryDAO searchcode= new MySQLCountryDAO() ;
                         searchcode.askcode();
                        
                        break;
                    case 3:/// checking the country by name
                        System.out.println("Showing Country by Name");
                         MySQLCountryDAO searchname= new MySQLCountryDAO() ;
                         searchname.askname();
                        break;
                    case 4:
                       
                        /// saving details into the data base
                       MySQLCountryDAO insert= new MySQLCountryDAO() ;
                         
                       insert.getDetails();
                       
                       System.out.println("Saved Correctly!!!");
                       
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("You can insert just numbers between 1 and 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please insert right number?");
                sn.next();
            }
        
            
            
        }}}
    
        
        
      
        
