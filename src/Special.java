public class Special extends customer{

    public Special(String name, String address, int accountBal) {
        super(name, address, accountBal);
    }

    @Override
    public void setReward(int reward) {
        super.setReward(reward);
    }
    @Override
    public void display(){
        System.out.println(this.getName()+"(Special)"+" ,"+this.getAddress()+" ,"+this.getAccountBal());

    }
}
