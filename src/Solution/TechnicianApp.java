package Solution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TechnicianApp class provides a GUI for managing technicians.
 * It allows the user to input technician details and generate
 * reports.
 */
public class TechnicianApp extends JFrame
{
    private final JComboBox<String> locationComboBox;   // ComboBox for selecting location
    private final JTextField nameField;                 // Input fields for name
    private final JTextField repairCostField;           // Input fields for cost
    private final JTextField rateField;                 // Input fields for rate
    private final JTextArea reportArea;                 // Area to display generated report

    /**
     * Constructor to set up the Technician application frame and components.
     */
    public TechnicianApp()
    {
        // Setup the frame properties
        setTitle("TECHNICIAN");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create form panel to hold input fields
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Technician Location ComboBox
        locationComboBox = new JComboBox<>(new String[]{"Cape Town", "Durban", "Pretoria"});
        formPanel.add(new JLabel("TECHNICIAN LOCATION:"));
        formPanel.add(locationComboBox);

        // Technician Name Field
        nameField = new JTextField();
        formPanel.add(new JLabel("TECHNICIAN NAME:"));
        formPanel.add(nameField);

        // Repair Cost Field
        repairCostField = new JTextField();
        formPanel.add(new JLabel("REPAIR COST:"));
        formPanel.add(repairCostField);

        // Technician Rate Field
        rateField = new JTextField();
        formPanel.add(new JLabel("TECHNICIAN RATE:"));
        formPanel.add(rateField);

        // Report Area for displaying output
        reportArea = new JTextArea(5, 20);
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);

        // Add components to frame
        add(formPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Set up the menu bar for file operations and tools
        setupMenu();

        setVisible(true); // Make the frame visible
    }

    /**
     * Sets up the menu bar with options for file operations and tools.
     */
    private void setupMenu()
    {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0)); // Exit application
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        
        // Process Report Menu Item
        JMenuItem processReportMenuItem = new JMenuItem("Process Report");
        processReportMenuItem.addActionListener(new ProcessReportAction());
        toolsMenu.add(processReportMenuItem);

        // Clear Menu Item
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(e -> clearFields());
        toolsMenu.add(clearMenuItem);

        // Save Report Menu Item
        JMenuItem saveReportMenuItem = new JMenuItem("Save Report");
        saveReportMenuItem.addActionListener(new SaveReportAction());
        toolsMenu.add(saveReportMenuItem);

        menuBar.add(toolsMenu); // Add tools menu to menu bar
        setJMenuBar(menuBar); // Set the menu bar for the frame
    }

    /**
     * Clears all input fields and the report area.
     */
    private void clearFields()
    {
        locationComboBox.setSelectedIndex(0);
        nameField.setText("");
        repairCostField.setText("");
        rateField.setText("");
        reportArea.setText("");
    }

    /**
     * ActionListener for processing the technician report.
     */
    private class ProcessReportAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Retrieve input values from the GUI
            String location = (String) locationComboBox.getSelectedItem();
            String name = nameField.getText();
            String repairCostStr = repairCostField.getText();
            String rateStr = rateField.getText();

            // Create Technician object with input values
            Technician technician = new Technician(location, name, repairCostStr, rateStr);
            // Validate the technician's data
            if (technician.validateData())
            {
                // Calculate pay and generate report if data is valid
                double calculatedPay = technician.calculatePay();
                reportArea.setText(technician.generateReport(calculatedPay));
            }
            else
            {
                // Show error message if validation fails
                JOptionPane.showMessageDialog(TechnicianApp.this, "Invalid data. Please check inputs.");
            }
        }
    }

    /**
     * ActionListener for saving the generated report to a file.
     */
    private class SaveReportAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Attempt to save the report text to a file
            try (FileWriter writer = new FileWriter("report.txt"))
            {
                writer.write(reportArea.getText());
                JOptionPane.showMessageDialog(TechnicianApp.this, "Report saved to report.txt");
            }
            catch (IOException ex)
            {
                // Show error message if file saving fails
                JOptionPane.showMessageDialog(TechnicianApp.this, "Error saving report.");
            }
        }
    }

    /**
     * Main method to launch the Technician application.
     * @param args
     */
    public static void main(String[] args)
    {
        TechnicianApp technicianApp = new TechnicianApp();
    }
}
