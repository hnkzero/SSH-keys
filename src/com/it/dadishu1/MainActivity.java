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
int longth=1*60*1000;//��Ϸ����ʱ��
int time=0;//��Ϸ����ʱ��
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
			//�@�e��ģ��ĕr�ģ��������Ӿ������\�е�
			@Override
			public void run() {  //д�����߳��еĽ���ǣ���ʹ���߳���һ����ʾ�����߳�
				                 //���ڹ涨��ʱ�䵽���������
			while(time<longth){//ʵ�ֵ���ͣ�������
				
				//ÿ2�������һ������
				
				try{//��������2000���ǹ涨��ʱ�䣬2000=2��
					Thread.sleep(2000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				time=time+2000;
				index=new Random().nextInt(6);//��ʱ�ǳ��̣����Կ���д�����߳��м�
				
				//������Ӿ����Ќ������̴��a
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {//��̎���������������������еĴ��a
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
