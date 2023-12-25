import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import model.*;
import model.Record;

public class EditPanel extends JPanel {
    private ServiceStation serviceStation;

    public EditPanel(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
        setup();
        build();
    }

    private void setup() {
        setLayout(new GridLayout(3, 1)); // r, c
    }

    private void build() {
        add(new EditServicePanel(serviceStation.getServices()));
        add(new EditTechnicianPanel(serviceStation.getTechnicians()));
    }

    public class EditServicePanel extends JPanel implements MyObserver {

        private JTextField idTxt = new JTextField(8);
        private JTextField nameTxt = new JTextField(8);
        private JTextField modelTxt = new JTextField(8);
        private JTextField dateTxt = new JTextField(8);
        private JRadioButton bodywashRadioBtn = new JRadioButton("Bodywash");
        private JRadioButton oilChangeRadioBtn = new JRadioButton("Oil Change");
        private JRadioButton fullServiceRadioBtn = new JRadioButton("Full Service");
        private JRadioButton bookedRadioBtn = new JRadioButton("Booked");
        private JRadioButton startedRadioBtn = new JRadioButton("Started");
        private JRadioButton processingRadioBtn = new JRadioButton("Processing");
        private JRadioButton finishedRadioBtn = new JRadioButton("Finished");
        private JButton saveServiceBtn = new JButton("Save Service");
        private JLabel resultLbl = new JLabel("-");

        private ButtonGroup serviceTypeButtonGroup = new ButtonGroup();
        private ButtonGroup statusButtonGroup = new ButtonGroup();

        public EditServicePanel(Services services) {
            setup();
            build();
            serviceStation.attach(this);
            services.attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(15, 1)); // Increase the number of rows
            saveServiceBtn.addActionListener(new SaveBtnListener());

            // Add radio buttons to the button groups
            serviceTypeButtonGroup.add(bodywashRadioBtn);
            serviceTypeButtonGroup.add(oilChangeRadioBtn);
            serviceTypeButtonGroup.add(fullServiceRadioBtn);

            statusButtonGroup.add(bookedRadioBtn);
            statusButtonGroup.add(startedRadioBtn);
            statusButtonGroup.add(processingRadioBtn);
            statusButtonGroup.add(finishedRadioBtn);
        }

        private void build() {
            add(new JLabel("Edit Services"));
            add(Box.createHorizontalStrut(0));
            addPair("ID: ", idTxt);
            addPair("Name: ", nameTxt);
            addPair("Model: ", modelTxt);
            addPair("Date: ", dateTxt);

            // Add radio buttons for ServiceType to the panel
            add(new JLabel("Service Type:"));
            add(bodywashRadioBtn);
            add(oilChangeRadioBtn);
            add(fullServiceRadioBtn);

            // Add space between Service Type and Status
            add(createSpacePanel(10)); // Adjust the height as needed

            // Add radio buttons for Status to the panel
            add(new JLabel("Status:"));
            add(bookedRadioBtn);
            add(startedRadioBtn);
            add(processingRadioBtn);
            add(finishedRadioBtn);

            add(saveServiceBtn);
            add(resultLbl);
        }

        private void addPair(String lbl, JTextField txt) {
            add(new JLabel(lbl));
            add(txt);
        }

        private class SaveBtnListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idTxt.getText());
                    var service = serviceStation.getServices().find(id);
                    if (service != null) {
                        // Get the selected ServiceType and Status from the radio buttons
                        ServiceType selectedServiceType = getServiceTypeFromRadioButtons();
                        Status selectedStatus = getStatusFromRadioButtons();

                        service.set(
                                nameTxt.getText(),
                                modelTxt.getText(),
                                dateTxt.getText(),
                                selectedServiceType,
                                selectedStatus
                        );
                        clearFields();
                        resultLbl.setText("Service with ID " + id + " successfully edited");
                    } else {
                        resultLbl.setText("Service with ID " + id + " unavailable!");
                    }
                } catch (NumberFormatException ex) {
                    resultLbl.setText("Invalid ID format");
                }
            }
        }

        private ServiceType getServiceTypeFromRadioButtons() {
            if (bodywashRadioBtn.isSelected()) {
                return ServiceType.BODYWASH;
            } else if (oilChangeRadioBtn.isSelected()) {
                return ServiceType.OIL_CHANGE;
            } else if (fullServiceRadioBtn.isSelected()) {
                return ServiceType.FULL_SERVICE;
            } else {
                // Default ServiceType if none selected
                return ServiceType.FULL_SERVICE;
            }
        }

        private Status getStatusFromRadioButtons() {
            if (bookedRadioBtn.isSelected()) {
                return Status.Booked;
            } else if (startedRadioBtn.isSelected()) {
                return Status.Started;
            } else if (processingRadioBtn.isSelected()) {
                return Status.Processing;
            } else if (finishedRadioBtn.isSelected()) {
                return Status.Finished;
            } else {
                // Default Status if none selected
                return Status.Booked;
            }
        }

        private void clearFields() {
            idTxt.setText("");
            nameTxt.setText("");
            modelTxt.setText("");
            dateTxt.setText("");
            serviceTypeButtonGroup.clearSelection(); // Clear radio button selection for ServiceType
            statusButtonGroup.clearSelection(); // Clear radio button selection for Status
        }

        // Helper method to create an empty panel with a specified height
        private JPanel createSpacePanel(int height) {
            JPanel spacePanel = new JPanel();
            spacePanel.setPreferredSize(new Dimension(0, height));
            return spacePanel;
        }

        @Override
        public void update() {

        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.EDIT)
                resultLbl.setText("Service Edited");
            else
                for (Record service : serviceStation.getServices().getList()) {
                    service.attach(this);
                }
        }
    }

    public class EditTechnicianPanel extends JPanel implements MyObserver {

        private JTextField idTxt = new JTextField(8);
        private JTextField nameTxt = new JTextField(8);
        private JTextField numberTxt = new JTextField(8);
        private JTextField levelTxt = new JTextField(8);
        private JButton saveTechnicianBtn = new JButton("Save Technician");
//        private JLabel resultLbl = new JLabel("-");
        private JLabel resultLbl2 = new JLabel("-");

        public EditTechnicianPanel(Technicians technicians) {
            setup();
            build();
            serviceStation.attach(this);
            serviceStation.getTechnicians().attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(6, 2));
            saveTechnicianBtn.addActionListener(new SaveBtnListener());
        }

        private void build() {
            add(new JLabel("Edit Technician"));
            add(Box.createHorizontalStrut(0));
            addPair("ID: ", idTxt);
            addPair("Name: ", nameTxt);
            addPair("Number: ", numberTxt);
            addPair("Level: ", levelTxt);
            add(saveTechnicianBtn);
            add(resultLbl2);
        }

        private void addPair(String lbl, JTextField txt) {
            add(new JLabel(lbl));
            add(txt);
        }

        private class SaveBtnListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idTxt.getText());
                    var technician = serviceStation.getTechnicians().find(id);
                    if (technician != null) {
                        technician.set(nameTxt.getText(), numberTxt.getText(), levelTxt.getText());
                        clearFields();
                        resultLbl2.setText("Technician with ID " + id + " successfully edited");
                    } else {
                        resultLbl2.setText("Technician with ID " + id + " unavailable!");
                    }
                } catch (NumberFormatException ex) {
                    resultLbl2.setText("Invalid ID format");
                }
            }
        }

        private void clearFields() {
            idTxt.setText("");
            nameTxt.setText("");
            numberTxt.setText("");
            levelTxt.setText("");
        }

        @Override
        public void update() {

        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.EDIT) {
            }
            else
                for (Record service : serviceStation.getServices().getList()) {
                    service.attach(this);
                }
        }
    }
}
