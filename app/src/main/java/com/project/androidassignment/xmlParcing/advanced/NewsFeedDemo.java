package com.project.androidassignment.xmlParcing.advanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.project.androidassignment.databinding.ActivityNewsFeedDemoBinding;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class NewsFeedDemo extends AppCompatActivity {
    private ActivityNewsFeedDemoBinding binding;
    private List<News> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsFeedDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        newsList = new ArrayList<>();

        showData();
    }

    private void showData() {
        // setup adapters
        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter adapter = new NewsAdapter(newsList, this);
        binding.recylerView.setAdapter(adapter);

        String url = "http://feeds.feedburner.com/ndtvnews-latest?format=xml";

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();

                    DefaultHandler handler = new DefaultHandler() {
                        String titleStr, desStr;
                        boolean title, des;

                        News news;

                        public void startElement(String uri, String localName,String qName,
                                                 Attributes attributes) throws SAXException {
                            if(localName.equalsIgnoreCase("title")){
                                news = new News();
                                title = true;
                            }

                            if(localName.equalsIgnoreCase("description")){
                                des = true;
                            }

                        }

                        public void characters(char ch[], int start, int length) throws SAXException {
                            if(title){
                                titleStr = new String(ch, start, length);
                                news.setTitle(titleStr);
                            }

                            if(des){
                                desStr = new String(ch, start, length);
                                news.setDes(desStr);
                            }
                        }

                        public void endElement(String uri, String localName,
                                               String qName) throws SAXException {
                            if(localName.equalsIgnoreCase("title")){
                                title = false;
                            }

                            if(localName.equalsIgnoreCase("description")){
                                des = false;
                                 newsList.add(news);
                            }
                        }
                    };
                    parser.parse(url, handler);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    Log.d("xml", "here");
                }catch (Exception e){
                    Log.d("xml", e.getLocalizedMessage());
                }
            }
        });
    }
}
