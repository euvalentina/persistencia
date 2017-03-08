package br.com.fiap.logincomsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText senha;
    CheckBox SalvarSenha;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
        SalvarSenha = (CheckBox) findViewById(R.id.SalvarSenha);

        sp = getPreferences(MODE_PRIVATE);

        login.setText(sp.getString("usuario", ""));
        senha.setText(sp.getString("senha", ""));
    }

    public void login(View view) {
        String usuario = login.getText().toString();
        String pass = senha.getText().toString();

        if(usuario.trim().equals("fiap") && pass.trim().equals("123")){
            if(SalvarSenha.isChecked()){
                SharedPreferences.Editor e = sp.edit();
                e.putString("usuario", usuario);
                e.putString("senha", pass);
                e.commit();
            }
            return;
            // lógica para abrir outra activity
        }
        Toast.makeText(this, R.string.usuario_incorreto, Toast.LENGTH_SHORT).show();

    }
}
