import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Tracker {
    public static void makeWaterButtons(JButton waterButton, JFrame Frame, Integer x, Integer ind){
        waterButton.setBounds(x, 100, 50, 50);
        waterButton.setFont(new Font("Arial", Font.PLAIN, 14));
        waterButton.setVisible(true);
        Frame.add(waterButton);
        waterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(TrackerDB.water[ind] < 8) {
                    TrackerDB.water[ind] += 1;
                }else{
                    TrackerDB.water[ind] = 0;
                }
                waterButton.setText(TrackerDB.water[ind].toString());
            }
        });
    }
    public static void makeHabbitButtons(JButton HabbitButton, JFrame frame, Integer x, Integer y, Integer ind1, Integer ind2){
        if(!TrackerDB.habTrackers[ind1][ind2]){
            HabbitButton.setText("○");
        }else{
            HabbitButton.setText("●");
        }
        HabbitButton.setFont(new Font("Arial", Font.BOLD, 50));
        HabbitButton.setBounds(x, y, 70, 70);
        HabbitButton.setOpaque(false);
        HabbitButton.setContentAreaFilled(false);
        HabbitButton.setBorderPainted(false);
        HabbitButton.setVisible(true);
        HabbitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!TrackerDB.habTrackers[ind1][ind2]) {
                    HabbitButton.setText("●");
                }else{
                    HabbitButton.setText("○");
                }
                TrackerDB.habTrackers[ind1][ind2] = !TrackerDB.habTrackers[ind1][ind2];
            }
        });
        frame.add(HabbitButton);
    }
    public static void showFrame(){
        JFrame frameTracker = new JFrame("Ежедневник");
        frameTracker.setSize(1280, 720);
        frameTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTracker.setLayout(null);
        frameTracker.setVisible(true);
        JLabel diary = new JLabel("Трекер");
        diary.setBounds(550, 10, 300, 50);
        diary.setFont(new Font("Arial", Font.BOLD, 50));
        diary.setVisible(true);
        frameTracker.add(diary);

        JLabel waterBalance = new JLabel("Водный баланс:");
        waterBalance.setFont(new Font("Arial", Font.ITALIC, 20));
        waterBalance.setBounds(10, 110, 200, 20);
        waterBalance.setVisible(true);
        frameTracker.add(waterBalance);

        JButton watMon = new JButton(TrackerDB.water[0].toString());
        makeWaterButtons(watMon, frameTracker, 200, 0);

        JButton watTue = new JButton(TrackerDB.water[1].toString());
        makeWaterButtons(watTue, frameTracker, 250, 1);

        JButton watWed = new JButton(TrackerDB.water[2].toString());
        makeWaterButtons(watWed, frameTracker, 300, 2);

        JButton watThu = new JButton(TrackerDB.water[3].toString());
        makeWaterButtons(watThu, frameTracker, 350, 3);

        JButton watFri = new JButton(TrackerDB.water[4].toString());
        makeWaterButtons(watFri, frameTracker, 400, 4);

        JButton watSat = new JButton(TrackerDB.water[5].toString());
        makeWaterButtons(watSat, frameTracker, 450, 5);

        JButton watSun = new JButton(TrackerDB.water[6].toString());
        makeWaterButtons(watSun, frameTracker, 500, 6);

        JLabel habits = new JLabel("Привычки:");
        habits.setFont(new Font("Arial", Font.BOLD, 20));
        habits.setBounds(10, 150, 150, 100);
        habits.setVisible(true);
        frameTracker.add(habits);
        JTextField hab1 = new JTextField(TrackerDB.habNames[0]);
        hab1.setFont(new Font("Arial", Font.PLAIN, 15));
        hab1.setBounds(10, 230, 150, 40);
        hab1.setVisible(true);
        frameTracker.add(hab1);

        JButton mon1 = new JButton();
        makeHabbitButtons(mon1, frameTracker, 150, 205, 0, 0);

        JButton tue1 = new JButton();
        makeHabbitButtons(tue1, frameTracker, 200, 205, 0, 1);

        JButton wed1 = new JButton();
        makeHabbitButtons(wed1, frameTracker, 250, 205, 0, 2);

        frameTracker.add(wed1);
        JButton thu1 = new JButton();
        makeHabbitButtons(thu1, frameTracker, 300, 205, 0, 3);

        JButton fri1 = new JButton();
        makeHabbitButtons(fri1, frameTracker, 350, 205, 0, 4);

        JButton sat1 = new JButton();
        makeHabbitButtons(sat1, frameTracker, 400, 205, 0, 5);

        JButton sun1 = new JButton();
        makeHabbitButtons(sun1, frameTracker, 450, 205, 0, 6);

        JTextField hab2 = new JTextField(TrackerDB.habNames[1], 16);
        hab2.setFont(new Font("Arial", Font.PLAIN, 15));
        hab2.setBounds(10, 280, 150, 40);
        hab2.setVisible(true);
        frameTracker.add(hab2);
        JButton mon2 = new JButton();
        makeHabbitButtons(mon2, frameTracker, 150, 255, 1, 0);

        JButton tue2 = new JButton();
        makeHabbitButtons(tue2, frameTracker, 200, 255, 1, 1);

        JButton wed2 = new JButton();
        makeHabbitButtons(wed2, frameTracker, 250, 255, 1, 2);

        JButton thu2 = new JButton();
        makeHabbitButtons(thu2, frameTracker, 300, 255, 1, 3);

        JButton fri2 = new JButton();
        makeHabbitButtons(fri2, frameTracker, 350, 255, 1, 4);

        JButton sat2 = new JButton();
        makeHabbitButtons(sat2, frameTracker, 400, 255, 1, 5);

        JButton sun2 = new JButton();
        makeHabbitButtons(sun2, frameTracker, 450, 255, 1, 6);


        JTextField hab3 = new JTextField(TrackerDB.habNames[2], 16);
        hab3.setFont(new Font("Arial", Font.PLAIN, 15));
        hab3.setBounds(10, 330, 150, 40);
        hab3.setVisible(true);
        frameTracker.add(hab3);
        JButton mon3 = new JButton();
        makeHabbitButtons(mon3, frameTracker,150, 305, 2, 0);

        JButton tue3 = new JButton();
        makeHabbitButtons(tue3, frameTracker, 200, 305, 2, 1);

        JButton wed3 = new JButton();
        makeHabbitButtons(wed3, frameTracker, 250, 305, 2, 2);

        JButton thu3 = new JButton();
        makeHabbitButtons(thu3, frameTracker, 300, 305, 2, 3);

        JButton fri3 = new JButton();
        makeHabbitButtons(fri3, frameTracker, 350, 305, 2, 4);

        JButton sat3 = new JButton();
        makeHabbitButtons(sat3, frameTracker, 400, 305, 2, 5);

        JButton sun3 = new JButton();
        makeHabbitButtons(sun3, frameTracker, 450, 305, 2, 6);


        JButton toWeek = new JButton("Неделя");
        toWeek.setBounds(1010, 10, 200, 20);
        toWeek.setFont(new Font("Arial", Font.BOLD, 14));
        toWeek.setVisible(true);
        frameTracker.add(toWeek);
        toWeek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TrackerDB.habNames[0] = hab1.getText();
                TrackerDB.habNames[1] = hab2.getText();
                TrackerDB.habNames[2] = hab3.getText();
                frameTracker.setVisible(false);
                try {
                    Week.showFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton toMonth = new JButton("Месяц");
        toMonth.setBounds(1010, 32, 200, 20);
        toMonth.setFont(new Font("Arial", Font.BOLD, 14));
        toMonth.setVisible(true);
        frameTracker.add(toMonth);
        toMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TrackerDB.habNames[0] = hab1.getText();
                TrackerDB.habNames[1] = hab2.getText();
                TrackerDB.habNames[2] = hab3.getText();
                frameTracker.setVisible(false);
                Month.showFrame();
            }
        });
        frameTracker.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TrackerDB.habNames[0] = hab1.getText();
                TrackerDB.habNames[1] = hab2.getText();
                TrackerDB.habNames[2] = hab3.getText();
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