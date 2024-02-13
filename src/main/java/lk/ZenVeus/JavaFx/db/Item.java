package lk.ZenVeus.JavaFx.db;

public class Item {
    private String itemId;
    public  String  itemName;
    public  String  itemSupplierId;
    public  String  itemPrice;
    public  String  itemQntity;

    public Item(String itemId,String itemName,String supId, String itemPrice, String itemQntity){
        this.itemId=itemId;
        this.itemName=itemName;
        this.itemSupplierId=supId;
        this.itemPrice=itemPrice;
        this.itemQntity=itemQntity;
    }

    public String getItemId() {
        return itemId;
    }
}
