package dataPersistance;

import circularityIndexCalculator.CreateMaterials;
import circularityIndexCalculator.Material;
import circularityIndexCalculator.ProductMCI;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import productsystem.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class exports the results of the calculations to a csv file
 */
public class ExportCsv {
    /**
     * Product to be exported
     */
    private Product product;
    /**
     * List of materials of the product
     */
    private List<Material> materials;
    /**
     * Object that creates the list of materials
     */
    private CreateMaterials createMaterials;
    /**
     * Name of the file to be exported
     */
    private String fileName;

    /**
     * Constructor
     * @param filename name of the file to be exported
     * @param product product to be exported
     */
    public ExportCsv(String filename, Product product) {
        this.product = product;
        this.createMaterials = new CreateMaterials(this.product.getProcess());
        this.fileName = filename;
    }

    /**
     * Writes the results of the calculations to a csv file
     * @return true if the file was successfully written, false otherwise
     */
    public boolean writeToCsv() {
        if(this.fileName == null)
            throw new IllegalArgumentException("filename cannot be null"
            );
        if(this.product == null)
            throw new IllegalArgumentException("product cannot be null"
            );
        this.materials = createMaterials.getMaterials();
        ProductMCI.productMciTotal(this.product);
        try (FileWriter fileWriter = new FileWriter(this.fileName);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {

            // Writing header
            csvPrinter.printRecord("Product",";", "Material",";", "Material virgem (V)",";","Materiais recuperados EoL (Rr)",";"
                    ,"Waste produzido na reciclagem (Wc)",";","Waste total produzido (W)",";","Waste radioactivo (Wr)",";","Materiais reciclados (R) (+ Burden Free) (-cr)",
                    ";","Energia necessária para produção das matérias/produtos principais",";","Energia necessária para produção das matérias/produtos secundário",
                    ";","Waste na produção de materiais (Wf) - ws",";","Input de Valor Reciclado (Ri) - fr",";","Massa (V+Ri)",";","Tempo de Vida Útil (anos)/Vida útil em média (anos)",";",
                    "Utilidade do Produto (U) - nº utilizações/Média (anos)",";","f(x)",";","LFI",";","MCIp",";","MCI Total");
            for(Material m : materials){
                csvPrinter.printRecord(product.getName(),";",m.getNameMaterial(),";", m.getVirginMaterial(),";",m.getRecoveredMaterial(),";",
                        m.getWasteOnRecycling(),";",m.getWasteTotal(),";",m.getWasteRadioactive(),";",m.getRecycledMaterial(),";",m.getEnergyNeededForMainMaterial(),";",
                        m.getEnergyNeededForSecondaryMaterial(),";",m.getWasteProduction(),";",m.getInputRecycled(),";",m.getMass(),";",m.getLifespan()/m.getAverageLifespan(),";",
                        m.getUsefulness()/m.getAverageUsefulness(),";",m.getFx(),";",m.getLinearFlowIndex(),";",m.circularityIndex(),";",product.getMci());

            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}