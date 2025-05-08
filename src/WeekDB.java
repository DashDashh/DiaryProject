import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WeekDB {
    public static File weekDB = new File("week.xml");
    public static Boolean[][] doneTasks = {{false, false, false}, {false, false, false}, {false, false, false}, {false, false, false}, {false, false, false}, {false, false, false}, {false, false, false}};
    public static String[][] taskNames = {{"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}, {"", "", ""}};

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public static void saveText(JTextField Mon1, JTextField Mon2, JTextField Mon3,
                                JTextField Tue1, JTextField Tue2, JTextField Tue3,
                                JTextField Wed1, JTextField Wed2, JTextField Wed3,
                                JTextField Thu1, JTextField Thu2, JTextField Thu3,
                                JTextField Fri1, JTextField Fri2, JTextField Fri3,
                                JTextField Sat1, JTextField Sat2, JTextField Sat3,
                                JTextField Sun1, JTextField Sun2, JTextField Sun3) {
        taskNames[0][0] = Mon1.getText();
        taskNames[0][1] = Mon2.getText();
        taskNames[0][2] = Mon3.getText();
        taskNames[1][0] = Tue1.getText();
        taskNames[1][1] = Tue2.getText();
        taskNames[1][2] = Tue3.getText();
        taskNames[2][0] = Wed1.getText();
        taskNames[2][1] = Wed2.getText();
        taskNames[2][2] = Wed3.getText();
        taskNames[3][0] = Thu1.getText();
        taskNames[3][1] = Thu2.getText();
        taskNames[3][2] = Thu3.getText();
        taskNames[4][0] = Fri1.getText();
        taskNames[4][1] = Fri2.getText();
        taskNames[4][2] = Fri3.getText();
        taskNames[5][0] = Sat1.getText();
        taskNames[5][1] = Sat2.getText();
        taskNames[5][2] = Sat3.getText();
        taskNames[6][0] = Sun1.getText();
        taskNames[6][1] = Sun2.getText();
        taskNames[6][2] = Sun3.getText();
    }

    public static void saveWeekDB() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File fileChange = new File("weekDBChange.xml");
        Document docToChange = builder.parse(weekDB);

        String[] tasks = {"firstTask", "secondTask", "thirdTask"};
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 3; ++j) {
                Node task = docToChange.getElementsByTagName(tasks[j]).item(i);
                NodeList doneChange = ((Element) task).getElementsByTagName("done").item(0).getChildNodes();
                Node doneSave = doneChange.item(0);
                doneSave.setTextContent(doneTasks[i][j].toString());
                NodeList textChange = ((Element) task).getElementsByTagName("text").item(0).getChildNodes();
                Node textSave = textChange.item(0);
                if (taskNames[i][j].isEmpty()) {
                    taskNames[i][j] = " ";
                }
                textSave.setTextContent(taskNames[i][j]);
            }
        }


        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(docToChange);
        StreamResult result = new StreamResult(fileChange);
        transformer.transform(source, result);
        Files.delete(Paths.get("week.xml"));
        File rename = new File("week.xml");
        fileChange.renameTo(rename);
    }

    public static void getWeekDB() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(weekDB);

        String[] tasks = {"firstTask", "secondTask", "thirdTask"};
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 3; ++j) {
                Node task = document.getElementsByTagName(tasks[j]).item(i);
                doneTasks[i][j] = Boolean.parseBoolean(getTagValue("done", (Element) task));
                taskNames[i][j] = getTagValue("text", (Element) task);
            }
        }
    }
}