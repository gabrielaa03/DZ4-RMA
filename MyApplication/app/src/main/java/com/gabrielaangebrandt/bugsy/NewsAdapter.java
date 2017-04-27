package com.gabrielaangebrandt.bugsy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gabriela on 25.4.2017..
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    ArrayList<Objekt> news;
    Context context;

    public NewsAdapter(Context context, ArrayList<Objekt> news){ this.context = context; this.news = news;};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.objekt_layout, parent, false);
        ViewHolder newsViewHolder = new ViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Objekt trenutniObjekt = news.get(position);
            holder.title.setText(trenutniObjekt.getTitle());
            holder.category.setText(trenutniObjekt.getCategory());
            holder.description.setText(trenutniObjekt.getPubDate());
            holder.pubDate.setText(trenutniObjekt.getDescription());
            Picasso.with(context).load(trenutniObjekt.getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return (news== null) ? 0 : news.size();
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
            String message = description.getText().toString();
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG);
        }

        }
    }


