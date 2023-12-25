/**
 * class TabbedPaneWindow - an example of a tabbed pane window
 */
import javax.swing.*;

import model.ServiceStation;

public class ServiceStationTabbedPaneWindows extends JFrame
{
    private ServiceStation serviceStation;
    public ServiceStationTabbedPaneWindows(ServiceStation serviceStation)
    {
        super("Service Station System");
        this.serviceStation = serviceStation;
        setup();
        build();
        setVisible(true);
    }

    private void setup()
    {
        setSize(900, 700);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void build()
    {
        ServiceStationTabber pane = new ServiceStationTabber(serviceStation);
        add(pane);
    }
}