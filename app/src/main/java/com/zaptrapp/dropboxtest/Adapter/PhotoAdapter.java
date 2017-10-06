package com.zaptrapp.dropboxtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zaptrapp.dropboxtest.Model.MainResponse;
import com.zaptrapp.dropboxtest.R;

import java.util.List;

/**
 * Created by Nishanth on 02-Oct-17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {

    private List<MainResponse.Photo> mPhotos;
    private Context mContext;

    public PhotoAdapter(List<MainResponse.Photo> photo) {
        mPhotos = photo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_photo_recycler,parent,false);
        return new MyViewHolder(view,this,mPhotos);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MainResponse.Photo photo = mPhotos.get(position);

//        https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg

        String imageUrlBuilder = "https://farm"+photo.farm+".staticflickr.com/"+
                photo.server+"/"+photo.id+"_"+photo.secret+".jpg";
        Log.d("Adapter", "imageUrl "+imageUrlBuilder);
        //bind items to view
        if(photo!=null) {
            Picasso.with(mContext).load(imageUrlBuilder).into(holder.photoImage);
            holder.photoName.setText(photo.title);
            holder.episodeNumber.setText(String.valueOf(photo.ispublic));
            holder.photoID.setText(photo.id);
        }
//        Glide.with(mContext).load(IMAGE_URL_BASE+mPhotos.get(position).still_path).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView photoImage;
        PhotoAdapter adapter;
        TextView photoName;
        TextView photoID;
        TextView episodeNumber;
        private List<MainResponse.Photo> mPhotos;


        public MyViewHolder(View itemView, PhotoAdapter episodeAdapter, List<MainResponse.Photo> photo) {
            super(itemView);
            this.adapter = episodeAdapter;
            photoImage = itemView.findViewById(R.id.imageViewEpisodeRecycler);
            photoName = itemView.findViewById(R.id.photoTitle);
            episodeNumber = itemView.findViewById(R.id.episodeNumber);
            photoID = itemView.findViewById(R.id.photoId);
            itemView.setOnClickListener(this);
            mPhotos = photo;
        }


        @Override
        public void onClick(View view) {
//            //get the position of the item that was clicked
//            int mPosition = getLayoutPosition();
//            MainResponse.Photo episode= mPhotos.get(mPosition);
//            Log.d("PhotoAdapter", "onClick: "+episode.name);
//            Intent intent = new Intent(view.getContext(), EpisodeActivity.class);
//            intent.putExtra("episodeClicked",episode);
//            view.getContext().startActivity(intent);
        }
    }


}


