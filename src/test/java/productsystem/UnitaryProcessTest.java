package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The test class UnitaryProcessTest.
 */
class UnitaryProcessTest {
    /** UnitaryProcess */
    private UnitaryProcess up1;
    /** Flow */
    private Flow f1;
    /** Flow */
    private Flow f2;
    /**
     * Set up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        up1 = new UnitaryProcess("up1");
        f1 = new Flow("f1", "null", 0, null, 0);
        f2 = new Flow("f2", "null", 0, null, 0);
    }

    /**
     * Add a Flow to the container of output Flows of UnitaryProcess
     */
    @Test
    void addOutputTest() {
        // Case 1: addOutput() should add a Flow to the container
        up1.addFlowOutput(f1);
        assertEquals(1, up1.getOutput().size(), "addOutput() should add a Flow to the container");
    }
    /**
     * Add a null Flow to the container of output Flows of UnitaryProcess
     */
    @Test
    void addNullOutputTest() {
        // Case 2: Flow cannot be null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> up1.addFlowOutput(null), "Esperava-se que addFlowOutput lançasse NullPointerException");
        assertEquals("Flow cannot be null", exception.getMessage());
    }
    /**
     * Remove a Flow from the container of output Flows of UnitaryProcess
     */
    @Test
    void removeOutputTest() {
        // Case 1: Count should be 0
        up1.addFlowOutput(f1);
        up1.removeFlowOutput(f1.getFlowName());
        assertEquals(0, up1.getOutput().size(), "removeOutput() should remove a Flow from the container");
    }
    /**
     * Remove a Flow that doesn't exist from the container of output Flows of UnitaryProcess
     */
    @Test
    void findNotExistingOutputTest() {
        // Case 2: Removing a flow that doesn't exist
        String expected = "cascalho";
        int result = up1.findOutFlow(expected);
        assertEquals(-1, result, "removeOutput() should return -1(because the does not exist in the container)");

    }
    /**
     * Remove a null Flow from the container of output Flows of UnitaryProcess
     */
    @Test
    void removeNullOutputTest() {
        // Case 3: removeOutput() name cannot be null.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> up1.removeFlowOutput("cascalho"),
                "Esperava-se que removeNullOutput lançasse NoSuchElementException");
        assertEquals("cascalho", exception.getMessage());
    }
    /**
     * Add a Flow to the container of input Flows of UnitaryProcess
     */
    @Test
    void addInputTest() {
        // Case 1: addInput() should add a Flow to the container
        up1.addFlowInput(f1);
        assertEquals(1, up1.getInput().size(), "addInput() should add a Flow to the container");
    }
    /**
     * Add a null Flow to the container of input Flows of UnitaryProcess
     */
    @Test
    void addNullInputTest() {
        // Case 2: Flow cannot be null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> up1.addFlowInput(null), "Esperava-se que addFlowInput lançasse NullPointerException");
        assertEquals("Flow cannot be null", exception.getMessage());
    }
    /**
     * Remove a Flow from the container of input Flows of UnitaryProcess
     */
    @Test
    void removeInputTest() {
        // Case 1: Count should be 0
        up1.addFlowInput(f1);
        up1.removeFlowInput(f1.getFlowName());
        assertEquals(0, up1.getInput().size(), "removeInput() should remove a Flow from the container");
    }
    /**
     * Remove a Flow that doesn't exist from the container of input Flows of UnitaryProcess
     */
    @Test
    void findNotExistingInputTest() {
        // Case 2: Removing a flow that doesn't exist
        String expected = "cascalho";
        int result = up1.findInFlow(expected);
        assertEquals(-1, result, "findInputTest should return -1(because the does not exist in the container)");

    }
    /**
     * Remove a null Flow from the container of input Flows of UnitaryProcess
     */
    @Test
    void removeNullInputTest() {
        // Case 3: removeInput() name cannot be null.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> up1.removeFlowInput("cascalho"),
                "Esperava-se que removeNullOutput lançasse NoSuchElementException");
        assertEquals("cascalho", exception.getMessage());
    }
    /**
     * Find a Flow in the container of output Flows of UnitaryProcess
     */
    @Test
    void findOutFlowTest() {
        // Case 1: findOutFlow() should return 0.
        up1.addFlowOutput(f1);
        assertEquals(0, up1.findOutFlow(f1.getFlowName()), "findOutFlow() should return 0");
    }
    /**
     * Find a Flow that doesn't exist in the container of output Flows of UnitaryProcess
     */
    @Test
    void NotFoundOutFlowTest() {
        // Case 2: NotFoundOutFlow() should return -1.
        up1.findOutFlow(f1.getFlowName());
        assertEquals(-1, up1.findOutFlow(f1.getFlowName()), "NotFoundOutFlow() should return -1");
    }
    /**
     * Find a Flow in the container of input Flows of UnitaryProcess
     */
    @Test
    void findInFlowTest() {
        // Case 1: findInFlow() should return 0.
        up1.addFlowInput(f1);
        assertEquals(0, up1.findInFlow(f1.getFlowName()), "findInFlow() should return 0");
    }
    /**
     * Find a Flow that doesn't exist in the container of input Flows of UnitaryProcess
     */
    @Test
    void NotFoundInFlowTest() {
        // Case 2: NotFoundInFlow() should return -1.
        up1.findInFlow(f1.getFlowName());
        assertEquals(-1, up1.findInFlow(f1.getFlowName()), "NotFoundInFlow() should return -1");
    }
    /**
     * Find a null Flow in the container of input Flows of UnitaryProcess
     */
    @Test
    void findNullFlowInTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> up1.findInFlow(null),
                "Espera-se que FindNullFlowInTeste lançasse NosuchElementException");
        assertEquals(null, exception.getMessage());
    }
    /**
     * Find a null Flow in the container of output Flows of UnitaryProcess
     */
    @Test
    void findNullFlowOutTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> up1.findOutFlow(null),
                "Espera-se que FindNullFlowOutTeste lançasse NosuchElementException");
        assertEquals(null, exception.getMessage());
    }

    /**
     * Coverage test for instructions
     */
    @Test
    void testeCoberturaInstrucoes() {
        up1.addFlowInput(f1);
        up1.removeFlowInput("f1");

        up1.addFlowOutput(f2);
        up1.removeFlowOutput("f2");

        assertEquals(0, up1.getOutput().size());
        assertEquals(0, up1.getInput().size());

    }
}