package productsystem;

/**
 * This class is the abstract class for the processes.
 * It has the id and name of the process.
 * It has the static variable nextId which is used to give the id to the processes.
 * It has the abstract method execute which is implemented in the subclasses.
 */
public abstract class Process {
    /**
     * The id that increments for every process created.
     */
    private static int nextId = 0;
    /**
     * The id of the process.
     */
    private int id;
    /**
     * The name of the process.
     */
    private String name;

    /**
     * The constructor of the class.
     * @param name The name of the process.
     */
    public Process(String name) {
        this.name= name;
        this.id = nextId++;
    }

    /**
     * Getter for the id of the process.
     * @return
     */
    public int getId() {
        return id;
    }
    /**
     * Getter for the nextId of the process.
     * @return
     */
    public static int getNextId() {
        return  nextId;
    }
    /**
     * Getter for the name of the process.
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for the name of the process.
     * @param name
     */
    public void setName(String name) {
        this.name=name;
    }
}
