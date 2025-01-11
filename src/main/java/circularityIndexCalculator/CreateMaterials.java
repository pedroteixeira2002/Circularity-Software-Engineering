package circularityIndexCalculator;

import productsystem.AggregatedProcess;
import productsystem.Process;
import productsystem.UnitaryProcess;

import java.util.List;


/**
 * This class creates a list of materials from a process
 */
public class CreateMaterials extends MaterialList {
    public CreateMaterials(Process process) {
        super(process);
    }

    /**
     * This method creates a material
     * @param name
     * @param p
     * @return
     */
    protected Material createMaterial(String name, Process p){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p == null){
            throw new IllegalArgumentException("Process cannot be null");
        }

        Material material = new Material(name);
        material.setVirginMaterial(getVirginMaterial(name,p));
        material.setRecoveredMaterial(getRecoveredMaterial(name,p));
        material.setWasteRadioactive(getRadioactiveWaste(name,p));
        material.setRecycledMaterial(getRecycledMaterial(name,p));
        material.setEnergyNeededForMainMaterial(getMainEnergy(name,p));
        material.setEnergyNeededForSecondaryMaterial(getSecondaryEnergy(name,p));
        material.setWasteProduction(getWasteProduction(name,p));
        material.setRecycledMaterial(getRecycledMaterial(name,p));
        material.setWasteOnRecycling(getRecycledWaste(name,p));
        return material;

    }
    /**
     * This method goes through the list of materials and calls the method createMaterial for each material
     * @param p
     * @return
     */
    protected void createAllMaterial(Process p){
        if(p == null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        if(p instanceof UnitaryProcess){
            for (String s:getMaterialName(p)){
                this.list.add(createMaterial(s,p));
            }
        }else if(p instanceof AggregatedProcess){
            for(UnitaryProcess un:((AggregatedProcess) p).getContainer()){
                for (String s:getMaterialName(un)){
                    this.list.add(createMaterial(s,un));
                }
            }
        }
    }
    /**
     * This method gets the list of materials created using the method createAllMaterial
     * @return
     */
    public List<Material> getMaterials(){
        createAllMaterial(this.process);
        return this.list;
    }
}
