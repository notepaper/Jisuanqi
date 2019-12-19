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
  private TextView text,text2;
  private Button  baba ,mama,xiong,jie,mei,di,fu,qi,zi,nv,de,dengyu,sc;
    SoundPool sp;//声明SoundPool的引用
    HashMap<String, Integer> hm;//声明HashMap来存放声音文件
    int currStaeamId;//当前正播放的streamId
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
                   text.setText("");
                }  else {
                        text.setText("功能正在开发中");
                   } ;
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                text.setText("Nothing");
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.de:
                dengyu.setEnabled(true);
               text2.setText(text.getText()+"的");
               text.setText("");
               de.setEnabled(false);
                playSound("1", 0);//播放音效
                break;
            case R.id.sc:
                text.setText("");
                text2.setText("");
                playSound("1", 0);//播放音效
                break;
            case R.id.baba:
                text.setText("爸爸");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.mama:
                text.setText("妈妈");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;

            case R.id.xiong:
                text.setText("哥哥");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.di:
                text.setText("弟弟");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.jie:
                text.setText("姐姐");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.mei:
                text.setText("妹妹");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.fu:
                text.setText("丈夫");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.qi:
                text.setText("妻子");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.zi:
                text.setText("儿子");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.nv:
                text.setText("女儿");
                de.setEnabled(true);
                playSound("1", 0);//播放音效
                break;
            case R.id.dengyu:
                //整合输入的信息
                text2.setText(text2.getText()+""+text.getText());
                //判断错误的输入
                if (text2.getText().equals("丈夫的丈夫")||text2.getText().equals("妻子的妻子")||text2.getText().equals("哥哥的丈夫")||text2.getText().equals("弟弟的丈夫")||text2.getText().equals("姐姐的妻子")||text2.getText().equals("妹妹的妻子")){

                    text.setText("真是奇妙的一家人");
                }else {

                    switch (text2.getText()+""){

                        case "爸爸的妈妈":
                            playSound("奶奶", 0);//播放音效
                            text.setText("奶奶");
                            break;
                        case "爸爸的爸爸":
                            playSound("爷爷", 0);//播放音效
                            text.setText("爷爷");
                            break;
                        case "爸爸的哥哥":
                            playSound("伯伯", 0);
                            text.setText("伯伯");
                            break;
                        case "爸爸的弟弟":
                            playSound("叔叔", 0);//播放音效
                            text.setText("叔叔");
                            break;
                        case "爸爸的姐姐":
                            playSound("姑姑", 0);//播放音效
                            text.setText("姑姑");
                            break;
                        case "爸爸的妹妹":
                            playSound("姑姑", 0);//播放音效
                            text.setText("姑姑");
                            break;
                        case "爸爸的妻子":
                            playSound("妈妈", 0);//播放音效
                            text.setText("妈妈");
                            break;
                        case "爸爸的儿子":
                            playSound("哥哥", 0);//播放音效
                            text.setText("哥哥/弟弟");
                            break;
                        case "爸爸的女儿":
                            playSound("姐姐", 0);//播放音效
                            text.setText("姐姐/妹妹");
                            break;
                        case "妈妈的妈妈":
                            playSound("外婆", 0);//播放音效
                            text.setText("外婆");
                            break;
                        case "妈妈的儿子":
                            playSound("哥哥", 0);
                            text.setText("要么是哥哥要么是弟弟");
                            break;
                        case "妈妈的爸爸":
                            playSound("外公", 0);
                            text.setText("外公");
                            break;
                        case "妈妈的哥哥":
                            playSound("舅舅", 0);
                            text.setText("舅舅");
                            break;
                        case "妈妈的弟弟":
                            playSound("舅舅", 0);
                            text.setText("舅舅");
                            break;
                        case "妈妈的姐姐":
                            playSound("大姨", 0);
                            text.setText("大姨");
                            break;
                        case "妈妈的妹妹":
                            playSound("小姨", 0);
                            text.setText("小姨");
                            break;
                        case "丈夫的爸爸":
                            playSound("爸爸", 0);
                            text.setText("爸爸");
                            break;
                        case "丈夫的妈妈":
                            playSound("妈妈", 0);
                            text.setText("妈妈");
                            break;
                        case "丈夫的哥哥":
                            playSound("哥哥", 0);
                            text.setText("哥哥");
                            break;
                        case "丈夫的弟弟":
                            playSound("弟弟", 0);
                            text.setText("弟弟");
                            break;
                        case "丈夫的姐姐":
                            playSound("姐姐", 0);
                            text.setText("姐姐");
                            break;
                        case "丈夫的妹妹":
                            playSound("妹妹", 0);
                            text.setText("妹妹");
                            break;
                        case "丈夫的儿子":
                            playSound("儿子", 0);
                            text.setText("儿子");
                            break;
                        case "丈夫的女儿":
                            playSound("女儿", 0);
                            text.setText("女儿");
                            break;
                        case "妻子的爸爸":
                            playSound("岳父", 0);
                            text.setText("岳父");
                            break;
                        case "妻子的妈妈":
                            playSound("岳母", 0);
                            text.setText("岳母");
                            break;
                        case "妻子的弟弟":
                            playSound("小舅子", 0);
                            text.setText("小舅子");
                            break;
                        case "妻子的哥哥":
                            playSound("大舅子", 0);
                            text.setText("大舅子");
                            break;
                        case "妻子的姐姐":
                            playSound("姐姐", 0);
                            text.setText("姐姐");
                            break;
                        case "妻子的妹妹":
                            playSound("妹妹", 0);
                            text.setText("妹妹");
                            break;
                        case "妻子的儿子":
                            text.setText("儿子");
                            break;
                        case "妻子的女儿":
                            text.setText("女儿");
                            break;
                        case "哥哥的爸爸":
                            playSound("爸爸", 0);
                            text.setText("爸爸");
                            break;
                        case "哥哥的妈妈":
                            playSound("妈妈", 0);
                            text.setText("妈妈");
                            break;
                        case "哥哥的妻子":
                            text.setText("嫂子");
                            playSound("嫂子", 0);
                            break;
                        case "哥哥的姐姐":
                            playSound("姐姐", 0);
                            text.setText("姐姐");
                            break;
                        case "哥哥的妹妹":
                            playSound("姐姐", 0);
                            text.setText("姐姐/妹妹");
                            break;
                        case "哥哥的弟弟":
                            playSound("哥哥", 0);
                            text.setText("哥哥/弟弟");
                            break;
                        case "弟弟的爸爸":
                            playSound("爸爸", 0);
                            text.setText("爸爸");
                            break;
                        case "弟弟的妈妈":
                            playSound("妈妈", 0);
                            text.setText("妈妈");
                            break;
                        case "弟弟的妻子":
                            playSound("弟媳", 0);
                            text.setText("弟媳");
                            break;
                        case "弟弟的妹妹":
                            playSound("妹妹", 0);
                            text.setText("妹妹");
                            break;
                        case "弟弟的弟弟":
                            playSound("弟弟", 0);
                            text.setText("弟弟");
                            break;
                        case "姐姐的爸爸":
                            playSound("爸爸", 0);
                            text.setText("爸爸");
                            break;
                        case "姐姐的妈妈":
                            playSound("妈妈", 0);
                            text.setText("妈妈");
                            break;
                        case "姐姐的丈夫":
                            playSound("姐夫", 0);
                            text.setText("姐夫");
                            break;
                        case "姐姐的姐姐":
                            playSound("姐姐", 0);
                            text.setText("姐姐");
                            break;
                        case "姐姐的妹妹":
                            playSound("姐姐", 0);
                            text.setText("姐姐/妹妹");
                            break;
                        case "姐姐的弟弟":
                            playSound("哥哥", 0);
                            text.setText("哥哥/弟弟");
                            break;
                        case "妹妹的爸爸":
                            playSound("爸爸", 0);
                            text.setText("爸爸");
                            break;
                        case "妹妹的妈妈":
                            playSound("妈妈", 0);
                            text.setText("妈妈");
                            break;
                        case "妹妹的丈夫":
                            playSound("妹夫", 0);
                            text.setText("妹夫");
                            break;
                        case "妹妹的哥哥":
                            playSound("哥哥", 0);
                            text.setText("哥哥/弟弟");
                            break;
                        case "妹妹的姐姐":
                            playSound("姐姐", 0);
                            text.setText("姐姐/妹妹");
                            break;
                        case "妹妹的妹妹":
                            text.setText("妹妹");
                            break;
                        case "妹妹的弟弟":
                            playSound("弟弟", 0);
                            text.setText("弟弟");
                            break;

                            default:text.setText("抱歉，此结果还未添加！");

                            break;

                                 }
                    dengyu.setEnabled(false);
                    }
                }
    }
}