package Model;

/**
 * Created by wissy on 2015/12/7.
 */
public class Warehouse {
    // 仓库名字,信息,进库时间,出库时间,进库数量,出库数量,功能
    private String warehouse_name;
    private String warehouse_info;
    private String inData;
    private String outData;
    private int inCount;
    private int outCount;
    private String warehouse_function;

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getInData() {
        return inData;
    }

    public void setInData(String inData) {
        this.inData = inData;
    }

    public String getOutData() {
        return outData;
    }

    public void setOutData(String outData) {
        this.outData = outData;
    }

    public int getInCount() {
        return inCount;
    }

    public void setInCount(int inCount) {
        this.inCount = inCount;
    }

    public int getOutCount() {
        return outCount;
    }

    public void setOutCount(int outCount) {
        this.outCount = outCount;
    }

}
