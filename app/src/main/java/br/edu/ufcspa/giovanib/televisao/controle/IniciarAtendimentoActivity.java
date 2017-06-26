package br.edu.ufcspa.giovanib.televisao.controle;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.CadastrarHistoricoAtendimentoClient;
import br.edu.ufcspa.giovanib.televisao.modelo.CadastroHistoricoAtendimento;

public class IniciarAtendimentoActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    private static final int CAMERA_REQUEST = 1888;
    private static String UPLOAD_URL="http://angelo.inf.ufrgs.br/televisao/uploads/";
    private String pathOlhoD;
    private String pathOlhoE;
    private String olhoEscolhido;
    EditText edtConduta;
    EditText edtParecer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_atendimento);
        edtConduta= (EditText) findViewById(R.id.histConduta);
        edtParecer= (EditText) findViewById(R.id.histParecer);
    }



    public void anexarOnClick(View v){

        if (v.getId()==R.id.btn_anexarOD) {
            olhoEscolhido = "D";
        }
        else{
            olhoEscolhido = "E";
        }

        ActivityCompat.requestPermissions(IniciarAtendimentoActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
    }




    public void capturarOnClick(View v){

        if (v.getId()==R.id.btn_capturarOD) {
            olhoEscolhido = "D";
        }
        else if(v.getId()==R.id.btn_capturarOE){
            olhoEscolhido = "E";
        }

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }






    public void finalizarOnClick(View v ){
        uploadImagens();
        enviarDadosWebService();
    }






    private void uploadImagens(){
        String[] pictures = {pathOlhoE,pathOlhoD};
        new UploadFilesAsync().execute(pictures);
    }



    private void enviarDadosWebService(){

        String fD = UPLOAD_URL + new File(pathOlhoD).getName();
        String fE = UPLOAD_URL + new File(pathOlhoE).getName();
        String conduta=edtConduta.getText().toString();
        String parecer=edtParecer.getText().toString();

        SingletonSession singleton = SingletonSession.getInstance();
        CadastroHistoricoAtendimento cadastro = new CadastroHistoricoAtendimento(singleton.atendimentoAtual.getId_atendimento(),singleton.id_usuario,conduta,parecer,fD,fE);
        CadastrarHistoricoAtendimentoClient client = new CadastrarHistoricoAtendimentoClient(this);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            client.postJson(new JSONObject(gson.toJson(cadastro)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }








    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

            if(olhoEscolhido=="D"){
                pathOlhoD = cursor.getString(columnIndex);
                cursor.close();
                ImageView imageView = (ImageView) findViewById(R.id.img_olhoDireito);
                imageView.setImageBitmap(BitmapFactory.decodeFile(pathOlhoD));
            } else if (olhoEscolhido=="E"){
                pathOlhoE = cursor.getString(columnIndex);
                cursor.close();
                ImageView imageView = (ImageView) findViewById(R.id.img_olhoEsquerdo);
                imageView.setImageBitmap(BitmapFactory.decodeFile(pathOlhoE));
            }
            olhoEscolhido="NULL";
        }


        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            //Bitmap photo = (Bitmap) data.getExtras().get("data");


            // SALVA IMAGEM
            String filename = System.currentTimeMillis()+".jpg";
            Log.d("imagem","filename:"+filename);
            File sd = Environment.getExternalStorageDirectory();
            File dest = new File(sd, filename);
            String filePath=dest.getAbsolutePath();
            Log.d("imagem","path:"+filePath);
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");


            try {
                FileOutputStream out = new FileOutputStream(dest);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

//            imageView.getBitmap(photo);
            if(olhoEscolhido=="D"){
                pathOlhoD = filePath;
                ImageView imageView = (ImageView) findViewById(R.id.img_olhoDireito);
                imageView.setImageBitmap(BitmapFactory.decodeFile(pathOlhoD));
            } else if (olhoEscolhido=="E"){
                pathOlhoE =filePath;
                ImageView imageView = (ImageView) findViewById(R.id.img_olhoEsquerdo);
                imageView.setImageBitmap(BitmapFactory.decodeFile(pathOlhoE));
            }
            olhoEscolhido="NULL";

        }
        Log.d("imagem","atual olho d:"+pathOlhoD);
        Log.d("imagem","atual olho e:"+pathOlhoE);

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted and now can proceed
                    Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, RESULT_LOAD_IMAGE);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(IniciarAtendimentoActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // add other cases for more permissions
        }
    }




}
