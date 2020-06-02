package com.example.online_veggie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_main_item extends RecyclerView.Adapter<Adapter_main_item.ViewHolder> {

    private List<model_main_item>modelMainItems;

    public Adapter_main_item(List<model_main_item> modelMainItems) {
        this.modelMainItems = modelMainItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int vegeimage= modelMainItems.get(position).getVegeimage();
        String offerpercent= modelMainItems.get(position).getOfferpercent();
        String vegename= modelMainItems.get(position).getVegename();
        String vegeweight= modelMainItems.get(position).getVegeweight();
        String vegeprice= modelMainItems.get(position).getVegeprice();

        viewHolder.SetData2(vegeimage,offerpercent,vegename,vegeweight,vegeprice);

    }

    @Override
    public int getItemCount() {
        return modelMainItems.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

    private ImageView vegeimage;
    private TextView offerpercent;
    private TextView vegename;
    private TextView vegeweight;
    private TextView vegeprice;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        vegeimage= itemView.findViewById(R.id.vege_image_id);
        offerpercent= itemView.findViewById(R.id.offer_percent_id);
        vegename= itemView.findViewById(R.id.vege_name_id);
        vegeweight= itemView.findViewById(R.id.vege_weight_id);
        vegeprice= itemView.findViewById(R.id.vege_price_id);

    }

    private void SetData2(int imagevege,String percentoffer,String nameveg,String weightvege,String pricevege){
        vegeimage.setImageResource(imagevege);
        offerpercent.setText(percentoffer);
        vegename.setText(nameveg);
        vegeweight.setText(weightvege);
        vegeprice.setText(pricevege);
    }
}


}
