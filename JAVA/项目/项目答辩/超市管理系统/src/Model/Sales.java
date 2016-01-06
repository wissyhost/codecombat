package Model;

/**
 * Created by wissy on 2015/12/7.
 */
public class Sales {
    //商品编号，售出数量，售出价格，消费金额，操作人员编号，售出日期
    private int sales_id;
    private int sales_count;
    private float sales_price;
    private float sales_money;
    private  int sales_userId;
    private String sales_Date;

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public int getSales_count() {
        return sales_count;
    }

    public void setSales_count(int sales_count) {
        this.sales_count = sales_count;
    }

    public float getSales_price() {
        return sales_price;
    }

    public void setSales_price(float sales_price) {
        this.sales_price = sales_price;
    }

    public float getSales_money() {
        return sales_money;
    }

    public void setSales_money(float sales_money) {
        this.sales_money = sales_money;
    }

    public int getSales_userId() {
        return sales_userId;
    }

    public void setSales_userId(int sales_userId) {
        this.sales_userId = sales_userId;
    }

    public String getSales_Date() {
        return sales_Date;
    }

    public void setSales_Date(String sales_Date) {
        this.sales_Date = sales_Date;
    }
}
