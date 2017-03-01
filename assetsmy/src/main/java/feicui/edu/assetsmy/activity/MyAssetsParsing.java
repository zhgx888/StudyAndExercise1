package feicui.edu.assetsmy.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import feicui.edu.assetsmy.entity.SmsBean;

public class MyAssetsParsing {//解析
    Context mCtx;

    MyAssetsParsing(Context mCtx) {
        this.mCtx = mCtx;
    }

    List<SmsBean> readList() {//读取内存信息
        InputStream inputStream = null;
        ArrayList arrayList = null;
        SmsBean bean = null;
        try {
            XmlPullParser xmlPullParser = Xml.newPullParser();//1.通过Xml获取一个XmlPullParser对象
            //2.设置XmlPullParser对象的参数，需要解析的是哪个xml文件,设置一个文件读取流
            AssetManager assetManager = mCtx.getAssets();//通过context获取一个资产管理者对象
            inputStream = assetManager.open("ass.xml");//通过资产管理者对象能获取一个文件读取流
            xmlPullParser.setInput(inputStream, "utf-8");
            //xm.setInput(openFileInput("backupsms.xml"), "utf-8");//上两行代码简写版
            //3.获取当前xml行的事件类型
            int eType = xmlPullParser.getEventType();
            //4.判断事件类型是否是文档结束的事件类型
            while (eType != XmlPullParser.END_DOCUMENT) {
                String currentNume = xmlPullParser.getName();
                switch (eType) {
                    case XmlPullParser.START_TAG:
                        if (currentNume.equals("Smss")) {//如果当前标签是Smss，需要初始化一个集合
                            arrayList = new ArrayList<SmsBean>();
                        } else if (currentNume.equals("Sms")) {
                            bean = new SmsBean();
                            bean.id = Integer.valueOf(xmlPullParser.getAttributeValue(null, "id"));
                        } else if (currentNume.equals("num")) {
                            bean.num = xmlPullParser.nextText();
                        } else if (currentNume.equals("date")) {
                            bean.times = xmlPullParser.nextText();
                        } else if (currentNume.equals("msg")) {
                            bean.content = xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (currentNume.equals("Sms")) {//当前结束标签是Sms的话，一条短信数据封装完成， 可以加入list中
                            arrayList.add(bean);
                        }
                        break;
                    default:
                        break;
                }
                eType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    void writeToXml() {//往内存写信息
        ArrayList<SmsBean> arrayList = getAllSms();//获取短信数据
        XmlSerializer xmlSerializer = Xml.newSerializer();
        try {
            xmlSerializer.setOutput(mCtx.openFileOutput("ass2.xml", Context.MODE_PRIVATE), "utf-8");
            xmlSerializer.startDocument("utf-8", true);
            xmlSerializer.startTag(null, "Smss");
            for (SmsBean bean : arrayList) {
                xmlSerializer.startTag(null, "Sms");
                xmlSerializer.attribute(null, "id", bean.id + "");
                xmlSerializer.startTag(null, "num");
                xmlSerializer.text(bean.num);
                xmlSerializer.endTag(null, "num");
                xmlSerializer.startTag(null, "date");
                xmlSerializer.text(bean.times);
                xmlSerializer.endTag(null, "date");
                xmlSerializer.startTag(null, "msg");
                xmlSerializer.text(bean.content);
                xmlSerializer.endTag(null, "msg");
                xmlSerializer.endTag(null, "Sms");
            }
            xmlSerializer.endTag(null, "Smss");
            xmlSerializer.endDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SmsBean> getAllSms() {//获取短信数据
        ArrayList<SmsBean> alsb = new ArrayList<SmsBean>();
        return alsb;
    }
}
