package lk.ZenVeus.JavaFx.db;

public class Customer {
    private String custId;
    public String custName;
    public String custAdd;
    public String custPhone;
    public String custEmail;

    public Customer(String custName,String custId,String custEmail,String custAdd, String custPhone){
        this.custId=custId;
        this.custName=custName;
        this.custEmail=custEmail;
        this.custAdd=custAdd;
        this.custPhone=custPhone;
    }

    public String getCustId() {
        return custId;
    }
}
