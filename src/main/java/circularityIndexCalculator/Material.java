package circularityIndexCalculator;

/**
 * This class represents a material
 */
public class Material {
    /**
     * name of the material
     */
    private String nameMaterial;
    /**
     * Virgin material (V)
     */
    private double virginMaterial;
    /**
     * Recovered material (Rr)
     */
    private double recoveredMaterial;
    /**
     * Waste on recycling (Wc)
     */
    private double wasteOnRecycling;
    /**
     * Waste radioactive
     */
    private double wasteRadioactive;
    /**
     * Recycled material (R)
     */
    private double recycledMaterial;
    /**
     * Energy needed for main material (Ep)
     */
    private double energyNeededForMainMaterial;
    /**
     * Energy needed for secondary material (Es)
     */
    private double energyNeededForSecondaryMaterial;
    /**
     * Waste production (Wf)
     */
    private double wasteProduction;
    /**
     * Lifespan (L)
     */
    private double lifespan;
    /**
     * Usefulness (U)
     */
    private double usefulness;
    /**
     * Average usefulness (U_avg)
     */
    private double averageUsefulness;
    /**
     * Average lifespan (L_avg)
     */
    private double averageLifespan;

    /**
     * Constructor of the class Material
     *
     * @param nameMaterial name of the material
     */
    public Material(String nameMaterial) {
        this.nameMaterial = nameMaterial;
        this.virginMaterial = 0;
        this.recoveredMaterial = 0;
        this.wasteOnRecycling = 0;
        this.wasteRadioactive = 0;
        this.recycledMaterial = 0;
        this.energyNeededForMainMaterial = 0;
        this.energyNeededForSecondaryMaterial = 0;
        this.wasteProduction = 0;
        this.lifespan = 1;
        this.usefulness = 1;
        this.averageUsefulness = 1;
        this.averageLifespan = 1;
    }

    /**
     * Returns the name of the material
     * @return
     */
    public String getNameMaterial() {
        return nameMaterial;
    }
    /**
     * Sets the name of the material
     * @param nameMaterial
     */
    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }
    /**
     * Returns the virgin material
     * @return
     */
    public double getVirginMaterial() {
        return virginMaterial;
    }
    /**
     * Sets the virgin material
     * @param virginMaterial
     */
    public void setVirginMaterial(double virginMaterial) {
        this.virginMaterial = virginMaterial;
    }
    /**
     * Returns the recovered material
     * @return
     */
    public double getRecoveredMaterial() {
        return recoveredMaterial;
    }
    /**
     * Sets the recovered material
     * @param recoveredMaterial
     */
    public void setRecoveredMaterial(double recoveredMaterial) {
        this.recoveredMaterial = recoveredMaterial;
    }
    /**
     * Returns the waste on recycling
     * @return
     */
    public double getWasteOnRecycling() {
        return wasteOnRecycling;
    }
    /**
     * Sets the waste on recycling
     * @param wasteOnRecycling
     */
    public void setWasteOnRecycling(double wasteOnRecycling) {
        this.wasteOnRecycling = wasteOnRecycling;
    }
    /**
     * This method calculates the total waste
     * @return
     */
    public double getWasteTotal() {

        double resultado = virginMaterial - recoveredMaterial;
            return resultado;

    }
    /**
     * Returns the radioactive waste
     * @return
     */
    public double getWasteRadioactive() {
        return wasteRadioactive;
    }
    /**
     * Sets the radioactive waste
     * @param wasteRadioactive
     */
    public void setWasteRadioactive(double wasteRadioactive) {
        this.wasteRadioactive = wasteRadioactive;
    }
    /**
     * Returns the recycled material
     * @return
     */
    public double getRecycledMaterial() {
        return recycledMaterial;
    }
    /**
     * Sets the recycled material
     * @param recycledMaterial
     */
    public void setRecycledMaterial(double recycledMaterial) {
        this.recycledMaterial = recycledMaterial;
    }
    /**
     * Returns the energy needed for main material
     * @return
     */
    public double getEnergyNeededForMainMaterial() {
        return energyNeededForMainMaterial;
    }
    /**
     * Sets the energy needed for main material
     * @param energyNeededForMainMaterial
     */
    public void setEnergyNeededForMainMaterial(double energyNeededForMainMaterial) {
        this.energyNeededForMainMaterial = energyNeededForMainMaterial;
    }
    /**
     * Returns the energy needed for secondary material
     * @return
     */
    public double getEnergyNeededForSecondaryMaterial() {
        return energyNeededForSecondaryMaterial;
    }
    /**
     * Sets the energy needed for secondary material
     * @param energyNeededForSecondaryMaterial
     */
    public void setEnergyNeededForSecondaryMaterial(double energyNeededForSecondaryMaterial) {
        this.energyNeededForSecondaryMaterial = energyNeededForSecondaryMaterial;
    }
    /**
     * Returns the waste production
     * @return
     */
    public double getWasteProduction() {
        return wasteProduction;
    }
    /**
     * Sets the waste production
     * @param wasteProduction
     */
    public void setWasteProduction(double wasteProduction) {
        this.wasteProduction = wasteProduction;
    }
    /**
     * Returns the lifespan
     * @return
     */
    public double getLifespan() {

            return lifespan;
    }
    /**
     * Sets the lifespan
     * @param lifespan
     */
    public void setLifespan(double lifespan) {
        this.lifespan = lifespan;
    }
    /**
     * Returns the usefulness
     * @return
     */
    public double getUsefulness() {

            return usefulness;
    }
    /**
     * Sets the usefulness
     * @param usefulness
     */
    public void setUsefulness(double usefulness) {
        this.usefulness = usefulness;
    }
    /**
     * Returns the average usefulness
     * @return
     */
    public double getAverageUsefulness() {
        return averageUsefulness;
    }
    /**
     * Sets the average usefulness
     * @param averageUsefulness
     */
    public void setAverageUsefulness(double averageUsefulness) {
        this.averageUsefulness = averageUsefulness;
    }
    /**
     * Returns the average lifespan
     * @return
     */
    public double getAverageLifespan() {
        return averageLifespan;
    }
    /**
     * Sets the average lifespan
     * @param averageLifespan
     */
    public void setAverageLifespan(double averageLifespan) {
        this.averageLifespan = averageLifespan;
    }
    /**
     * This method calculates the mass of the material
     * @return
     */
    public double getMass() {
        double resultado=  virginMaterial + getInputRecycled();
            return resultado;
    }

    /**
     * This method calculates input recycled
     * @return
     */
    public double getInputRecycled() {
        double resultado = recycledMaterial + recoveredMaterial;

        if (resultado < 0){
            return 0;
        }else {
            return resultado;
        }
    }
    /**
     * This method calculates the utility factor
     * @return
     */
    public double getFx() {
        double a = 0, b = 0;
        a = usefulness / averageUsefulness;
        b = lifespan / averageLifespan;
        if (a * b <= 0)
            throw new ArithmeticException("The product of the usefulness and lifespan cannot be zero");
        return 0.9 / (a * b);
    }
    /**
     * This method calculates the linear flow index
     * @return
     */
    public double getLinearFlowIndex() {
        double resultado=(2 * virginMaterial - recoveredMaterial) / (2 * getMass() + ((wasteProduction - wasteOnRecycling) / 2));
            return resultado;
    }
    /**
     * This method calculates the circularity
     * @return
     */
    public double circularityIndex() {
        double resultado=1 - (getLinearFlowIndex() * getFx());
            return resultado;
        }
}
