package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import sg.edu.np.mad.mad_recyclerview.R;

public class toDoListViewHolder extends RecyclerView.ViewHolder
{
    TextView toDo;
    CheckBox checkBox;

    public toDoListViewHolder(View itemView) {
        super(itemView);
        toDo = itemView.findViewById(R.id.textView);
        checkBox = itemView.findViewById(R.id.checkBox);
    }
}
