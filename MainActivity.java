package ismek.grevsepeti;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView gorevListesi;

    public Button bitenler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent gecisYap = new Intent(MainActivity.this,GorevEkleme.class);

                startActivity(gecisYap);
            }
        });


        gorevListesi=findViewById(R.id.gorevler);

        final Veritabani vt = new Veritabani(MainActivity.this);
        final List<Gorev> gorevler =vt.gorevleriGetir("Hepsi");

        OzelAdaptor adaptor = new OzelAdaptor(MainActivity.this,gorevler);

        gorevListesi.setAdapter(adaptor);


        gorevListesi.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });



        bitenler=findViewById(R.id.bitenler);

        bitenler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Gorev> bitenGorevler = vt.gorevleriGetir("Tamam");
                OzelAdaptor bitenlerAdaptor = new OzelAdaptor(MainActivity.this,bitenGorevler);

                gorevListesi.setAdapter(bitenlerAdaptor);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      if(id==R.id.cikis) {
          Toast.makeText(this, "Çıkış Yapılıyor...", Toast.LENGTH_SHORT).show();
      }
      if(id==R.id.force) {
          System.exit(0);
      }

        return super.onOptionsItemSelected(item);
    }
}
