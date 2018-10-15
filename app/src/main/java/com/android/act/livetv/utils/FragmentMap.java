package com.android.act.livetv.utils;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by Ajeena Sainudeen on 15-10-2018.
 * COMPANY : Claysol MediaLabs Pvt Ltd,
 * EMAIL : ajeena.sainudeen@claysol.com
 */

class FragmentMap extends HashMap<String, Fragment> {
    private static  FragmentMap instance ;

    static FragmentMap getInstance() {

        if(instance == null){
            instance = new FragmentMap();
        }
        return  instance;
    }

    private FragmentMap() {
    }
}
