package com.example.GroupAndroidApp;

/******
 * Application Name - F13K Cancer
 * Created by - Neil Bicker B00685473
 * Date Created - 05 April 2016
 * Date Edited - 19 April 2016
 * Description - About the charity screen for F13K Cancer Application
 ******/
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;



public class NeilsPage extends Activity
{
   Spinner spinnerMenu;

   /**
    * Called when the activity is first created.
    */

   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

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
            if (s.equals("Shop"))
               startActivity(new Intent(view.getContext(), MyActivity.class));
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

   }//spinner drop down list

   public void goToWeb (View view) {
      goToUrl ( "https://www.justgiving.com/f13kcancer/");
   }

   private void goToUrl (String url) {
      Uri uriUrl = Uri.parse(url);
      Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
      startActivity(launchBrowser);
   }
}
