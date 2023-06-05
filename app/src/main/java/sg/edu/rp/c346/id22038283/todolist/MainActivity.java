package sg.edu.rp.c346.id22038283.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    Button btnRmv;
    Button btnUpd;
    EditText Pos;
    ListView lvtodo;

    ArrayList<String> todolist = new ArrayList<String>();
    ArrayAdapter<String> aalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnUpd = findViewById(R.id.buttonUpdate);
        btnRmv = findViewById(R.id.buttonRemoveItem);
        lvtodo = findViewById(R.id.listView);

        aalist = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todolist);
        lvtodo.setAdapter(aalist);

        lvtodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = todolist.get(position);
                Toast.makeText(getApplicationContext(), colour, Toast.LENGTH_SHORT).show();
            }
        });

        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index  = Integer.parseInt(etElement.getText().toString() );
                if (index >= 0 && index < todolist.size()) {
                    todolist.remove(index);
                    aalist.notifyDataSetChanged();
                    etElement.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid index", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todo = etElement.getText().toString();
                todolist.add(todo);
                aalist.notifyDataSetChanged();
                etElement.setText("");
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todolist.clear();
                aalist.notifyDataSetChanged();
                etElement.setText("");
            }
        });
    }
}
