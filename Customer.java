public class Customer
{
    //attribute
    private String custName;
    private String custId;
    private String custPhoneNum;
    private String custIcNum;
    private int age;
    private char gender;
    
    //constructor
    public Customer()
    {
        custName = null;
        custId = null;
        custPhoneNum = null;
        custIcNum = null;
        age = 0;
        gender = 0;
    }
    
    //constructor
    public Customer(String n, String id, String p, String ic, int a, char g)
    {
        custName = n;
        custId = id;
        custPhoneNum = p;
        custIcNum = ic;
        age = a;
        gender = g;
    }
    

    //setter
    public void setCustomer(String n, String id, String p, String ic, int a, char g)
    {
        custName = n;
        custId = id;
        custPhoneNum = p;
        custIcNum = ic;
        age = a;
        gender = g;
    }
    
        public void setCustName(String cn){
            custName = cn;
        }
        
        public void setCustID(String id){
            custId = id;
        }
        
        public void setCustPhoneNum(String p){
            custPhoneNum = p;
        }
        
        public void setCustIcNum(String ic){
            custIcNum = ic;
        }
        
        public void setAge(int a){
            age = a;
        }
        
        public void setGender(char g){
            gender = g;
        }
        
            
    //getter
    public String getCustName()
    {
        return custName;
    }
    
    public String getCustId()    
    {
        return custId;
    }
    
    public String getCustPhoneNum()
    {
        return custPhoneNum;
    }
    
    public String getCustIcNum()
    {
        return custIcNum;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public char getGender()
    {
        return gender;
    }
    
    //toString
    int no = 0;
    public String toString()
    {
        String genders = null;
        if(gender == 'M' || gender == 'm'){
            genders = "Male";
        }else if(gender == 'F' || gender == 'f'){
            genders = "Female";
        }
        
        
        
        return("Customer Name: " + custName +"\n   Customer ID: " + custId + "\n   Customer Phone Number: " + custPhoneNum + 
        "\n   Customer IC Number: " + custIcNum + "\n   Age: " + age + " years old" + "\n   Gender: " + genders);
        
        
    }
}