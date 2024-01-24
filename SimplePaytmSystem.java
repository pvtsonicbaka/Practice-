import java.util.Scanner;

public class SimplePaytmSystem {
    public String name,Month,username,address;
    private String password;
    public long phone_number,year,day;

    private  double bankBalance = 10000.0; // Initial bank balance
    private double upiBalance = 5000.0;   // Initial UPI balance
    private double paytm_balance ;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter NUmber Of users To Enter");
        int n = scanner.nextInt();
        SimplePaytmSystem users[] = new SimplePaytmSystem[n];
        for(int i =0;i<users.length;i++){
            users[i] = new SimplePaytmSystem();
            users[i].createUser(users,i);

        }
        do{
            System.out.println("enter user index to login and -1 to exit");
            int temp ;
            temp = scanner.nextInt();
            scanner.nextLine();
            if(temp < users.length && temp>=-1){
                if (temp==-1){
                    break;
                }
                System.out.println("enter password");
                String pass = scanner.nextLine();
                if(pass.equals(users[temp].password)){
                    users[0].menu(users[temp]);
                }
                else{
                System.out.println("invalid pass");
                }
        }
            else{
                System.out.println("invalid");
            }


        }
        while( true);
       
        
    }
    void display(SimplePaytmSystem user){
        System.out.println("name :");
        System.out.println("age");
        System.out.println("mobile number:");
        System.out.println("account balance:"+user.paytm_balance);
        System.out.println("address:");
        System.out.println("Date Of Birth:");
        // System.out.println();
        // System.out.println();
        // System.out.println();
    }

    private void menu(SimplePaytmSystem user){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manualEntry(scanner,this);
                    break;
                case 2:
                    rechargeOptions(scanner,this);
                    break;
                case 3:
                    rechargePacks(scanner,this);
                    break;
                // case 4:
                //     billPayment(scanner);
                //     break;
                case 4:
                    upiTransfer(scanner,this);
                    break;
                case 5:
                    display(this);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    Scanner sc  = new Scanner(System.in);
    private  void createUser(SimplePaytmSystem user[] ,int i){
        System.out.println("Enter name");
        user[i].name = sc.next();
        System.out.println("phone number");
        user[i].phone_number = sc.nextLong();
        while(true){
            System.out.println("enter day");{
                user[i].day  = sc.nextInt();
            }
            if(day <=31 && day >0){
                break;
            }
        }
        System.out.print("Enter the month (1-12): ");
        int n = sc.nextInt();
        user[i].Month = month(this, n);
        System.out.println("month"+Month);
        System.out.println("Enter Year");
        user[i].year = sc.nextInt();
        
        System.out.println("Enter password of length 8");
        String temp ;
        while(true){

        do{
            user[i].password = sc.nextLine();
            if(password.length() !=8){
                System.out.println("type 8 digit pass");
            }
        }
        while(password.length() != 8);
            System.out.println("confirm pasword:");
            temp = sc.nextLine();
            if(temp.equals(password)){
                break;
            }
            else{
                System.out.println("incorrect password");
            }
        }
            System.out.println("enter initial balance");
            user[i].paytm_balance = sc.nextInt();
            user[i].bankBalance = 10000.0; // Initial bank balance
            user[i]. upiBalance = 5000.0;   // Initial UPI balance
            
    }
    
    private static String month(SimplePaytmSystem s,int n){
        
        switch (n) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return null;
        }

    }

    private static void displayMenu() {
        System.out.println("\nPaytm System");
        System.out.println("1. Manual Entry");
        System.out.println("2. Recharge Options");
        System.out.println("3. Recharge Packs");
        
        System.out.println("4. UPI Transfer");
        System.out.println("5 for displaying deatils of your account:");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private  void manualEntry(Scanner scanner,SimplePaytmSystem user) {
        System.out.println("\nManual Entry");
        System.out.print("Enter amount to top up: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Choose payment option:");
        System.out.println("1. Card Payment");
        System.out.println("2. UPI Payment");
        System.out.print("Enter your choice: ");

        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (paymentChoice) {
            case 1:
                cardPayment(amount, scanner,this);
                break;
            case 2:
                upiPayment(amount, scanner,this);
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
        }
    }

    private void cardPayment(double amount, Scanner scanner,SimplePaytmSystem user) {
        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();

        
        System.out.println("Card Payment successful. Deducted Rs. " + amount);
        user.bankBalance -= amount;
        user.paytm_balance += amount;
    }   

    private  void upiPayment(double amount, Scanner scanner,SimplePaytmSystem user) {
        System.out.print("Enter UPI Password: ");
        String upiPassword = scanner.nextLine();

        
        System.out.println("UPI Payment successful. Deducted Rs. " + amount);
        user.upiBalance -= amount;
        user.paytm_balance+= amount;
    }

    private void rechargeOptions(Scanner scanner,SimplePaytmSystem user) {
        while (true) {
            System.out.println("Recharge Menu");
            System.out.println("1. Recharge with Bank");
            System.out.println("2. Recharge with Paytm");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rechargeWithBank(scanner,user);
                    break;
                case 2:
                    rechargeWithPaytm(scanner,user);
                    break;
                case 3:
                    checkBalance(user);
                    break;
                case 4:
                    System.out.println("Exiting Recharge Menu. ");
                    menu(user);
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
       
    }

    private void rechargePacks(Scanner scanner,SimplePaytmSystem user) {
        while (true) {
            System.out.println("Airtel Recharge Menu");
            System.out.println("1. Recharge Talktime ");
            System.out.println("2. Recharge Data Pack");
            System.out.println("3. Recharge SMS Pack");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Recharge Talktime selected \n5$ for 3 days\n7$ for 6 days \n10$ for 20 days");
                   
                    break;
                case 2:
                    System.out.println("Recharge Data Pack selected \n10$ for 2days \n15$ for 5days \n20$ for 10days");
                   
                    break;
                case 3:
                    System.out.println("Recharge SMS Pack selected \n17$ for 15days \n28 for a month \n100 for a year");
                    
                    break;
                
                case 4:
                    System.out.println("Exiting Airtel Recharge Menu.");
                    menu(user);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        
    }

    
    private void upiTransfer(Scanner scanner,SimplePaytmSystem user) {
        System.out.println("Welcome to Bank Money Transfer Simulation!");

        System.out.print("Enter sender's bank account number: ");
        String senderAccountNumber = scanner.nextLine();

        System.out.print("Enter recipient's bank account number: ");
        String recipientAccountNumber = scanner.nextLine();
        
        System.out.print("Enter the transfer amount: ");
        double amount = scanner.nextDouble();
        System.out.println("press 1 to transfer in paytm:\nPress 2 to transfer in User bank:");
        int n  = scanner.nextInt();
        
        switch (n) {
            case 1:
                user.paytm_balance+= amount;
                System.out.println("New paytmBalance:"+user.paytm_balance);
                break;
                
                
            case 2:
                user.bankBalance+=amount;
                System.out.println("New bankBalance:"+user.bankBalance);
                
            default:
                System.out.println("invalid returning to the menu");
                menu(user);
                break;
        }
        
        
    }
    private static void rechargeWithBank(Scanner scanner,SimplePaytmSystem user) {
        System.out.println("Recharge with Bank selected");
        
        System.out.println("Enter the amount to recharge: ");
        
        double amount = scanner.nextDouble();
        user.bankBalance -= amount;

        System.out.println("Recharged $" + amount + " with Bank\nNew Bank Balance:"+user.bankBalance);
    }

    private static void rechargeWithPaytm(Scanner scanner,SimplePaytmSystem user) {
        System.out.println("Recharge with Paytm selected");
        System.out.println("Enter the amount to recharge: ");
        
        double amount = scanner.nextDouble();
        user.paytm_balance -= amount;
        System.out.println("Recharged $" + amount + " with Paytm \nNew balance"+user.paytm_balance);
    }

    private static void checkBalance(SimplePaytmSystem user) {
       
        
        System.out.println("Your balance is $" + user.paytm_balance+"\nbank balance:"+ user.bankBalance);
    }
    
}
