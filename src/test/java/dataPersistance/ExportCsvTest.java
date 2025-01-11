package dataPersistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The test class ExportCsvTest.
 */
class ExportCsvTest {
    /** ExportCsv */
    private ExportCsv exportCsv;
    /** Product */
    private Product product;
    /** String of filepath */
    private String filePath;
    /** ImportCsv */
    private ImportCsv importCsv;

    /**
     * Set up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        importCsv=new ImportCsv("src/main/resources/CSV/csv.csv");
        filePath = "src/main/resources/CSV/result.csv";
        product=importCsv.sendProduct();
        exportCsv=new ExportCsv(filePath,product);
    }

    /**
     * Test in case of success
     * Should create a csv file with the results of the calculations and information about the product
     */
    @Test
    void writeToCsvTest() {
        boolean resultado = exportCsv.writeToCsv();
        assertEquals(resultado,true,"ficheiro csv criado");
    }
    /**
     * Test in case of failure
     */
    @Test
    void writeToCsvFalseTest() {
        boolean resultado = exportCsv.writeToCsv();
        assertFalse(!resultado, "writeToCsv deve criar um ficheiro csv");
    }
}