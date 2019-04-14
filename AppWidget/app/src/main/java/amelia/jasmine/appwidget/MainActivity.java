package amelia.jasmine.appwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtNama, edtTtl, edtNohp, edtHobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this);

        btnSave = (Button)findViewById(R.id.btn_save);
        edtNama= (EditText)findViewById(R.id.edt_nama);
        edtTtl = (EditText)findViewById(R.id.edt_ttl);
        edtNohp = (EditText)findViewById(R.id.edt_nohp);
        edtHobi = (EditText)findViewById(R.id.edt_hobi);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().write("nama", edtNama.getText().toString());
                Paper.book().write("ttl", edtTtl.getText().toString());
                Paper.book().write("nohp", edtNohp.getText().toString());
                Paper.book().write("hobi", edtHobi.getText().toString());

                Toast.makeText(MainActivity.this, "Save!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
