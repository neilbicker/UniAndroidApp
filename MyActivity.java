package com.example.GroupAndroidApp;
/**
 Created By: Erin McIvor
 Application Name: F13K Cancer
 Created on: 28th March
 Last Edited: 6th April
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MyActivity extends Activity
{
   Spinner spinnerMenu;
    ArrayAdapter menu_array;
   /**
    * Called when the activity is first created.
    */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.erin);
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
            else if (s.equals("Marie Curie"))
               startActivity(new Intent(view.getContext(), ReubensPage.class));
            else if (s.equals("Contact Page"))
               startActivity(new Intent(view.getContext(), RonansPage.class));

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent)
         {

         }
      });

   }


   public void goToSo (View view) {
      goToUrl ( "http://www.onthecase.im/shop/4588058988/lee-johnston-f13k-cancer-case/9655256");
   }

   public void onClick(View view) {
      Intent intent1= new Intent(MyActivity.this, NeilsPage.class);
      startActivity(intent1);
   }
   private void goToUrl (String url) {
      Uri uriUrl = Uri.parse(url);
      Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
      startActivity(launchBrowser);
   }


   public void goToWeb (View view) {
      goToUrl ( "http://f13kcancer.com/");
   }

   private void goToWeb (String url) {
      Uri uriUrl = Uri.parse(url);
      Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
      startActivity(launchBrowser);
   }

}
