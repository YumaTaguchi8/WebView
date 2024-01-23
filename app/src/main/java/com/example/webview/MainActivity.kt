package com.example.webview

import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.webview.ui.theme.WebViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val myWebViewA: WebView = findViewById(R.id.webViewA)
        val myWebViewB: WebView = findViewById(R.id.webViewB)

        myWebViewA.settings.javaScriptEnabled = true
        myWebViewA.settings.domStorageEnabled = true
        myWebViewA.loadUrl("https://measurement-tool.makip.co.jp/sdk/localStorageAccess.html")
        myWebViewA.webViewClient = WebViewClient()
        myWebViewA.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                result?.cancel()
                return super.onJsAlert(view, url, message, result)
            }
        }

        myWebViewB.settings.javaScriptEnabled = true
        myWebViewB.settings.domStorageEnabled = true
        myWebViewB.loadUrl("https://measurement-tool.makip.co.jp/sdk/localStorageAccess.html")
        myWebViewB.webViewClient = WebViewClient()
        myWebViewB.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                result?.cancel()
                return super.onJsAlert(view, url, message, result)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WebViewTheme {
        Greeting("Android")
    }
}