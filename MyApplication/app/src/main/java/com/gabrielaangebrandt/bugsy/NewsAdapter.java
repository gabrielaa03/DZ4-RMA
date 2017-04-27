package com.gabrielaangebrandt.bugsy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriela on 25.4.2017..
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    ArrayList<Objekt> news;
    Context context;
    ArrayList<Objekt> posebni;


    public NewsAdapter(ArrayList<Objekt> news) {
        this.news = news;
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.objekt_layout, parent, false);
        ViewHolder newsViewHolder = new ViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Objekt trenutniObjekt = news.get(position);
        holder.title.setText(trenutniObjekt.getMtitle());
        holder.category.setText(trenutniObjekt.getMcategory());
        holder.description.setText(trenutniObjekt.getMdescription());
        holder.pubDate.setText(trenutniObjekt.getMpubDate());
        Picasso.with(context).load(trenutniObjekt.getMenclosure()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return (news == null) ? 0 : news.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, description, category, pubDate;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.picture);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            category = (TextView) itemView.findViewById(R.id.tvCategory);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
            pubDate = (TextView) itemView.findViewById(R.id.tvPubDate);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse(news.get(getAdapterPosition()).getMlink());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }


    }

    public List<Objekt> load(String item) {
        posebni = new ArrayList<>();
        for(Objekt objekt : news) {
            String category = objekt.getMcategory();
            if (category.equalsIgnoreCase(item)){
                Log.d("kategorije", objekt.getMcategory());
                this.posebni.add(objekt);

            }
            else{
                return news;

            }
            notifyDataSetChanged();



        } return posebni;
    }
}



