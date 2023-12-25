/**
 * class SimpsonsTabber - an example of a tabbed pane window
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import model.ServiceStation;

public class ServiceStationTabber extends JTabbedPane
{
        private ServiceStation serviceStation;
    public ServiceStationTabber(ServiceStation serviceStation)
    {
        this.serviceStation = serviceStation;
        setup();
        build();
        setVisible(true);
    }

    private void setup()
    {
    }

    private void build()
    {
       ;


//        addTabs.addtab("Services",addTab);
//        addPanel.add(addTabs);
//        add("Add", addPanel);

        add("ADD",new AddPanel(serviceStation));
        add("Edit", new EditPanel(serviceStation));
        add("Report", new ReportPanel(serviceStation));
    }
}