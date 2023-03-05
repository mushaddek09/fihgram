package com.example.fihgram;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private String sender;
    private String receiver;
    private String content;


    public Message() {
    }

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//
//
//        List<ResponseModel> data = new ArrayList<>();
//
//        public MyAdapter() {
//        }
//
//        @NonNull
//        @Override
//        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
//
//            return new MyViewHolder(view);
//
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//
//            holder.userName.setText(data.get(position).getUser_name());
//            holder.publisher.setText(data.get(position).getUser_name());
//            holder.description.setText(data.get(position).getDescription());
//            Glide.with(holder.post_image.getContext()).load("http://192.168.1.13/instagram/" +
//                    data.get(position).getImage_profile()).into(holder.post_image);
//
//
//            Glide.with(holder.post_image.getContext()).load("http://192.168.1.13/instagram/" +
//                    data.get(position).getImage_profile()).into(holder.image_profile);
//
//
//
//
//
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return data == null ? 0 : data.size();
//        }
//
//        class MyViewHolder extends RecyclerView.ViewHolder {
//
//
//            ImageView post_image, image_profile;
//            TextView userName, publisher, description;
//
//
//            public MyViewHolder(@NonNull View itemView) {
//                super(itemView);
//
//
//                post_image = itemView.findViewById(R.id.post_image);
//                image_profile = itemView.findViewById(R.id.image_profile);
//                userName = itemView.findViewById(R.id.userName);
//                publisher = itemView.findViewById(R.id.publisher);
//                description = itemView.findViewById(R.id.description);
//            }
//        }
//
//
//        @SuppressLint("NotifyDataSetChanged")
//        public void setList(List<ResponseModel> list) {
//            data.addAll(list);
//            notifyDataSetChanged();
//        }
//
//
//    }
}
