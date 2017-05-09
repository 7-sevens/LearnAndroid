package com.developer.beatbox;

/**
 * blog：http://www.developer1024.com/
 * 微信公众号：开发者小黑屋
 * ----------------------------------
 * brief : Sound管理类
 * author: 7-sevens
 * date  : 2017/5/2.
 */

public class Sound {

    private String mAssetPath;
    private String mName;
    private Integer mSoundId;


    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".waw", "");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
