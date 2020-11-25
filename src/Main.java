import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static public ArrayList<restaurant> rdata = new ArrayList<>();

    static int finalId = 1;
    private static restaurant r;
    //cart c=new cart();
    private static cart c = new cart();
    private static double CompanyAsset=0;
    private static int deliveryCollected=0;

    static public HashMap<Integer, customer> cdata = new HashMap<>();
    private static List<fooditem> recentList=new ArrayList<>();


    static Scanner sc = new Scanner(System.in);


    public static void restaurantOwner() {

        System.out.println("Choose Restaurant");
        System.out.println("1) Shah - Authentic");
        System.out.println("2) Ravi's");
        System.out.println("3) The Chinese - Authentic");
        System.out.println("4) Wang's - Fastfood");
        System.out.println("5) Paradise");
        int n = sc.nextInt();

        int check = 1;
        do {
            System.out.println("Welcome" + rdata.get(n - 1).getName());
            System.out.println("1) Add item");
            System.out.println("2) Edit item");
            System.out.println("3) Print Rewards");
            System.out.println("4) Discount on bill value");
            System.out.println("5) exit");
            int n1 = sc.nextInt();
            switch (n1) {
                case 1:
                    addItem(n);
                    break;
                case 2:
                    editItem(n);
                    break;
                case 3:
                    printRewards(n);
                    break;
                case 4:
                    discountBill(n);
                    break;
                case 5:
                    check = 0;
                    break;
            }

        } while (check == 1);

    }

    public static void addItem(int serial) {
        System.out.println(" Enter Food name");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Item Price");
        int price = sc.nextInt();
        System.out.println("Item Quantity");
        int quantity = sc.nextInt();
        System.out.println("Item Category");
        String category = sc.next();
        System.out.println("Offer");
        int offer = sc.nextInt();
        fooditem f = new fooditem(finalId, name, price, quantity, offer, category);
        f.display();
        rdata.get(serial - 1).getList1().add(f);
        finalId++;


    }
    public static void editItem(int serial) {
        rdata.get(serial - 1).dispAllFood();
        int n = sc.nextInt();
        System.out.println("Choose an attribute to edit");
        System.out.println("1) Name");
        System.out.println("2) Price");
        System.out.println("3) Quantity");
        System.out.println("4) Category");
        System.out.println("5) Offer");
        int change = sc.nextInt();
        switch (change) {
            case 1:
                System.out.println("Enter new name:");
                String name = sc.next();
                rdata.get(serial - 1).editName(n, name);
                break;
            case 2:
                System.out.println("Enter new Price:");
                int price = sc.nextInt();
                rdata.get(serial - 1).editPrice(n, price);
                break;
            case 3:
                System.out.println("Enter new Quantity:");
                int quantity = sc.nextInt();
                rdata.get(serial - 1).editQuantity(n, quantity);
                break;
            case 4:
                System.out.println("Enter new Category:");
                String category = sc.next();
                rdata.get(serial - 1).editCategory(n, category);
                break;
            case 5:
                System.out.println("Enter new offer:");
                int offer = sc.nextInt();
                rdata.get(serial - 1).editOffer(n, offer);
                break;

        }
        rdata.get(serial - 1).dispFood(n);
    }
    public static void printRewards(int serial) {
        System.out.println("Reward Points: " + rdata.get(serial - 1).getRewards());


    }
    public static void discountBill(int serial) {
        System.out.println("Enter offer on the total bill value - ");
        int dis = sc.nextInt();
        if ( Authentic.class.isInstance(rdata.get(serial - 1)) ) {
            Authentic authentic = (Authentic) rdata.get(serial - 1);
            authentic.setDiscount(dis);

        } else if ( Fast.class.isInstance(rdata.get(serial - 1)) ) {
            Fast fast = (Fast) rdata.get(serial - 1);
            fast.setDiscount(dis);
        } else {
            //no discount given to regular restaurant;
        }


    }
//---------
    public static void asCustomer() {
        System.out.println("1) Ram -Elite");
        System.out.println("2) Sam -Elite");
        System.out.println("3) Tim - Special");
        System.out.println("4) Kim");
        System.out.println("5) Jim");
        int n = sc.nextInt();
        System.out.println("Welcome " + cdata.get(n).getName());
        int check = 1;
        do {
            System.out.println("1) Select Restaurant");
            System.out.println("2) Checkout cart");
            System.out.println("3) Reward won");
            System.out.println("4) Print the recent order ");
            System.out.println("5) Exit");
            int n1 = sc.nextInt();
            switch (n1) {
                case 1:
                    selection(n);
                    break;
                case 2:
                    checkOutCart(n);
                    break;
                case 3: rewardWon(n);
                    break;
                case 4:printrecent();
                    break;
                case 5:
                    check = 0;
                    break;
            }


        } while (check == 1);

    }

    public static void selection(int n) {
        System.out.println("Choose Restaurant");
        System.out.println("1) Shah - Authentic");
        System.out.println("2) Ravi's");
        System.out.println("3) The Chinese - Authentic");
        System.out.println("4) Wang's - Fastfood");
        System.out.println("5) Paradise");
        int choice = sc.nextInt();
        if(!rdata.get(choice-1).getList1().isEmpty()) {
            System.out.println("Choose item by code");
            for (fooditem f : rdata.get(choice - 1).getList1()) {
                System.out.println(f.getID() + " " + rdata.get(choice - 1).getName() + " - " + f.getName() + " " + f.getPrice() + " " + f.getQuantity() + " " + f.getOffer() + "% off " + f.getCategory());

            }
            int select = sc.nextInt();
            System.out.println("Enter item quantity");
            int quantity = sc.nextInt();
            for (fooditem f : rdata.get(choice - 1).getList1()) {
                if ( f.getID() == select ) {
                    fooditem f1 = new fooditem(f.getID(), f.getName(), f.getPrice(), quantity, f.getOffer(), f.getCategory());
                    c.getCartlist().add(f1);
                    f.setQuantity(f.getQuantity() - quantity);
                    break;
                }
            }
            c.setRcode(choice);
            System.out.println("Items added to cart");
            rdata.get(choice-1).setNumOrders(quantity);

        }

    }
    public static void checkOutCart(int n) {

        double initialAmount = 0;
        int deliveryCharge=0;
        System.out.println("Items in cart -");
        int count = 0;
        for (fooditem f : c.getCartlist()) {
            System.out.println(f.getID() + rdata.get(c.getRcode() - 1).getName() + " - " + f.getName() + " " + f.getPrice() + " " + f.getQuantity() + " " + f.getOffer() + "% off ");
            initialAmount += f.getPrice() * f.getQuantity();
            initialAmount -= initialAmount * f.getOffer() / 100;
            count++;
            recentList.add(f);


        }

        if ( Authentic.class.isInstance(rdata.get(c.getRcode() - 1))){
                initialAmount-=initialAmount*rdata.get(c.getRcode() - 1).getDiscount()/100;
                if( initialAmount > 100 ) {
                     initialAmount-= 50;
                }
        }
        if(Fast.class.isInstance(rdata.get(c.getRcode()-1))){
            initialAmount-=initialAmount*rdata.get(c.getRcode() - 1).getDiscount()/100;
        }

        if ( Elite.class.isInstance(cdata.get(n)) ) {

            if ( initialAmount > 200 ) {
                initialAmount-= 50;
            }

        } else if ( Special.class.isInstance(cdata.get(n)) ) {

            if ( initialAmount  > 200 ) {
                initialAmount-= 25;
            }
            deliveryCharge+= 20;

        } else {
            deliveryCharge+= 40;
        }
        deliveryCollected+=deliveryCharge;
        System.out.println("Delivery Charges - "+deliveryCharge+ "/-");
        initialAmount+=deliveryCharge;
        System.out.println("Total order value - " + initialAmount+ "/-");
        int a=cdata.get(n).getReward();
        double b=initialAmount-a;
        if(b>0){
            initialAmount-=a;
            System.out.println("reward point used-"+cdata.get(n).getReward());
            cdata.get(n).removeReward(a);
        }
        else{
            initialAmount=0;
            System.out.println("reward point used-"+cdata.get(n).getReward());
            cdata.get(n).removeReward((int) initialAmount);
        }

        System.out.println("1)Proceed to checkout");
        int choice = sc.nextInt();
        if ( choice == 1 && initialAmount < cdata.get(n).getAccountBal() ) {
            System.out.println(count + " items successfully bought for INR " + initialAmount + "/-");
            cdata.get(n).setAccountBal(initialAmount);
        }
        CompanyAsset+=1*initialAmount/100;



        if ( Fast.class.isInstance(rdata.get(c.getRcode() - 1)) ) {
            int Rvalue = (int) initialAmount / 150;
            rdata.get(c.getRcode() - 1).setRewards(10 * Rvalue);
            cdata.get(n).setReward(10*Rvalue);
        }
        else if ( Authentic.class.isInstance(rdata.get(c.getRcode() - 1)) ) {
            int Rvalue = (int) initialAmount / 200;
            rdata.get(c.getRcode() - 1).setRewards(25 * Rvalue);
            cdata.get(n).setReward(25*Rvalue);
        }
        else {
            int Rvalue = (int) initialAmount / 100;
            rdata.get(c.getRcode() - 1).setRewards(5 * Rvalue);
            cdata.get(n).setReward(5*Rvalue);


        }
        c.emptyCart();

    }
    public static void rewardWon(int n){
        System.out.println("Reward won- "+cdata.get(n).getReward());

    }
    public static  void printrecent(){
        for (fooditem f:recentList) {
            System.out.println(f.getID()+" "+f.getName()+" "+f.getQuantity()+" "+f.getPrice()+" "+f.getCategory());

        }


    }
//----------
    public static void checkUserDetails(){
        System.out.println("1)Customer list");
        System.out.println("2)Restaurant list");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println("1) Ram");
            System.out.println("2) Sam");
            System.out.println("3) Tim");
            System.out.println("4) Kim");
            System.out.println("5) Jim");

            int choice2=sc.nextInt();
            cdata.get(choice2).display();
        }
        if(choice==2){
            System.out.println("1) Shah");
            System.out.println("2) Ravi's");
            System.out.println("3) The Chinese");
            System.out.println("4) Wang's");
            System.out.println("5) Paradise");
            int choice2=sc.nextInt();
            rdata.get(choice2-1).display();
        }
    }
//----------
    public static void checkCompanyDetails(){
        System.out.println("Total comapany Balance - INR "+CompanyAsset+"/-");
        System.out.println("Total delivery charges collected - INR "+deliveryCollected+"/-");
    }

    public static void main(String[] args) {

        rdata.add(new Authentic("Shah", "Delhi"));
        rdata.add(new restaurant("Ravi's", "Pune"));
        rdata.add(new Authentic("The Chinese", "Chennai"));
        rdata.add(new Fast("Wang's", "Bangalore"));
        rdata.add(new restaurant("Paradise", "Patna"));

        cdata.put(1, new Elite("Ram", "delhi", 1000));
        cdata.put(2, new Elite("Sam", "punjab", 1000));
        cdata.put(3, new Special("Tim", "jammu", 1000));
        cdata.put(4, new customer("Kim", "kerala", 1000));
        cdata.put(5, new customer("Jim", "jaipur", 1000));


        boolean check = true;
        do {
            System.out.println("Welcome to Zotato:");
            System.out.println("1) Enter as Restaurant Owner");
            System.out.println("2) Enter as customer");
            System.out.println("3) Check user details");
            System.out.println("4) Company account details");
            System.out.println("5) Exit");

            int n = sc.nextInt();

            switch (n) {

                case 1:
                    restaurantOwner();
                    break;
                case 2:
                    asCustomer();
                    break;
                case 3: checkUserDetails();
                    break;
                case 4:checkCompanyDetails();
                    break;
                case 5:
                    check = false;
                    break;

            }
        } while (check);


    }
}
