import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MonthDB {
    public static ImageIcon party = new ImageIcon("party.png");
    public static ImageIcon book = new ImageIcon("books.png");
    public static ImageIcon concert = new ImageIcon("concert.png");
    public static ImageIcon[] icons = {party, book, concert};
    public static ImageIcon[] pictureOfEvent = {party, party, party, party, party, party, party, party, party, party, party, party,
                                                party, party, party, party, party, party, party, party, party, party, party, party,
                                                party, party, party, party, party, party, party, party, party, party, party};
    public static String[] nameofEvent = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                                            "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    public static String[] descriptionOfEvent = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                                                "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    private static final File Monthdb = new File("month.xml");
    private static final String[] days = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                            "eighteen", "nineteen", "twenty", "twentyone", "twentytwo", "twentythree",
                                            "twentyfour", "twentyfive", "twentysix", "twentyseven", "twentyeight",
                                            "twentynine", "thirty", "thirtyone", "thirtytwo", "thirtythree", "thirtyfour", "thirtyfive"};
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
    public static void getMonthDB() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Monthdb);
        for(int i = 0; i < 35; ++i){
            Node day = document.getElementsByTagName(days[i]).item(0);
            pictureOfEvent[i] = icons[Integer.parseInt(getTagValue("picture", (Element) day))];
            nameofEvent[i] = getTagValue("title", (Element) day);
            descriptionOfEvent[i] = getTagValue("description", (Element) day);
        }
    }
    public static void saveMonthDB() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File fileChange = new File("monthChange.xml");
        Document docToChange = builder.parse(Monthdb);

        for(int i = 0; i < 35; ++i){
            Node picture = docToChange.getElementsByTagName("picture").item(i);
            Node title = docToChange.getElementsByTagName("title").item(i);
            Node description = docToChange.getElementsByTagName("description").item(i);
            if(pictureOfEvent[i] == party){
                picture.setTextContent("0");
            } else if (pictureOfEvent[i] == book) {
                picture.setTextContent("1");
            }else{
                picture.setTextContent("2");
            }
            title.setTextContent(nameofEvent[i]);
            if(nameofEvent[i].isEmpty()){
                title.setTextContent(" ");
            }
            description.setTextContent(descriptionOfEvent[i]);
            if(descriptionOfEvent[i].isEmpty()){
                description.setTextContent(" ");
            }
        }

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(docToChange);
        StreamResult result = new StreamResult(fileChange);
        transformer.transform(source, result);
        Files.delete(Paths.get("month.xml"));
        File rename = new File("month.xml");
        fileChange.renameTo(rename);
    }
}
