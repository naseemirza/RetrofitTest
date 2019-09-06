package technologies.acsius.retrofittest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

     private Context mCtx;
   private List<Hero> productList;

    public HeroAdapter(Context mCtx, List<Hero> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    public void setHeroList(List<Hero> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.detailslayout, null);
        return new HeroAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Hero product = productList.get(position);

        holder.nametxt.setText(product.getName());
        holder.realnametxt.setText(product.getRealname());
        holder.teamtxt.setText(product.getTeam());
        holder.fatxt.setText(product.getFirstappearance());
        holder.createdtxt.setText(product.getCreatedby());
        holder.publishertxt.setText(product.getPublisher());
        holder.biotxt.setText(product.getBio());

        Glide.with(mCtx)
                .load(product.getImageurl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nametxt, realnametxt, teamtxt, fatxt, createdtxt, publishertxt, biotxt;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nametxt = itemView.findViewById(R.id.nmtxt);
            realnametxt = itemView.findViewById(R.id.rlnmtxt);
            teamtxt = itemView.findViewById(R.id.teamtxt);
            fatxt = itemView.findViewById(R.id.fatxt);
            createdtxt = itemView.findViewById(R.id.crtedtxt);
            publishertxt = itemView.findViewById(R.id.publshrtxt);
            biotxt = itemView.findViewById(R.id.biotxt);
            imageView = itemView.findViewById(R.id.img);

        }
    }
}
