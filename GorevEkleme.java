package ismek.grevsepeti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GorevEkleme extends AppCompatActivity {


    public EditText baslik,aciklama;
    public Button kaydetButonu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorev_ekleme);

        baslik=findViewById(R.id.yeniBaslik);
        aciklama=findViewById(R.id.yeniAciklama);

        kaydetButonu=findViewById(R.id.butonKaydet);

        final Veritabani vt = new Veritabani(GorevEkleme.this);

        kaydetButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

  Gorev yeniGorev = new Gorev(baslik.getText().toString(),aciklama.getText().toString(),"Devam");

  vt.gorevEkle(yeniGorev);

                Intent geriDon = new Intent(GorevEkleme.this,MainActivity.class);

                startActivity(geriDon);
            }
        });

    }
}
