import model.ServiceStation;

public class Root
{
    public Root()
    {
        ServiceStation serviceStation = new ServiceStation();
        new ServiceStationTabbedPaneWindows(serviceStation);
    }

    public static void main(String[] args) {
        new Root();
    }
}
