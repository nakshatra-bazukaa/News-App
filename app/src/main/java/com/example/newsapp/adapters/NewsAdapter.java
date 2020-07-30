package com.example.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.models.Article;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

    //    Setting up OnClickListener to listen to Article clicked callback
    private NewsAdapter.OnClickListener listener;

    public interface OnClickListener{
        void onItemClick(Article article);
    }

    public void setOnItemClickListener(NewsAdapter.OnClickListener listener){
        this.listener = listener;
    }


    //    Diff instead of notifyOnDataSetChanged to improve performance
    //    This manages our list in recyclerview
    private static final DiffUtil.ItemCallback<Article> differCallback = new DiffUtil.ItemCallback<Article>(){
        @Override
        public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
            return oldItem.getUrl() == newItem.getUrl();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
            return oldItem.equals(newItem);
        }
    };
    private final AsyncListDiffer<Article> differ = new AsyncListDiffer<Article>(this, differCallback);


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_article_preview,
                        parent,
                        false
                )
        );
    }
    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = differ.getCurrentList().get(position);
        Glide.with(holder.itemView)
                .load(article.getUrlToImage())
                .into(holder.imageView);
        holder.source.setText(article.getSource().getName());
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.publishedAt.setText(article.getPublishedAt());
    }
    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView source;
        TextView title;
        TextView description;
        TextView publishedAt;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivArticleImage);
            source = itemView.findViewById(R.id.tvSource);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
            publishedAt = itemView.findViewById(R.id.tvPublishedAt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(differ.getCurrentList().get(position));
                    }
                }
            });

        }
    }





}
