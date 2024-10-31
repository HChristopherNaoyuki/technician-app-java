package Solution;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Technician class.
 * It contains unit tests for validating inputs and calculating pay.
 */
public class TechnicianTest
{
    private Technician validTechnician;    // Valid technician for testing
    private Technician invalidTechnician;  // Invalid technician for testing

    /**
     * Setup method to initialize valid and invalid Technician objects
     * before each test.
     */
    @Before
    public void setUp()
    {
        // Set up valid and invalid Technician objects for testing
        validTechnician = new Technician("Cape Town", "Joe Bloggs", "5000", "10");
        invalidTechnician = new Technician("", "", "-100", "-10");
    }

    // Test for successful pay calculation with valid inputs
    @Test
    public void CalculatePay_PayCalculatedSuccessfully()
    {
        // Expected pay based on inputs
        double expectedPay = 5000 * (10 / 100.0); 
        assertEquals("Expected calculated pay to match", expectedPay, validTechnician.calculatePay(), 0.001);
    }

    // Test for unsuccessful pay calculation with invalid inputs
    @Test
    public void CalculatePay_PayCalculatedUnsuccessfully()
    {
        // Expect the method to return zero for invalid data inputs
        assertEquals("Expected calculated pay to be zero for invalid data inputs", 0.0, invalidTechnician.calculatePay(), 0.001);
    }

    // Validation tests for valid inputs
    @Test
    public void ValidationTest_ValidInputs()
    {
        assertTrue("Expected validation to pass for valid inputs", validTechnician.validateData());
    }

    // Validation test: invalid technician location (empty string)
    @Test
    public void ValidationTest_InvalidLocation()
    {
        Technician technician = new Technician("", "Joe Bloggs", "5000", "10");
        assertFalse("Expected validation to fail for empty location", technician.validateData());
    }

    // Validation test: invalid technician name (empty string)
    @Test
    public void ValidationTest_InvalidName()
    {
        Technician technician = new Technician("Cape Town", "", "5000", "10");
        assertFalse("Expected validation to fail for empty name", technician.validateData());
    }

    // Validation test: repair cost is less than or equal to zero
    @Test
    public void ValidationTest_InvalidRepairCost()
    {
        Technician technician = new Technician("Cape Town", "Joe Bloggs", "0", "10");
        assertFalse("Expected validation to fail for zero repair cost", technician.validateData());
    }

    // Validation test: technician rate is less than or equal to zero
    @Test
    public void ValidationTest_InvalidRate()
    {
        Technician technician = new Technician("Cape Town", "Joe Bloggs", "5000", "0");
        assertFalse("Expected validation to fail for zero rate", technician.validateData());
    }
}
