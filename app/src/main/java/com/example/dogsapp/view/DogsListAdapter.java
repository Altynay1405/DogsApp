package com.example.dogsapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogsapp.R;
import com.example.dogsapp.databinding.ItemDogBinding;
import com.example.dogsapp.model.DogBreed;
import com.example.dogsapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DogsListAdapter extends RecyclerView.Adapter<DogsListAdapter.DogViewHolder> implements DogClickListener { //1  //2c <>

    private ArrayList<DogBreed> dogsList; //4

    public DogsListAdapter(ArrayList<DogBreed> dogsList){ //4a
        this.dogsList = dogsList;
    }

    public void updateDogsList(List<DogBreed> newDogsList){  //5 update the list
        dogsList.clear();
        dogsList.addAll(newDogsList);
        notifyDataSetChanged();
    }



    //3 implemented methods  //6 binding data with view holder
    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDogBinding view = DataBindingUtil.inflate(inflater, R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.itemView.setDog(dogsList.get(position));
        holder.itemView.setListener(this);

     /*   ImageView image = holder.itemView.findViewById(R.id.imageView);
        TextView name = holder.itemView.findViewById(R.id.name);
        TextView lifespan = holder.itemView.findViewById(R.id.lifespan);
        LinearLayout layout = holder.itemView.findViewById(R.id.dogLayout);

        name.setText(dogsList.get(position).dogBreed);
        lifespan.setText(dogsList.get(position).lifeSpan);
        Util.loadImage(image, dogsList.get(position).imageUrl, Util.getProgressDrawable(image.getContext()));
        layout.setOnClickListener(view -> {
            ListFragmentDirections.ActionDetail action = ListFragmentDirections.actionDetail();
            action.setDogUuid(dogsList.get(position).uuid);
            Navigation.findNavController(layout).navigate(action);
        });*/

    }

    @Override
    public void onDogClicked(View v) {
        String uuidString = ((TextView)v.findViewById(R.id.dogId)).getText().toString();
        int uuid = Integer.valueOf(uuidString);
        ListFragmentDirections.ActionDetail action = ListFragmentDirections.actionDetail();
        action.setDogUuid(uuid);
        Navigation.findNavController(v).navigate(action);
    }

    @Override
    public int getItemCount() {
        return dogsList.size();
    }

    class DogViewHolder extends RecyclerView.ViewHolder{  //2

        public ItemDogBinding itemView; //2b

        public DogViewHolder(@NonNull ItemDogBinding itemView) { //2a
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}
