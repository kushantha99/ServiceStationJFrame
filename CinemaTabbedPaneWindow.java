///**
// * class TabbedPaneWindow - an example of a tabbed pane window
// */
//import java.awt.*;
//import javax.swing.*;
//import model.Cinema;
//
//public class CinemaTabbedPaneWindow extends JFrame
//{
//    private Cinema cinema;
//    public CinemaTabbedPaneWindow(Cinema cinema)
//    {
//        super("Cinema System");
//        this.cinema = cinema;
//        setup();
//        build();
//        setVisible(true);
//    }
//
//    private void setup()
//    {
//        setSize(500, 500);
//        setLocation(200, 200);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    private void build()
//    {
//        CinemaTabber pane = new CinemaTabber(cinema);
//        add(pane);
//    }
//}