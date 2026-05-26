import java.time.LocalDate; 
import java.text.DecimalFormat; 

public class Ticket{
    
    private final static DecimalFormat df = new DecimalFormat("0.00");
    private String ticketType;
    private Object origin;
    private Object destination;
    private String departureDate;
    private String returnDate;
    private char packageType;
    private boolean isSeniorCitizen;
    private char ticketCategory;
    private double amount;
    private int returnOption;
    
    //constructor
    public Ticket(){
        ticketType = "";
        origin = "";
        destination = "";
        departureDate = "";
        returnDate = "";
        packageType = '-';
        isSeniorCitizen = false;
        ticketCategory = '-';
        amount = 0.0;
        returnOption = 0;
    }
    
    public Ticket(String tt, Object o, Object ds, String dd, String rd, char pt, boolean isc, char tc, double a, int ro){
        ticketType = tt;
        origin = o;
        destination = ds;
        departureDate = dd;
        returnDate = rd;
        packageType = pt;
        isSeniorCitizen = isc;
        ticketCategory = tc;
        amount = a;
        returnOption = ro;
    }
    
    //setter
    public void setTicket(String tt, String o, String ds, String dd, String rd, char pt, boolean isc, char tc, double a, int ro){
        ticketType = tt;
        origin = o;
        destination = ds;
        departureDate = dd;
        returnDate = rd;
        packageType = pt;
        isSeniorCitizen = isc;
        ticketCategory = tc;
        amount = a;
        returnOption = ro;
    }
    public void setAmount(double a){
        amount = a;
    }
    public void setReturnOption(int ro){
        returnOption = ro;
    }
    public void setSeniorCitizen(boolean isc){
        isSeniorCitizen = isc;
    }
    public void setTicketCategory(char tc){
        ticketCategory = tc;
    }
    
    //getter
    public String getTicketType(){return ticketType;}
    public Object getOrigin(){return origin;}
    public Object getDestination(){return destination;}
    public String getdepartureDate(){return departureDate;}
    public String getReturnDate(){return returnDate;}
    public char getPackageType(){return packageType;}
    public boolean getisSeniorCitizen(){return isSeniorCitizen;}
    public char getTicketCategory(){return ticketCategory;}
    public double getAmount(){return amount;}
    public int getReturnOption(){return returnOption;}
    
    //tostring
    public String toString(){
        
        String category = null;
        
        if(ticketCategory == 'A' || ticketCategory == 'a'){
            category = "Adult";
        }else if(ticketCategory == 'C' || ticketCategory == 'c'){
            category = "Child";
        }
        
        return("\n\n   Ticket Type : "+ ticketType + "\n   Origin : " + origin + "\n   Destination: "+ destination + "\n   Departure Date: "+ departureDate +"\n   Return Date: "+ returnDate
        + "\n   Package Type: "+ packageType  + "\n   Is Senior Citizen: "+ isSeniorCitizen + "\n   Ticket Category: "+ category);
        
    }
    
    //calculate price
    double totalPrice = 0.0;
    public double calcPrice(int returnOption){
        
        //calculate price from origin to destination based on ticket type
        if(ticketType.equalsIgnoreCase("Gold")){
            
            if((origin == "Tapah Road" && destination =="Ipoh") || (origin == "Ipoh" && destination  == "Tapah Road")){
                
                totalPrice = 16.00;
              
            }else if((origin == "Tapah Road" && destination == "Kajang") || (origin == "Kajang" && destination  == "Tapah Road")){
                
                totalPrice = 33.00;
                
            }else if((origin == "Tapah Road" && destination == "KL Sentral") || (origin == "KL Sentral" && destination  == "Tapah Road")){
                
                totalPrice = 31.00;
                
            }else if((origin == "Ipoh" && destination == "Kajang") || (origin == "Kajang" && destination  == "Ipoh")){
                
                totalPrice = 40.00;
                
            }else if((origin == "Ipoh" && destination == "KL Sentral") || (origin == "KL Sentral" && destination  == "Ipoh")){
                
                totalPrice = 39.00;
                
            }else if((origin == "Kajang" && destination == "KL Sentral") || (origin == "KL Sentral" && destination  == "Kajang")){
                
                totalPrice = 12.00;
                
            }
            
            
        }else if(ticketType.equalsIgnoreCase("Silver")){
            
            if((origin == "Tapah Road" && destination =="Ipoh") || (origin == "Ipoh" && destination  == "Tapah Road")){
                
                totalPrice = 13.00;
              
            }else if((origin == "Tapah Road" && destination == "Kajang") || (origin == "Kajang" && destination  == "Tapah Road")){
                
                totalPrice = 30.00;
                
            }else if((origin == "Tapah Road" && destination == "KL Sentral") || (origin == "KL Sentral" && destination  == "Tapah Road")){
                
                totalPrice = 29.00;
                
            }else if((origin == "Ipoh" && destination == "Kajang") || (origin == "Kajang" && destination  == "Ipoh")){
                
                totalPrice = 37.00;
                
            }else if((origin == "Ipoh" && destination == "KL Sentral") || (origin == "KL Sentral" && destination  == "Ipoh")){
                
                totalPrice = 37.00;
                
            }else if((origin == "Kajang" && destination == "KL Sentral") || (origin == "KL Sentral" && destination  == "Kajang")){
                
                totalPrice = 10.00;
                
            }
            
        }
        
        //calculate price based on package type
        if(packageType == 'A' || packageType == 'a'){
            totalPrice = totalPrice + 6.00;
        }else if(packageType == 'B' || packageType == 'b'){
            totalPrice = totalPrice + 3.00;
        }else if(packageType == 'C' || packageType == 'c'){
            totalPrice = totalPrice + 8.00;
        }else if(packageType == 'N' || packageType == 'n'){
            totalPrice = totalPrice + 0.00;
        }
        
        //calculate price based on ticket category
        if(ticketCategory == 'C' || ticketCategory == 'c'){
            totalPrice = totalPrice - (totalPrice * 0.2);
        }
        
        
        //calculate price if customer is senior citizen
        if(isSeniorCitizen == true){
            totalPrice = totalPrice - (totalPrice * 0.2);
        }
        
      
        //calculate price if user want return ticket
        if(returnOption == 0){
            totalPrice = totalPrice * 2;
        }
        
        return totalPrice;
    }
    
    //print receipt
    public void printReceipt(String custName, String transactionID, LocalDate paymentDate, String bankName, double amount){
             
             String category = null;
             if(ticketCategory == 'A' || ticketCategory == 'a'){
                 category = "Adult";
             }else if(ticketCategory == 'C' || ticketCategory == 'c'){
                 category = "Child";
             }
             
             System.out.println("\n\n\nRECEIPT");
             System.out.println("_______________________________________________________________________");
             System.out.println("                     " + origin + "-" + destination + "                ");
             System.out.println("_______________________________________________________________________");
             System.out.println("Departure Date      : " + departureDate);
             System.out.println("Return Date         : " + returnDate);
             System.out.println("Name                : " + custName);
             System.out.println("Category            : " + category);
             System.out.println("Ticket Type         : " + ticketType);
             System.out.println("Transaction Id      : " + transactionID);
             System.out.println("Payment Date        : " + paymentDate);
             System.out.println("Bank Name           : " + bankName);
             System.out.println("_______________________________________________________________________");
             System.out.println("                                                    Total: RM" + df.format(amount));
             System.out.println("_______________________________________________________________________");
             System.out.println("*Any requires or problems please contact : 05-5679-123                 ");
        
    }
    
}
