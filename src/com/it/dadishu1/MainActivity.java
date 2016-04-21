package com.it.dadishu1;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	ImageButton[] btns;
int index;
int longth=1*60*1000;//游戏限制时间
int time=0;//游戏进行时间
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btns=new ImageButton[6];
		btns[0] = (ImageButton) findViewById(R.id.imageButton1);
		btns[1] = (ImageButton) findViewById(R.id.imageButton2);
		btns[2] = (ImageButton) findViewById(R.id.imageButton3);
		btns[3] = (ImageButton) findViewById(R.id.imageButton4);
		btns[4]= (ImageButton) findViewById(R.id.imageButton5);
		btns[5]= (ImageButton) findViewById(R.id.imageButton6);
		
		new Thread(new Runnable() {
			//這裡面的（耗時的）都是在子線程中運行的
			@Override
			public void run() {  //写在子线程中的结果是：会使主线程先一步显示而子线程
				                 //会在规定的时间到达后再运行
			while(time<longth){//实现地鼠不停地钻出来
				
				//每2秒钟钻出一个地鼠
				
				try{//在这里面2000就是规定的时间，2000=2秒
					Thread.sleep(2000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				time=time+2000;
				index=new Random().nextInt(6);//耗时非常短，所以可以写在主线程中间
				
				//如何在子線程中寫主線程代碼
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {//此處編寫的是在主線程中运行的代碼
						btns[index].setImageResource(R.drawable.zzz0);
						btns[index].setTag("dishu");
					}
				});
			}	
			System.out.println("fsdf" + score);	
			runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(MainActivity.this, ""+score, 0).show();
				}
			});
			}
			
		}).start();
	}
	int score;
	public void fun(View view){
		ImageButton btn=(ImageButton) view;
		
		String tag=(String)btn.getTag();
		
		if("dishu".equals(tag)){
			score++;
			btn.setImageResource(R.drawable.t0);
			btn.setTag("beijing");
			
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
