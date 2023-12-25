package model;

/**
 * class Record - complete
 */
public class Record extends Updater
{
    protected int id;
    protected String name;


    public Record(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public boolean matches(int id)
    {
        return this.id == id;
    }

    public void show()
    {   
        System.out.println(toString()); 
    }  

    public String toString()
    {
        return id + " " + name;
    }
}
