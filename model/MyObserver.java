package model;
public interface MyObserver
{
    public void update();

    public void update(AddOrEdit ops);
}
