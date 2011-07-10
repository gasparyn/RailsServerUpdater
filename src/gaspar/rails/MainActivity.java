package gaspar.rails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	//TextView Tname,TCountry,TDob,TCity;
	//EditText Ename,ECountry,EDob,ECity;
	//Button btnCreate;
	// String page="";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		Button btnCreate = (Button)findViewById(R.id.submit_button);
		btnCreate.setOnClickListener(this);
		
//		EditText email = (EditText) findViewById(R.id.edit_email);
//		
//		EditText name = (EditText) findViewById(R.id.edit_name);
//		
		
		
	}//end main activity

		public void onClick(View v){
			switch(v.getId()){
			case R.id.submit_button:
				
			
			//This method  for HttpConnection  
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://vogueable.heroku.com/users");

			try {
				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("user[email]", "Anonymous"));
				nameValuePairs.add(new BasicNameValuePair("user[user_name]", "Cool!"));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				Log .d("Vogueable", "error on POSTing");

				// Execute HTTP Post Request
				HttpResponse response = httpclient.execute(httppost);
				Log.d("Vogueable",response.toString());

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		 break;
		 }
		}
		
}




