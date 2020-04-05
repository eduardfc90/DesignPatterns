package PACKAGE;




/**
 *
 * @author eduar
 */
public class Country {
   
         private   String Code;
         private  String Name;
         private  String Continent;
         private  float SurfaceArea;
         private  String HeadOfState;
         
         
   private Country(CountryBuilder builder)
                 
         {
             
             this.Code = builder.getCode();
             this.Name=builder.getName();
             this.Continent= builder.getContinent();
             this.SurfaceArea= builder.getSurfaceArea();
             this.HeadOfState = builder.getHeadOfState();

 
    
}
            public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getContinent() {
        return Continent;
    }

    public float getSurfaceArea() {
        return SurfaceArea;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }
    

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public void setSurfaceArea(float SurfaceArea) {
        this.SurfaceArea = SurfaceArea;
    }

    public void setHeadOfState(String HeadOfState) {
        this.HeadOfState = HeadOfState;
    }
 
  
        
        
        @Override        
         public String toString(){
        return "Code:"+Code+"Name:"+Name +"Phone Number:"+Continent+"Address:"+HeadOfState;
        }
         
         /// Using patterns Builder
         public static class CountryBuilder{
             
         private  String Code;
         private String Name;
         private  String Continent;
         private  float SurfaceArea;
         private  String HeadOfState;
         
         public  CountryBuilder(String Code, String Name){
             
             this.Code=Code;
             this.Name=Name;
             
         }

                 public String getCode() {
                     return Code;
                 }

                 public CountryBuilder setCode(String Code) {
                     this.Code = Code;
                     return this;
                 }

                 public String getName() {
                     return Name;
                 }

                 public CountryBuilder setName(String Name) {
                     this.Name = Name;
                     return this;
                 }

                 public String getContinent() {
                     return Continent;
                 }

                 public CountryBuilder setContinent(String Continent) {
                     this.Continent = Continent;
                     return this;
                 }

                 public float getSurfaceArea() {
                     return SurfaceArea;
                 }

                 public CountryBuilder setSurfaceArea(float SurfaceArea) {
                     this.SurfaceArea = SurfaceArea;
                     return this;
                 }

                 public String getHeadOfState() {
                     return HeadOfState;
                 }

                 public CountryBuilder setHeadOfState(String HeadOfState) {
                     this.HeadOfState = HeadOfState;
                     
                    return this;
                 }
         public Country build (){
         
             return new Country(this);
         }
         
         
}}
   