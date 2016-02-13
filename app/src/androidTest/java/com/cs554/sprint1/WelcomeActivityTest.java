package com.cs554.sprint1;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.test.*;

/**
 * Created by Sunil_Shenoy on 2/10/2016.
 */
public class WelcomeActivityTest extends ActivityInstrumentationTestCase2<WelcomeActivity> {

    private WelcomeActivity wActivity;
    private BoardActivity bActivity;

    private TextView line_text;
    private RadioButton online_Radio;
    private RadioButton offline_Radio;

    private TextView style_text;
    private RadioButton freestyle_Radio;
    private RadioButton standard_Radio;

    private TextView num_players_text;
    private RadioButton two_player_Radio;
    private RadioButton one_player_Radio;

    private TextView board_size_text;
    private RadioButton ten_Radio;
    private RadioButton fifteen_Radio;
    private RadioButton twenty_Radio;

    private Button play_Button;


    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public WelcomeActivityTest() {
        super(WelcomeActivity.class);
    }

    public void testboardsize10() throws Throwable {

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BoardActivity.class.getName(), null, false);

        wActivity = getActivity();

        line_text = (TextView) wActivity.findViewById(R.id.line_text);
        online_Radio = (RadioButton) wActivity.findViewById(R.id.on_line_radio);
        offline_Radio = (RadioButton) wActivity.findViewById(R.id.off_line_radio);

        style_text = (TextView) wActivity.findViewById(R.id.style_text);
        freestyle_Radio = (RadioButton) wActivity.findViewById(R.id.freestyle_radio);
        standard_Radio = (RadioButton) wActivity.findViewById(R.id.standard_radio);

        num_players_text = (TextView) wActivity.findViewById(R.id.num_players_text);
        one_player_Radio = (RadioButton) wActivity.findViewById(R.id.one_player_radio);
        two_player_Radio = (RadioButton) wActivity.findViewById(R.id.two_player_radio);

        board_size_text = (TextView) wActivity.findViewById(R.id.board_size_text);
        ten_Radio = (RadioButton) wActivity.findViewById(R.id.ten_radio);
        fifteen_Radio = (RadioButton) wActivity.findViewById(R.id.fifteen_radio);
        twenty_Radio = (RadioButton) wActivity.findViewById(R.id.twenty_radio);

        play_Button = (Button) wActivity.findViewById(R.id.play_button);

        assertNotNull(wActivity);

        assertEquals("Select online or offline", line_text.getText().toString());
        assertEquals("Select freestyle or standard mode", style_text.getText().toString());
        assertEquals("Select number of players", num_players_text.getText().toString());
        assertEquals("Select board size", board_size_text.getText().toString());

        TouchUtils.clickView(this, offline_Radio);
        TouchUtils.clickView(this, freestyle_Radio);
        TouchUtils.clickView(this, one_player_Radio);
        TouchUtils.clickView(this, ten_Radio);
        TouchUtils.clickView(this, play_Button);

        bActivity = (BoardActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(bActivity);

        TouchUtils.clickView(this, bActivity.findViewById(R.id.stone00));
        TouchUtils.clickView(this, bActivity.findViewById(R.id.stone01));
        TouchUtils.clickView(this, bActivity.findViewById(R.id.stone02));
        TouchUtils.clickView(this, bActivity.findViewById(R.id.stone03));
        TouchUtils.clickView(this, bActivity.findViewById(R.id.stone04));

        delay(5);

        bActivity.finish();

    }

    public void testboardsize15() throws Throwable {

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BoardActivity.class.getName(), null, false);

        wActivity = getActivity();

        assertNotNull(wActivity);


        line_text = (TextView) wActivity.findViewById(R.id.line_text);
        online_Radio = (RadioButton) wActivity.findViewById(R.id.on_line_radio);
        offline_Radio = (RadioButton) wActivity.findViewById(R.id.off_line_radio);

        style_text = (TextView) wActivity.findViewById(R.id.style_text);
        freestyle_Radio = (RadioButton) wActivity.findViewById(R.id.freestyle_radio);
        standard_Radio = (RadioButton) wActivity.findViewById(R.id.standard_radio);

        num_players_text = (TextView) wActivity.findViewById(R.id.num_players_text);
        one_player_Radio = (RadioButton) wActivity.findViewById(R.id.one_player_radio);
        two_player_Radio = (RadioButton) wActivity.findViewById(R.id.two_player_radio);

        board_size_text = (TextView) wActivity.findViewById(R.id.board_size_text);
        ten_Radio = (RadioButton) wActivity.findViewById(R.id.ten_radio);
        fifteen_Radio = (RadioButton) wActivity.findViewById(R.id.fifteen_radio);
        twenty_Radio = (RadioButton) wActivity.findViewById(R.id.twenty_radio);

        play_Button = (Button) wActivity.findViewById(R.id.play_button);

        TouchUtils.clickView(this, offline_Radio);
        TouchUtils.clickView(this, freestyle_Radio);
        TouchUtils.clickView(this, one_player_Radio);
        TouchUtils.clickView(this, fifteen_Radio);
        TouchUtils.clickView(this, play_Button);

        bActivity = (BoardActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(bActivity);
        delay(5);
        bActivity.finish();

    }

    public void testboardsize20() throws Throwable {

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BoardActivity.class.getName(), null, false);

        wActivity = getActivity();

        assertNotNull(wActivity);

        line_text = (TextView) wActivity.findViewById(R.id.line_text);
        online_Radio = (RadioButton) wActivity.findViewById(R.id.on_line_radio);
        offline_Radio = (RadioButton) wActivity.findViewById(R.id.off_line_radio);

        style_text = (TextView) wActivity.findViewById(R.id.style_text);
        freestyle_Radio = (RadioButton) wActivity.findViewById(R.id.freestyle_radio);
        standard_Radio = (RadioButton) wActivity.findViewById(R.id.standard_radio);

        num_players_text = (TextView) wActivity.findViewById(R.id.num_players_text);
        one_player_Radio = (RadioButton) wActivity.findViewById(R.id.one_player_radio);
        two_player_Radio = (RadioButton) wActivity.findViewById(R.id.two_player_radio);

        board_size_text = (TextView) wActivity.findViewById(R.id.board_size_text);
        ten_Radio = (RadioButton) wActivity.findViewById(R.id.ten_radio);
        fifteen_Radio = (RadioButton) wActivity.findViewById(R.id.fifteen_radio);
        twenty_Radio = (RadioButton) wActivity.findViewById(R.id.twenty_radio);

        play_Button = (Button) wActivity.findViewById(R.id.play_button);

        TouchUtils.clickView(this, offline_Radio);
        TouchUtils.clickView(this, freestyle_Radio);
        TouchUtils.clickView(this, one_player_Radio);
        TouchUtils.clickView(this, twenty_Radio);
        TouchUtils.clickView(this, play_Button);

        bActivity = (BoardActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(bActivity);
        delay(5);
        bActivity.finish();

    }

    public void testfreestyle() throws Throwable {

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BoardActivity.class.getName(), null, false);

        wActivity = getActivity();

        assertNotNull(wActivity);

        line_text = (TextView) wActivity.findViewById(R.id.line_text);
        online_Radio = (RadioButton) wActivity.findViewById(R.id.on_line_radio);
        offline_Radio = (RadioButton) wActivity.findViewById(R.id.off_line_radio);

        style_text = (TextView) wActivity.findViewById(R.id.style_text);
        freestyle_Radio = (RadioButton) wActivity.findViewById(R.id.freestyle_radio);
        standard_Radio = (RadioButton) wActivity.findViewById(R.id.standard_radio);

        num_players_text = (TextView) wActivity.findViewById(R.id.num_players_text);
        one_player_Radio = (RadioButton) wActivity.findViewById(R.id.one_player_radio);
        two_player_Radio = (RadioButton) wActivity.findViewById(R.id.two_player_radio);

        board_size_text = (TextView) wActivity.findViewById(R.id.board_size_text);
        ten_Radio = (RadioButton) wActivity.findViewById(R.id.ten_radio);
        fifteen_Radio = (RadioButton) wActivity.findViewById(R.id.fifteen_radio);
        twenty_Radio = (RadioButton) wActivity.findViewById(R.id.twenty_radio);

        play_Button = (Button) wActivity.findViewById(R.id.play_button);

        TouchUtils.clickView(this, offline_Radio);
        TouchUtils.clickView(this, freestyle_Radio);
        TouchUtils.clickView(this, two_player_Radio);
        TouchUtils.clickView(this, ten_Radio);
        TouchUtils.clickView(this, play_Button);

        bActivity = (BoardActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
        assertNotNull(bActivity);
        delay(50);
        bActivity.finish();

    }

    public void teststandardstyle() throws Throwable {

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BoardActivity.class.getName(), null, false);

        wActivity = getActivity();

        assertNotNull(wActivity);

        line_text = (TextView) wActivity.findViewById(R.id.line_text);
        online_Radio = (RadioButton) wActivity.findViewById(R.id.on_line_radio);
        offline_Radio = (RadioButton) wActivity.findViewById(R.id.off_line_radio);

        style_text = (TextView) wActivity.findViewById(R.id.style_text);
        freestyle_Radio = (RadioButton) wActivity.findViewById(R.id.freestyle_radio);
        standard_Radio = (RadioButton) wActivity.findViewById(R.id.standard_radio);

        num_players_text = (TextView) wActivity.findViewById(R.id.num_players_text);
        one_player_Radio = (RadioButton) wActivity.findViewById(R.id.one_player_radio);
        two_player_Radio = (RadioButton) wActivity.findViewById(R.id.two_player_radio);

        board_size_text = (TextView) wActivity.findViewById(R.id.board_size_text);
        ten_Radio = (RadioButton) wActivity.findViewById(R.id.ten_radio);
        fifteen_Radio = (RadioButton) wActivity.findViewById(R.id.fifteen_radio);
        twenty_Radio = (RadioButton) wActivity.findViewById(R.id.twenty_radio);

        play_Button = (Button) wActivity.findViewById(R.id.play_button);

        TouchUtils.clickView(this, offline_Radio);
        TouchUtils.clickView(this, standard_Radio);
        TouchUtils.clickView(this, two_player_Radio);
        TouchUtils.clickView(this, ten_Radio);
        TouchUtils.clickView(this, play_Button);

        bActivity = (BoardActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
        assertNotNull(bActivity);
        delay(50);
        bActivity.finish();
    }

    public void testzcomputerplay() throws Throwable {

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(BoardActivity.class.getName(), null, false);

        wActivity = getActivity();

        assertNotNull(wActivity);

        line_text = (TextView) wActivity.findViewById(R.id.line_text);
        online_Radio = (RadioButton) wActivity.findViewById(R.id.on_line_radio);
        offline_Radio = (RadioButton) wActivity.findViewById(R.id.off_line_radio);

        style_text = (TextView) wActivity.findViewById(R.id.style_text);
        freestyle_Radio = (RadioButton) wActivity.findViewById(R.id.freestyle_radio);
        standard_Radio = (RadioButton) wActivity.findViewById(R.id.standard_radio);

        num_players_text = (TextView) wActivity.findViewById(R.id.num_players_text);
        one_player_Radio = (RadioButton) wActivity.findViewById(R.id.one_player_radio);
        two_player_Radio = (RadioButton) wActivity.findViewById(R.id.two_player_radio);

        board_size_text = (TextView) wActivity.findViewById(R.id.board_size_text);
        ten_Radio = (RadioButton) wActivity.findViewById(R.id.ten_radio);
        fifteen_Radio = (RadioButton) wActivity.findViewById(R.id.fifteen_radio);
        twenty_Radio = (RadioButton) wActivity.findViewById(R.id.twenty_radio);

        play_Button = (Button) wActivity.findViewById(R.id.play_button);

        TouchUtils.clickView(this, offline_Radio);
        TouchUtils.clickView(this, freestyle_Radio);
        TouchUtils.clickView(this, one_player_Radio);
        TouchUtils.clickView(this, ten_Radio);
        TouchUtils.clickView(this, play_Button);

        bActivity = (BoardActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
        assertNotNull(bActivity);
        delay(50);
        bActivity.finish();

    }

    void delay(int n) {
        try {
            Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
        } catch
                (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
