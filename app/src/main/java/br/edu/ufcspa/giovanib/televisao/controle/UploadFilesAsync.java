package br.edu.ufcspa.giovanib.televisao.controle;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by icaromsc on 15/02/2017.
 */

public class UploadFilesAsync extends AsyncTask<String, Void, String> {
    private static final String TAG ="televisao_async";
    @Override
    protected String doInBackground(String... params) {
        Log.d(TAG, "open task...");
        for (String file: params
             ) {
            upload(file);
        }
        return "Executed";
    }


    public void upload(String filename){
        try {
            Log.d(TAG, "async task source file:" + filename);
            HttpURLConnection conn = null;
            DataOutputStream dos = null;
            String lineEnd = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";
            int bytesRead, bytesAvailable, bufferSize;
            byte[] buffer;
            int maxBufferSize = 4 * 1024 * 1024;
            File sourceFile = new File(filename);
            Log.d(TAG,"nome do arquivo:" + sourceFile.getName());
            int serverResponseCode;

            if (sourceFile.isFile()) {

                try {
                    String upLoadServerUri = "http://angelo.inf.ufrgs.br/televisao/UploadToServer.php";

                    // open a URL connection to the Servlet
                    FileInputStream fileInputStream = new FileInputStream(sourceFile);
                    //fileInputStream=inAudioData;
                    URL url = new URL(upLoadServerUri);

                    // Open a HTTP connection to the URL
                    conn = (HttpURLConnection) url.openConnection();

                    Log.d(TAG, "File upload started...");
                    conn.setDoInput(true); // Allow Inputs
                    conn.setDoOutput(true); // Allow Outputs
                    conn.setUseCaches(false); // Don't use a Cached Copy
                    conn.setChunkedStreamingMode(1024);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Connection", "Keep-Alive");
                    conn.setRequestProperty("ENCTYPE",
                            "multipart/form-data");
                    conn.setRequestProperty("Content-Type",
                            "multipart/form-data;boundary=" + boundary);
                    conn.setRequestProperty("uploadedfile", filename);

                    dos = new DataOutputStream(conn.getOutputStream());

                    dos.writeBytes(twoHyphens + boundary + lineEnd);
                    dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\""
                            + filename + "\"" + lineEnd);

                    dos.writeBytes(lineEnd);

                    // create a buffer of maximum size
                    bytesAvailable = fileInputStream.available();

                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    buffer = new byte[bufferSize];

                    // read file and write it into form...
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                    Log.d(TAG, "uploading file...");
                    while (bytesRead > 0) {
                        // Log.d("-while (bytesRead > 0)", " ");
                        dos.write(buffer, 0, bufferSize);
                        bytesAvailable = fileInputStream.available();
                        bufferSize = Math
                                .min(bytesAvailable, maxBufferSize);
                        bytesRead = fileInputStream.read(buffer, 0,
                                bufferSize);
                    }

                    // send multipart form data necesssary after file
                    // data...
                    dos.writeBytes(lineEnd);
                    dos.writeBytes(twoHyphens + boundary + twoHyphens
                            + lineEnd);

                    // Responses from the server (code and message)
                    serverResponseCode = conn.getResponseCode();
                    String serverResponseMessage = conn
                            .getResponseMessage();

                    if (serverResponseCode == 200) {
                        Log.d(TAG, "File upload complete");
                        Log.d(TAG, serverResponseMessage);
                        //recursiveDelete(mDirectory1);

                    } else {
                        Log.e(TAG, "Error, server returned: " + serverResponseCode + "/n" + serverResponseMessage);
                    }

                    // close the streams //
                    fileInputStream.close();
                    dos.flush();
                    dos.close();

                } catch (Exception e) {

                    // dialog.dismiss();
                    e.printStackTrace();

                }
                // dialog.dismiss();
            } else {
                Log.d(TAG, "file no finded");
                // End else block
                Log.d(TAG, sourceFile.getAbsolutePath());
            }
        } catch (Exception ex) {
            // dialog.dismiss();

            ex.printStackTrace();
        }
    }

    private void deleteTempFile(String filename) {
        File file = new File(filename);
        try {
            boolean v=file.getCanonicalFile().delete();
            Log.w(TAG, "File deleted: " + file +" state:" + v);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG,"finish task");
    }

    @Override
    protected void onPreExecute() {
        /*
        *
        * */
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }



}