package extentReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlModifier {

	public static Document doc;

	public static void main() throws Exception

	{
		File htmlContent = new File(
				"C:/Users/jmanera/Documents/Document/Java work/ExtentReport/test-output/ashikali.html");
		doc = Jsoup.parse(htmlContent, "utf-8");
		doc.select("a").first().remove();
		doc.select("a").first().before("<a><span> Auto-ReEngineering </span></a>");

		Elements ReportHeader = doc.getElementsByAttributeValue("class", "report-name");
		for (Element header : ReportHeader) {
			header.text("Auto-ReEngineering Execution Report");
		}

		String project = "CDM";
		Element ReportHeader1 = doc.getElementsByTag("h5").first();
		
			ReportHeader1.html("<h5><font color='blue' size='6'><b>"+project+" Test</b></font></h5>");
			

		
		Elements ReportHeader3 = doc.getElementsContainingOwnText("ExtentReports 2.0");
		for (Element header : ReportHeader3) {
			header.text("Auto-ReEngineering Execution Report");
		}
		
		
		
		Elements ReportHeader2 = doc.getElementsContainingOwnText("v2.41.1");
		for (Element header : ReportHeader2) {
			header.text("v1.0");
		}

		String html = doc.html();
		Writer writer = new PrintWriter(
				"C:/Users/jmanera/Documents/Document/Java work/ExtentReport/test-output/ashikali.html");

		writer = new BufferedWriter(writer);
		writer.write(doc.html());
		writer.close();
	}

}
