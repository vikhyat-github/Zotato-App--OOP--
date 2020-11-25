public class fooditem {
    private final int ID;
    private String name;
    private int price;
    private int quantity;
    private int offer;
    private String category;

    public fooditem(int ID, String name, int price, int quantity, int offer, String category){
        this.ID=ID;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.offer = offer;
        this.category=category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getOffer() {
        return offer;
    }

    public int getID() {
        return ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void display(){
        System.out.println(this.ID+" "+this.name+" "+this.price+" "+this.quantity+
                " "+this.offer+"% off "+this.category);
    }

}
