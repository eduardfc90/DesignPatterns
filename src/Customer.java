
/**
 *
 * @author eduar
 */
public class Customer {
    
        private int id;
         private String name;
        private int phoneNumber;
         private String address;
         
         public Customer ( int id, String name, int phonNumber, String address)
                 
         {
             
             this.id= id;
             this.name=name;
             this.phoneNumber=phoneNumber;
             this.address=address;
         }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public String toString(){
        return "Id:"+id+"Name:"+name+"Phone Number:"+phoneNumber+"Address:"+address;
    
}
    
}
