package com.example.picturematch;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder>
{
    Activity activity;
    String[] level;
    public RecyclerAdapter(Activity activity, String[] level)
    {
        this.activity=activity;
        this.level=level;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.no_time_limit_item,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }
    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
    holder.textView.setText(""+level[position]);
    holder.textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            Intent intent=new Intent(activity,Level_Activity.class);
            intent.putExtra("level",holder.getAdapterPosition());
            activity.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return level.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder
    {

        TextView textView;
        public View_Holder(@NonNull View itemView)
        {
            super(itemView);
            textView=itemView.findViewById(R.id.no_time_limit_item_text);
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent;
//                    intent = new Intent(activity,Level_Activity.class);
//                    activity.startActivity(intent);
//                }
//            });
        }
    }
}
