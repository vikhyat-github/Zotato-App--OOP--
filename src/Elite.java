public class Elite extends customer{

    public Elite(String name, String address, int accountBal) {
        super(name, address, accountBal);
    }

    @Override
    public void setReward(int reward) {
        super.setReward(reward);
    }
    @Override
    public void display(){
        System.out.println(this.getName()+"(Elite)"+" ,"+this.getAddress()+" ,"+this.getAccountBal());

    }
}
