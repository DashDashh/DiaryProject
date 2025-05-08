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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class Main {
        public static void main(String[] args) throws Exception {
            Calendar today = Calendar.getInstance();
            Integer month = today.get(Calendar.MONTH);
            Integer week = today.get(Calendar.WEEK_OF_MONTH);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("lastVisited.xml"));
            Node last = document.getElementsByTagName("lastday").item(0);
            Integer lastWeek = Integer.parseInt(getTagValue("week", (Element) last));
            Integer lastMonth = Integer.parseInt(getTagValue("month", (Element) last));
            if(!month.equals(lastMonth)){
                copyContent(new File("defaultMonth.xml"), new File("month.xml"));
            }
            if(!week.equals(lastWeek)){
                copyContent(new File("defaultWeek.xml"), new File("week.xml"));
                copyContent(new File("defaultTracker.xml"), new File("habitTracker.xml"));
            }
            Node weekSave = document.getElementsByTagName("week").item(0);
            weekSave.setTextContent(week.toString());
            Node monthSave = document.getElementsByTagName("month").item(0);
            monthSave.setTextContent(month.toString());
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            File fileChange = new File("changeVisit.xml");
            StreamResult result = new StreamResult(fileChange);
            transformer.transform(source, result);
            Files.delete(Paths.get("lastVisited.xml"));
            File rename = new File("lastVisited.xml");
            fileChange.renameTo(rename);
            WeekDB.getWeekDB();
            TrackerDB.getTrackerDB();
            MonthDB.getMonthDB();
            Week.showFrame();
        }
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
    public static void copyContent(File a, File b)
            throws Exception
    {
        FileInputStream in = new FileInputStream(a);
        FileOutputStream out = new FileOutputStream(b);

        try {
            int n;
            while ((n = in.read()) != -1) {
                out.write(n);
            }
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}