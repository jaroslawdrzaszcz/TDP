package com.example.jaro.TylkoDlaPar;


import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private WebView webView = null;
   // Configuration config = getResources ().getConfiguration ();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        //TextView textView = findViewById ( R.id.textView );


        VCSBroadcastReciver vcsBroadcastReciver = new VCSBroadcastReciver ();

        IntentFilter filter = new IntentFilter ( ConnectivityManager.CONNECTIVITY_ACTION );
        filter.addAction ( ConnectivityManager.CONNECTIVITY_ACTION );
        registerReceiver ( vcsBroadcastReciver, filter );

        this.webView = (WebView)findViewById ( R.id.webView1 );
        webView.setWebViewClient ( new MyWebViewClient () );
        webView.loadUrl("http://tylkodlapar.pl/logowanie?aplikacja=1/");

        WebSettings webSettings = webView.getSettings ();
        webSettings.setJavaScriptEnabled ( true );
        webSettings.setBuiltInZoomControls ( true );

    }

    public boolean onKeyDown(final int keyCode, final KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(final int keyCode, final KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_FORWARD) && webView.canGoForward ()) {
            webView.goForward ();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
