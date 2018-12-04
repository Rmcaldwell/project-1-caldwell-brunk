package edu.uncw.seahawktours;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.v4.content.ContextCompat;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

class CaptionedBuildingsAdapter extends RecyclerView.Adapter<CaptionedBuildingsAdapter.ViewHolder> {

    //MARK: Properties
    private ArrayList<String> captions;
    private int[] imageIds;
    private Box<Building> buildingBox;
    private BoxStore database;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Define the view to be used for each data item

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    //MARK: Constructor(s)
//    public CaptionedBuildingsAdapter(String[] captions, int[] imageIds) {
//        this.captions = captions;
//        this.imageIds = imageIds;
//    }

    public CaptionedBuildingsAdapter(ArrayList<String> captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    public CaptionedBuildingsAdapter(Box<Building> box) {
        this.buildingBox = box;
        database = App.getBoxStore();
    }

    @Override
    public int getItemCount() {
        return captions.size();
    }

    @Override
    public CaptionedBuildingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions.get(position));
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions.get(position));
    }

    // Create list of buildings by reading from the database

}
