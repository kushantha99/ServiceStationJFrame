import javax.swing.*;

import model.*;
import model.Record;

import java.awt.*;

public class ReportPanel extends JPanel implements MyObserver
{
    private ServiceStation serviceStation;
    private JTextArea servicesTextArea = new JTextArea();
    private JTextArea techniciansTextArea = new JTextArea();

    public ReportPanel(ServiceStation serviceStation)
    {
        this.serviceStation = serviceStation;
        setup();
        build();
    }

    private void setup()
    {
        setLayout(new GridLayout(6, 2));
        servicesTextArea.setEditable(false);
        this.serviceStation.attach(this);
        this.serviceStation.getServices().attach(this);

        techniciansTextArea.setEditable(false);
        this.serviceStation.getTechnicians().attach(this);
    }

    private void build()
    {
        add(Box.createHorizontalStrut(0));
        add(servicesTextArea);
        add(techniciansTextArea);
    }

    @Override
    public void update() {
        for (Record service : serviceStation.getServices().getList())
        {
            service.attach(this);
        }
        servicesTextArea.setText(serviceStation.getServices().toString());

        for (Record technician : serviceStation.getTechnicians().getList())
        {
            technician.attach(this);
        }
        techniciansTextArea.setText(serviceStation.getTechnicians().toString());
    }

    @Override
    public void update(AddOrEdit ops) {
        update();
    }
}