package com.example.weijia.simpleplayer;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.VideoView;

        import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String mPath;
    private MediaPlayer mp;
    private VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        Uri uri=intent.getData();
        mPath=uri.getPath();
        if(intent.getType().contains("audio")){
            mp=new MediaPlayer();
            try {
                mp.setDataSource(mPath);
                mp.prepare();
                mp.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(intent.getType().contains("video")){
            vv=new VideoView(this);
            vv.setVideoURI(uri);
        }
    }
}
