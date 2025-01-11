package productsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class AggregatedProcessTest.
 */
class AggregatedProcessTest {
    /** AggregatedProcess */
    private AggregatedProcess ag1;
    /** UnitaryProcess */
    private UnitaryProcess up1;
    /** UnitaryProcess */
    private UnitaryProcess up2;

    /**
     * Set up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    void setUp() {
        ag1 = new AggregatedProcess("ag1");
        up1 = new UnitaryProcess("up1");
        up2 = new UnitaryProcess("up2");
    }

    /**
     * Add a UnitaryProcess to the container of AggregatedProcess
     */
    @Test
    void addProcessTest() {
        // Caso 1: addUnitaryProcess() deve adicionar um UnitaryProcess ao container
        ag1.addUnitaryProcess(up1);
        assertEquals(1, ag1.getContainer().size(), "addUnitaryProcess() deve adicionar um UnitaryProcess ao container");
    }
    /**
     * Add a null UnitaryProcess to the container of AggregatedProcess
     */
    @Test
    public void addNullProcessTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> ag1.addUnitaryProcess(null),
                "Esperava-se que addUnitaryProcess lançasse NullPointerException"
        );
        assertEquals("Unitary Process cannot be null", exception.getMessage());
    }
    /**
     * Remove a UnitaryProcess
     */
    @Test
    void removeProcessTest() {
        // Caso 1: Contagem deve ser 0
        ag1.addUnitaryProcess(up1);
        ag1.removeUnitaryProcess(up1.getId());
        assertEquals(0, ag1.getContainer().size(), "removeUnitaryProcess() deve remover um UnitaryProcess do container");
    }
    /**
     * Remove a process that doesn't exist
     */
    @Test
    void removeNotExistingProcessTest() {
        // Caso 2: removeUnitaryProcess() deve retornar -1 (porque o ID não existe no container)
        int expected = -1;
        int result = ag1.findUnitaryProcess(expected);
        assertEquals(expected, result, "removeUnitaryProcess() deve retornar -1 (porque o ID não existe no container)");
    }

    /**
     * Find a UnitaryProcess
     */
    @Test
    void findUnitaryProcessTest() {
        // Caso 1: findUnitaryProcess() deve retornar 0
        ag1.addUnitaryProcess(up1);
        assertEquals(0, ag1.findUnitaryProcess(up1.getId()), "findUnitaryProcess() deve retornar 0");
    }
    /**
     * Find a UnitaryProcess that doesn't exist
     */
    @Test
    void NotFoundUnitaryProcessTest() {
        // Caso 2: NotFoundUnitaryProcess() deve retornar -1
        ag1.findUnitaryProcess(up1.getId());
        assertEquals(-1, ag1.findUnitaryProcess(up1.getId()), "NotFoundUnitaryProcess() deve retornar -1");
    }
}
