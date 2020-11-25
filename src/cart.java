import java.util.ArrayList;
import java.util.List;

public class cart {
    private  ArrayList<fooditem> cartlist=new ArrayList<>();
    private int Rcode;

    public List<fooditem> getCartlist() {
        return cartlist;
    }

    public int getRcode() {
        return Rcode;
    }

    public void setRcode(int rcode) {
        Rcode = rcode;
    }
    public void emptyCart(){
        //this.getCartlist().clear();
        //System.out.println("->"+cartlist.size());
        while(!getCartlist().isEmpty()){
            getCartlist().remove(0);
        }

    }

}



