public class Fast extends restaurant {
    public Fast(String name, String address) {
        super(name, address);
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public void setReward(int reward) {
        super.setReward(reward);
    }
}

