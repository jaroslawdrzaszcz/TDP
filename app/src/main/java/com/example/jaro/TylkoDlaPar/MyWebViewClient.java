package com.example.jaro.TylkoDlaPar;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by jaro on 10.12.17.
 */

class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals("tylkodlapar.pl")){
            return false;
        }
        else{
            Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return  true;
        }
    }
}
