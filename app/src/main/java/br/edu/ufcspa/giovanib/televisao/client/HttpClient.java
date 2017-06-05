package br.edu.ufcspa.giovanib.televisao.client;

import android.content.Context;

/**
 * Created by icaromsc on 05/06/2017.
 */

public class HttpClient {
    protected Context context;
    protected static final String URL="http://angelo.inf.ufrgs.br/televisao/";

    public HttpClient(Context context){
        this.context=context;
    }
}
