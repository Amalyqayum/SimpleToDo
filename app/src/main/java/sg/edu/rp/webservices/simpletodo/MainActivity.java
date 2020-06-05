package sg.edu.rp.webservices.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    Button btnAdd, btnClear, btnDelete;
    ListView lv;
    ArrayList<String> alTasks;
    ArrayAdapter aaTasks;
    Spinner spn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTask = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        btnDelete = findViewById(R.id.buttonDelete);
        lv = findViewById(R.id.lv);
        spn = findViewById(R.id.spinner);

        alTasks = new ArrayList<>();
        aaTasks = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alTasks);
        lv.setAdapter(aaTasks);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Adding = etTask.getText().toString();
                alTasks.add(Adding);
                aaTasks.notifyDataSetChanged();
            }

        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Removing = etTask.getText().toString();
                alTasks.remove(Removing);
                aaTasks.notifyDataSetChanged();
            }
        });
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                switch (position) {
                    case 0:
                        etTask.setHint("Type in a new task here");
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Adding = etTask.getText().toString();
                                alTasks.add(Adding);
                                aaTasks.notifyDataSetChanged();
                            }

                        });
                        break;
                    case 1:
                        etTask.setHint("Type in the index of the task to be removed");
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);
                        btnDelete.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                int Delete = Integer.parseInt(etTask.getText().toString());
                                alTasks.remove(Delete);
                                aaTasks.notifyDataSetChanged();
                            }
                        });
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}

