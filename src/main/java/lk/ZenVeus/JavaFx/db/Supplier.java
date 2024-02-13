package lk.ZenVeus.JavaFx.db;

public class Supplier {
    private String supplierId;
    public String supplierName;
    public String supplierEmail;
    public String supplierAddress;
    public String supplierPhone;

    public Supplier(String supId , String supName ,  String supEmail , String supAdd , String supPhone){
        this.supplierId=supId;
        this.supplierName=supName;
        this.supplierEmail=supEmail;
        this.supplierAddress=supAdd;
        this.supplierPhone=supPhone;
    }

    public String getSupplierId() {
        return supplierId;
    }
}
