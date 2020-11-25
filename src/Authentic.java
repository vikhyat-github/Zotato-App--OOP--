public class Authentic extends restaurant {
    public Authentic(String name, String address) {
        super(name, address);
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount=discount;
    }

    @Override
    public void setReward(int reward) {
        super.setReward(reward);
    }
}
