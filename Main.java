import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar myCalendar = new Calendar();

        boolean contine = true;
        Scanner userinput = new Scanner(System.in);

        while(contine){
            System.out.println("Welcome to Group 13's Event Calendar");
            System.out.println("Please select an option: ");
            System.out.println("1. Add an Event \n" + "2. View an event for a specific day\n" + "3. View Events for a specific Month\n"+ "4. Edit an event\n"+ "5. Delete an Event\n" + "6. Get Reminder\n" + "7. Exit");
            int response= userinput.nextInt();
            userinput.nextLine();
            if ( response == 1)
            {
                System.out.println("Enter the Title");
                
                String Title = userinput.nextLine();
                System.out.println("Description");
                String Description = userinput.nextLine();
                System.out.println("Date(DD-MM-YYYY)");
                String Date = userinput.nextLine();
                System.out.println("Time");
                String Time = userinput.nextLine();
                myCalendar.createEvent(Title, Description, Date, Time);


            }
            else if (response == 2)
            {
                // Displaying daily view for a specific date
                System.out.println("Enter the date for the events you want to view(DD-MM-YYYY)");
                String Date = userinput.nextLine();
                myCalendar.dailyView(Date);

            }
            else if (response == 3)
            {
                // Displaying monthly view for a specific month
                System.out.println("Enter the month you would like to view(1-12)");
                int Month = userinput.nextInt();
                if (Month < 0 && Month > 12)
                {
                    System.out.println("Invalid month. Try again");
                    Month = userinput.nextInt();

                }
                
                userinput.nextLine();
                System.out.println("Enter the year you would like to view.");
                int year = userinput.nextInt();
                myCalendar.monthlyView(Month, year);

            }
            else if (response == 4)
            {
                // Modifying an event
                System.out.println("Enter the date of the event you would like to edit(DD-MM-YYYY)");
                String olddate = userinput.nextLine();
                System.out.println("Enter the Title");
                String Title = userinput.nextLine();
                System.out.println("Description");
                String Description = userinput.nextLine();
                System.out.println("Date");
                String Date = userinput.nextLine();
                System.out.println("Time");
                String Time = userinput.nextLine();
                Event modifiedEvent = new Event(Title, Description, Date,Time);
                myCalendar.modifyEvent(olddate, modifiedEvent);

            }

            else if (response == 5)
            {
                // Deleting an event
                System.out.println("Enter the date of the event you would like to delete(DD-MM_YYY)");
                String olddate = userinput.nextLine();
                System.out.println("Enter the Title");
                String Title = userinput.nextLine();
                System.out.println("Description");
                String Description = userinput.nextLine();
                System.out.println("Date(DD-MM-YYYY)");
                String Date = userinput.nextLine();
                System.out.println("Time");
                String Time = userinput.nextLine();
                
                Event eventToDelete = new Event(Title,Description,Date,Time);
                myCalendar.deleteEvent(olddate, eventToDelete);

            }

            else if(response == 6)
            {
                myCalendar.displayReminders();

            }

            else if (response ==  7)
            {
                break;
            }
        
        }

        userinput.close();
    
    }


}



