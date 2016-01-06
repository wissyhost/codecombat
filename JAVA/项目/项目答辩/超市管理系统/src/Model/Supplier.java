package Model;

/**
 * Created by wissy on 2015/12/7.
 */

/**
 * 供货商
 */
public class Supplier {
    private String supplier_name;//供货商名字
    private String supplier_provider;//所供商
    private String supplier_moblie;//供货商手机
    private String supplier_address;//供货商地址

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_moblie() {
        return supplier_moblie;
    }

    public void setSupplier_moblie(String supplier_moblie) {
        this.supplier_moblie = supplier_moblie;
    }

    public String getSupplier_provider() {
        return supplier_provider;
    }

    public void setSupplier_provider(String supplier_provider) {
        this.supplier_provider = supplier_provider;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }
}
