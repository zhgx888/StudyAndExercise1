package edu.feicui.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class NewsClientActivity extends AppCompatActivity {
    final String GET = "http://118.244.212" +
            ".82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";
    final String POST = "http://118.244.212" +
            ".82:9092/newsClient/news_list";
    String result;
    TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_client);
        mTxt = (TextView) findViewById(R.id.news_txt);
        new Thread() {
            @Override
            public void run() {
                super.run();
//                getDataHttpClientGET();
//                getDataHttpClientPOST();
                getDataHttpURLConnectionGET();
            }
        }.start();
        try {
            Thread.sleep(500);
            if (result != null) {
                mTxt.setText(result);
            } else {
//                mTxt.setGravity();
                mTxt.setTextSize(24);
                mTxt.setText("hi，真不巧，网页走丢了。");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void getDataHttpClientGET() {
//        新建HttpGet对象
        HttpGet get = new HttpGet(GET);
//        新建HttpClient对象
        HttpClient client = new DefaultHttpClient();
//        HttpClient client= AndroidHttpClient.newInstance("");//★推荐
        try {
            //发送请求Get
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println("@@@@@@@@@@" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getDataHttpClientPOST() {
        List<NameValuePair> pairlist = new ArrayList<NameValuePair>();
//        通过List存储键值对
        pairlist.add(new BasicNameValuePair("ver", "1"));
        pairlist.add(new BasicNameValuePair("subid", "1"));
        pairlist.add(new BasicNameValuePair("dir", "1"));
        pairlist.add(new BasicNameValuePair("nid", "1"));
        pairlist.add(new BasicNameValuePair("stamp", "20140321"));
        pairlist.add(new BasicNameValuePair("cnt", "20"));
//        新建HttpPost对象
        HttpPost post = new HttpPost(POST);
//        通过List传值给HttpPost对象
        try {
            post.setEntity(new UrlEncodedFormEntity(pairlist, HTTP.UTF_8));
//            新建HttpClient对象
            HttpClient client = new DefaultHttpClient();
//            HttpClient client = new AndroidHttpClient();
            //发送请求Post
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println("##########" + result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void getDataHttpURLConnectionGET() {
            //新建Url对象
        try {
            URL url = new URL(GET);
            //新建HttpURLConnection对象
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //设置超时时间
            urlConnection.setConnectTimeout(5000);
            //设置请求方式
            urlConnection.setRequestMethod("GET");
            //设置使用缓存
            urlConnection.setUseCaches(false);
            //设置可输出 设置是否向httpUrlConnection(对外) 输出
//            urlConnection.setDoOutput(true);
            //判断是否连接成功
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                int connLeng=urlConnection.getContentLength();
                // 获取到读取流
                InputStream in = urlConnection.getInputStream();
                // 创建读取缓冲流
                BufferedInputStream bufIn=new BufferedInputStream(in);
                byte[][] bytes=null;
                int row=0;
                int lastRow=connLeng % 1024;
                if (lastRow == 0) {
                    row=connLeng / 1024;
                } else {
                    row=connLeng / 1024+1;
                }
                bytes = new byte[row][1024];
                int count=0;
                // 不断读写文件
                int len;
                while (count<row&&(len= in.read(bytes[count])) != -1) {
                    count++;
                }
                byte[] descBytes=new byte[row*1024];
                for(int i=0;i<row;i++) {
                    if (i==row-1){
                        System.arraycopy(bytes[i],0,descBytes,i*1024,lastRow);
                    }else
                    System.arraycopy(bytes[i],0,descBytes,i*1024,1024);
                }
                result=new String(descBytes,0,row*1024);
                System.out.println(result);
                // 关闭流操作
                bufIn.close();
                in.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
