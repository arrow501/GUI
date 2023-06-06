// import necessary packages
import java.awt.*;
import java.time.*;
import java.time.format.*;
import java.util.Locale;

import javax.swing.*;

// create a custom list model that extends AbstractListModel
class MonthListModel extends AbstractListModel<String> {
  // declare a private array of strings to store the days of the month
  private String[] days;

  // create a constructor that takes the current month and year as parameters
  public MonthListModel(int month, int year) {
    // initialize the array with the length of the month
    days = new String[Month.of(month).length(Year.isLeap(year))];
    // create a date formatter for the day of week
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", new Locale("pl"));
    // loop through the array and fill it with the day number and name
    for (int i = 0; i < days.length; i++) {
      // create a local date object for each day
      LocalDate date = LocalDate.of(year, month, i + 1);
      // format the date as "number - name"
      days[i] = date.getDayOfMonth() + " - " + date.format(formatter);
    }
  }

  // override the getSize method to return the length of the array
  @Override
  public int getSize() {
    return days.length;
  }

  // override the getElementAt method to return the element at the given index
  @Override
  public String getElementAt(int index) {
    return days[index];
  }
}

// create a main class that extends JFrame
public class App extends JFrame {
  // create a constructor that takes no parameters
  public App() {
    // call the super constructor with the title as the current month and year
    super(Month.of(LocalDate.now().getMonthValue()) + "." + LocalDate.now().getYear());
    // set the default close operation to exit on close
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set the size of the frame
    setSize(300, 400);
    // set the layout of the frame to border layout
    setLayout(new BorderLayout());
    // create a JList with a custom list model using the current month and year
    JList<String> list = new JList<>(new MonthListModel(LocalDate.now().getMonthValue(), LocalDate.now().getYear()));
    // create a scroll pane and add the list to it
    JScrollPane scrollPane = new JScrollPane(list);
    // add the scroll pane to the center of the frame
    add(scrollPane, BorderLayout.CENTER);
    // get the current day of month and select it in the list
    int currentDay = LocalDate.now().getDayOfMonth();
    list.setSelectedIndex(currentDay - 1);
    // make the frame visible
    setVisible(true);
  }

  // create a main method that launches the app
  public static void main(String[] args) {
    // create an instance of App
    App app = new App();
  }
}
