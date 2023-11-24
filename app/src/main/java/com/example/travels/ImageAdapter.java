package com.example.travels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    public static final List<Integer> imagenes = Arrays.asList(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
    );



    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public int currentPosition;  // Nuevo: mantener el índice de la imagen actual
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            currentPosition = 0;  // Inicializar el índice en 0
        }
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Integer image = imagenes.get(position);
        holder.imageView.setImageResource(image);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    // Cargar la imagen en el ImageSwitcher
                    ImageSwitcher imageSwitcher = view.getRootView().findViewById(R.id.imageSwitcher);
                    imageSwitcher.setImageResource(image);
            }
        });
    }



    @Override
    public int getItemCount() {
        return imagenes.size();
    }

    public static List<Integer> getImageList(){
        return imagenes;
    }

}
