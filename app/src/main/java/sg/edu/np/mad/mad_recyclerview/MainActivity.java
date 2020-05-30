package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG = "recyclerview1";
    ArrayList<String> toDoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<String> list = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "starting");
        Button addButton = findViewById(R.id.addButton);
        final EditText etAdd = findViewById(R.id.editTextAdd);
        final RecyclerView recyclerView = findViewById(R.id.toDoList);
        recyclerFunction(list);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = etAdd.getText().toString();
                if (newItem.isEmpty()) {
                    Log.v(TAG, "Input is empty");
                }
                else {
                    list.add(newItem);
                    showNewEntry(recyclerView, list);
                    etAdd.setText("");
                }
            }
        });



    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }

    private void recyclerFunction(List<String> sList) {
        RecyclerView recyclerView = findViewById(R.id.toDoList);
        toDoAdapter mAdaptor = new toDoAdapter(sList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdaptor);
    }
}
