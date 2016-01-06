package Model;

import java.util.Date;
import java.util.stream.Stream;

/**
 * Created by wissy on 2015/12/7.
 */
public class Commodity {
    //商品编号,名字,类型,价格,折扣,数量
    private int commodity_id;
    private String commodity_name;
    private Stream commodity_type;
    private float commodity_price;
    private float commodity_discount;
    private int commodity_count;

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodity_id=" + commodity_id +
                ", commodity_name='" + commodity_name + '\'' +
                ", commodity_type=" + commodity_type +
                ", commodity_price=" + commodity_price +
                ", commodity_discount=" + commodity_discount +
                ", commodity_count=" + commodity_count +
                '}';
    }

    public Stream getCommodity_type() {
        return commodity_type;
    }

    public void setCommodity_type(Stream commodity_type) {
        this.commodity_type = commodity_type;
    }

    public float getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(float commodity_price) {
        this.commodity_price = commodity_price;
    }

    public int getCommodity_count() {
        return commodity_count;
    }

    public void setCommodity_count(int commodity_count) {
        this.commodity_count = commodity_count;
    }

    public float getCommodity_discount() {
        return commodity_discount;
    }

    public void setCommodity_discount(float commodity_discount) {
        this.commodity_discount = commodity_discount;
    }
}
