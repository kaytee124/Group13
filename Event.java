public class Event {
    String title;
    String description, date, time;

    public Event(String title,String description, String date, String time)
    {
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
    }

    public void setevent(String title)
    {
        this.title = title;

    }

    public void setdescription(String description)
    {
        this.description = description;
    }

    public void setdate(String date)
    {
        this.date = date;
    }

    public void settime(String time)
    {
        this.time = time;

    }
    
    public String getEvent() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Event title = " + getEvent()+ "\n" + "Description = " + getDescription() + "\n" + "time = " + getTime() +"\n"+  " Date= " + getDate();
    }

}
