package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.HttpClient;
import br.edu.ufcspa.giovanib.televisao.client.ListarAtendimentosClient;
import br.edu.ufcspa.giovanib.televisao.modelo.Atendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarAtendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarAtendimentosRequest;

import static android.content.ContentValues.TAG;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ListView.OnItemSelectedListener {

    private static final String PREF_LOGIN = "LoginActivePreferences";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public static ArrayList<ListarAtendimento> atendimentos = new ArrayList<>();
    public static ListView listaDeAtenListView;
    public static AdapterListaAtend adapter;

    private TextView usuario;
    private TextView perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //atendimentos = new ArrayList<>();


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //Implementing tab selected listener over tablayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //setting current selected item over viewpager
                mViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        Log.e("TAG","Atendimentos");

                        break;
                    case 1:
                        Log.e("TAG","Usuários");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Navigation Menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        usuario = (TextView) header.findViewById(R.id.nav_nomeUsuario);
        perfil = (TextView) header.findViewById(R.id.nav_perfilUsuario);

        SingletonSession session = SingletonSession.getInstance();
        Log.d("singleton","sharedPref on singleton:"+session.toString());
        usuario.setText(session.nomeUsuario);
        perfil.setText(session.perfil);

        ListarAtendimentosClient client = new ListarAtendimentosClient(this);
        ListarAtendimentosRequest request = new ListarAtendimentosRequest();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Log.d("backend", "gson formated usuario:" + gson.toJson(request));

        // TODO VERIFICAR POST
        post(null);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }

        if (id == R.id.action_about) {
            startActivity(new Intent(this, SobreActivity.class));
            return true;
        }
        if (id == R.id.action_logoff) {
            startActivity(new Intent(this, LoginActivity.class));
            SharedPreferences sp = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.clear().commit();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /*
    *
    * COMUNICAO COM WEB SERVICE
    *
    *
    *
    * */
    public void post(JSONObject json) {
        JsonArrayRequest req = new JsonArrayRequest(HttpClient.URL + "listar_atendimentos.php",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d(TAG, response.toString());
                        Log.d("backend","web service response:"+response.toString());
                        try {
                            // Parsing json array response
                            // loop through each json object
                            //jsonResponse = "";
                            Gson gson = new Gson();

                            //converte para usuario


                            for (int i = 0; i < response.length(); i++) {

                                // TA AI O MALUCO QUE A GENTE QUER!!!
                                JSONObject person = (JSONObject) response
                                        .get(i);
                                ListarAtendimento l = gson.fromJson(person.toString(), ListarAtendimento.class);
                                atendimentos.add(l);


                                //Log.d("backend", "gson coverted to ListarAtendimento object:"+l.toString());
                                Log.d("backend","json obj:"+person.toString());

                            }

                            /*
                            * CHAMAR METODO PARA POPULAR LISTVIEW
                            *
                            * */
                            popularListView();




                        } catch (JSONException e) {
                            e.printStackTrace();
                           /* Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();*/
                        }

                       /* hidepDialog();*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
               /* Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();*/
            }
        });
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(req);
    }



    public void popularListView(){
        AdapterListaAtend adapterListaAtend = new AdapterListaAtend(atendimentos,this);
        listaDeAtenListView.setAdapter(adapterListaAtend);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_solicita_atendimento) {
            startActivity(new Intent(this, SolicitaAtendimentoActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this, SobreActivity.class));
        } else if (id == R.id.nav_logoff) {
            finish();
        } else if (id == R.id.nav_camera) {
            startActivity(new Intent(this, MyCameraActivity.class));
        } else if (id == R.id.nav_password) {
            startActivity(new Intent(this, ChangePasswdActivity.class));
        } else if(id== R.id.nav_historico){
            startActivity(new Intent(this, HistoricoAtendimentoActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //ListView
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //Demostração
        Toast.makeText(this, "Passando para Tela de Visuzalização de Atendimento", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, VisualizaAtendimentoActivity.class));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Tabbed Methods

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            // TODO LISTVIEW
            listaDeAtenListView = (ListView) rootView.findViewById(R.id.lista);
            listaDeAtenListView.setAdapter(adapter);



            listaDeAtenListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    SingletonSession singleton = SingletonSession.getInstance();
                    singleton.atendimentoAtual=atendimentos.get(position);
                    Log.d("singleton"," atendimento atual:"+singleton.atendimentoAtual.toString());
                    Toast.makeText(getContext(), "Passando para Tela de Visuzalização de Atendimento", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), VisualizaAtendimentoActivity.class));


                }
            });

//            TextView teste = (TextView) rootView.findViewById(R.id.teste);
//            teste.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Mostra o total de páginas
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String atend = getString(R.string.tabbed_atend);
            String user = getString(R.string.tabbed_user);
            switch (position) {
                case 0:
                    return user;
                case 1:
                    return atend;
            }
            return null;
        }
    }
}
