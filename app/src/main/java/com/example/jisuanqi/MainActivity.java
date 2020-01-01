package com.example.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Spinner spinner1;
  private HashMap<String,String> cx ;
  private TextView text,text2;
  private Button  baba ,mama,xiong,jie,mei,di,fu,qi,zi,nv,de,dengyu,sc;
    SoundPool sp;//声明SoundPool的引用
    HashMap<String, Integer> hm;//声明HashMap来存放声音文件
    int currStaeamId;//当前正播放的streamId
    String  data ;
  //更新
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSoundPool();//初始化声音池的方法
        spinner1 = (Spinner)findViewById(R.id.spinner1) ;
        text = (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);
        baba=(Button)findViewById(R.id.baba);
        mama=(Button)findViewById(R.id.mama);
        xiong=(Button)findViewById(R.id.xiong);
        jie=(Button)findViewById(R.id.jie);
        mei=(Button)findViewById(R.id.mei);
        di=(Button)findViewById(R.id.di);
        fu=(Button)findViewById(R.id.fu);
        qi=(Button)findViewById(R.id.qi);
        zi=(Button)findViewById(R.id.zi);
        nv=(Button)findViewById(R.id.nv);
        dengyu=(Button)findViewById(R.id.dengyu);
        de=(Button)findViewById(R.id.de);
        sc=(Button)findViewById(R.id.sc);
        baba.setOnClickListener(this);
        mama.setOnClickListener(this);
        xiong.setOnClickListener(this);
        di.setOnClickListener(this);
        jie.setOnClickListener(this);
        mei.setOnClickListener(this);
        fu.setOnClickListener(this);
        qi.setOnClickListener(this);
        zi.setOnClickListener(this);
        nv.setOnClickListener(this);
        sc.setOnClickListener(this);
        de.setOnClickListener(this);
        dengyu.setOnClickListener(this);
        ArrayList list  = new ArrayList<String>();
        cx = new HashMap<String, String>();
        cx.put("爸爸的妈妈","奶奶");
        cx.put("爸爸的爸爸","爷爷");
        cx.put("爸爸的老婆","妈妈");
        cx.put("爸爸的哥哥","伯父");
        cx.put("爸爸的弟弟","叔叔");
        cx.put("爸爸的姐姐","姑姑");
        cx.put("爸爸的妹妹","姑姑");
        cx.put("妈妈的爸爸","外公");
        cx.put("妈妈的妈妈","外婆");
        cx.put("妈妈的哥哥","舅舅");
        cx.put("妈妈的弟弟","舅舅");
        cx.put("妈妈的姐姐","大姨");
        cx.put("妈妈的妹妹","小姨");
        cx.put("哥哥的妻子","嫂子");
        cx.put("弟弟的妻子","弟媳");
        cx.put("老婆的哥哥","大舅子");
        list.add("我是男的");
        list.add("我是女的");
        //下拉列表适配器 this,android.R.layout.simple_spinner_item,list
        ArrayAdapter arrayAdapter  = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        //下拉列表样式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载下拉列表适配器
        spinner1.setAdapter(arrayAdapter);
        //监听下拉列表选项
        spinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {//选择item的选择点击监听事件
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                // 将所选Spinner 的值带入TextView 中
               // text.setText("欢迎选择" + spinner1.getSelectedItem());//文本说明
                if (spinner1.getSelectedItem().equals("我是男的")){
                    fu.setEnabled(false);
                    qi.setEnabled(true);
                }  else {
                    fu.setEnabled(true);
                    qi.setEnabled(false);
                   } ;
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                text.setText("Not");
            }
        });
    }
    //-------------------------创建播放声音类---------------
    private void playSound (String sound,int loop) {
        //获取AudioManager引用
        AudioManager am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        //获取当前音量
        float streamVolumeCurrent = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        //获取系统最大音量
        float streamVolumeMax = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //计算得到播放音量
        float volume = streamVolumeCurrent / streamVolumeMax;
        //调用SoundPool的play方法来播放声音文件
        currStaeamId = sp.play(hm.get(sound), volume, volume, 1, loop, 1.0f);
    }
    //------------------初始化声音类--------------------------------
    private void initSoundPool( ) {//初始化声音池
        sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);//创建SoundPool对象
        hm = new HashMap<String, Integer>();//创建HashMap对象
        //加载声音文件，并且设置为1号声音放入hm中
        hm.put("1", sp.load(this, R.raw.a, 1));
        hm.put("爷爷", sp.load(this, R.raw.jyeye, 1));
        hm.put("奶奶",sp.load(this,R.raw.jnainai,1));
        hm.put("爸爸",sp.load(this,R.raw.jbaba,1));
        hm.put("妈妈",sp.load(this,R.raw.jmama,1));
        hm.put("外公",sp.load(this,R.raw.jwaigong,1));
        hm.put("外婆",sp.load(this,R.raw.jwaipo,1));
        hm.put("伯伯",sp.load(this,R.raw.jbobo,1));
        hm.put("叔叔",sp.load(this,R.raw.jshushu,1));
        hm.put("哥哥",sp.load(this,R.raw.jgege,1));
        hm.put("姐姐",sp.load(this,R.raw.jjiejie,1));
        hm.put("弟弟",sp.load(this,R.raw.jdidi,1));
        hm.put("妹妹",sp.load(this,R.raw.jmeimei,1));
        hm.put("舅舅",sp.load(this,R.raw.jjiujiu,1));
        hm.put("大姨",sp.load(this,R.raw.jdayi,1));
        hm.put("小姨",sp.load(this,R.raw.jxiaoyi,1));
        hm.put("岳父",sp.load(this,R.raw.jyuefu,1));
        hm.put("岳母",sp.load(this,R.raw.jyuemu,1));
        hm.put("姐夫",sp.load(this,R.raw.jjiefu ,1));
        hm.put("嫂子",sp.load(this,R.raw.jsaozi,1));
        hm.put("弟媳",sp.load(this,R.raw.jdixi,1));
        hm.put("姑姑",sp.load(this,R.raw.jgugu,1));
        hm.put("大舅子",sp.load(this,R.raw.jdajiuzi,1));
        hm.put("小舅子",sp.load(this,R.raw.jxiaojiuzi,1));
      //  hm.put("",sp.load(this,R.raw.j,1));
    }
    //提示播放即时音效
    // Toast.makeText(MainActivity.this, "播放即时音效", Toast.LENGTH_SHORT).show();
    //-------------------------------------------------------
    @Override
    public void onClick(View v)  {

        //异常类处理
        try {
            switch (v.getId()){
                case R.id.de:
                    fu.setEnabled(true);
                    qi.setEnabled(true);
                    dengyu.setEnabled(true);
                    text2.setText(text.getText().toString()+"的");
                    text.setText("");
                    de.setEnabled(false);
                    playSound("1", 0);
                    break;
                case R.id.sc:
                    text.setText("");
                    text2.setText("");
                    playSound("1", 0);
                    break;
                case R.id.baba:
                    text.setText("爸爸");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.mama:
                    text.setText("妈妈");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;

                case R.id.xiong:
                    text.setText("哥哥");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.di:
                    text.setText("弟弟");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.jie:
                    text.setText("姐姐");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.mei:
                    text.setText("妹妹");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.fu:
                    text.setText("丈夫");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.qi:
                    text.setText("妻子");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.zi:
                    text.setText("儿子");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.nv:
                    text.setText("女儿");
                    de.setEnabled(true);
                    playSound("1", 0);
                    break;
                case R.id.dengyu:
                    //整合输入的信息
                    text2.setText(text2.getText()+""+text.getText());
                    data = cx.get(""+text2.getText().toString());
                    //判断错误的输入
                    if (text2.getText().equals("丈夫的丈夫")||text2.getText().equals("妻子的妻子")||text2.getText().equals("哥哥的丈夫")||text2.getText().equals("弟弟的丈夫")||text2.getText().equals("姐姐的妻子")||text2.getText().equals("妹妹的妻子")){

                        text.setText("真是奇妙的一家人");
                    }else {

                        text.setText(data);
                        playSound(data,0);
                        dengyu.setEnabled(false);
                    }
                    break;
            }

        }
        catch (Exception e){
        text2.setText("未记录");
        }
    }
}
