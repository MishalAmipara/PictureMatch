package com.example.picturematch;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.View_Holder>
{
    Runnable runnable;
    Activity activity;
    List<String> imgArr;
    int click=1,pos1=0,pos2=0;
    View firstview;

    public LevelAdapter(Activity activity, List<String> imgArr) {
        this.activity=activity;
        this.imgArr=imgArr;
    }
    @NonNull
    @Override
    public LevelAdapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.activity_level_item,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }
    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.View_Holder holder, int position)
    {
        InputStream inputstream= null;
        try
        {
            inputstream = activity.getAssets().open(imgArr.get(position));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Drawable drawable = Drawable.createFromStream(inputstream, null);
        holder.img.setImageDrawable(drawable);

//        holder.img.setImageResource(imgArr.get(position));
        int interval = 5000; // 1 Second
        Handler handler = new Handler();
        runnable = new Runnable()
        {
            public void run()
            {
                holder.view1.setVisibility(View.VISIBLE);
            }
        };
        handler.postAtTime(runnable, System.currentTimeMillis()+interval);
        handler.postDelayed(runnable, interval);
        holder.relativeLayout.setOnClickListener(v -> {
            if(click==1)
            {
                holder.view1.setVisibility(View.INVISIBLE);
                pos1=holder.getAdapterPosition();
                firstview=holder.view1;
                click=3;
                runnable = new Runnable()
                {
                    public void run() {
                        click=2;
                    }
                };
                handler.postAtTime(runnable, System.currentTimeMillis()+interval);
                handler.postDelayed(runnable, 100);
                System.out.println("first click");
            }
            if(click==2)
            {
                holder.view1.setVisibility(View.INVISIBLE);
                pos2=holder.getAdapterPosition();
                click=3;
                System.out.println("second click");
                if(imgArr.get(pos1).equals(imgArr.get(pos2)))
                {
                    System.out.println("match");
                    runnable = new Runnable(){
                        public void run()
                        {
                            click=1;
                        }
                    };
                    handler.postAtTime(runnable, System.currentTimeMillis()+interval);
                    handler.postDelayed(runnable, 500);
                }
                else
                {
                    System.out.println("not match");
                    runnable = new Runnable()
                    {
                        public void run()
                        {
                            holder.view1.setVisibility(View.VISIBLE);
                            firstview.setVisibility(View.VISIBLE);
                            click=1;
                        }
                    };
                    handler.postAtTime(runnable, System.currentTimeMillis()+interval);
                    handler.postDelayed(runnable, 500);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgArr.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        ImageView img;
        View view1;
        RelativeLayout relativeLayout;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgView);
            view1=itemView.findViewById(R.id.view1);
            relativeLayout=itemView.findViewById(R.id.relative);
        }
    }
}
