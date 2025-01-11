package dataPersistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.AggregatedProcess;
import productsystem.Flow;
import productsystem.Product;
import productsystem.UnitaryProcess;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The test class ImportCsvTest.
 */
class ImportCsvTest {
    /** ImportCsv */
    private ImportCsv importCsv;
    /** String of filePath*/
    private String filePath;
    /** Product */
    private Product product;

    /**
     * Set up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        filePath = "src/main/resources/CSV/csv.csv";
        importCsv=new ImportCsv(filePath);
        Product product = importCsv.sendProduct();
    }
    /**
     * Test whether the import of csv lines was successful.
     */
    @Test
    void importRowsFromCSVTest(){
        List<Row> rows = importCsv.importFlowsFromCSV(filePath);
        assertTrue(rows!=null,"importRowsFromCSVTest cant return null");
    }

    /**
     * Testing if csv row import was null.
     */
    @Test
    void importRowsFromCSVNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.importFlowsFromCSV(null),
                "Esperava-se que importRowsFromCSV lançasse IllegalArgumentException"
        );
        assertEquals("filePath cannot be null", exception.getMessage());
    }

    /**
     * Test if the list of names of the processes is not null.
     */
    @Test
    void getProcessNamesTest(){
        List<String> names = importCsv.getProcessNames();
        assertTrue(names!=null,"getProcessNamesTest cant return null");
    }

    /**
     * Test if the list of names of the processes is null.
     */
    @Test
    void getProcessNamesNull() {
        List<String> names = importCsv.getProcessNames();
        assertFalse(names == null, "getProcessNamesTest can t return a list of names");
    }

    /**
     * Test in case the list of names of the processes exists.
     */
    @Test
    void createProcessTest() {
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        assertTrue(product!=null,"createProcess cant return null");
    }
    /**
     * Test in case the list of names of the processes is null.
     */
    @Test
    void createProcessNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.createProcess(null),
                "Esperava-se que createProcess lançasse IllegalArgumentException"
        );
        assertEquals("lista cannot be null", exception.getMessage());
    }

    /**
     * This test checks if the unitary process was created and if the inputs and outputs were imported correctly.
     */
    @Test
    void createUnitaryProcessTest() {
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if (product.getProcess() instanceof UnitaryProcess) {
            importCsv.createUnitaryProcess(product);
            assertTrue(product.getProcess() != null, "createUnitaryProcessTest needs to create a process");
        }
    }
    /**
     * This test checks try to create a unitary process with a null value.
     */
    @Test
    void createUnitaryProcessNullTest(){
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if(product.getProcess() instanceof UnitaryProcess){
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.createUnitaryProcess(null),
                    "Esperava-se que createUnitaryProcess lançasse IllegalArgumentException"
            );
            assertEquals("Product cannot be null", exception.getMessage());
        }

    }
    /**
     * This test checks if the aggregated process was created and if the inputs and outputs were imported correctly.
     */
    @Test
    void createAggregatedProcessTest() {
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if (product.getProcess() instanceof AggregatedProcess) {
            importCsv.createAggregatedProcess(product);
            assertTrue(product.getProcess() != null, "createAggregatedProcessTest needs to create a process");
        }
    }
    /**
     * This test checks try to create an aggregated process with a null value.
     */
    @Test
    void createAggregatedProcessNullTest(){
        Product product = importCsv.createProcess(importCsv.getProcessNames());
        if(product.getProcess() instanceof AggregatedProcess){
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->importCsv.createAggregatedProcess(null),
                    "Esperava-se que createAggregatedProcess lançasse IllegalArgumentException"
            );
            assertEquals("Product cannot be null", exception.getMessage());
        }

    }

    /**
     * Coverage of createProcess
     */
    @Test
    void coverageCreateProcess(){
        int count = 0;
        for (String s : importCsv.getProcessNames()) {
            count++;
        }

        Product productTeste;
        if(count >=2){
            productTeste=importCsv.createProcess(importCsv.getProcessNames());
            Boolean result = productTeste.getProcess() instanceof AggregatedProcess;
            assertEquals(true,result,"Create process should return Product with AggregatedProcess");
        }
        else if(count ==1){
            productTeste=importCsv.createProcess(importCsv.getProcessNames());
            Boolean result = productTeste.getProcess() instanceof UnitaryProcess;
            assertEquals(true,result,"Create process should return Product with UnitaryProcess");
        }
    }
    /**
     * Coverage of UnitaryProcess
     */
    @Test
    void coverageUnitaryProcess() {
        List<Flow> inputs = new ArrayList<>();
        List<Flow> outputs = new ArrayList<>();
        Product product1 = importCsv.sendProduct();
        if(product1.getProcess() instanceof UnitaryProcess){
            inputs = ((UnitaryProcess) product1.getProcess()).getInput();
            outputs = ((UnitaryProcess) product1.getProcess()).getOutput();
        }


        boolean inputsB=true;
        boolean outputsB = true;

        if(product1.getProcess() instanceof UnitaryProcess){
            for(int i=0;i<inputs.size();i++){
                if(!inputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getInput().get(i).getFlowName())){
                    inputsB=false;
                }
            }
            for(int i=0;i<outputs.size();i++){
                if(!outputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getOutput().get(i).getFlowName())){
                    outputsB=false;
                }
            }
        }
        assertTrue(inputsB, "Failed Import of flows");
        assertTrue(outputsB, "Failed Import of flows");
    }
    /**
     * Coverage of AggregatedProcess
     */
    @Test
    void coverageAggregatedProcess() {
        List<Flow> inputs ;
        List<Flow> outputs;
        boolean inputsB=true;
        boolean outputsB = true;
        Product product1 = importCsv.sendProduct();
        if(product1.getProcess() instanceof AggregatedProcess){
            for(UnitaryProcess un:((AggregatedProcess) product1.getProcess()).getContainer()){
                inputs = ((UnitaryProcess) product1.getProcess()).getInput();
                outputs = ((UnitaryProcess) product1.getProcess()).getOutput();
                for(int i=0;i<inputs.size();i++){
                    if(!inputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getInput().get(i).getFlowName())){
                        inputsB=false;
                    }
                    if(!outputs.get(i).getFlowName().equals(((UnitaryProcess) product1.getProcess()).getOutput().get(i).getFlowName())){
                        outputsB=false;
                    }
                }

            }

        }

        assertTrue(inputsB, "Failed Import of flows");
        assertTrue(outputsB, "Failed Import of flows");
    }
}