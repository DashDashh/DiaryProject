import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Month {

    public static String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    private static final Calendar today = Calendar.getInstance();
    public static int thisMonth = today.get(Calendar.MONTH);

    public static void makeDayButton(JButton button, int x, int y, JFrame frame){
        button.setBounds(x, y, 100, 100);
        button.setVisible(true);
        int xb = button.getX();
        int yb = button.getY();
        int numButton = (xb - 250) / 100 + ((yb - 100) / 100) * 7;
        button.addActionListener(_ -> {
            if(!(button.getText()).isEmpty()) {
                WindowForDay.showFrame(Integer.parseInt(button.getText()), thisMonth, numButton, button);
            }
        });
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setVerticalTextPosition(SwingConstants.TOP);
        if(!MonthDB.nameofEvent[numButton].equals(" ")){
            if(MonthDB.pictureOfEvent[numButton].equals(MonthDB.party)){
                button.setIcon(new ImageIcon("partyMini.png"));
            }else if(MonthDB.pictureOfEvent[numButton].equals(MonthDB.book)){
                button.setIcon(new ImageIcon("booksMini.png"));
            }else{
                button.setIcon(new ImageIcon("concertMini.png"));
            }
        }
        frame.add(button);
    }
    public static void makingButtons(Calendar today, JFrame frameMonth){
        Calendar firstDay = Calendar.getInstance();
        firstDay.setTime(new Date());
        firstDay.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayWeek = firstDay.get(Calendar.DAY_OF_WEEK) - 1;
        if(firstDayWeek == -1){
            firstDayWeek = 7;
        }
        int days = 1;
        JButton button1 = new JButton();
        makeDayButton(button1, 250, 100, frameMonth);
        if(firstDayWeek == 1){
            button1.setText(Integer.toString(days));
            days += 1;
        }
        JButton button2 = new JButton();
        if(firstDayWeek == 2 || days != 1){
            button2.setText(Integer.toString(days));
            days += 1;
        }
        makeDayButton(button2, 350, 100, frameMonth);
        JButton button3 = new JButton();
        if(firstDayWeek == 3 || days != 1){
            button3.setText(Integer.toString(days));
            days += 1;
        }
        makeDayButton(button3, 450, 100, frameMonth);
        JButton button4 = new JButton();
        if(firstDayWeek == 4 || days != 1){
            button4.setText(Integer.toString(days));
            days += 1;
        }
        makeDayButton(button4, 550, 100, frameMonth);
        JButton button5 = new JButton();
        if(firstDayWeek == 5 || days != 1){
            button5.setText(Integer.toString(days));
            days += 1;
        }
        makeDayButton(button5, 650, 100, frameMonth);
        JButton button6 = new JButton();
        if(firstDayWeek == 6 || days != 1){
            button6.setText(Integer.toString(days));
            days += 1;
        }
        makeDayButton(button6, 750, 100, frameMonth);
        JButton button7 = new JButton(Integer.toString(days));
        makeDayButton(button7, 850, 100, frameMonth);
        JButton button8 = new JButton(Integer.toString(days + 1));
        makeDayButton(button8, 250, 200, frameMonth);
        JButton button9 = new JButton(Integer.toString(days + 2));
        makeDayButton(button9, 350, 200, frameMonth);
        JButton button10 = new JButton(Integer.toString(days + 3));
        makeDayButton(button10, 450, 200, frameMonth);
        JButton button11 = new JButton(Integer.toString(days + 4));
        makeDayButton(button11, 550, 200, frameMonth);
        JButton button12 = new JButton(Integer.toString(days + 5));
        makeDayButton(button12, 650, 200, frameMonth);
        JButton button13 = new JButton(Integer.toString(days + 6));
        makeDayButton(button13, 750, 200, frameMonth);
        JButton button14 = new JButton(Integer.toString(days + 7));
        makeDayButton(button14, 850, 200, frameMonth);
        JButton button15 = new JButton(Integer.toString(days + 8));
        makeDayButton(button15, 250, 300, frameMonth);
        JButton button16 = new JButton(Integer.toString(days + 9));
        makeDayButton(button16, 350, 300, frameMonth);
        JButton button17 = new JButton(Integer.toString(days + 10));
        makeDayButton(button17, 450, 300, frameMonth);
        JButton button18 = new JButton(Integer.toString(days + 11));
        makeDayButton(button18, 550, 300, frameMonth);
        JButton button19 = new JButton(Integer.toString(days + 12));
        makeDayButton(button19, 650, 300, frameMonth);
        JButton button20 = new JButton(Integer.toString(days + 13));
        makeDayButton(button20, 750, 300, frameMonth);
        JButton button21 = new JButton(Integer.toString(days + 14));
        makeDayButton(button21, 850, 300, frameMonth);
        JButton button22 = new JButton(Integer.toString(days + 15));
        makeDayButton(button22, 250, 400, frameMonth);
        JButton button23 = new JButton(Integer.toString(days + 16));
        makeDayButton(button23, 350, 400, frameMonth);
        JButton button24 = new JButton(Integer.toString(days + 17));
        makeDayButton(button24, 450, 400, frameMonth);
        JButton button25 = new JButton(Integer.toString(days + 18));
        makeDayButton(button25, 550, 400, frameMonth);
        JButton button26 = new JButton(Integer.toString(days + 19));
        makeDayButton(button26, 650, 400, frameMonth);
        JButton button27 = new JButton(Integer.toString(days + 20));
        makeDayButton(button27, 750, 400, frameMonth);
        JButton button28 = new JButton(Integer.toString(days + 21));
        makeDayButton(button28, 850, 400, frameMonth);
        JButton button29 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 22);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button29.setText(Integer.toString(days + 22));
        }
        makeDayButton(button29, 250, 500, frameMonth);
        JButton button30 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 23);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button30.setText(Integer.toString(days + 23));
        }
        makeDayButton(button30, 350, 500, frameMonth);
        JButton button31 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 24);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button31.setText(Integer.toString(days + 24));
        }
        makeDayButton(button31, 450, 500, frameMonth);
        JButton button32 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 25);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button32.setText(Integer.toString(days + 25));
        }
        makeDayButton(button32, 550, 500, frameMonth);
        JButton button33 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 26);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button33.setText(Integer.toString(days + 26));
        }
        makeDayButton(button33, 650, 500, frameMonth);
        JButton button34 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 27);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button34.setText(Integer.toString(days + 27));
        }
        makeDayButton(button34, 750, 500, frameMonth);
        JButton button35 = new JButton();
        firstDay.set(Calendar.DAY_OF_MONTH, days + 28);
        if(firstDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            button35.setText(Integer.toString(days + 28));
        }
        makeDayButton(button35, 850, 500, frameMonth);
    }
    public static void showFrame(){
        JFrame frameMonth = new JFrame("Ежедневник");
        frameMonth.setSize(1280, 720);
        frameMonth.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMonth.setLayout(null);
        frameMonth.setVisible(true);
        JLabel diary = new JLabel(months[today.get(Calendar.MONTH)]);
        diary.setBounds(550, 10, 300, 50);
        diary.setFont(new Font("Arial", Font.BOLD, 50));
        diary.setVisible(true);
        frameMonth.add(diary);

        makingButtons(today, frameMonth);

        JButton toWeek = new JButton("Неделя");
        toWeek.setBounds(1010, 10, 200, 20);
        toWeek.setFont(new Font("Arial", Font.BOLD, 14));
        toWeek.setVisible(true);
        frameMonth.add(toWeek);
        toWeek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMonth.setVisible(false);
                try {
                    Week.showFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton toTracker = new JButton("Трекер привычек");
        toTracker.setBounds(1010, 32, 200, 20);
        toTracker.setFont(new Font("Arial", Font.BOLD, 14));
        toTracker.setVisible(true);
        frameMonth.add(toTracker);
        toTracker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMonth.setVisible(false);
                Tracker.showFrame();
            }
        });

        frameMonth.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    TrackerDB.saveTrackerDB();
                    WeekDB.saveWeekDB();
                    MonthDB.saveMonthDB();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}