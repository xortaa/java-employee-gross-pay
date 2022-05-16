import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestCompute extends JFrame{
    public static void main(String[] args) throws Exception {
       new Frame();
    }
}

class Frame extends JFrame {
    String name;
    String natureOfWork;
    String position;
    int hoursWorked;
    int rate;
    int allowance;
    int grossPay;
    String[] natureOptions = { "field", "office" };
    String[] positions = { "manager", "supervisor", "employee" };

    Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(438, 720);
        this.setLayout(new GridLayout(5, 1));
        this.setResizable(false);

        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(200, 50));
        panel1.add(nameLabel);
        panel1.add(nameTextField);

        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel natureLabel = new JLabel("Nature of Work: ");
        JComboBox<String> natureComboBox = new JComboBox<>(natureOptions);
        panel2.add(natureLabel);
        panel2.add(natureComboBox);

        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel positionLabel = new JLabel("Job Position: ");
        JComboBox<String> positionComboBox = new JComboBox<>(positions);
        panel3.add(positionLabel);
        panel3.add(positionComboBox);

        JPanel panel4 = new JPanel(new FlowLayout());
        JLabel hoursLabel = new JLabel("Hours Worked: ");
        JTextField hoursTextField = new JTextField();
        hoursTextField.setPreferredSize(new Dimension(200, 50));
        panel4.add(hoursLabel);
        panel4.add(hoursTextField);

        JButton button = new JButton("Submit");
        button.addActionListener(event -> {
            if (nameTextField.getText().length() != 0) {
                name = nameTextField.getText();
            } else {
                JOptionPane.showMessageDialog(null, "name input has to be not blank", "error",
                        JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

            natureOfWork = natureComboBox.getSelectedItem().toString();

            if (natureOfWork == "field") {
                allowance = 1000;
            } else {
                allowance = 0;
            }

            position = positionComboBox.getSelectedItem().toString();

            String hours = hoursTextField.getText();

            try {
                hoursWorked = Integer.parseInt(hours);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "hours worked input has to be an integer or not blank", "error",
                        JOptionPane.WARNING_MESSAGE);
                System.exit(0);

            }

            if (position == "manager") {
                Manager manager = new Manager(natureOfWork, hoursWorked);
                grossPay = manager.grossPay();
                rate = 1000;
            } else if (position == "supervisor") {
                Supervisor supervisor = new Supervisor(natureOfWork, hoursWorked);
                grossPay = supervisor.grossPay();
                rate = 700;
            } else if (position == "employee") {
                Employee employee = new Employee(natureOfWork, hoursWorked);
                grossPay = employee.grossPay();
                rate = 300;
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("lab5.csv"));
                writer.write("Name: " + name);
                writer.write("\nNature of work: " + natureOfWork);
                writer.write("\nPosition: " + position);
                writer.write("\nRate: " + rate);
                writer.write("\nNumber of hours worked: " + hoursWorked);
                writer.write("\nAllowance: " + allowance);
                writer.write("\nGross Pay: " + grossPay);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(button);
        this.setVisible(true);
    }
}
