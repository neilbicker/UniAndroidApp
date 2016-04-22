package com.example.GroupAndroidApp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class ReubensPage extends Activity
{
   /**
    * Called when the activity is first created.
    */
   Spinner spinnerMenu;
   ArrayAdapter menuArray;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.reuben);


      spinnerMenu = (Spinner) findViewById(R.id.spinnerMenu);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu_array, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerMenu.setAdapter(adapter);
      spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

      {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
         {
            String s = ((TextView) view).getText().toString();
            if (s.equals("About The Charity"))
               startActivity(new Intent(view.getContext(), NeilsPage.class));
            else if (s.equals("Shop"))
               startActivity(new Intent(view.getContext(), MyActivity.class));
            else if (s.equals("Contact Page"))
               startActivity(new Intent(view.getContext(), RonansPage.class));

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent)
         {
         }
      });

   }
   public void openMarieCurie(View view)
   {
      Uri uri = Uri.parse("https://www.mariecurie.org.uk/");
      Intent openMarieCurieIntent = new Intent(Intent.ACTION_VIEW, uri);
      startActivity(openMarieCurieIntent);
   }
}



