package circularityIndexCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productsystem.*;
import productsystem.Process;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The test class CreateMaterialTest.
 */
class CreateMaterialTest {
    /** Flow */
    private Flow flow1;
    /** Flow */
    private Flow flow2;
    /** Process */
    private Process process;
    /** String */
    private String name;

    /**
     * Set up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        flow1 = new Flow("teste", "Materials", 1, null, 1);
        flow2 = new Flow("Material Virgem (V)", "Materials", 1, null, 1);
        process = new UnitaryProcess("teste");
        name = "teste";
    }

    /**
     * Test the method createMaterial in normal conditions
     */
    @Test
    void createMaterialTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        Material result = createMaterials.createMaterial(name,process);
        assertTrue(result != null, "createMaterial should create a Material");
    }

    /**
     * Test the method createMaterial with null process
     * @throws NoSuchMethodException
     */
    @Test
    void createMaterialNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.createMaterial(name,null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }
    /**
     * Test the method createMaterial with null name
     * @throws NoSuchMethodException
     */
    @Test
    void createMaterialStringNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.createMaterial(null,process), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }

    }

    /**
     * Testing the method getMaterials in normal conditions with a valid process
     * @throws NoSuchMethodException
     */
    @Test
    void getMaterialsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        CreateMaterials createMaterials = new CreateMaterials(process);
        List<Material> result = createMaterials.getMaterials();
        assertTrue(result != null, "createMaterial should create a List<Material>");
    }
    /**
     * Testing the method getMaterials with a null value
     * @throws NoSuchMethodException
     */
    @Test
    void getMaterialsNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(null);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.getMaterials(), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }
    }

    /**
     * Testing with a null process
     * @throws NoSuchMethodException
     */
    @Test
    void createAllMaterialNullTest() throws NoSuchMethodException {
        CreateMaterials createMaterials = new CreateMaterials(process);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> createMaterials.createAllMaterial(null), "Expected IllegalArgumentException");

        Throwable cause = illegalArgumentException.getCause();

        if (cause instanceof IllegalArgumentException) {
            assertEquals("Process cannot be null", cause.getMessage());
        }
    }
    /**
     * Testing with a valid UnitaryProcess
     * @throws NoSuchMethodException
     */
    @Test
    public void CreateAllMaterialUnitaryProcess() {
        UnitaryProcess unitaryProcess = new UnitaryProcess("test");
        unitaryProcess.addFlowInput(flow1);
        unitaryProcess.addFlowOutput(flow2);
        CreateMaterials createMaterials = new CreateMaterials(unitaryProcess);
        int count = 0;
        for (Material material : createMaterials.getMaterials()) {
            count++;
        }
        assertEquals(1, count);
    }
    /**
     * Testing with a valid AggregatedProcess
     * @throws NoSuchMethodException
     */
    @Test
    public void CreatAllMaterialAggregatedProcess() {
        AggregatedProcess aggregatedProcess = new AggregatedProcess("test");
        UnitaryProcess unitaryProcess1 = new UnitaryProcess("test");
        UnitaryProcess unitaryProcess2 = new UnitaryProcess("test");
        unitaryProcess1.addFlowInput(flow1);
        unitaryProcess1.addFlowOutput(flow2);
        unitaryProcess2.addFlowInput(flow1);
        unitaryProcess2.addFlowOutput(flow2);
        aggregatedProcess.addUnitaryProcess(unitaryProcess1);
        aggregatedProcess.addUnitaryProcess(unitaryProcess2);


        CreateMaterials createMaterials = new CreateMaterials(aggregatedProcess);
        int count = 0;

        for (Material material : createMaterials.getMaterials()) {
            count++;
        }

        assertEquals(2, count);
    }
}
