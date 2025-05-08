import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Week {
    public static void makeDayWeekLabel(JLabel dayWeek, JFrame frame, int x, int y){
        dayWeek.setFont(new Font("Arial", Font.BOLD, 25));
        dayWeek.setBounds(x, y, 200, 30);
        dayWeek.setVisible(true);
        frame.add(dayWeek);
    }
    public static void makeTasksLabels(JTextField task, JCheckBox tsk, JFrame frame, int x, int y, int x1, int y1, int ind1, int ind2){
        task.setText(WeekDB.taskNames[ind1][ind2]);
        task.setFont(new Font("Arial", Font.PLAIN, 18));
        task.setBounds(x, y, 210, 40);
        task.setVisible(true);
        frame.add(task);
        tsk.setSize(30, 30);
        tsk.setBounds(x1, y1, 30, 30);
        tsk.setSelected(WeekDB.doneTasks[ind1][ind2]);
        tsk.setVisible(true);
        tsk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeekDB.doneTasks[ind1][ind2] = !WeekDB.doneTasks[ind1][ind2];
                System.out.println(WeekDB.doneTasks[ind1][ind2]);
            }
        });
        frame.add(tsk);
    }

    public static void showFrame() throws IOException {
        JFrame frameWeek = new JFrame("Ежедневник");
        frameWeek.setContentPane(new JLabel(new ImageIcon("backgroundWeek.png")));
        frameWeek.setSize(1280, 720);
        frameWeek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWeek.setLayout(null);
        JLabel diary = new JLabel("Неделя");
        diary.setBounds(550, 10, 300, 50);
        diary.setFont(new Font("Arial", Font.BOLD, 50));
        diary.setVisible(true);
        frameWeek.add(diary);
        JLabel monday = new JLabel("Понедельник");
        makeDayWeekLabel(monday, frameWeek, 78, 120);
        JLabel tuesday = new JLabel("Вторник");
        makeDayWeekLabel(tuesday, frameWeek, 420, 120);
        JLabel wednesday = new JLabel("Среда");
        makeDayWeekLabel(wednesday, frameWeek, 750, 120);
        JLabel thursday = new JLabel("Четверг");
        makeDayWeekLabel(thursday, frameWeek, 1050, 120);
        JLabel friday = new JLabel("Пятница");
        makeDayWeekLabel(friday, frameWeek, 260, 400);
        JLabel saturday = new JLabel("Суббота");
        makeDayWeekLabel(saturday, frameWeek, 575, 400);
        JLabel sunday = new JLabel("Воскресенье");
        makeDayWeekLabel(sunday, frameWeek, 855, 400);

        JTextField taskMon1 = new JTextField();
        JCheckBox tskMn1 = new JCheckBox();
        makeTasksLabels(taskMon1, tskMn1, frameWeek, 60, 170, 30, 170, 0, 0);
        JTextField taskMon2 = new JTextField();
        JCheckBox tskMn2 = new JCheckBox();
        makeTasksLabels(taskMon2, tskMn2, frameWeek, 60, 220, 30, 220, 0, 1);
        JTextField taskMon3 = new JTextField();
        JCheckBox tskMn3 = new JCheckBox();
        makeTasksLabels(taskMon3, tskMn3, frameWeek, 60, 270, 30, 270, 0, 2);
        JTextField taskTue1 = new JTextField();
        JCheckBox tskTue1 = new JCheckBox();
        makeTasksLabels(taskTue1, tskTue1, frameWeek, 370, 170, 340, 170, 1, 0);
        JTextField taskTue2 = new JTextField();
        JCheckBox tskTue2 = new JCheckBox();
        makeTasksLabels(taskTue2, tskTue2, frameWeek, 370, 220, 340, 220, 1, 1);
        JTextField taskTue3 = new JTextField();
        JCheckBox tskTue3 = new JCheckBox();
        makeTasksLabels(taskTue3, tskTue3, frameWeek, 370, 270, 340, 270, 1, 2);
        JTextField taskWed1 = new JTextField();
        JCheckBox tskWed1 = new JCheckBox();
        makeTasksLabels(taskWed1, tskWed1, frameWeek, 680, 170, 650, 170, 2, 0);
        JTextField taskWed2 = new JTextField();
        JCheckBox tskWed2 = new JCheckBox();
        makeTasksLabels(taskWed2, tskWed2, frameWeek, 680, 220, 650, 220, 2, 1);
        JTextField taskWed3 = new JTextField();
        JCheckBox tskWed3 = new JCheckBox();
        makeTasksLabels(taskWed3, tskWed3, frameWeek, 680, 270, 650, 270, 2, 2);
        JTextField taskThu1 = new JTextField();
        JCheckBox tskThu1 = new JCheckBox();
        makeTasksLabels(taskThu1, tskThu1, frameWeek, 990, 170, 960, 170, 3, 0);
        JTextField taskThu2 = new JTextField();
        JCheckBox tskThu2 = new JCheckBox();
        makeTasksLabels(taskThu2, tskThu2, frameWeek, 990, 220, 960, 220, 3, 1);
        JTextField taskThu3 = new JTextField();
        JCheckBox tskThu3 = new JCheckBox();
        makeTasksLabels(taskThu3, tskThu3, frameWeek, 990, 270, 960, 270, 3, 2);
        JTextField taskFri1 = new JTextField();
        JCheckBox tskFri1 = new JCheckBox();
        makeTasksLabels(taskFri1, tskFri1, frameWeek, 210, 450, 180, 450, 4, 0);
        JTextField taskFri2 = new JTextField();
        JCheckBox tskFri2 = new JCheckBox();
        makeTasksLabels(taskFri2, tskFri2, frameWeek, 210, 500, 180, 500, 4, 1);
        JTextField taskFri3 = new JTextField();
        JCheckBox tskFri3 = new JCheckBox();
        makeTasksLabels(taskFri3, tskFri3, frameWeek, 210, 550, 180, 550, 4, 2);
        JTextField taskSat1 = new JTextField();
        JCheckBox tskSat1 = new JCheckBox();
        makeTasksLabels(taskSat1, tskSat1, frameWeek, 520, 450, 490, 450, 5, 0);
        JTextField taskSat2 = new JTextField();
        JCheckBox tskSat2 = new JCheckBox();
        makeTasksLabels(taskSat2, tskSat2, frameWeek, 520, 500, 490, 500, 5, 1);
        JTextField taskSat3 = new JTextField();
        JCheckBox tskSat3 = new JCheckBox();
        makeTasksLabels(taskSat3, tskSat3, frameWeek, 520, 550, 490, 550, 5, 2);
        JTextField taskSun1 = new JTextField();
        JCheckBox tskSun1 = new JCheckBox();
        makeTasksLabels(taskSun1, tskSun1, frameWeek, 830, 450, 800, 450, 6, 0);
        JTextField taskSun2 = new JTextField();
        JCheckBox tskSun2 = new JCheckBox();
        makeTasksLabels(taskSun2, tskSun2, frameWeek, 830, 500, 800, 500, 6, 1);
        JTextField taskSun3 = new JTextField();
        JCheckBox tskSun3 = new JCheckBox();
        makeTasksLabels(taskSun3, tskSun3, frameWeek, 830, 550, 800, 550, 6, 2);

        frameWeek.setVisible(true);


        JButton toTracker = new JButton("Трекер привычек");
        toTracker.setBounds(1010, 10, 200, 20);
        toTracker.setFont(new Font("Arial", Font.BOLD, 14));
        toTracker.setVisible(true);
        frameWeek.add(toTracker);
        toTracker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeekDB.saveText(taskMon1, taskMon2, taskMon3,
                        taskTue1, taskTue2, taskTue3,
                        taskWed1, taskWed2, taskWed3,
                        taskThu1, taskThu2, taskThu3,
                        taskFri1, taskFri2, taskFri3,
                        taskSat1,taskSat2, taskSat3,
                        taskSun1, taskSun2, taskSun3);
                frameWeek.setVisible(false);
                Tracker.showFrame();
            }
        });

        JButton toMonth = new JButton("Месяц");
        toMonth.setBounds(1010, 32, 200, 20);
        toMonth.setFont(new Font("Arial", Font.BOLD, 14));
        toMonth.setVisible(true);
        frameWeek.add(toMonth);
        toMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeekDB.saveText(taskMon1, taskMon2, taskMon3,
                        taskTue1, taskTue2, taskTue3,
                        taskWed1, taskWed2, taskWed3,
                        taskThu1, taskThu2, taskThu3,
                        taskFri1, taskFri2, taskFri3,
                        taskSat1,taskSat2, taskSat3,
                        taskSun1, taskSun2, taskSun3);
                frameWeek.setVisible(false);
                Month.showFrame();
            }
        });

        frameWeek.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    WeekDB.saveText(taskMon1, taskMon2, taskMon3,
                            taskTue1, taskTue2, taskTue3,
                            taskWed1, taskWed2, taskWed3,
                            taskThu1, taskThu2, taskThu3,
                            taskFri1, taskFri2, taskFri3,
                            taskSat1,taskSat2, taskSat3,
                            taskSun1, taskSun2, taskSun3);
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
