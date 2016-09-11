package id.sch.smktelkom_mlg.tugas01.xiirpl1005.beasiswaindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama;
    EditText etTahun;
    EditText etSekolah;
    RadioButton rbLK, rbPR;
    CheckBox cbOS, cbPR, cbJR;
    Button bOk;
    Spinner spKota;
    TextView tvHasil, tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvOrgan, tvHasil6;
    int nOrgan;


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
        spKota = (Spinner) findViewById(R.id.spinnerProvinsi);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil5);
        tvOrgan = (TextView) findViewById(R.id.textViewOR);
        tvHasil6 = (TextView) findViewById(R.id.textViewHasil6);

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
            tvHasil6.setText("Kota : " + spKota.getSelectedItem().toString());

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
