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
 
                System.out.println("Select an option , please :");
                option = sn.nextInt();
 
                switch (option) {
                    case 1:
                        System.out.println("Showing  ALL list");
                        
                         CountryDAO dao= new MySQLCountryDAO();
                        ArrayList<Country> countries = dao.getCountry();
                        System.out.println(countries);
                        
                        break;
                    case 2:
                        System.out.println("Country by Code");
                         CountryDAO dao1= new MySQLCountryDAO();
                        Country c=dao1.findCountry("POL");
                          System.out.println(c);
                        
                        break;
                    case 3:
                        System.out.println("Country by Name");
                        break;
                    case 4:
                        MySQLCountryDAO save1= new MySQLCountryDAO();
                        //save1.getDetails();
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
        
            
            
        }
    
        
        
             
      
      
     
        /*ArrayList<Country> countries = dao.getCountry();
        System.out.println(countries);
        
        Country c=dao.findCountry("POL");
        System.out.println(c);*/
    } 
     }
 /*   public void readMenuImput(){
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
try
{
boolean valid = false;
String input="";
do{
System.out.println("Please enter a number");
input= br.readLine();
if(input.matches("[0-9]+")){
valid= true;
}else{
valid=false;
}
}while(valid==false);

if(input.equals("1")){
checkAccBalance();

}else if(input.equals("2")){
WithDraw();
}
else if (input.equals("9"))
{

login();
}

}catch(Exception e){
System.out.println("Error reading input");
}
*/
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //dao.saveCustomer(c);
       // c= dao.findCustomer(228);
        // System.out.println(c);
        
       /* ArrayList<Country> countries = dao.getCountry();
        System.out.println(countries);*/
      
        
        /*DAOcountryInterface ci= new countryDAOimplementation();
        
        ci.getCountry();*/
        
        
        //  System.out.println(CheckIfEmpty("String Required"));
        
        /*System.out.println(ci.getCountry());*/
        
      
        
