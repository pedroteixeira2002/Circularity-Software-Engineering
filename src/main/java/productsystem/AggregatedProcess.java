package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Class to represent an Aggregated Process
 */
public class AggregatedProcess extends Process{
    /**
     * List to store Unitary Processes
     */
    private List<UnitaryProcess> container;

    /**
     * Constructor for Aggregated Process
     * @param name name of the process
     */
    public AggregatedProcess(String name) {
        super(name);
        this.container=new ArrayList<>();
    }

    /**
     * Method to find the position of a Unitary Process by its id
     * @param id id of the Unitary Process
     * @return position of the Unitary Process
     */
    public int findUnitaryProcess(int id){
        int position = 0;
        for (UnitaryProcess un : this.container) {
            if (un.getId() == id) {
                return position; // devolve a posição correta se encontrado
            }
            position++;
        }
        return -1; // caso nao encontre retorna -1
    }
    /**
     * Method to add a Unitary Process to the list
     * @param un Unitary Process to be added
     * @return the Unitary Process added
     */
    public UnitaryProcess addUnitaryProcess(UnitaryProcess un){
        if(un == null){
            throw new NullPointerException("Unitary Process cannot be null");
        }
        this.container.add(un);
        return un;
    }
    /**
     * Method to remove a Unitary Process from the list by its id
     * @param id id of the Unitary Process to be removed
     * @return the Unitary Process removed
     */
    public UnitaryProcess removeUnitaryProcess(int id){
        int pos=findUnitaryProcess(id); // find the position of the Unitary Process
        if(pos==-1){
            throw new NoSuchElementException(id + " doesn't exist");
        }
        UnitaryProcess un = this.container.get(pos);
        this.container.remove(pos);

        return un;//devolve o processo removido
    }
    /**
     * Method to get the list of Unitary Processes
     * @return the list of Unitary Processes
     */
    public List<UnitaryProcess> getContainer() {
        return container;
    }
}

