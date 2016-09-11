package id.sch.smktelkom_mlg.tugas01.xiirpl1005.beasiswaindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama;
    EditText etTahun;
    EditText etSekolah;
    RadioButton rbLK, rbPR;
    CheckBox cbOS, cbPR, cbJR;
    Button bOk;
    //    Spinner spProvinsi, spKota;
    TextView tvHasil, tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvOrgan, tvHasil6, tvHasil7;
    int nOrgan;
    /*String [][] arKota = {{"Medan","Pematangsiantar","Binjai","Sibolga"},{"Padang","Bukittinggi","Solok","Payakumbuh"},{"Palembang","Lahat","Prabumulih","Lubuklinggau"},{"Bandar Lampung","Kalianda","Tulang Bawang","Metro"},{"Jakarta Barat","Jakarta Utara","Jakarta Selatan","Jakarta Timur","Jakarta Pusat"},{"Bandung","Cirebon","Bekasi","Bogor"},{"Semarang","Solo","Wonogiri","Salatiga"},{"Surabaya","Malang","Madiun","Kediri"},{"Denpasar","Tabanan","Gianyar","Klungkung"},{"Ende","Kupang","Labuan Bajo","Maumere"},{"Tondano","Boolang Mongondoow","Minahasa","Talaud"},{"Mamuju","Mamasa","Polewali"},{"Bulukumba","Masamba","Watampone"},{"Sukadana","Ketapang","Sambas","Sanggau"},{"Tenggarong","Berau","Balikpapan","Samarinda"},{"Banjar","Martapura","Paringin","Amuntai"},{"Biak","Sentani","Wamena","Yapen"}};
    ArrayList<String> listKota = new ArrayList<>();
   ArrayAdapter<String> adapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        etSekolah = (EditText) findViewById(R.id.editTextSekolah);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLk);
        rbPR = (RadioButton) findViewById(R.id.radioButtonPr);
        cbOS = (CheckBox) findViewById(R.id.checkBoxOS);
        cbPR = (CheckBox) findViewById(R.id.checkBoxPr);
        cbJR = (CheckBox) findViewById(R.id.checkBoxJr);
        /*spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        spKota = (Spinner) findViewById(R.id.spinnerKota);*/
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil5);
        tvOrgan = (TextView) findViewById(R.id.textViewOR);
        tvHasil6 = (TextView) findViewById(R.id.textViewHasil6);
        tvHasil7 = (TextView) findViewById(R.id.textViewHasil7);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });

        cbOS.setOnCheckedChangeListener(this);
        cbPR.setOnCheckedChangeListener(this);
        cbJR.setOnCheckedChangeListener(this);
/*
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
//        spKota.setAdapter(adapter);

       /* spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.setProvinsi((String)spProvinsi.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }*/

//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView)
//            {
//
//            }
//        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String hasil = null;
            String sekolah = etSekolah.getText().toString();
            if (rbLK.isChecked()) {
                hasil = rbLK.getText().toString();
            } else if (rbPR.isChecked()) {
                hasil = rbPR.getText().toString();
            }
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2016 - tahun;

            String hasil1 = "Organisasi di Sekolah :\n";
            int startlen = hasil1.length();
            if (cbOS.isChecked()) hasil1 += cbOS.getText() + "\n";
            if (cbPR.isChecked()) hasil1 += cbPR.getText() + "\n";
            if (cbJR.isChecked()) hasil1 += cbJR.getText() + "\n";

            if (hasil1.length() == startlen) hasil1 += "Organisasi belum dipilih";

            tvHasil.setText("Data Diri Pendaftar Beasiswa");
            tvHasil1.setText("Nama : " + nama);
            tvHasil2.setText("Usia : " + usia + " tahun");
            if (hasil == null) {
                tvHasil3.setText("Belum memilih jenis kelamin");
            } else {
                tvHasil3.setText("Jenis kelamin : " + hasil);
            }
            tvHasil4.setText("Asal Sekolah : " + sekolah);
            tvHasil5.setText(hasil1);
           /* tvHasil6.setText("Provinsi : "+ spProvinsi.getSelectedItem().toString());
            tvHasil7.setText("Kota : "+spKota.getSelectedItem().toString())*/
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String sekolah = etSekolah.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun kelahiran belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format Tahun kelahiran bukan yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }

        if (sekolah.isEmpty()) {
            etSekolah.setError("Sekolah belum diisi");
            valid = false;
        } else if (sekolah.length() < 3) {
            etSekolah.setError("Sekolah harus diisi");
            valid = false;
        } else {
            etSekolah.setError(null);
        }

        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) nOrgan += 1;
        else nOrgan -= 1;

        tvOrgan.setText("Organisasi (" + nOrgan + " terpilih)");
    }
}
