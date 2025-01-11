package circularityIndexCalculator;

import productsystem.Process;
import productsystem.UnitaryProcess;

import java.util.ArrayList;
import java.util.List;

public class MaterialList {
    /**
     * This class creates a list of materials
     */
    protected List<Material> list;
    /**
     * This attribute is the process
     */
    protected Process process;

    /**
     * This constructor creates a MaterialList
     *
     * @param process
     */
    public MaterialList(Process process) {
        this.process = process;
        this.list = new ArrayList<>();
    }

    /**
     * This method returns the name of all materials in a process
     *
     * @param p
     * @return
     */
    public List<String> getMaterialName(Process p) {
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        List<String> names = new ArrayList<>();
        if (p instanceof UnitaryProcess) {
            for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
                if (((UnitaryProcess) p).getInput().get(i).getCategory().contains("Materials") || ((UnitaryProcess) p).getInput().get(i).getCategory().contains("Recurso")) {
                    names.add(((UnitaryProcess) p).getInput().get(i).getFlowName());
                }
            }
        }
        return names;
    }
    /**
     * This method returns the quantity of virgin material in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getVirginMaterial(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Material virgem (V)")) {

                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of recovered material in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getRecoveredMaterial(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Materiais recuperados EoL (Rr)")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of recycled waste in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getRecycledWaste(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Waste produzido na reciclagem (Wc)")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of radioactive waste in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getRadioactiveWaste(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Waste radioactivo (Wr)")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of recycled material in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getRecycledMaterial(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Materiais reciclados (R) (+ Burden Free) (-cr)")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of main energy in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getMainEnergy(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Energia necessaria para producao das materias/produtos principais")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of secondary energy in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getSecondaryEnergy(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Energia necessaria para producao das materias/produtos secundario")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    /**
     * This method returns the quantity of waste production in a process
     *
     * @param name
     * @param p
     * @return
     */
    protected double getWasteProduction(String name, Process p) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
            if (((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Waste na producao de materiais (Wf) - ws")) {
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
}
