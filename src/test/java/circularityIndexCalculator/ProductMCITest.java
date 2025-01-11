package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.AggregatedProcess;
import productsystem.Product;
import productsystem.ProductList;
import productsystem.UnitaryProcess;

import static circularityIndexCalculator.ProductMCI.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class ProductMCITest.
 */
public class ProductMCITest {
    /**
     * CreateMaterials
     */
    private CreateMaterials materials, materials1;
    /**
     * Product
     */
    private Product product, product1;
    /**
     * AggregatedProcess
     */
    private AggregatedProcess process;
    /**
     * UnitaryProcess
     */
    private UnitaryProcess process1;
    /**
     * ProductList
     */
    private ProductList products;

    /**
     * Set up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        process = new AggregatedProcess("process");
        process1 = new UnitaryProcess("Processo");
        materials = new CreateMaterials(process);
        materials = new CreateMaterials(process1);
        product = new Product("produto", process);
        product1 = new Product("produto", process1);
        products = new ProductList("products");
    }

    /**
     * Test the method productMciTotal with a null argument
     */
    @Test
    void productMciTotalNullTest() {
        // Case 1: productMciTotal() should return the total MCI of a product
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productMciTotal(null), "productMciTotal() should return the total MCI of a product");
        assertEquals("Product cannot be null", exception.getMessage());
    }

    /**
     * Test the method productListMciTotal with a null argument
     */
    @Test
    void productListMciTotalNullTest() {
        // Case 1: productListMciTotal() should do the total MCI of each element on the product List
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> productListMciTotal(null), "productMciTotal() should return the total MCI of a product");
        assertEquals("Product List cannot be null", exception.getMessage());
    }

    @Test
    void mciTotalNullTest() {
        //Case 2: mciTotal() should return the total MCI of each element on the material List
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mciTotal(null), "mciTotal() should return the total MCI of each element on the material List");
        assertEquals("Material List cannot be null", exception.getMessage());
    }
    @Test
    void mciTotalTest() {
        //Case 1: mciTotal() should return the total MCI of each element on the material List
        materials.list.add(new Material("m1"));
        materials.list.add(new Material("m2"));
        materials.list.add(new Material("m3"));

        materials.list.get(0).setLifespan(1);
        materials.list.get(0).setUsefulness(1);
        materials.list.get(0).setAverageLifespan(1);
        materials.list.get(0).setAverageUsefulness(1);

        materials.list.get(0).setVirginMaterial(247);
        materials.list.get(0).setRecycledMaterial(-143.26);
        materials.list.get(0).setRecoveredMaterial(103.15);
        materials.list.get(0).setWasteProduction(103.74);
        materials.list.get(0).setWasteOnRecycling(40.11);

        materials.list.get(0).getLinearFlowIndex();
        materials.list.get(0).getFx();

        materials.list.get(1).setLifespan(1);
        materials.list.get(1).setUsefulness(1);
        materials.list.get(1).setAverageLifespan(1);
        materials.list.get(1).setAverageUsefulness(1);

        materials.list.get(1).setVirginMaterial(730);
        materials.list.get(1).setRecycledMaterial(-423.4);
        materials.list.get(1).setRecoveredMaterial(270.98);
        materials.list.get(1).setWasteProduction(0.58);
        materials.list.get(1).setWasteOnRecycling(152.4);

        materials.list.get(1).getLinearFlowIndex();
        materials.list.get(1).getFx();

        materials.list.get(2).setLifespan(1);
        materials.list.get(2).setUsefulness(1);
        materials.list.get(2).setAverageLifespan(1);
        materials.list.get(2).setAverageUsefulness(1);

        materials.list.get(2).setVirginMaterial(23);
        materials.list.get(2).setRecycledMaterial(-13.34);
        materials.list.get(2).setRecoveredMaterial(0);
        materials.list.get(2).setWasteProduction(9.66);
        materials.list.get(2).setWasteOnRecycling(9.66);

        materials.list.get(2).getLinearFlowIndex();
        materials.list.get(2).getFx();

        assertTrue(mciTotal(materials) <= 1 && mciTotal(materials) >= 0, "mciTotal() should return the total MCI of each element on the material List");
    }

    @Test
    void mciTotalGreaterTest() {
        //Case 3: mciTotal() should return the total MCI of each element on the material List
        materials.list.add(new Material("m1"));
        materials.list.add(new Material("m2"));
        materials.list.add(new Material("m3"));

        materials.list.get(0).setLifespan(1);
        materials.list.get(0).setUsefulness(1);
        materials.list.get(0).setAverageLifespan(1);
        materials.list.get(0).setAverageUsefulness(1);

        materials.list.get(0).setVirginMaterial(1);
        materials.list.get(0).setRecycledMaterial(-143.26);
        materials.list.get(0).setRecoveredMaterial(103.15);
        materials.list.get(0).setWasteProduction(103.74);
        materials.list.get(0).setWasteOnRecycling(40.11);

        materials.list.get(0).getLinearFlowIndex();
        materials.list.get(0).getFx();

        materials.list.get(1).setLifespan(1);
        materials.list.get(1).setUsefulness(1);
        materials.list.get(1).setAverageLifespan(1);
        materials.list.get(1).setAverageUsefulness(1);

        materials.list.get(1).setVirginMaterial(1);
        materials.list.get(1).setRecycledMaterial(-423.4);
        materials.list.get(1).setRecoveredMaterial(270.98);
        materials.list.get(1).setWasteProduction(306);
        materials.list.get(1).setWasteOnRecycling(152.4);

        materials.list.get(1).getLinearFlowIndex();
        materials.list.get(1).getFx();

        materials.list.get(2).setLifespan(1);
        materials.list.get(2).setUsefulness(1);
        materials.list.get(2).setAverageLifespan(1);
        materials.list.get(2).setAverageUsefulness(1);

        materials.list.get(2).setVirginMaterial(1);
        materials.list.get(2).setRecycledMaterial(-13.34);
        materials.list.get(2).setRecoveredMaterial(0);
        materials.list.get(2).setWasteProduction(9.66);
        materials.list.get(2).setWasteOnRecycling(9.66);

        materials.list.get(2).getLinearFlowIndex();
        materials.list.get(2).getFx();
        assertTrue(mciTotal(materials) > 1, "mciTotal() should return the total MCI of each element on the material List");
    }

    @Test
    void mciTotalNegativeTest() {
        //Case 4: mciTotal() should return the total MCI of each element on the material List
        materials.list.add(new Material("m1"));
        materials.list.add(new Material("m2"));
        materials.list.add(new Material("m3"));

        materials.list.get(0).setLifespan(1);
        materials.list.get(0).setUsefulness(1);
        materials.list.get(0).setAverageLifespan(10);
        materials.list.get(0).setAverageUsefulness(1);

        materials.list.get(0).setVirginMaterial(247);
        materials.list.get(0).setRecycledMaterial(-143.26);
        materials.list.get(0).setRecoveredMaterial(103.15);
        materials.list.get(0).setWasteProduction(103.74);
        materials.list.get(0).setWasteOnRecycling(40.11);

        materials.list.get(0).getLinearFlowIndex();
        materials.list.get(0).getFx();

        materials.list.get(1).setLifespan(1);
        materials.list.get(1).setUsefulness(1);
        materials.list.get(1).setAverageLifespan(1);
        materials.list.get(1).setAverageUsefulness(1);

        materials.list.get(1).setVirginMaterial(730);
        materials.list.get(1).setRecycledMaterial(-423.4);
        materials.list.get(1).setRecoveredMaterial(270.98);
        materials.list.get(1).setWasteProduction(0.58);
        materials.list.get(1).setWasteOnRecycling(152.4);

        materials.list.get(1).getLinearFlowIndex();
        materials.list.get(1).getFx();

        materials.list.get(2).setLifespan(1);
        materials.list.get(2).setUsefulness(1);
        materials.list.get(2).setAverageLifespan(1);
        materials.list.get(2).setAverageUsefulness(1);

        materials.list.get(2).setVirginMaterial(23);
        materials.list.get(2).setRecycledMaterial(-13.34);
        materials.list.get(2).setRecoveredMaterial(0);
        materials.list.get(2).setWasteProduction(9.66);
        materials.list.get(2).setWasteOnRecycling(9.66);

        materials.list.get(2).getLinearFlowIndex();
        materials.list.get(2).getFx();

        assertTrue(mciTotal(materials) < 0, "mciTotal() should return the total MCI of each element on the material List");
    }

    @Test
    void mciTotalEqualsOne() {
        //Case 4: mciTotal() should return the total MCI of each element on the material List
        materials.list.add(new Material("m1"));
        materials.list.add(new Material("m2"));
        materials.list.add(new Material("m3"));
        materials.list.get(0).setLifespan(1);
        materials.list.get(0).setUsefulness(1);
        materials.list.get(0).setAverageLifespan(10000);
        materials.list.get(0).setAverageUsefulness(10000);
        materials.list.get(0).setVirginMaterial(2);
        materials.list.get(0).setRecycledMaterial(2);
        materials.list.get(0).setRecoveredMaterial(1);
        materials.list.get(0).setWasteProduction(2);
        materials.list.get(0).setWasteOnRecycling(2);
        materials.list.get(0).getLinearFlowIndex();
        materials.list.get(0).getFx();

        materials.list.get(1).setLifespan(1);
        materials.list.get(1).setUsefulness(1);
        materials.list.get(1).setAverageLifespan(10000);
        materials.list.get(1).setAverageUsefulness(10000);
        materials.list.get(1).setVirginMaterial(2);
        materials.list.get(1).setRecycledMaterial(2);
        materials.list.get(1).setRecoveredMaterial(1);
        materials.list.get(1).setWasteProduction(2);
        materials.list.get(1).setWasteOnRecycling(2);
        materials.list.get(1).getLinearFlowIndex();
        materials.list.get(1).getFx();

        materials.list.get(2).setLifespan(1);
        materials.list.get(2).setUsefulness(1);
        materials.list.get(2).setAverageLifespan(10000);
        materials.list.get(2).setAverageUsefulness(10000);
        materials.list.get(2).setVirginMaterial(2);
        materials.list.get(2).setRecycledMaterial(2);
        materials.list.get(2).setRecoveredMaterial(1);
        materials.list.get(2).setWasteProduction(2);
        materials.list.get(2).setWasteOnRecycling(2);
        materials.list.get(2).getLinearFlowIndex();
        materials.list.get(2).getFx();

        assertTrue(mciTotal(materials) < 0, "mciTotal() should return the total MCI of each element on the material List");
    }
}
