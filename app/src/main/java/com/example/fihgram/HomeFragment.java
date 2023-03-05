package com.example.fihgram;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.api.ApiController;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {



    RecyclerView recyclerView;



        private MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View myView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = myView.findViewById(R.id.post_recycle);

        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        processData();








        return myView;
    }

    private void processData() {

        Call<List<ResponseModel>> call = ApiController.getInstance().getApi().getdata();

        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ResponseModel>> call,
                                   @NonNull Response<List<ResponseModel>> response) {

                List<ResponseModel> data = response.body();
                myAdapter.setList(data);
            }

            @Override
            public void onFailure(@NonNull Call<List<ResponseModel>> call, @NonNull Throwable t) {
                Log.e("Rec_error",t.getMessage());
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }


}