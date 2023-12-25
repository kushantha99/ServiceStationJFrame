package model;
import java.util.*;
public class Updater
{
    protected LinkedList<MyObserver> views = new LinkedList<MyObserver>();   

    public void attach(MyObserver o)
    {   
        if (!views.contains(o))
            views.add(o);   
    }  

    public void detach(MyObserver o)
    {   
        views.remove(o);    
    }                

    public void updateViews()
    {   
        for(MyObserver view : views)
            view.update(); 
    }

    public void updateViews(AddOrEdit ops)
    {   
        for(MyObserver view : views)
            view.update(ops); 
    }

}
