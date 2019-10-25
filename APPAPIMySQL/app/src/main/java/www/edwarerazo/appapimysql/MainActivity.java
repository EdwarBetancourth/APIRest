package www.edwarerazo.appapimysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        email = findViewById (R.id.id_username);
        register = findViewById (R.id.id_Register);

        register.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Register("http://192.168.56.1/APIRest/ScriptsPHP/register_user.php");
            }
        });

    }

    private void Register(String url){
        StringRequest stringRequest = new StringRequest (Request.Method.POST, url, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                Toast.makeText (MainActivity.this, "User has been registered", Toast.LENGTH_SHORT).show ();
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText (getApplicationContext (), error.toString (),Toast.LENGTH_SHORT).show ();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<> ();
                params.put ("email",email.getText ().toString ());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue (this);
        requestQueue.add (stringRequest);
    }
}
