package com.developer.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * blog：http://www.developer1024.com/
 * 微信公众号：开发者小黑屋
 * ----------------------------------
 * brief : BeatBox资源管理类
 * author: 7-sevens
 * date  : 2017/5/2.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAsset;    // assets manager
    private List<Sound> mSounds = new ArrayList<>();


    /**
     * 构造函数
     * @param context
     */
    public BeatBox(Context context) {
        mAsset = context.getAssets();
        loadSounds();
    }

    /**
     * 加载声音文件清单
     */
    private void loadSounds() {
        String[] soundNames = null;
        try {
            soundNames = mAsset.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
        }

        for (String filename : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
