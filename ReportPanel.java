import javax.swing.*;

import model.*;
import model.Record;

public class ReportPanel extends JPanel implements MyObserver
{   
    private ServiceStation serviceStation;
    private JTextArea servicesTextArea = new JTextArea();

    public ReportPanel(ServiceStation serviceStation)
    {   
        this.serviceStation= serviceStation;
        setup();
        build();
    }

    private void setup()
    {
        servicesTextArea.setEditable(false);
        this.serviceStation.attach(this);
        this.serviceStation.getServices().attach(this);
    }

    private void build()
    {  
        add(servicesTextArea);
    }

    @Override
    public void update() {
        for (Record movie : serviceStation.getServices().getList())
        {
            movie.attach(this);
        }
        servicesTextArea.setText(serviceStation.getServices().toString());
    }

    @Override
    public void update(AddOrEdit ops) {
        update();
    }
}
