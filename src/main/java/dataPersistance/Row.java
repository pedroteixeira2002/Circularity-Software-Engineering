package dataPersistance;
import com.opencsv.bean.CsvBindByName;

/**
 * This class represents a row of the CSV file
 */
public class Row {
    /** The name of the product */
    @CsvBindByName(column = "Produto")
    private String product;
    /** The name of the process */
    @CsvBindByName(column = "Processo")
    private String process;
    /** The type of the process */
    @CsvBindByName(column = "type")
    private String type;
    /** The flow of the process */
    @CsvBindByName(column = "Flow")
    private String flow;
    /** The category of the process */
    @CsvBindByName(column = "Categoria")
    private String category;
    /** The quantity of the process */
    @CsvBindByName(column = "Qtd")
    private double quantity;
    /** The unity of the process */
    @CsvBindByName(column = "Unidade")
    private String unity;
    /** The cost of the process */
    @CsvBindByName(column = "Custo/Receita")
    private double cost;

    /**
     * Constructor of the class
     */
    public Row() {
    }

    /**
     * Getter of the product
     * @return
     */
    public String getProduct() {
        return product;
    }
    /**
     * Getter of the process
     * @return
     */
    public String getProcess() {
        return process;
    }
    /**
     * Getter of the type
     * @return
     */
    public String getType() {
        return type;
    }
    /**
     * Getter of the flow
     * @return
     */
    public String getFlow() {
        return flow;
    }
    /**
     * Getter of the category
     * @return
     */
    public String getCategory() {
        return category;
    }
    /**
     * Getter of the quantity
     * @return
     */
    public double getQuantity() {
        return quantity;
    }
    /**
     * Getter of the unity
     * @return
     */
    public String getUnity() {
        return unity;
    }
    /**
     * Getter of the cost
     * @return
     */
    public double getCost() {
        return cost;
    }
}
