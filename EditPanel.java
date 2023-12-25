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
        private JTextField typeTxt = new JTextField(8);
        private JButton saveServiceBtn = new JButton("Save Service");
        private JLabel resultLbl = new JLabel("-");

        public EditServicePanel(Services services) {
            setup();
            build();
            serviceStation.attach(this);
            services.attach(this);
        }

        private void setup() {
            setLayout(new GridLayout(6, 2));
            saveServiceBtn.addActionListener(new SaveBtnListener());
        }

        private void build() {
            add(new JLabel("Edit Services"));
            add(Box.createHorizontalStrut(0));
            addPair("ID: ", idTxt);
            addPair("Name: ", nameTxt);
            addPair("Model: ", modelTxt);
            addPair("Date: ", dateTxt);
            addPair("Type: ", typeTxt);
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
                        service.set(nameTxt.getText(), modelTxt.getText(), dateTxt.getText(), ServiceType.FULL_SERVICE,
                                Status.Booked);
                        clearFields(); // Clear input fields after successful edit
                    } else {
                        resultLbl.setText("Service with ID " + id + " unavailable!");
                    }
                } catch (NumberFormatException ex) {
                    resultLbl.setText("Invalid ID format");
                }
            }
        }

        private void clearFields() {
            idTxt.setText("");
            nameTxt.setText("");
            modelTxt.setText("");
            dateTxt.setText("");
            typeTxt.setText("");
        }

        @Override
        public void update() {
            resultLbl.setText("Service Edited");
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
        private JLabel resultLbl = new JLabel("-");

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
                    var technician = serviceStation.getTechnicians().find(id);
                    if (technician != null) {
                        technician.set(nameTxt.getText(), numberTxt.getText(), levelTxt.getText());
                        clearFields(); // Clear input fields after successful edit
                    } else {
                        resultLbl.setText("Technician with ID " + id + " unavailable!");
                    }
                } catch (NumberFormatException ex) {
                    resultLbl.setText("Invalid ID format");
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
            resultLbl.setText("Technician Edited");
        }

        @Override
        public void update(AddOrEdit ops) {
            if (ops == AddOrEdit.EDIT)
                resultLbl.setText("Technician Edited");
            else
                for (Record service : serviceStation.getServices().getList()) {
                    service.attach(this);
                }
        }
    }
}
