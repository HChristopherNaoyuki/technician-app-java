# Technician Management App

A simple Java application designed for managing technicians. This app allows users to input technician details, calculate pay based on repair costs and rates, and generate/save reports in a minimalistic user interface.

## Features

- **Technician Details Input**: Enter technician location, name, repair cost, and pay rate.
- **Pay Calculation**: Automatically calculate pay based on the entered details.
- **Report Generation**: Generate a formatted report with technician details and calculated pay.
- **File Saving**: Save the generated report to a text file.

## Technologies Used

- Java
- Java Swing for GUI
- JUnit for testing

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your machine.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/HChristopherNaoyuki/technician-app-java.git
   cd technician-management-app
   ```

2. Compile the Java files:

   ```bash
   javac Solution/*.java
   ```

3. Run the application:

   ```bash
   java Solution.TechnicianApp
   ```

### Usage

1. Select the technician's location from the dropdown menu.
2. Enter the technician's name, repair cost, and rate (%).
3. Click "Process Report" to calculate the pay and generate the report.
4. Click "Save Report" to save the generated report to a text file.

### Testing

To run the tests, ensure you have JUnit in your classpath and execute:

```bash
java -cp .:junit-platform-console-standalone-<version>.jar org.junit.platform.console.ConsoleLauncher
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License.
