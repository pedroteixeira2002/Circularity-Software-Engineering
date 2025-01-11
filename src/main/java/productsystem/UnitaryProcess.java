package productsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class that represents a Unitary Process
 */
public class UnitaryProcess extends Process {
    /**
     * List of output flows
     */
    private List<Flow> output;
    /**
     * List of input flows
     */
    private List<Flow> input;

    /**
     * Constructor of Unitary Process
     * @param name name of the process
     */
    public UnitaryProcess(String name) {
        super(name);
        this.input= new ArrayList<>();
        this.output= new ArrayList<>();
    }

    /**
     * Method to add a flow to the output list
     * @param output flow to be added
     * @return the flow added
     */
    public Flow addFlowOutput(Flow output){
        if(output==null){
            throw new NullPointerException("Flow cannot be null");
        }
        this.output.add(output);
        return output;
    }
    /**
     * Method to remove a flow from the output list
     * @param flowName name of the flow to be removed
     * @return the flow removed
     */
    public Flow removeFlowOutput(String flowName){
        if(flowName==null){
            throw new NullPointerException("Flow Name cannot be null");

        }
        int pos=findOutFlow(flowName);
        if(pos==-1){
            throw new NoSuchElementException(flowName);
        }
        Flow flow = this.output.get(pos);
        this.output.remove(pos);
        return flow;

    }
    /**
     * Method to add a flow to the input list
     * @param input flow to be added
     * @return the flow added
     */
    public Flow addFlowInput(Flow input){
        if(input==null){
            throw new NullPointerException("Flow cannot be null");
        }
        this.input.add(input);
        return input;
    }
    /**
     * Method to remove a flow from the input list
     * @param flowName name of the flow to be removed
     * @return the flow removed
     */
    public Flow removeFlowInput(String flowName){
        if(flowName==null){
            throw new NullPointerException("Flow Name cannot be null");
        }
        int pos=findInFlow(flowName);
        if(pos==-1){
            throw new NoSuchElementException(flowName);
        }
        Flow flow = this.input.get(pos);
        this.input.remove(pos);

        return flow;
    }
    /**
     * Method to get the output list
     * @return the output list
     */
    public List<Flow> getOutput(){
        return output;
    }
    /**
     * Method to get the input list
     * @return the input list
     */
    public List<Flow> getInput(){
        return input;
    }
    /**
     * Method to find a flow in the output list
     * @param flowName name of the flow to be found
     * @return the position of the flow in the list
     */
    public int findOutFlow(String flowName){
        int position=0;
        if(flowName==null){
            throw new NullPointerException(flowName);
        }
        for(Flow f: this.output){
            if (f.getFlowName().equals(flowName)) {
                return position;

            }
            position++;
        }
        return -1;
    }
    /**
     * Method to find a flow in the input list
     * @param flowName name of the flow to be found
     * @return the position of the flow in the list
     */
    public int findInFlow(String flowName){
        int position=0;
        if(flowName==null){
            throw new NullPointerException(flowName);
        }
        for(Flow f:this.input){
            if(f.getFlowName().equals(flowName)){
                return position;
            }
            position++;
        }
        return -1;
    }
}
