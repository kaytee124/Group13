import java.util.*;

public class Calendar {
    private HashMap<String, LinkedList<Event>> eventsByDate; // Map to store events by date
    private PriorityQueue<Event> reminders; // Priority queue for reminders

    public Calendar() {
        eventsByDate = new HashMap<>();
        reminders = new PriorityQueue<>(Comparator.comparing(Event::getDate));
    }

    // Method to create an event
    public void createEvent(String title, String description, String date, String time) {
        Event newEvent = new Event(title, description, date, time);
        LinkedList<Event> events = eventsByDate.getOrDefault(date, new LinkedList<>());
        events.add(newEvent);
        eventsByDate.put(date, events);
        reminders.add(newEvent);
    }

    // Method to modify an event
    public void modifyEvent(String oldDate, Event event) {
        deleteEvent(oldDate, event);
        createEvent(event.getEvent(), event.getDescription(), event.getDate(), event.getTime());
    }

    // Method to delete an event
    public void deleteEvent(String date, Event event) {
        LinkedList<Event> events = eventsByDate.get(date);
        if (events != null) {
            events.remove(event);
            if (events.isEmpty()) {
                eventsByDate.remove(date);
            } else {
                eventsByDate.put(date, events);
            }
        }
        reminders.remove(event);
    }

    // Method to display all events for a single day using a doubly linked list (Daily View)
    public void dailyView(String date) {
        LinkedList<Event> events = eventsByDate.get(date);
        if (events != null) {
            for (Event event : events) {
                System.out.println(event.toString());
            }
        } else {
            System.out.println("No events for this day.");
        }
    }

    // Method to display all events for a particular month using Hashtable (Monthly View)
    public void monthlyView(int month, int year) {
        for (String key : eventsByDate.keySet()) {
            String[] parts = key.split("-");
            int eventMonth = Integer.parseInt(parts[1]);
            int eventYear = Integer.parseInt(parts[0]);
            if (eventMonth == month && eventYear == year) {
                LinkedList<Event> events = eventsByDate.get(key);
                if (events != null) {
                    for (Event event : events) {
                        System.out.println(event.toString());
                    }
                }
            }
        }
    }

    // Method to display event reminders
    public void displayReminders() {
        System.out.println("Upcoming Event Reminders:");
        while (!reminders.isEmpty()) {
            System.out.println(reminders.poll().toString());
            System.out.println("\n");

        }
    }
}

