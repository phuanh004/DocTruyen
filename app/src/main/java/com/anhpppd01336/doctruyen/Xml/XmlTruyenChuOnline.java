package com.anhpppd01336.doctruyen.Xml;

import com.anhpppd01336.doctruyen.Data.DanhSachTruyenOnline;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anh Pham on 21/10/2015.
 */
public class XmlTruyenChuOnline {
    DanhSachTruyenOnline obj;
    private String urlString = null;
    XmlPullParser myparser;
    public static ArrayList<DanhSachTruyenOnline> arrTruyen;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    String N1;

    public XmlTruyenChuOnline(String url) {
        urlString = url;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        try {
            obj = new DanhSachTruyenOnline();
            int event = myparser.getEventType();
            String text = null;
            arrTruyen = new ArrayList<>();
            while (event != XmlPullParser.END_DOCUMENT) {
                String nameTag = myparser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (nameTag.equals("item")) {
                            obj = new DanhSachTruyenOnline();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        N1= text;
                        break;
                    case XmlPullParser.END_TAG:
                        if (nameTag.equals("title")) {
                            obj.setTenTruyen(text);
                        }
                        if (nameTag.equals("link")) {
                            obj.setLinkTruyen(text);
                        }
                        if (nameTag.equals("description")) {
                            obj.setBiaTruyen(Arrays.toString(StringUtils.substringsBetween(text, "<img src=\"", "\" alt=\""))
                                    .replaceAll("\\[", "").replaceAll("\\]", ""));

                            String finalDescription = StringEscapeUtils.unescapeHtml4(text)
                                    .replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;"," ");
                            obj.setTomTatTruyen(finalDescription);
                        }
                        if (nameTag.equals("item")) {
                            arrTruyen.add(obj);
                        }
                        break;

                }
                event = myParser.next();

            }
            parsingComplete = false;
        } catch (Exception e) {}

    }


    public void fetchXML() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);

                    conn.connect();

                    InputStream stream = conn.getInputStream();

                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);

                    myparser.setInput(stream, "UTF-8");
                    parseXMLAndStoreIt(myparser);

                    stream.close();

                } catch (Exception e) {
                }
            }
        });
        thread.start();
    }
}
