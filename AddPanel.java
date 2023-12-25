import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;

public class AddPanel extends JPanel {
    private ServiceStation serviceStation;

    public AddPanel(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
        setup();
        build();
    }

    private void setup() {
        setLayout(new GridLayout(3, 1));
    }

    private void build() {
        add(new AddServicePanel(serviceStation.getServices()));
        add(new AddTechnicianPanel(serviceStation.getTechnicians()));
    }

    public class AddServicePanel extends JPanel implements MyObserver {
        private Services services;
        private JTextField nameTxt = new JTextField(8);
        private JTextField modelTxt = new JTextField(8);
        private JTextField dateTxt = new JTextField(8);
        private JButton ADD = new JButton("ADD");
        private JLabel resultLbl = new JLabel("-");
        private JRadioButton bodywashRadioButton = new JRadioButton("Bodywash");
        private JRadioButton oilChangeRadioButton = new JRadioButton("Oil Change");
        private JRadioButton fullServiceRadioButton = new JRadioButton("Full Service");
        private ButtonGroup serviceTypeGroup = new ButtonGroup();

        public AddServicePanel(Services services) {
            this.services = services;
            setup();
            build();
            this.services.attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(9, 2)); // Updated rows to accommodate radio buttons

            // Group the radio buttons
            serviceTypeGroup.add(bodywashRadioButton);
            serviceTypeGroup.add(oilChangeRadioButton);
            serviceTypeGroup.add(fullServiceRadioButton);

            ADD.addActionListener(new ADD());
        }

        private void build() {
            add(new JLabel("Add Service"));
            add(Box.createHorizontalStrut(0));

            addPair("name : ", nameTxt);
            addPair("model : ", modelTxt);
            addPair("date : ", dateTxt);

            // Add radio buttons
            add(new JLabel("type : "));
            add(bodywashRadioButton);
            add(new JLabel(""));
            add(oilChangeRadioButton);
            add(new JLabel(""));
            add(fullServiceRadioButton);

            add(ADD);
            add(resultLbl);
        }

        private void addPair(String lbl, JTextField txt) {
            add(new JLabel(lbl));
            add(txt);
        }

        private class ADD implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceType selectedServiceType = getServiceType();
                services.add(nameTxt.getText(), modelTxt.getText(), dateTxt.getText(), selectedServiceType, Status.Booked);
            }
        }

        private ServiceType getServiceType() {
            if (bodywashRadioButton.isSelected()) {
                return ServiceType.BODYWASH;
            } else if (oilChangeRadioButton.isSelected()) {
                return ServiceType.OIL_CHANGE;
            } else if (fullServiceRadioButton.isSelected()) {
                return ServiceType.FULL_SERVICE;
            } else {
                // Default to FULL_SERVICE if no radio button is selected
                return ServiceType.FULL_SERVICE;
            }
        }

        @Override
        public void update() {
            resultLbl.setText("Service Added");
        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.ADD)
                resultLbl.setText("Service Added");
        }
    }

    public class AddTechnicianPanel extends JPanel implements MyObserver {
        private Technicians technicians;
        private JTextField nameTxt = new JTextField(8);
        private JTextField numberTxt = new JTextField(8);
        private JTextField levelTxt = new JTextField(8);
        private JButton ADD = new JButton("ADD");
        private JLabel resultLbl = new JLabel("-");

        public AddTechnicianPanel(Technicians technicians) {
            this.technicians = technicians;
            setup();
            build();
            this.technicians.attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(5, 2)); // 5 rows, 2 columns
            ADD.addActionListener(new ADD());
        }

        private void build() {
            add(new JLabel("Add Technicians"));
            add(Box.createHorizontalStrut(0));
            addPair("name : ", nameTxt);
            addPair("number : ", numberTxt);
            addPair("level : ", levelTxt);
            add(ADD);
            add(resultLbl);
        }

        private void addPair(String lbl, JTextField txt) {
            add(new JLabel(lbl));
            add(txt);
        }

        private class ADD implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                technicians.add(nameTxt.getText(), numberTxt.getText(), levelTxt.getText());
            }
        }

        @Override
        public void update() {
            resultLbl.setText("Technician Added");
        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.ADD)
                resultLbl.setText("Technician Added");
        }
    }

    public static void main(String[] args) {
        // Sample usage
        ServiceStation serviceStation = new ServiceStation();
        JFrame frame = new JFrame("AddPanel Demo");
        AddPanel addPanel = new AddPanel(serviceStation);
        frame.getContentPane().add(addPanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
