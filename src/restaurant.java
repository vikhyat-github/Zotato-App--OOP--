import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class restaurant implements personUser {
    private final String name;
    private final String address;
    private int numOrders;
    private int rewards=0;
    protected  int discount=0;



    private List<fooditem> list1=new ArrayList<>();

    public  List<fooditem> getList1() {
        return list1;
    }

    public restaurant(String name, String address) {
        this.name =name;
        this.address =address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders+= numOrders;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards+= rewards;
    }

    public void dispAllFood(){
        for (fooditem f:list1) {
            System.out.println(f.getID()+" "+name+" - "+f.getName()+" "+f.getPrice()+" "+f.getQuantity()+" "+f.getOffer()+"% off "+f.getCategory() );
         }
    }
    public void dispFood(int n){
        for (fooditem f:list1) {
            if ( f.getID() == n ) {
                System.out.println(f.getID() + " " + name + " - " + f.getName() + " " + f.getPrice() + " " + f.getQuantity() + " " + f.getOffer() + "% off " + f.getCategory());
            }
        }
    }

    public void editName(int n,String name){
        for (fooditem f:list1) {
            if(f.getID()==n){
                f.setName(name);

            }
        }
    }
    public void editPrice(int n, int price){
        for (fooditem f:list1) {
            if(f.getID()==n){
                f.setPrice(price);
            }

        }

    }
    public void editQuantity(int n, int quantity){
        for (fooditem f:list1) {
            if(f.getID()==n){
                f.setQuantity(quantity);
            }

        }
    }
    public void editCategory(int n, String category){
        for (fooditem f:list1) {
            if(f.getID()==n){
                f.setCategory(category);
            }

        }
    }
    public void editOffer(int n, int offer){
        for (fooditem f:list1) {
            if(f.getID()==n){
                f.setOffer(offer);
            }

        }
    }

    public int getDiscount() {
        return discount;
    }
    @Override
    public void display(){
        System.out.println(this.getName()+" "+this.getAddress()+" "+this.getNumOrders());
    }

    @Override
    public void setReward(int reward) {
        this.rewards+=rewards;

    }

    @Override
    public int getReward() {
        return rewards;
    }












}
