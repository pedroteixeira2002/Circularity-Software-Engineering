package productsystem;

/**
 * Class that represents a flow
 */
public class Flow {
    /**
     * Name of the flow
     */
    private String flowName;
    /**
     * Category of the flow
     */
    private String category;
    /**
     * Quantity of the flow
     */
    private double quantity;
    /**
     * Unit of the flow
     */
    private UnitType unit;
    /**
     * Cost of the flow
     */
    private double cost;

    /**
     * Constructor of the class
     * @param flowName Name of the flow
     * @param category Category of the flow
     * @param quantity Quantity of the flow
     * @param unit Unit of the flow
     * @param cost Cost of the flow
     */
    public Flow(String flowName, String category, double quantity, UnitType unit, double cost) {
        this.flowName = flowName;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.cost = cost;
    }

    /**
     * Empty constructor of the class
     * @param flowName
     */
    public Flow(String flowName) {

    }

    /**
     * Method that returns the name of the flow
     * @return Name of the flow
     */
    public String getFlowName() {
        return flowName;
    }
    /**
     * Method that sets the name of the flow
     * @param flowName Name of the flow
     */
    public void setFlowName(String flowName) {
        this.flowName= flowName;
    }
    /**
     * Method that returns the category of the flow
     * @return Category of the flow
     */
    public String getCategory() {
        return category;
    }
    /**
     * Method that sets the category of the flow
     * @param category
     */
    public void setCategory(String category) {
        this.category= category;
    }
    /**
     * Method that returns the quantity of the flow
     * @return Quantity of the flow
     */
    public double getQuantity() {
        return quantity;
    }
    /**
     * Method that sets the quantity of the flow
     * @param quantity Quantity of the flow
     */
    public void setQuantity(double quantity) {
        this.quantity= quantity;
    }
    /**
     * Method that returns the unit of the flow
     * @return Unit of the flow
     */
    public UnitType getUnit() {
        return unit;
    }
    /**
     * Method that sets the unit of the flow
     * @param unit Unit of the flow
     */
    public void setUnit(UnitType unit) {
        this.unit=unit;
    }
    /**
     * Method that returns the cost of the flow
     * @return Cost of the flow
     */
    public double getCost() {
        return cost;
    }
    /**
     * Method that sets the cost of the flow
     * @param cost
     */
    public void setCost(double cost) {
        this.cost= cost;
    }
}
