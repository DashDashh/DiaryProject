import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TrackerDB {
    public static String[] nameOfWeek = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

    private static File habTrack = new File("habitTracker.xml");
    public static Integer[] water = {0, 0, 0, 0, 0, 0, 0};
    public static Boolean[][] habTrackers = {{false, false, false, false, false, false, false}, {false, false, false, false, false, false, false}, {false, false, false, false, false, false, false}};
    public static String[] habNames = {"", "", ""};
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
    public static void saveTrackerDB() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File fileChange = new File("habitTrackerChange.xml");
        Document docToChange = builder.parse(habTrack);
        NodeList wat1 = docToChange.getElementsByTagName("water");
        Node waterNode1 = wat1.item(0);
        for(int i = 0; i < 7; ++i){
            NodeList watNodeList = ((Element)waterNode1).getElementsByTagName(nameOfWeek[i]).item(0).getChildNodes();
            Node watNod = watNodeList.item(0);
            watNod.setTextContent(water[i].toString());
        }

        NodeList habits = docToChange.getElementsByTagName("habits");
        Node habitNames = habits.item(0);
        NodeList hab1 = ((Element)habitNames).getElementsByTagName("firstHabit").item(0).getChildNodes();
        Node habit1 = hab1.item(0);
        habit1.setTextContent(habNames[0]);
        NodeList hab2 = ((Element)habitNames).getElementsByTagName("secondHabit").item(0).getChildNodes();
        Node habit2 = hab2.item(0);
        habit2.setTextContent(habNames[1]);
        NodeList hab3 = ((Element)habitNames).getElementsByTagName("thirdHabit").item(0).getChildNodes();
        Node habit3 = hab3.item(0);
        habit3.setTextContent(habNames[2]);

        String[] habitss = {"firstHab", "secondHab", "thirdHab"};
        for(int i = 0; i < 3; ++i){
            Node hab = docToChange.getElementsByTagName(habitss[i]).item(0);
            for(int j = 0; j < 7; ++j){
                NodeList toSave = ((Element)hab).getElementsByTagName(nameOfWeek[j]).item(0).getChildNodes();
                Node savingElem = toSave.item(0);
                savingElem.setTextContent(habTrackers[i][j].toString());
            }
        }


        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(docToChange);
        StreamResult result = new StreamResult(fileChange);
        transformer.transform(source, result);
        Files.delete(Paths.get("habitTracker.xml"));
        File rename = new File("habitTracker.xml");
        fileChange.renameTo(rename);
    }
    public static void getTrackerDB() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(habTrack);
        NodeList wat = document.getElementsByTagName("water");
        Node waterNode = wat.item(0);
        for(int i = 0; i < 7; ++i){
            water[i] = Integer.parseInt(getTagValue(nameOfWeek[i], (Element) waterNode));
        }
        NodeList habits = document.getElementsByTagName("habits");
        Node habitNames = habits.item(0);
        habNames[0] = getTagValue("firstHabit", (Element) habitNames);
        habNames[1] = getTagValue("secondHabit", (Element) habitNames);
        habNames[2] = getTagValue("thirdHabit", (Element) habitNames);

        String[] habitss = {"firstHab", "secondHab", "thirdHab"};
        for(int i = 0; i < 3; ++i){
            Node hab = document.getElementsByTagName(habitss[i]).item(0);
            for(int j = 0; j < 7; ++j){
                habTrackers[i][j] = Boolean.parseBoolean(getTagValue(nameOfWeek[j], (Element) hab));
            }
        }
    }
}