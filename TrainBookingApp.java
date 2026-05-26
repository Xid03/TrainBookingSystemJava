import java.util.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Random;
import java.text.DecimalFormat;  

public class TrainBookingApp{
    
     private final static DecimalFormat df = new DecimalFormat("0.00");
     
    public static void main(String[] args){
        
        //create queue
        Queue customerQ = new Queue();
        Queue ticketQ = new Queue();        
        //create temp
        Queue tempQ = new Queue();
        Queue tempAdultQ = new Queue();
        Queue tempChildQ = new Queue();
        Queue tempSeniorQ = new Queue();
        Stack tempS = new Stack();
        Queue tempTicketQ = new Queue();
        //create Object
        Object obj;
        
        //create stack
        Stack ticketStack = new Stack();
        
        
        //declare variable
        boolean whichsite = true;
        int pax = 0;
        String custID = null;
        Object selectOrigin = null;
        Object selectDestination = null;
        String departureDate = null;
        int returnOption;
        String returnDate = null;
        String ticketType = null;
        char packageType = '-';
        boolean seniorCitizen = false;
        char ticketCategory = '-';
        double amount = 0.0;
        double totalPayment = 0.0;
        double average = 0.0;
        char custGender = '-';
        double amountMin = 999999999;
        double amountMax = 0;
        String outputMax = null;
        String outputMax2 = null;
        String outputMin = null;
        String outputMin2 = null;
        
        //array for destination and destination
        Object[] origin = { "Tapah Road","Ipoh","Kajang","KL Sentral" };
        Object[] destination = { "Tapah Road","Ipoh","Kajang","KL Sentral" };
        
        
        //create object
        Customer cust = new Customer();
        Customer cust2 = new Customer();
        
        // Create the HTML message with the image path
        String message = "<html>" +
                         "<head>" +
                         "<style>" +
                         "body { background-color: #f0f8ff; text-align: center; font-family: Arial, sans-serif; padding: 20px; }" + // Background and padding
                         "h1 { color: #4CAF50; font-size: 28px; margin-bottom: 20px; text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3); }" + // Header style with shadow
                         "p { font-size: 16px; color: #333; margin-top: 10px; text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2); }" + // Paragraph style with shadow
                         "img { border: 3px solid #4CAF50; border-radius: 15px; margin-top: 20px; }" + // Image border and radius
                         ".container { border: 1px solid #4CAF50; border-radius: 10px; padding: 20px; background-color: white; display: inline-block; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); }" + // Container for a card-like effect
                         "</style>" +
                         "</head>" +
                         "<body>" +
                         "<div class='container'>" +
                         "<h1>Welcome to Train Ticket Booking System</h1>" +
                         "<img src='file:src/logos.png' width='300' height='300'>" + // Adjusted image size
                         "<p>Book your tickets easily and conveniently!</p>" + // Additional text
                         "</div>" +
                         "</body>" +
                         "</html>";
                         
        // Show the message dialog with the HTML content
        JOptionPane.showMessageDialog(null, message, "Welcome", JOptionPane.PLAIN_MESSAGE);
        
        while(whichsite){
            
            message = "<html>" +
                        "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Which Site</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Select Which Site:</p>" +
                         "</html>";
                         
            String[] options = {"🛒 Customer", "👨🏻‍💻 Admin", "❌ Exit"};
            int site = JOptionPane.showOptionDialog(null, message, "Select one", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]); 
            
            if(site == 0){
                         
                //enter pax
                message = "<html>" +
                         "<img src='file:src/logos.png' width='350' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Total Pax</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please enter the number of passengers:</p>" +
                         "</html>";

                // Show the input dialog with the HTML content
                String paxString = JOptionPane.showInputDialog(null, message, "Total Pax", JOptionPane.PLAIN_MESSAGE);
                
                // Check if user input is not null (user didn't click cancel)
                if (paxString != null) {
                    
                    try {
                        pax = Integer.parseInt(paxString);
                        // Further processing with pax variable
                        System.out.println("Total Pax: " + pax);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else {
                        System.out.println("User cancelled the operation.");
                }
                
                
                int num = 0;
                //enter customer information
                for(int i=0; i<pax; i++){
                    
                    num++;
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='300' height='250'><br>" + 
                         "<h2 style='color: #4CAF50;'>Enter Customer " + num + " Information</h2>" + 
                         "</html>";
                         
                    JOptionPane.showMessageDialog(null, message, "Enter Customer", JOptionPane.PLAIN_MESSAGE);
                    
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Customer Information</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Enter Customer Name:</p>" +
                         "</html>";
                         
                    String custName = JOptionPane.showInputDialog(null, message, "Customer Info", JOptionPane.PLAIN_MESSAGE);
           
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='350' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Customer Information</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Enter Customer Phone Number:</p>" +
                         "</html>";
           
                    String custPhoneNum = JOptionPane.showInputDialog(null, message, "Customer Info", JOptionPane.PLAIN_MESSAGE);
           
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='320' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Customer Information</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Enter Customer IC Number:</p>" +
                         "</html>";
           
                    String custIC = JOptionPane.showInputDialog(null, message, "Customer Info", JOptionPane.PLAIN_MESSAGE);
           
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='600' height='400'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Customer Information</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Enter Customer age(ticket category base on customer age!):</p>" +
                         "</html>";
           
                    int custAge = Integer.parseInt(JOptionPane.showInputDialog(null, message, "Customer Info", JOptionPane.PLAIN_MESSAGE));
           
                    
    
                    //input gender
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Gender</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Select Gender:</p>" +
                         "</html>";
                    
                    String[] optionsGender = {"🚹 Male", "🚺 Female"};
                    int optionGenders = JOptionPane.showOptionDialog(null, message, "Select Ticket Type", 0, JOptionPane.PLAIN_MESSAGE, null, optionsGender, optionsGender[0]); 
                    
                    if(optionGenders == 0){
                        custGender = 'M';
                    }else if(optionGenders == 1){
                        custGender = 'F';
                    }
                    
                    //generate random customer id
                    // create an object of Random class
                    Random random = new Random();
                    // create a string of all characters
                    String id = "abcd12345";
                       
                    // specify length of random string
                    int lengths = 5;
                       
                    //create of object for StringBuilder class
                    StringBuilder sbCustID = new StringBuilder();

                    for(int a = 0; a < lengths; a++) {

                        // generate random index number
                        int indexs = random.nextInt(id.length());

                        // get character specified by index
                        // from the string
                        char randomchar = id.charAt(indexs);

                        //append the character to string builder
                        sbCustID.append(randomchar);
                    } 
                       
                    custID = sbCustID.toString();
                    
                    cust = new Customer(custName, custID, custPhoneNum, custIC, custAge, custGender);
                    
                    //insert to queue
                    customerQ.enqueue(cust);
                    
                    
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Select Origin</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Select Origin:</p>" +
                         "</html>";
           
                    //select origin 
                    selectOrigin = JOptionPane.showInputDialog(null, message, "Select Origin", JOptionPane.PLAIN_MESSAGE, null, origin, origin[0]); 
           
           
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Select Destination</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Select Destination:</p>" +
                         "</html>";
            
                    //select destination
                    selectDestination = JOptionPane.showInputDialog(null, message, "Select Destination", JOptionPane.PLAIN_MESSAGE, null, destination, destination[1]); 
           
           
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='320' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter departure date</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Enter departure date (dd-mm-yyyy):</p>" +
                         "</html>";
                         
                    //input departure date
                    departureDate = JOptionPane.showInputDialog(null, message, "Departure Date", JOptionPane.PLAIN_MESSAGE);
           
                    //input return date
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='400' height='350'><br>" +
                         "<h2 style='color: #4CAF50;'>Return Option</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Do you want to buy return ticket also (Yes/No)?</p>" +
                         "</html>";
                         
                    returnOption = JOptionPane.showConfirmDialog(null,message);
                    
                    if(returnOption ==0){
                        
                        message = "<html>" +
                        "<img src='file:src/logos.png' width='390' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter return date</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Enter return date (dd-mm-yyyy):</p>" +
                         "</html>";
                         
                        returnDate = JOptionPane.showInputDialog(null, message, "Return Date", JOptionPane.PLAIN_MESSAGE);
                        
                    }else{
                        returnDate = "None";
                    }
                    
                    //display table for ticket price
                    if(selectOrigin == origin[0] && selectDestination == destination[1]){
               
                            // Create the HTML message for the ticket information
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>Ipoh</td>" +
                            "<td>RM16.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>Ipoh</td>" +
                            "<td>RM13.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";

                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[0] && selectDestination == destination[2]){
               
                            // Create the HTML message for the ticket information
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>Kajang</td>" +
                            "<td>RM33.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>Kajang</td>" +
                            "<td>RM30.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";

                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[0] && selectDestination == destination[3]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>RM31.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>RM29.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[1] && selectDestination == destination[2]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Ipoh</td>" +
                            "<td>Kajang</td>" +
                            "<td>RM40.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Ipoh</td>" +
                            "<td>Kajang</td>" +
                            "<td>RM37.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[1] && selectDestination == destination[3]){
               
                            // Create the HTML message for the ticket information
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Ipoh</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>RM39.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Ipoh</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>RM37.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[1] && selectDestination == destination[0]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Ipoh</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>RM16.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Ipoh</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>RM13.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[2] && selectDestination == destination[3]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Kajang</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>RM12.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Kajang</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>RM10.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[2] && selectDestination == destination[1]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Kajang</td>" +
                            "<td>Ipoh</td>" +
                            "<td>RM40.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Kajang</td>" +
                            "<td>Ipoh</td>" +
                            "<td>RM37.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[2] && selectDestination == destination[0]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>Kajang</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>RM33.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>Kajang</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>RM30.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[3] && selectDestination == destination[0]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>RM31.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>Tapah Road</td>" +
                            "<td>RM29.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[3] && selectDestination == destination[1]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>Ipoh</td>" +
                            "<td>RM39.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>Ipoh</td>" +
                            "<td>RM37.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                
                    }else if(selectOrigin == origin[3] && selectDestination == destination[2]){
               
                            message = "<html>" +
                            "<head>" +
                            "<style>" +
                            "table { width: 100%; border-collapse: collapse; }" +
                            "th, td { padding: 10px; text-align: left; border: 1px solid #dddddd; }" +
                            "th { background-color: #4CAF50; color: white; }" +
                            "h2 { color: #4CAF50; text-align: center; }" +
                            ".discount { font-style: italic; color: #ff0000; text-align: center; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h2>Ticket Available</h2>" +
                            "<table>" +
                            "<tr>" +
                            "<th>Ticket Type</th>" +
                            "<th>Origin</th>" +
                            "<th>Destination</th>" +
                            "<th>Price Each Person</th>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Gold</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>Kajang</td>" +
                            "<td>RM12.00</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>Silver</td>" +
                            "<td>KL Sentral</td>" +
                            "<td>Kajang</td>" +
                            "<td>RM10.00</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class='discount'>Child Discount: 20%</div>" +
                            "</body>" +
                            "</html>";
                
                            // Show the ticket information in a JOptionPane
                            JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.PLAIN_MESSAGE);
                            
                    }
                    
                    
                    //input ticket type
                    message = "<html>" +
                     "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Ticket Type</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Select Ticket Type:</p>" +
                         "</html>";
                    
                    String[] optionsTicketType = {"Gold", "Silver"};
                    int optionTicketT = JOptionPane.showOptionDialog(null, message, "Select Ticket Type", 0, JOptionPane.PLAIN_MESSAGE, null, optionsTicketType, optionsTicketType[0]); 
                    
                    if(optionTicketT == 0 ){
                        ticketType = "Gold";
                    }else if(optionTicketT == 1){
                        ticketType = "Silver";
                    }
                    
                    //input package type
                    message = "<html>" +
                    "<img src='file:src/logos.png' width='680' height='350'><br>" +
                         "<h2 style='color: #4CAF50;'>Enter Package Type</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Please Select Package Type:</p>" +
                         "</html>";
                    
                    String[] optionsPackageT = {"🍔 A-have food only", "☕ B-have drink only ", "🍔☕ C-have food and drink", "❌ N-none"};
                    int optionPackageT = JOptionPane.showOptionDialog(null, message, "Select Package Type", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsPackageT, optionsPackageT[0]); 
                    
                    if(optionPackageT == 0){
                        packageType = 'A';
                    }else if(optionPackageT == 1){
                        packageType = 'B';
                    }else if(optionPackageT == 2){
                        packageType = 'C';
                    }else if(optionPackageT == 3){
                        packageType = 'N';
                    }
                    
                    
                   
                    
                    //find if customer is senior citizen
                    while(!customerQ.isEmpty()){
                        
                        obj = customerQ.dequeue();
                        Customer cs = (Customer) obj;
                        
                        if(cs.getAge() >= 60){
                            seniorCitizen = true;
                        }else{
                            seniorCitizen = false;
                        }
                        
                        tempQ.enqueue(cs);
                    }
                    
                    //move to original queue
                    while (!tempQ.isEmpty()) {
                        obj = tempQ.dequeue();
                        customerQ.enqueue(obj);
                    }
                    
                  
                    //find if customer ticket category 
                    while(!customerQ.isEmpty()){
                        
                        obj = customerQ.dequeue();
                        Customer cs = (Customer) obj;
                        
                        if(cs.getAge() >= 18){
                            ticketCategory = 'A';
                        }else{
                            ticketCategory = 'C';
                        }
                        
                        tempQ.enqueue(cs);
                    }
                    
                    //move to original queue
                    while (!tempQ.isEmpty()) {
                        obj = tempQ.dequeue();
                        customerQ.enqueue(obj);
                    }
                    
                    

                    
                    //create object for ticket
                    Ticket tk = new Ticket(ticketType, selectOrigin, selectDestination, departureDate, returnDate, packageType, seniorCitizen, ticketCategory, 0.0, returnOption);
                       
                    //insert ticket data to stack 
                    ticketStack.push(tk);
           
                }
                
                //split queue to another queue (customer)
                Queue adultQ = new Queue();
                Queue childQ = new Queue();
                Queue seniorcitizenQ = new Queue();

                while(!customerQ.isEmpty()){
                    
                    obj = customerQ.dequeue();
                    Customer cs = new Customer();
                    cs = (Customer) obj;
                    
                    if(cs.getAge() >= 60){
                        seniorcitizenQ.enqueue(cs);
                    }
                    
                    if(cs.getAge() >= 18){
                        adultQ.enqueue(cs);
                    }else{
                        childQ.enqueue(cs);
                    }
                    
                    tempQ.enqueue(cs);
                    
                }
                
                //move to original queue
                while(!tempQ.isEmpty()){
                    
                    obj = tempQ.dequeue();
                    customerQ.enqueue(obj);
                }
                
                                
                //convert stack for ticket to queue
                while(!ticketStack.isEmpty()){
                                
                    obj = ticketStack.pop();
                    Ticket tk = new Ticket();
                    tk = (Ticket) obj;
                                
                    tempS.push(tk);
                }
                            
                // move from temp stack to ticket queue
                while(!tempS.isEmpty()){
                                
                    obj = tempS.pop();
                    ticketQ.enqueue(obj);
                }

                boolean menuOption = true;
                
                //customer menu
                while(menuOption){
                    
                    message = "<html>" +
                    "<div style='text-align: center;'>" +  
                    "<h2 style='color: #4CAF50;'>Customer Menu</h2>" + 
                    "<img src='file:src/background.png' width='1250' height='300'><br>" + 
                    "<p style='font-size: 14px; color: #333;'>Please Select:</p>" +
                    "</div>" +  
                     "</html>";
                     
                    String[] optionCust = {"👤 Display Customer", "📝 Edit Customer Information", "🗑 Refund Customer Ticket", "⌕ Search Customer Based on Ticket Type", "💳 Make Payment"};
                    int custOption = JOptionPane.showOptionDialog(null, message, "Customer Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionCust, optionCust[0]);
                     
                    if(custOption == 0){
                        
                        menuOption = true;
                        int no = 1;
                        
               
                        message = "<html>" +
                        "<div style='text-align: center;'>" +  
                        "<h2 style='color: #4CAF50;'>Display Menu</h2>" + 
                        "<img src='file:src/background.png' width='1250' height='300'><br>" + 
                        "<p style='font-size: 14px; color: #333;'>Please Select:</p>" +
                        "</div>" +  
                         "</html>";
                     
                        String[] optionDisplay = {"ⓘ All with ticket info", "18+ Adult", "👶 Child", "👴 Senior Citizen"};
                        int displayCustOption = JOptionPane.showOptionDialog(null, message, "Display Customer", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionDisplay, optionDisplay[0]);
                         
                        if(displayCustOption == 0){
                            
                            String outputCust = "\n\n___________________________________All Customer Information with ticket---------------------------------";
                        
                            
                            
                            //process to display customer info
                            while(!customerQ.isEmpty() && !ticketQ.isEmpty()){
                                obj = customerQ.dequeue();
                                Customer cs = new Customer();
                                cs = (Customer) obj;
                                
                                outputCust = outputCust + "\n\n" + no + ") " + cs.toString();
                                
                                no++;
                                
                                tempQ.enqueue(cs);
                                
                                obj = ticketQ.dequeue();
                                Ticket tk = new Ticket();
                                tk = (Ticket) obj;
                                
                                outputCust += tk.toString();
                                
                                tempTicketQ.enqueue(tk);
                            }
                            
                            //move to original queue
                            while(!tempQ.isEmpty() && !tempTicketQ.isEmpty()){
                    
                                obj = tempQ.dequeue();
                                customerQ.enqueue(obj);
                                
                                obj = tempTicketQ.dequeue();
                                ticketQ.enqueue(obj);
                            }
                            
                            System.out.println(outputCust); 
                            
                        }else if(displayCustOption == 1){
                            
                            String outputCust = "\n\n___________________________________Customer Information for Adult---------------------------------";
                            
                            while(!adultQ.isEmpty()){
                                obj = adultQ.dequeue();
                                Customer cs = new Customer();
                                cs = (Customer) obj;
                                
                                outputCust = outputCust + "\n\n" + no + ") " + cs.toString();
                                
                                no++;
                                
                                tempQ.enqueue(cs);
                            }
                            
                            //move to original queue
                            while(!tempQ.isEmpty()){
                    
                                obj = tempQ.dequeue();
                                adultQ.enqueue(obj);
                            }
                            
                            System.out.println(outputCust); 
                            
                        }else if(displayCustOption == 2){
                            
                            String outputCust = "\n\n___________________________________Customer Information for Child---------------------------------";
                            
                            while(!childQ.isEmpty()){
                                obj = childQ.dequeue();
                                Customer cs = new Customer();
                                cs = (Customer) obj;
                                
                                outputCust = outputCust + "\n\n" + no + ") " + cs.toString();
                                
                                no++;
                                
                                tempQ.enqueue(cs);
                            }
                            
                            //move to original queue
                            while(!tempQ.isEmpty()){
                    
                                obj = tempQ.dequeue();
                                childQ.enqueue(obj);
                            }
                            
                            System.out.println(outputCust); 
                            
                        }else if(displayCustOption == 3){
                            
                            String outputCust = "\n\n___________________________________Customer Information for Senior Citizen---------------------------------";
                            
                            while(!seniorcitizenQ.isEmpty()){
                                obj = seniorcitizenQ.dequeue();
                                Customer cs = new Customer();
                                cs = (Customer) obj;
                                
                                outputCust = outputCust + "\n\n" + no + ") " + cs.toString();
                                
                                no++;
                                
                                tempQ.enqueue(cs);
                            }
                            
                            //move to original queue
                            while(!tempQ.isEmpty()){
                    
                                obj = tempQ.dequeue();
                                seniorcitizenQ.enqueue(obj);
                            }
                            
                            System.out.println(outputCust); 
                            
                        }
                        
                        
                        
                    }else if(custOption == 1){
                        menuOption = true;
                        int no = 1;
                        
                        message = "<html>" +
                        "<h2 style='color: #4CAF50;'>Edit Customer</h2>" + 
                         "<img src='file:src/logos.png' width='300' height='300'>" +
                         "<p style='font-size: 14px; color: #333;'>Enter Customer ID to Edit:</p>" +
                         "</html>";
                 
                        String searchUpdate = JOptionPane.showInputDialog(null, message, "Edit Customer Info", JOptionPane.PLAIN_MESSAGE);
                        
                        while(!customerQ.isEmpty()){
                            
                            obj = customerQ.dequeue();
                            Customer cs = new Customer();
                            cs = (Customer) obj;
                            
                            if(cs.getCustId().equalsIgnoreCase(searchUpdate)){
                                
                                message = "<html>" +
                                "<img src='file:src/logos.png' width='300' height='250'><br>" +
                                 "<h2 style='color: #4CAF50;'>Enter Customer Information</h2>" +
                                 "<p style='font-size: 14px; color: #333;'>Please Enter Customer Name:</p>" +
                                 "</html>";
                         
                                String custName = JOptionPane.showInputDialog(null, message, "Customer Info", JOptionPane.PLAIN_MESSAGE);
           
                                message = "<html>" +
                                "<img src='file:src/logos.png' width='350' height='250'><br>" +
                                "<h2 style='color: #4CAF50;'>Enter Customer Information</h2>" +
                                 "<p style='font-size: 14px; color: #333;'>Please Enter Customer Phone Number:</p>" +
                                 "</html>";
           
                                String custPhoneNum = JOptionPane.showInputDialog(null, message, "Customer Info", JOptionPane.PLAIN_MESSAGE);
           
                    
                                //input gender
                                message = "<html>" +
                                "<img src='file:src/logos.png' width='300' height='250'><br>" +
                                 "<h2 style='color: #4CAF50;'>Enter Gender</h2>" +
                                 "<p style='font-size: 14px; color: #333;'>Please Select Gender:</p>" +
                                 "</html>";
                    
                                String[] optionsGender = {"🚹 Male", "🚺 Female"};
                                int optionGenders = JOptionPane.showOptionDialog(null, message, "Select Ticket Type", 0, JOptionPane.PLAIN_MESSAGE, null, optionsGender, optionsGender[0]); 
                    
                                if(optionGenders == 0){
                                    custGender = 'M';
                                }else if(optionGenders == 1){
                                    custGender = 'F';
                                }
                                
                                
                    
                                //update using setter on customer class
                                cs.setCustName(custName);
                                cs.setCustPhoneNum(custPhoneNum);
                                cs.setGender(custGender);
                                
                                
                                
                                tempQ.enqueue(cs);
                            }else{
                                tempQ.enqueue(cs);
                            }
                        }
                        
                        //move to original queue
                        while(!tempQ.isEmpty()){
                    
                            obj = tempQ.dequeue();
                            customerQ.enqueue(obj);
                            
                        }
                        
                    }else if(custOption == 2){
                        
                        menuOption = true;
               
                        message = "<html>" +
                         "<h2 style='color: #4CAF50;'>Refund Ticket</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Enter Customer Name to refund:</p>" +
                         "</html>";
               
                        String searchRefundName = JOptionPane.showInputDialog(null, message, "Refund Ticket", JOptionPane.PLAIN_MESSAGE);
               
                        message = "<html>" +
                         "<h2 style='color: #4CAF50;'>Refund Ticket</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Enter Customer IC to refund:</p>" +
                         "</html>";
               
                        String searchRefundIC = JOptionPane.showInputDialog(null, message, "Refund Ticket", JOptionPane.PLAIN_MESSAGE);
                        
                        
                        while(!customerQ.isEmpty()){
                            
                            Object objRefundName = customerQ.dequeue();
                            Customer nameRefund = (Customer) objRefundName;
                         
                            Object objRefundIC = ticketQ.dequeue();
                            Ticket ICRefund = (Ticket) objRefundIC;
                            
                            if(nameRefund.getCustName().equalsIgnoreCase(searchRefundName) && nameRefund.getCustIcNum().equalsIgnoreCase(searchRefundIC)){
                                
                                message = "<html>" +
                                 "<h2 style='color: #4CAF50;'>Refund Ticket</h2>" +
                                 "<p style='font-size: 14px; color: #333;'>Ticket Refund Successful</p>" +
                                 "</html>";
                                JOptionPane.showMessageDialog(null, message);
                                pax = pax -1;
                            }else{
                                tempQ.enqueue(nameRefund);
                                tempTicketQ.enqueue(ICRefund);
                            }
                        }
                        
                        while(!adultQ.isEmpty()){
                             Object objRemoveAdult = adultQ.dequeue();
                             Customer adultRefund = (Customer) objRemoveAdult;
                             
                             if(!(adultRefund.getCustName().equalsIgnoreCase(searchRefundName) && adultRefund.getCustIcNum().equalsIgnoreCase(searchRefundIC))){
                                 tempAdultQ.enqueue(adultRefund);
                             }
                        }
                        while(!childQ.isEmpty()){
                             Object objRemoveChild = childQ.dequeue();
                             Customer childRefund = (Customer) objRemoveChild;
                             
                             if(!(childRefund.getCustName().equalsIgnoreCase(searchRefundName) && childRefund.getCustIcNum().equalsIgnoreCase(searchRefundIC))){
                                 tempChildQ.enqueue(childRefund);
                             }
                        }
                        while(!seniorcitizenQ.isEmpty()){
                             Object objRemoveSenior = seniorcitizenQ.dequeue();
                             Customer seniorRefund = (Customer) objRemoveSenior;
                             
                             if(!(seniorRefund.getCustName().equalsIgnoreCase(searchRefundName) && seniorRefund.getCustIcNum().equalsIgnoreCase(searchRefundIC))){
                                 tempSeniorQ.enqueue(seniorRefund);
                             }
                             
                             
                        }
                        
                        //move cust data to original queue
                        while(!tempQ.isEmpty()){
                        
                            obj = tempQ.dequeue();
                            customerQ.enqueue(obj);
                        }
                        while(!tempAdultQ.isEmpty()){
                        
                            obj = tempAdultQ.dequeue();
                            adultQ.enqueue(obj);
                        }
                        while(!tempChildQ.isEmpty()){
                        
                            obj = tempChildQ.dequeue();
                            childQ.enqueue(obj);
                        }
                        while(!tempSeniorQ.isEmpty()){
                        
                            obj = tempSeniorQ.dequeue();
                            seniorcitizenQ.enqueue(obj);
                        }
               
               
                        //move cust data to original Queue
                        while(!tempTicketQ.isEmpty()){
                        
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }
                        
                    }else if(custOption == 3){
                        
                        menuOption = true;
                        String searchTicketType = null;
                        
                        message = "<html>" +
                        "<div style='text-align: center;'>" +  
                        "<h2 style='color: #4CAF50;'>Customer Menu</h2>" + 
                        "<img src='file:src/background.png' width='1250' height='300'><br>" + 
                        "<p style='font-size: 14px; color: #333;'>Please Select:</p>" +
                        "</div>" +  
                         "</html>";
                     
                        String[] optionSearch = {"Gold", "Silver"};
                        int searchOption = JOptionPane.showOptionDialog(null, message, "Select Ticket Type", 0, JOptionPane.PLAIN_MESSAGE, null, optionSearch, optionSearch[0]); 
                        
                        if(searchOption == 0){
                            searchTicketType = "Gold";
                        }else if(searchOption == 1){
                            searchTicketType = "Silver";
                        }
                        
                        
                        int no = 0;
                        String outputSearch = "\n\nList Customer Information " + searchTicketType + " Ticket Type\n-----------------------------------------------\n";
                  
               
                        boolean found = false;
                        Ticket searchFound = new Ticket();
                        Customer searchCust = new Customer();
                    
                        
                        while(!customerQ.isEmpty() && !ticketQ.isEmpty()){
                            obj = ticketQ.dequeue();
                            Object objc = customerQ.dequeue();
                            
                            Ticket tk = (Ticket) obj;
                            Customer cs = (Customer) objc;
                            
                            if(tk.getTicketType().equalsIgnoreCase(searchTicketType)){
                                found = true;
                                no++;
                                searchFound = tk;
                                searchCust = cs;
                                outputSearch += "\n\n" + no + ") " + searchCust.toString() + "\n" + searchFound.toString();
                            }
                            
                            tempQ.enqueue(cs);
                            tempTicketQ.enqueue(tk);
                        }
                        
                        //move back to orignial queue
                        while(!tempQ.isEmpty()){
                        
                            obj = tempQ.dequeue();
                            customerQ.enqueue(obj);
                        }
                        while(!tempTicketQ.isEmpty()){
                        
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }
                        
                        if(found){
                            System.out.println(outputSearch);
                        }else{
                            JOptionPane.showMessageDialog(null, "NOT FOUND", "Search", JOptionPane.PLAIN_MESSAGE);
                        }
                        
                    }else if(custOption == 4){
                        menuOption = false;
                        
                        //create random
                        Random random = new Random();
               
                        message = "<html>" +
                         "<h2 style='color: #4CAF50;'>Payment</h2>" +
                         "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<p style='font-size: 14px; color: #333;'>Make Payment</p>" +
                         "</html>";
                        // make a payment
                        JOptionPane.showMessageDialog(null, message, "Payment", JOptionPane.PLAIN_MESSAGE);
                
                        //generate random transaction id
                        // create a string of all characters
                        String alphabet = "abcdefghijklmnopqrstuvwxyz123456789";
                
                        // specify length of random string
                        int length = 10;
                
                        // create object for String builder class
                        StringBuilder sbTicket = new StringBuilder();

                        for(int i = 0; i < length; i++) {

                            // generate random index number
                            int index = random.nextInt(alphabet.length());

                            // get character specified by index
                            // from the string
                            char randomChar = alphabet.charAt(index);

                            //append the character to string builder
                            sbTicket.append(randomChar);
                        } 

                        String transactionID = sbTicket.toString();
                 
                        //create object for payment date use class localDate
                        LocalDate paymentDate = LocalDate.now();
                        
                        message = "<html>" +
                         "<h2 style='color: #4CAF50;'>Payment</h2>" +
                         "<img src='file:src/logos.png' width='300' height='250'><br>" +
                         "<p style='font-size: 14px; color: #333;'>Enter Bank Name:</p>" +
                         "</html>";
                        String bankName =  JOptionPane.showInputDialog(null, message, "Payment", JOptionPane.PLAIN_MESSAGE);
               
                        //calculate price for each customer
                        while(!ticketQ.isEmpty()){
                            obj= ticketQ.dequeue();
                            Ticket tk = (Ticket) obj;
                            
                            amount = tk.calcPrice(tk.getReturnOption());
                            tk.setAmount(amount);
                            
                            tempTicketQ.enqueue(tk);
                        }
                        //move to original queue
                        while(!tempTicketQ.isEmpty()){
                        
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }
                        
                        //print receipt
                        while(!customerQ.isEmpty() || !ticketQ.isEmpty()){
                            
                            Object objC = customerQ.dequeue();
                            Object objT = ticketQ.dequeue();
                            
                            Customer cs = (Customer) objC;
                            Ticket tk = (Ticket) objT;
                            
                            tk.printReceipt(cs.getCustName(), transactionID, paymentDate, bankName, tk.getAmount());
                            
                            tempQ.enqueue(cs);
                            tempTicketQ.enqueue(tk);
                        }
                        //move to original queue
                        while(!tempTicketQ.isEmpty()){
                        
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }
                        //move to original queue
                        while(!tempQ.isEmpty()){
                        
                            obj = tempQ.dequeue();
                            customerQ.enqueue(obj);
                        }


                        
                        //calculate total payment
                        while(!ticketQ.isEmpty()){
                            
                            obj = ticketQ.dequeue();
                            Ticket tk = (Ticket) obj;
                            
                            totalPayment = totalPayment + tk.getAmount();
                            
                            tempTicketQ.enqueue(tk);
                        }
                        //move to original queue
                        while(!tempTicketQ.isEmpty()){
                        
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }

                        
                        //display output for total payment      
                        System.out.println("\n\n\n-----------------------------------------------------------------------------------------");
                        System.out.println("                                      Payment                                              ");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("Total amount to pay: RM" + df.format(totalPayment));
                        System.out.println("Total ticket       :   " + pax);
                        System.out.println("-----------------------------------------------------------------------------------------");
                        
                        // HTML and CSS for styling
                        String htmlContent = "<html>"
                         + "<head>"
                         + "<style>"
                         + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; color: #333; }"
                         + ".receipt { width: 300px; margin: 20px auto; padding: 15px; border: 1px solid #ccc; border-radius: 8px; background: white; box-shadow: 0 0 10px rgba(0,0,0,0.1); }"
                         + ".logo { text-align: center; }"
                         + ".logo img { width: 100px; }"
                         + "h2 { text-align: center; color: #007BFF; margin-bottom: 10px; }"
                         + "p, .item { font-size: 14px; line-height: 1.4; }"
                         + ".item { margin: 5px 0; }"
                         + ".total { font-weight: bold; font-size: 16px; margin-top: 15px; }"
                         + ".footer { text-align: center; margin-top: 20px; font-size: 12px; }"
                         + ".thank-you { font-weight: bold; }"
                         + "</style>"
                         + "</head>"
                         + "<body>"
                         + "<div class='receipt'>"
                         + "<div class='logo'><img src='file:src/logos.png' width='100' height='100'></div>" // Placeholder for logo
                         + "<h2>Receipt</h2>"
                         + "<p>-----------------------------------------------------------------------------------------</p>"
                         + "<div class='item'>Total Amount to Pay: RM<strong>" + df.format(totalPayment) + "</strong></div>"
                         + "<div class='item'>Total Tickets: <strong>" + pax + "</strong></div>"
                         + "<p>-----------------------------------------------------------------------------------------</p>"
                         + "<div class='total'>Thank you for your purchase!</div>"
                         + "<div class='footer'>"
                         + "<p>Terms and conditions apply.</p>"
                         + "<p>For inquiries, contact us at trainconnect@gmail.com</p>"
                         + "</div>"
                         + "</div>"
                         + "</body>"
                         + "</html>";

                        // Displaying the HTML in a JOptionPane
                        JTextPane textPane = new JTextPane();
                        textPane.setContentType("text/html");
                        textPane.setText(htmlContent);
                        textPane.setEditable(false);

                        JOptionPane.showMessageDialog(null, textPane, "Payment Receipt", JOptionPane.PLAIN_MESSAGE);
                    }
                    
                }
                
            }else if(site ==1){
                
                //admin site
                boolean menuOption = true;
                
                while(menuOption){
                    
                    message = "<html>" +
                    "<center><h2 style='color: #4CAF50;'>Admin Menu</h2></center>" + 
                    "<center><img src='file:src/logos.png' width='1200' height='500'><center>" +
                    "<p style='font-size: 14px; color: #333;'>Please Select:</p>" +
                    "</html>";
           
                    String[] optionAdmin = {"Average", "Maximum", "Minimum", "Total sold for each ticket type", "Infix to Postfix", "Exit"};
                    int adminOption = JOptionPane.showOptionDialog(null, message, "Admin Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionAdmin, optionAdmin[0]);
                    
                    if(adminOption == 0){
                        
                        menuOption = true;
                        average = totalPayment / pax;
                        message = "<html>" + "<img src='file:src/logos.png' width='300' height='250'><br>" + "<center><h2 style='color: #4CAF50;'>Average Sales</h2></center>" + "Average Sales: RM" + df.format(average);
                        JOptionPane.showMessageDialog(null, message, "Average", JOptionPane.PLAIN_MESSAGE);
                        
                    }else if(adminOption == 1){
                        
                        menuOption = true;
                        
                        //find maximum or highest ticket amount
                        
                        while(!ticketQ.isEmpty() && !customerQ.isEmpty()){
                            
                            obj = ticketQ.dequeue();
                            Ticket t = (Ticket) obj;
                            
                            Object objc = customerQ.dequeue();
                            Customer c = (Customer) objc;
                            
                            if(t.getAmount() > amountMax){
                                amountMax = t.getAmount();
                                outputMax = t.toString();
                                outputMax2 = c.toString();
                            }
                            
                            tempQ.enqueue(c);
                            tempTicketQ.enqueue(t);
                        }
                        
                        //move to original queue
                        while(!tempQ.isEmpty()){
                            obj = tempQ.dequeue();
                            customerQ.enqueue(obj);
                        }
                        
                        while(!tempTicketQ.isEmpty()){
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }
                        
                        message = "<html>" + "<center><h2 style='color: #4CAF50;'>Customer Information that have highest Amount for Ticket</h2></center>" + "\n\n" + " " + outputMax2 + outputMax + "\n" + " "+ "  RM" + df.format(amountMax);
                        JOptionPane.showMessageDialog(null, message, "Maximum", JOptionPane.PLAIN_MESSAGE);
                        
                    }else if(adminOption == 2){
                        
                        menuOption = true;
                        
                        //find minimum or lowest ticket amount
                        
                        while(!ticketQ.isEmpty() && !customerQ.isEmpty()){
                            
                            obj = ticketQ.dequeue();
                            Ticket t = (Ticket) obj;
                            
                            Object objc = customerQ.dequeue();
                            Customer c = (Customer) objc;
                            
                            if(t.getAmount() < amountMin){
                                amountMin = t.getAmount();
                                outputMin = t.toString();
                                outputMin2 = c.toString();
                            }
                            
                            tempQ.enqueue(c);
                            tempTicketQ.enqueue(t);
                        }
                        
                        //move to original queue
                        while(!tempQ.isEmpty()){
                            obj = tempQ.dequeue();
                            customerQ.enqueue(obj);
                        }
                        
                        while(!tempTicketQ.isEmpty()){
                            obj = tempTicketQ.dequeue();
                            ticketQ.enqueue(obj);
                        }
                        
                        message = "<html>" + "<center><h2 style='color: #4CAF50;'>Customer Information that have lowest Amount for Ticket</h2></center>" + "\n\n" + " " + outputMin2 + outputMin + "\n" + " "+ "  RM" + df.format(amountMin);
                        JOptionPane.showMessageDialog(null, message, "Minimum", JOptionPane.PLAIN_MESSAGE);
                        
                    }else if(adminOption == 3){
                        
                        menuOption = true;
                        
                        //convert queue for ticket to stack
                        while(!ticketQ.isEmpty()){
                                
                            obj = ticketQ.dequeue();
                            Ticket tk = new Ticket();
                            tk = (Ticket) obj;
                                
                            tempTicketQ.enqueue(tk);
                        }
                            
                        // move from temp queue to ticket stack
                        while(!tempTicketQ.isEmpty()){
                                
                            obj = tempTicketQ.dequeue();
                            ticketStack.push(obj);
                        }
                        
                        //split stack to another stack (ticket)
                        Stack goldStack = new Stack();
                        Stack silverStack = new Stack();
                        Stack tempStack = new Stack();
                        
                        int countGold = 0;
                        int countSilver = 0;
                
                        while(!ticketStack.isEmpty()){
                    
                            obj = ticketStack.pop();
                            Ticket tk = (Ticket) obj;
                    
                            if(tk.getTicketType().equalsIgnoreCase("Gold")){
                                goldStack.push(tk);
                                countGold++;
                            }else if(tk.getTicketType().equalsIgnoreCase("Silver")){
                                silverStack.push(tk);
                                countSilver++;
                            }
                    
                            tempStack.push(tk);
                        }
                
                        //move to original stack
                        while(!tempStack.isEmpty()){
                            ticketStack.push(tempStack.pop());
                        }
                        
                        String[] optionCount = {"Total Gold", "Total Silver"};
                        int countOption = JOptionPane.showOptionDialog(null, message, "Total Ticket Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionCount, optionCount[0]);

                        if(countOption == 0){
                            message = "<html>" + "<img src='file:src/logos.png' width='300' height='250'><br>" + "<center><h2 style='color: #4CAF50;'>Total Gold Ticket</h2></center>" + "Total Gold Ticket: " + countGold + " tickets";
                            JOptionPane.showMessageDialog(null, message, "Total Gold Ticket", JOptionPane.PLAIN_MESSAGE);
                        }else if(countOption == 1){
                            message = "<html>" + "<img src='file:src/logos.png' width='300' height='250'><br>" + "<center><h2 style='color: #4CAF50;'>Total Silver Ticket</h2></center>" + "Total Silver Ticket: " + countSilver + " tickets";
                            JOptionPane.showMessageDialog(null, message, "Total Silver Ticket", JOptionPane.PLAIN_MESSAGE);
                        }
                        
                        
                        
                        
                    }else if(adminOption == 4){
                        
                        menuOption = true;
                        
                        //expression conversion
                        message = "<html>" +
                         "<img src='file:src/logos.png' width='350' height='250'><br>" +
                         "<h2 style='color: #4CAF50;'>Convert Infix to Postfix</h2>" +
                         "</html>";

                        // Show the input dialog with the HTML content
                        JOptionPane.showMessageDialog(null, message, "Expression Conversion", JOptionPane.PLAIN_MESSAGE);
                        
                        message = "<html>" +
                         "<h2 style='color: #4CAF50;'>Infix to Postfix</h2>" +
                         "<p style='font-size: 14px; color: #333;'>Enter infix expression:</p>" +
                         "</html>";
                         
                        String outputExpression = "";
                        InfixToPostfix ec = new InfixToPostfix();
                        
                        String infix =  JOptionPane.showInputDialog(null, message, "Expression Conversion", JOptionPane.PLAIN_MESSAGE);
                        
                        outputExpression += ec.toPostfix(infix);
                        
                        message = "<html>" + "<img src='file:src/logos.png' width='300' height='250'><br>" + "<center><h2 style='color: #4CAF50;'>Infix to Postfix</h2></center>" + 
                        "Postfix Expression: " + outputExpression;
                        JOptionPane.showMessageDialog(null, message, "Expression Conversiono", JOptionPane.PLAIN_MESSAGE);
                        
                        
                        
                        
                    }else if(adminOption == 5){
                        menuOption = false;
                    }
                }
                
            }else if(site == 2){

                message = "<html>" +
                 "<center><h2 style='color: #4CAF50;'>Thank you for purchase!</h2></center>" + 
                 "<center><img src='file:src/logos.png' width='300' height='300'><center>" +
                 "<p style='font-size: 14px; color: #333;'>Please Come Again</p>" +
                 "</html>";
                JOptionPane.showMessageDialog(null, message, "Exit", JOptionPane.PLAIN_MESSAGE);
           
                whichsite = false;
            }
        }
        
    }
}