package es.pue.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btnActivateRemote;
    private TextView tvIndicator;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get view elements.
        tvIndicator = findViewById(R.id.tvIndicator);
/*        btnActivateRemote = findViewById(R.id.btnActivateRemoteControl);

        // Create listener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvIndicator.setText("Remote control activated");
            }
        };

        // Link listener to button
        btnActivateRemote.setOnClickListener(listener);
*/
    }

    public void changeColor(View view) {
        Button button = (Button) view;
        int btnId = button.getId();
        int color;

        switch (btnId) {
            case R.id.btnRed:
                color = getResources().getColor(R.color.red);
                break;
            case R.id.btnGreen:
                color = getResources().getColor(R.color.green);
                break;
            case R.id.btnBlue:
                color = getResources().getColor(R.color.blue);
                break;
            default:
                color = getResources().getColor(R.color.black);
                //throw new Exception("Unexpected button clicked");
                break;
        }

        tvIndicator.setTextColor(color);
    }

    public void changeText(View view) {
        Button button = (Button) view;
        int btnId = button.getId();
        String text;

        etName = findViewById(R.id.etName);
        String name = etName.getText().toString();

        Log.i("APP_SYSTEM", "User " + name + " has activated system");

        switch (btnId) {
            case R.id.btnActivateRemoteControl:
                text = getResources().getString(R.string.litsRemoteControlActivated)+" "+name;
                break;
            case R.id.btnStopSystem:
                text = "System stopped by "+name;
                break;
            default:
                text = "Unexpected";
                //throw new Exception("Unexpected button clicked");
                break;
        }

        tvIndicator.setText(text);
    }
}
