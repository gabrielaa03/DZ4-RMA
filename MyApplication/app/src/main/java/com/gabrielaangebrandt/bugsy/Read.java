package com.gabrielaangebrandt.bugsy;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Gabriela on 26.4.2017..
 */

public class Read extends AsyncTask<Void, Void, Void> {
    Context context;
    ProgressDialog progressDialog;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Objekt> news;
    RecyclerView recyclerView1;
    String page = "http://www.bug.hr/rss/vijesti";
    URL url;
    public Read(Context context, RecyclerView recyclerView1){
        this.context = context;
        this.recyclerView1 = recyclerView1;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Učitavanje podataka...");

    }
    @Override
    protected Void doInBackground(Void... voids) {
        ProcessXML(getData());
        return null;
    }

    private void ProcessXML(Document data) {
            if(data!=null){
                news = new ArrayList<>();
                Element root = data.getDocumentElement();
                Node channel = root.getChildNodes().item(0);
                NodeList items = channel.getChildNodes();
                for(int i=0; i<items.getLength();i++){
                    Objekt objekt = new Objekt();
                    Node currentChild = items.item(1);
                    if(currentChild.getNodeName().equalsIgnoreCase("item")){
                        NodeList itemChild = currentChild.getChildNodes();
                        for( int j=0; j<itemChild.getLength(); j++){
                            Node current = itemChild.item(j);
                            if(current.getNodeName().equalsIgnoreCase("title")){
                                objekt.setTitle(current.getTextContent());
                            }
                            else if(current.getNodeName().equalsIgnoreCase("description")){
                                objekt.setDescription(current.getTextContent());
                            }

                            else if(current.getNodeName().equalsIgnoreCase("category")){
                                objekt.setCategory(current.getTextContent());
                            }
                            else if(current.getNodeName().equalsIgnoreCase("pubDate")){
                                objekt.setPubDate(current.getTextContent());
                            }
                            else if(current.getNodeName().equalsIgnoreCase("enclosure")){
                                String url = current.getAttributes().item(0).getTextContent();
                                objekt.setUrl(url);
                            }
                        }
                        news.add(objekt);
                    }
                }
            }
    }

    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();

    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        layoutManager = new LinearLayoutManager(context);

        NewsAdapter adapter = new NewsAdapter(context, news);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public Document getData(){
            try{
                url = new URL (page);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                InputStream inputStream = httpURLConnection.getInputStream();
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document xml= documentBuilder.parse(inputStream);
                progressDialog.dismiss();
                return xml;

    } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }
}
