package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class toDoAdapter extends RecyclerView.Adapter<toDoListViewHolder> {
    List<String> data = new ArrayList<>();
    private static final String TAG = "Adapter";

    public toDoAdapter(List<String> input) {
        this.data = input;
    }

    public toDoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        toDoListViewHolder holder = new toDoListViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(final toDoListViewHolder holder, final int position) {
        holder.toDo.setText(data.get(position));
        holder.toDo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int pos = position;
                String toDoDesc = data.get(holder.getAdapterPosition());
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete \n" + toDoDesc + "?" );
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
                        notifyItemRangeChanged(holder.getAdapterPosition(), data.size());
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG, "User declines to delete");
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return false;
            }
        });
    }

    public int getItemCount() {
        return data.size();
    }


}
