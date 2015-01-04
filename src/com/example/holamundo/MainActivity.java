package com.example.holamundo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener{
	
	RelativeLayout pant=null;
	SeekBar barra=null;
	RatingBar estrellas=null;
	TextView punts=null;
	ImageView marco=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pant=(RelativeLayout) findViewById(R.id.pantalla);
		
		punts=(TextView) findViewById(R.id.punts);
		estrellas=(RatingBar) findViewById(R.id.ratingBar1);
		estrellas.setOnRatingBarChangeListener(this);
		
		marco=(ImageView) findViewById(R.id.marco);
		
		barra=(SeekBar) findViewById(R.id.seekBar1);
		barra.setBackgroundColor(Color.RED);
		barra.setOnSeekBarChangeListener(this);
		
		final Button miboton=(Button) findViewById(R.id.button);
		miboton.setText(R.string.show_message);
		
		miboton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView label=(TextView) findViewById(R.id.label);
				label.setTextColor(Color.BLUE);
				
				if(label.getText().length()>0){
					
					label.setText("");
					miboton.setBackgroundColor(Color.GRAY);
					miboton.setText(R.string.show_message);
					
				}
				else{
					
					label.setText(R.string.hello_world);
					miboton.setText(R.string.hide_message);
					miboton.setBackgroundColor(Color.RED);
				}
			}
		});
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
	/////////////////////////////////////////////////////////
	///acciones barra de progresos
	/////////////////////////////////////////////////////////
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		//progreso de la barra
		
		pant.setBackgroundColor(Color.rgb(progress, progress, progress));
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		//movemos la barra
		
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// cuando dejamos de moverla
		
	}
	/////////////////////////////////////////////////////////
	///acciones estrellas
	/////////////////////////////////////////////////////////
	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
		
		//punts.setText(R.string.score+" "+rating+"");
		
		punts.setText(R.string.score);
		punts.setText(punts.getText()+" "+rating);
		
		if(rating==0 || rating<1){
			marco.setImageResource(R.drawable.img0);
		}else if(rating==1 || rating<2){
			marco.setImageResource(R.drawable.img1);
		}else if(rating==2 || rating<3){
			marco.setImageResource(R.drawable.img2);
		}else if(rating==3 || rating<4){
			marco.setImageResource(R.drawable.img3);
		}else if(rating==4 || rating<5){
			marco.setImageResource(R.drawable.img4);
		}else if(rating==5){
			marco.setImageResource(R.drawable.img5);
		}
		
		
	}
}
