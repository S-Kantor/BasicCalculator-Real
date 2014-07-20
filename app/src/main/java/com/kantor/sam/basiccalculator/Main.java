package com.kantor.sam.basiccalculator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public static String str = "";
    public static String str2 = "";

    public boolean wasAddClicked = false;
    public boolean wasMultClicked = false;
    public boolean wasDivClicked = false;
    public boolean wasSubClicked = false;
    public boolean wasOpClicked = false;
    public boolean wasEqualsClicked = false;
    public boolean wasNumClicked = false;


    public void numberClicked (View view) {

        Button button = (Button)view;
        String newstr = button.getText().toString();
        TextView textView = (TextView)findViewById(R.id.container1); //finding the specific Textview
        wasEqualsClicked = false;
        wasNumClicked = true;

        if (!(wasOpClicked) ) {

            str = str + newstr;
            textView.setText(str);
        }
        else {

            str2 = str2 + newstr;
            textView.setText(str2);
        }
    }

    public void Add (View view) {

        //Button button = (Button)view;
        //String newstr1 = button.getText().toString();
        //TextView operationClick = (TextView)findViewById(R.id.OperationSelected);
        // str = newstr1;
        wasOpClicked = true;
        wasAddClicked = true;
        if (wasNumClicked) {
            wasNumClicked = false;
        }
        else {
            Toast.makeText(this, "First a number then press the operation :P", Toast.LENGTH_SHORT).show();        }
    }

    public void Multiply (View view) {
        wasOpClicked = true;
        wasMultClicked = true;
        if (wasNumClicked) {
            wasNumClicked = false;
        }
        else {
            Toast.makeText(this, "First a number then press the operation :P", Toast.LENGTH_SHORT).show();        }
    }

    public void Substract (View view) {
        wasOpClicked = true;
        wasSubClicked = true;
        if (wasNumClicked) {
            wasNumClicked = false;
        }
        else {
            Toast.makeText(this, "First a number then press the operation :P", Toast.LENGTH_SHORT).show();
        }
    }

    public void Divide (View view) {
        wasOpClicked = true;
        wasDivClicked = true;
        if (wasNumClicked) {
            wasNumClicked = false;
        }
        else {
            Toast.makeText(this, "First a number then press the operation :P", Toast.LENGTH_SHORT).show();        }
    }

    public void Equals (View view) {
        int number = 0;
        int number2 = 0;
        int equals2 = 0;
        TextView equals = (TextView) findViewById(R.id.textView2);
        try {
            number = Integer.parseInt(str);
            number2 = Integer.parseInt(str2);
        }
        catch(Exception e) {

            equals.setText("Input an integer / number");

        }

        if (wasAddClicked) {
            equals2 = number + number2;
            equals.setText("It equals: " + Integer.toString(equals2));
            wasAddClicked = false;
        }
        if (wasSubClicked) {
            equals2 = number - number2;
            equals.setText("It equals: " + Integer.toString(equals2));
            wasSubClicked = false;
        }
        if (wasMultClicked) {
            equals2 = number * number2;
            equals.setText("It equals: " + Integer.toString(equals2));
            wasMultClicked = false;
        }
        if (wasDivClicked) {
            try {
                equals2 = number / number2;
            }
            catch (Exception e) {
                Toast.makeText(this, "You Can't Divide by 0", Toast.LENGTH_LONG).show();
                Clear(view);
                return;
            }
            equals.setText("It equals: " + Integer.toString(equals2));
            wasDivClicked= false;
        }
        wasEqualsClicked = true;
        wasNumClicked = false;
        Clear(view);
    }

    public void Clear (View view) {
        str = "";
        str2 = "";
        wasAddClicked = false;
        wasOpClicked = false;
        TextView temp = (TextView) findViewById(R.id.container1);
        temp.setText("");
        //if (!(wasEqualsClicked)) {
            //TextView temp1 = (TextView) findViewById(R.id.textView2);
            //temp1.setText("");
            wasEqualsClicked = false;
        //}
    }

    public void ServiceStart (View view) {

        //start the service from here //MyService is your service class name
        startService(new Intent(this, MyService.class));
        Log.d("Activity", "Start");
    }

    public void ServiceEnd(View view) {

        //Stop the running service from here//MyService is your service class name
        //Service will only stop if it is already running.
        stopService(new Intent(this, MyService.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
