package productsystem;

/**
 * Class that represents a product
 */
public class Product {
    /**
     * Name of the product
     */
    private String name;
    /**
     * Process/es of the product
     */
    Process process;
    /**
     * mci of the product
     */
    private double mci;

    /**
     * Constructor of the class Product
     * @param name name of the product
     * @param process process of the product
     */
    public Product(String name, Process process) {
        this.name = name;
        this.process = process;
    }

    /**
     * Getter of the name of the product
     * @return name of the product
     */
    public String getName() {
        return name;
    }
    /**
     * Setter of the name of the product
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter of the process of the product
     * @return process of the product
     */
    public Process getProcess() {
        return process;
    }
    /**
     * Setter of the process of the product
     * @param process
     */
    public void setProcess(Process process) {
        this.process = process;
    }
    /**
     * Getter of the mci of the product
     * @return
     */
    public double getMci() {
        return mci;
    }
    /**
     * Setter of the mci of the product
     * @param mci
     */
    public void setMci(double mci) {
        this.mci = mci;
    }
}
