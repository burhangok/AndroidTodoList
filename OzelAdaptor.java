package ismek.grevsepeti;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class OzelAdaptor extends BaseAdapter {

    public List<Gorev> gorevler;
    public LayoutInflater mLayoutInflater;


    public OzelAdaptor(Activity activity, List<Gorev> gorevler1) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mLayoutInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        gorevler = gorevler1;
    }

    @Override
    public int getCount() {
        return gorevler.size();
    }

    @Override
    public Object getItem(int position) {
        return gorevler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satir= mLayoutInflater.inflate(R.layout.satir,null);

        TextView baslik = satir.findViewById(R.id.baslik);
        TextView aciklama =satir.findViewById(R.id.aciklama);
        CheckBox durum = satir.findViewById(R.id.durum);



        Gorev gorev = gorevler.get(position);

        baslik.setText(gorev.getBaslik());
        aciklama.setText(gorev.getAciklama());

        if(gorev.getDurum().equals("Tamam"))
            durum.setChecked(true);

        if(gorev.getDurum().equals("Devam"))
            durum.setChecked(false);

        return satir;
    }
}
