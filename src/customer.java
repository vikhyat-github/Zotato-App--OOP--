public class customer implements personUser {
    private final String name;
    private final String address;
    private double accountBal;
    private int rewards=0;



    public customer(String name, String address,double accountBal ){
        this.name=name;
        this.address=address;
        this.accountBal=accountBal;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(double accountBal) {
        this.accountBal-= accountBal;
    }

    @Override
    public void display(){
        System.out.println(this.getName()+" ,"+this.getAddress()+" ,"+this.getAccountBal());

    }

    @Override
    public void setReward(int rewards) {
        this.rewards+=rewards;

    }
    public void removeReward(int rewards){
        this.rewards-=rewards;
    }

    @Override
    public int getReward() {
        return rewards;
    }

}
