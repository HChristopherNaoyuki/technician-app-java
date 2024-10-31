package Solution;

/**
 * The Technician class implements the ITechnician interface.
 * It holds information about a technician, including their location,
 * name, repair cost, and rate, and provides methods to calculate
 * pay and validate the technician's data.
 */
class Technician implements ITechnician
{
    private String location;       // Technician's location
    private String name;           // Technician's name
    private double repairCost;     // Cost of repair work
    private double rate;           // Pay rate as a percentage

    /**
     * Constructor to initialize the Technician object.
     * Parses repair cost and rate from strings to doubles.
     * If parsing fails, sets invalid values to -1.
     */
    public Technician(String location, String name, String repairCostStr, String rateStr)
    {
        this.location = location;
        this.name = name;

        try
        {
            this.repairCost = Double.parseDouble(repairCostStr);
            this.rate = Double.parseDouble(rateStr);
        }
        catch (NumberFormatException e)
        {
            this.repairCost = -1; // Invalid value
            this.rate = -1;       // Invalid value
        }
    }

    @Override
    public boolean validateData()
    {
        // Validate that location and name are not empty and
        // that repair cost and rate are positive values
        return location != null && !location.isEmpty() &&
               name != null && !name.isEmpty() &&
               repairCost > 0 && rate > 0;
    }

    @Override
    public double calculatePay()
    {
        // If data is invalid, return 0.0 for calculated pay
        if (!validateData())
        {
            return 0.0; // Return 0.0 if the data is invalid
        }

        // Calculate pay based on repair cost and rate
        return repairCost * (rate / 100);
    }

    /**
     * Generates a formatted report string with technician details
     * and calculated pay.
     */
    public String generateReport(double calculatedPay)
    {
        return String.format("TECHNICIAN LOCATION: %s\nTECHNICIAN NAME: %s\nREPAIR COST: R %.2f\nTECHNICIAN RATE: %.2f%%\nCALCULATED PAY: R %.2f",
                             location, name, repairCost, rate, calculatedPay);
    }
}
