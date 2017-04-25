package com.gabrielaangebrandt.bugsy;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gabriela on 25.4.2017..
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    ArrayList<Objekt> news;

    public NewsAdapter(ArrayList<Objekt> mnews){news = mnews;};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.objekt_layout, parent, false);
        ViewHolder newsViewHolder = new ViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Objekt objekt = this.news.get(position);
            holder.title.setText(objekt.getTitle());
            holder.category.setText(objekt.getCategory());
            holder.description.setText(objekt.getDescription());
            holder.image.setImageURI(Uri.parse(objekt.getUrl()));
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, description, category;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.picture);
            this.title = (TextView) itemView.findViewById(R.id.tvTitle);
            this.category = (TextView) itemView.findViewById(R.id.tvCategory);
            this.description = (TextView) itemView.findViewById(R.id.tvDescription);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            String message = description.getText().toString();
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG);
        }
    }
}
