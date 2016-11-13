package com.thomaz.ambiduos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thomaz.ambiduos.dbs.DBHelperCacamba;
import com.thomaz.ambiduos.dbs.DBHelperDespachoResiduo;
import com.thomaz.ambiduos.dbs.DBHelperMestreObra;
import com.thomaz.ambiduos.dbs.DBHelperSolicitacaoCacamba;
import com.thomaz.ambiduos.dbs.DBHelperSolicitacaoTransporte;
import com.thomaz.ambiduos.support.UserDefaults;
import com.thomaz.ambiduos.support.WSUrlProvider;
import com.thomaz.ambiduos.to.User;

import org.androidannotations.annotations.EActivity;
import org.json.JSONException;
import org.json.JSONObject;

import thomaz.com.br.httpproject.suport.Post;
import thomaz.com.br.httpproject.suport.Request;
import thomaz.com.br.httpproject.suport.ResultRequest;

/**
 * A login screen that offers login via email/password.
 */
@EActivity
public class LoginActivity extends AppCompatActivity {

    static final String OPENED = "OPENED";

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    // private EditText type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserDefaults defaults = new UserDefaults(this);

        // Se nao tem, cria as tabelas do sistema
        if( !defaults.hasKey(OPENED) ) {
            defaults.write(OPENED, true);

            new DBHelperCacamba(this).dropTable();
            new DBHelperDespachoResiduo(this).dropTable();
            new DBHelperMestreObra(this).dropTable();
            new DBHelperMestreObra(this).dropTable();
            new DBHelperSolicitacaoCacamba(this).dropTable();
            new DBHelperSolicitacaoTransporte(this);
        }

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    return true;
                }
                return false;
            }
        });

//        type = ((EditText) findViewById(R.id.type_user));
//
//        type.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final CharSequence[] items = {
//                        getString(R.string.op_login_coop),
//                        getString(R.string.op_login_engen),
//                        getString(R.string.op_login_locad),
//                        getString(R.string.op_login_mestre),
//                        getString(R.string.op_login_transp)
//                };
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                builder.setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        type.setText(items[i]);
//
//                        dialogInterface.dismiss();
//                    }
//                });
//                builder.show();
//            }
//        });


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private boolean attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        //if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            //mPasswordView.setError(getString(R.string.error_invalid_password));
            //focusView = mPasswordView;
            //cancel = true;
        //}

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();

            return false;
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            JSONObject object = new JSONObject();
            try {
                object.put(WSUrlProvider.Login.Entry.EMAIL, email);
                object.put(WSUrlProvider.Login.Entry.SENHA, password);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Post post = new Post(WSUrlProvider.Login.URL);
            post.setBody(object);

            Request request = new Request(post);
            request.setListener(new ResultRequest(LoginActivity.this, R.string.app_name, getString(R.string.str_enviando_dados)) {
                @Override
                public void onSuccess(JSONObject object, boolean b) throws Exception {

                    if( b ) {
                        JSONObject user = object.getJSONObject(WSUrlProvider.Login.Exit.USER);
                        int tipo = user.getInt("TipoUsuario");

                        User newUser = new User();
                        newUser.setEmpresa(user.getString("Empresa"));
                        newUser.setId(user.getInt("Id"));
                        newUser.setNome(user.getString("Nome"));
                        newUser.setCpf(user.getString("CPF"));
                        newUser.setEmail(user.getString("Email"));
                        newUser.setTelefone(user.getString("Telefone"));
                        newUser.setEndereco(user.getString("Endereco"));
                        newUser.setCep(user.getString("CEP"));
                        newUser.setEmpresaId(user.getInt("EmpresaId"));
                        newUser.setTipo(user.getInt("TipoUsuario"));

                        // Intent intent = new Intent(LoginActivity.this, a);
                        // intent.putExtra("USER_CURRENT", newUser);
                        // startActivity(intent);

                        // mestre : tipoUsuario:1 | TipoEmpresa:0
                        // locador: tipoUsuario:0 | TipoEmpresa:1
                        // engenheiro : tipoUsuario:0 | TipoEmpresa:0
                        // cooperativa : tipoUsuario:0 | TipoEmpresa:3
                        // transp : tipoUsuario:0 | TipoEmpresa:2

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        JSONObject empresa = user.getJSONObject("Empresa");

                        @MenuRes int menu;
                        if( empresa.getInt("TipoEmpresa") == 0 ) {
                            if( user.getInt("TipoUsuario") == 1 ) {
                                menu = R.menu.menu_navigation_mestre_de_obra;
                            } else {
                                menu = R.menu.menu_navigation_engenheiro;
                            }
                        } else if( empresa.getInt("TipoEmpresa") == 1  ) {
                            menu = R.menu.menu_navigation_locador;
                        } else if( empresa.getInt("TipoEmpresa") == 2  ) {
                            menu = R.menu.menu_navigation_transportador;
                        } else {
                            menu = R.menu.menu_navigation_cooperativa;
                        }

                        intent.putExtra("MENU", menu);

                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, getString(R.string.str_error_login), Toast.LENGTH_SHORT).show();
                    }
                }

            });

            request.execute();
            return true;
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return true;
    }


}

