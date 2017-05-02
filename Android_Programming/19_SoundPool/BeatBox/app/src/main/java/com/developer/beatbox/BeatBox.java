package com.developer.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
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
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAsset;    // assets manager
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;


    /**
     * 构造函数
     * @param context
     */
    public BeatBox(Context context) {
        mAsset = context.getAssets();
        // This old constructor is deprecated, but we need it for compatibility
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    /**
     * 播放音频
     */
    public void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null) {
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    /**
     * 释放音频
     */
    public void release() {
        mSoundPool.release();
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
            try {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException ioe) {
                Log.e(TAG, "Could not load sound " + filename, ioe);
            }
        }
    }

    /**
     * 加载音频
     */
    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAsset.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
