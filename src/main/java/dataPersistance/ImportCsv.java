package dataPersistance;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import productsystem.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class imports a CSV file and creates a process
 */
public class ImportCsv {
    /** The path of the CSV file */
    private String filePath;
    /** The list of rows of the CSV file */
    private List<Row> list;

    /**
     * Constructor of the class
     * @param filePath the path of the CSV file
     */
    public ImportCsv(String filePath){
        this.filePath=filePath;
        this.list=importFlowsFromCSV(this.filePath);
    }

    /**
     * This method imports flows from CSV file
     * @param filePath the path of the CSV file
     * @return the list of rows of the CSV file
     */
    public List<Row> importFlowsFromCSV(String filePath) {
        if(filePath == null){
            throw new IllegalArgumentException("filePath cannot be null");
        }
        Reader reader;
        try {
            reader = new BufferedReader(new FileReader(this.filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado: " + this.filePath, e);
        }

        CsvToBean<Row> csvReader = new CsvToBeanBuilder<Row>(reader)
                .withType(Row.class)
                .withSeparator(';')
                .withIgnoreEmptyLine(true)
                .build();

        return csvReader.parse();
    }
    /**
     * This method returns the list of names that exists in a Row of the CSV file
     * @return the list of names of the processes
     */
    public List<String> getProcessNames() {
        List<String> names = new ArrayList<>();
        String previous = this.list.get(0).getProcess();
        for(Row r:this.list){
            String current = r.getProcess();
            if (!previous.equals(current)) {
                names.add(current);
                previous=current;
            }
        }
        return names;
    }
    /**
     * This method creates a process when importing a CSV file
     * @param lista the list of names of the processes
     * @return the process
     */
    public Product createProcess(List<String> lista) {
        if(lista==null){
            throw new IllegalArgumentException("lista cannot be null");
        }
        int count = 0;
        for (String s : lista) {
            count++;
        }
        if (count >= 2) {
            AggregatedProcess ag = new AggregatedProcess("Aggregated");
            for (String s : lista) {
                UnitaryProcess un = new UnitaryProcess(s);
                ag.addUnitaryProcess(un);
            }
            return new Product(this.list.get(0).getProduct(), ag);
        } else if (count == 1) {
            UnitaryProcess un = null;
            for (String s : lista) {
                un = new UnitaryProcess(s);
            }
            return new Product(this.list.get(0).getProduct(), un);
        }
        return null;
    }
    /**
     * This method creates a unitary process
     * @param product the product
     */
    public void createUnitaryProcess(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (product.getProcess() instanceof UnitaryProcess) {
            for (Row r : this.list) {
                if (r.getProcess().trim().equals(product.getProcess().getName().trim()) && r.getType().equals("Input")) {
                    Flow flow = new Flow(r.getFlow().trim(), r.getCategory().trim(), r.getQuantity(), UnitType.valueOf(r.getUnity().trim()), r.getCost());
                    ((UnitaryProcess) product.getProcess()).addFlowInput(flow);


                } else if (r.getProcess().equals(product.getProcess().getName()) && r.getType().equals("Output")) {
                    Flow flow = new Flow(r.getFlow().trim(), r.getCategory().trim(), r.getQuantity(), UnitType.valueOf(r.getUnity().trim()), r.getCost());
                    ((UnitaryProcess) product.getProcess()).addFlowOutput(flow);
                }
            }
        }
    }
    /**
     * This method creates an aggregated process
     * @param product the product
     */
    public void createAggregatedProcess(Product product){
        if(product.getProcess() instanceof AggregatedProcess){
            for(UnitaryProcess p:((AggregatedProcess) product.getProcess()).getContainer()){
                for(Row r:this.list){
                    if(r.getProcess().equals(p.getName()) && r.getType().equals("Input")){
                        Flow flow = new Flow(r.getFlow(),r.getCategory(),r.getQuantity(),UnitType.valueOf(r.getUnity()), r.getCost());
                        p.addFlowInput(flow);
                    }
                    else if(r.getProcess().equals(p.getName()) && r.getType().equals("Output")){
                        Flow flow = new Flow(r.getFlow(),r.getCategory(),r.getQuantity(),UnitType.valueOf(r.getUnity()), r.getCost());
                        p.addFlowOutput(flow);
                    }
                }
            }
        }
    }

    /**
     * This method sends a product with all data.
     * @return the product
     */
    public Product sendProduct(){
        Product product = createProcess(getProcessNames());
        if(product.getProcess() instanceof UnitaryProcess ){
            createUnitaryProcess(product);
        }
        else if(product.getProcess() instanceof AggregatedProcess){
            createAggregatedProcess(product);
        }
        return product;
    }
}

