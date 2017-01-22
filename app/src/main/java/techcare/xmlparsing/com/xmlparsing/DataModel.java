package techcare.xmlparsing.com.xmlparsing;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataModel {

	static final String KEY_SITE = "item";
	static final String KEY_NAME = "title";
	static final String KEY_LINK = "link";
	static final String KEY_IMAGE_URL = "description";

	public static List<Data>  getDataFromFile(Context ctx) {

		// List of StackSites that we will return
		List<Data> Dataitem;
		Dataitem = new ArrayList<Data>();

		// temp holder for current StackSite while parsing
		Data CurDataitem = null;
		// temp holder for current text value while parsing
		String curText = "";

		try {
			// Get our factory and PullParser
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = factory.newPullParser();

			// Open up InputStream and Reader of our file.
			FileInputStream fis = ctx.openFileInput("rss.xml");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

			// point the parser to our file.
			xpp.setInput(reader);

			// get initial eventType
			int eventType = xpp.getEventType();

			// Loop through pull events until we reach END_DOCUMENT
			while (eventType != XmlPullParser.END_DOCUMENT) {
				// Get the current tag
				String tagname = xpp.getName();
				if (tagname.equalsIgnoreCase("channel")){
				// React to different event types appropriately
				switch (eventType) {
				case XmlPullParser.START_TAG:
					if (tagname.equalsIgnoreCase(KEY_SITE)) {
						// If we are starting a new <site> block we need
						//a new StackSite object to represent it
						CurDataitem = new Data();
					}
					break;

				case XmlPullParser.TEXT:
					//grab the current text so we can use it in END_TAG event
					curText = xpp.getText();
					break;

				case XmlPullParser.END_TAG:
					if (tagname.equalsIgnoreCase(KEY_SITE)) {
						// if </site> then we are done with current Site
						// add it to the list.
						Dataitem.add(CurDataitem);
					} else if (tagname.equalsIgnoreCase(KEY_NAME)) {
						// if </name> use setName() on curSite
						CurDataitem.setDescription(curText);
					} else if (tagname.equalsIgnoreCase(KEY_LINK)) {
						// if </link> use setLink() on curSite
						CurDataitem.setLink(curText);

					} else if (tagname.equalsIgnoreCase(KEY_IMAGE_URL)) {
						// if </image> use setImgUrl() on curSite
						CurDataitem.setImgUrl(curText);
					}
					break;

				default:
					break;
				}
				//move on to next iteration
				eventType = xpp.next();
			}
		} }catch (Exception e) {
			e.printStackTrace();
		}

		// return the populated list.
		return Dataitem;
	}
}
