package com.example.android.android_baking_app;

public final class Constant {

    private Constant(){

    }
    static final String BAKING_BASE_URL = "https://d17h27t6h515a5.cloudfront.net/";


    public static final String EXTRA_RECIPE = "recipe";

    public static final String EXTRA_STEP_INDEX = "step_index";

    public static final String SAVE_STEP = "save_step";

    public static final String STATE_STEP_INDEX = "state_step_index";

    public static final String STATE_PLAYBACK_POSITION = "state_playback_position";
    public static final String STATE_CURRENT_WINDOW = "state_current_window";
    public static final String STATE_PLAY_WHEN_READY = "state_play_when_ready";

    public static final String BAKING_NOTIFICATION_CHANNEL_ID = "baking_notification_channel_id";
    public static final int BAKING_PENDING_INTENT_ID = 0;
    public static final int BAKING_NOTIFICATION_ID = 20;

    /** Constants for ExoPlayer */
    public static final float PLAYER_PLAYBACK_SPEED = 1f;
    public static final int REWIND_INCREMENT = 3000;
    public static final int FAST_FORWARD_INCREMENT = 3000;
    public static final int START_POSITION = 0;


}
