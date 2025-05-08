import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowForDay {
    public static String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};
    public static ImageIcon[] eventsType = {new ImageIcon("party.png"),
                                            new ImageIcon("books.png"),
                                            new ImageIcon("concert.png")};
    public static void showFrame(int day, int month, int numButton, JButton button){
        JFrame dayFrame = new JFrame(day +  " " + months[month]);
        dayFrame.setSize(600, 700);
        dayFrame.setLayout(null);
        dayFrame.setVisible(true);
        JLabel typeOfEvent = new JLabel("Тип события:");
        typeOfEvent.setBounds(50, 30, 250, 100);
        typeOfEvent.setFont(new Font("Arial", Font.BOLD, 30));
        typeOfEvent.setVisible(true);
        dayFrame.add(typeOfEvent);
        JComboBox<ImageIcon> events = new JComboBox<>(eventsType);
        int indEvent = 0;
        if(MonthDB.pictureOfEvent[numButton] == MonthDB.party){
            indEvent = 0;
        }else if(MonthDB.pictureOfEvent[numButton] == MonthDB.book){
            indEvent = 1;
        }else{
            indEvent = 2;
        }
        events.setSelectedIndex(indEvent);
        events.setRenderer(new ImageComboBoxRenderer());
        events.setAlignmentX(Component.LEFT_ALIGNMENT);
        events.setBounds(300, 30, 100, 100);
        events.setVisible(true);
        dayFrame.add(events);
        JTextField nameOfEvent = new JTextField(MonthDB.nameofEvent[numButton]);
        nameOfEvent.setFont(new Font("Arial", Font.PLAIN, 25));
        nameOfEvent.setBounds(50, 150, 400, 70);
        nameOfEvent.setVisible(true);
        dayFrame.add(nameOfEvent);
        JLabel description = new JLabel("Описание:");
        description.setBounds(50, 220, 250, 100);
        description.setFont(new Font("Arial", Font.BOLD, 30));
        description.setVisible(true);
        dayFrame.add(description);
        JTextArea descriptionText = new JTextArea(10, 50);
        descriptionText.append(MonthDB.descriptionOfEvent[numButton]);
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setFont(new Font("Dialog", Font.PLAIN, 20));
        descriptionText.setTabSize(10);
        descriptionText.setBounds(10, 300, 550, 300);
        descriptionText.setVisible(true);
        dayFrame.add(descriptionText);
        JButton done = new JButton("Готово");
        done.setBounds(475, 625, 100, 25);
        done.setVisible(true);
        dayFrame.add(done);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!nameOfEvent.getText().isEmpty()) {
                    MonthDB.pictureOfEvent[numButton] = MonthDB.icons[events.getSelectedIndex()];
                    MonthDB.nameofEvent[numButton] = nameOfEvent.getText();
                    MonthDB.descriptionOfEvent[numButton] = descriptionText.getText();
                    if(MonthDB.pictureOfEvent[numButton].equals(MonthDB.party)){
                        button.setIcon(new ImageIcon("partyMini.png"));
                    }else if(MonthDB.pictureOfEvent[numButton].equals(MonthDB.book)){
                        button.setIcon(new ImageIcon("booksMini.png"));
                    }else{
                        button.setIcon(new ImageIcon("concertMini.png"));
                    }
                    dayFrame.setVisible(false);
                }
            }
        });
    }
}

class ImageComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel();
        label.setIcon((ImageIcon) value);
        return label;
    }
}