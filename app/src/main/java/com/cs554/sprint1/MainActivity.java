/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cs554.sprint1;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	int board[][] =
			{
					{R.id.stone00, R.id.stone01, R.id.stone02, R.id.stone03, R.id.stone04, R.id.stone05, R.id.stone06, R.id.stone07, R.id.stone08, R.id.stone09,
							R.id.stone0a, R.id.stone0b, R.id.stone0c, R.id.stone0d, R.id.stone0e, R.id.stone0f, R.id.stone0g, R.id.stone0h, R.id.stone0i, R.id.stone0j},
					{R.id.stone10, R.id.stone11, R.id.stone12, R.id.stone13, R.id.stone14, R.id.stone15, R.id.stone16, R.id.stone17, R.id.stone18, R.id.stone19,
							R.id.stone1a, R.id.stone1b, R.id.stone1c, R.id.stone1d, R.id.stone1e, R.id.stone1f, R.id.stone1g, R.id.stone1h, R.id.stone1i, R.id.stone1j},
					{R.id.stone20, R.id.stone21, R.id.stone22, R.id.stone23, R.id.stone24, R.id.stone25, R.id.stone26, R.id.stone27, R.id.stone28, R.id.stone29,
							R.id.stone2a, R.id.stone2b, R.id.stone2c, R.id.stone2d, R.id.stone2e, R.id.stone2f, R.id.stone2g, R.id.stone2h, R.id.stone2i, R.id.stone2j},
					{R.id.stone30, R.id.stone31, R.id.stone32, R.id.stone33, R.id.stone34, R.id.stone35, R.id.stone36, R.id.stone37, R.id.stone38, R.id.stone39,
							R.id.stone3a, R.id.stone3b, R.id.stone3c, R.id.stone3d, R.id.stone3e, R.id.stone3f, R.id.stone3g, R.id.stone3h, R.id.stone3i, R.id.stone3j},
					{R.id.stone40, R.id.stone41, R.id.stone42, R.id.stone43, R.id.stone44, R.id.stone45, R.id.stone46, R.id.stone47, R.id.stone48, R.id.stone49,
							R.id.stone4a, R.id.stone4b, R.id.stone4c, R.id.stone4d, R.id.stone4e, R.id.stone4f, R.id.stone4g, R.id.stone4h, R.id.stone4i, R.id.stone4j},
					{R.id.stone50, R.id.stone51, R.id.stone52, R.id.stone53, R.id.stone54, R.id.stone55, R.id.stone56, R.id.stone57, R.id.stone58, R.id.stone59,
							R.id.stone5a, R.id.stone5b, R.id.stone5c, R.id.stone5d, R.id.stone5e, R.id.stone5f, R.id.stone5g, R.id.stone5h, R.id.stone5i, R.id.stone5j},
					{R.id.stone60, R.id.stone61, R.id.stone62, R.id.stone63, R.id.stone64, R.id.stone65, R.id.stone66, R.id.stone67, R.id.stone68, R.id.stone69,
							R.id.stone6a, R.id.stone6b, R.id.stone6c, R.id.stone6d, R.id.stone6e, R.id.stone6f, R.id.stone6g, R.id.stone6h, R.id.stone6i, R.id.stone6j},
					{R.id.stone70, R.id.stone71, R.id.stone72, R.id.stone73, R.id.stone74, R.id.stone75, R.id.stone76, R.id.stone77, R.id.stone78, R.id.stone79,
							R.id.stone7a, R.id.stone7b, R.id.stone7c, R.id.stone7d, R.id.stone7e, R.id.stone7f, R.id.stone7g, R.id.stone7h, R.id.stone7i, R.id.stone7j},
					{R.id.stone80, R.id.stone81, R.id.stone82, R.id.stone83, R.id.stone84, R.id.stone85, R.id.stone86, R.id.stone87, R.id.stone88, R.id.stone89,
							R.id.stone8a, R.id.stone8b, R.id.stone8c, R.id.stone8d, R.id.stone8e, R.id.stone8f, R.id.stone8g, R.id.stone8h, R.id.stone8i, R.id.stone8j},
					{R.id.stone90, R.id.stone91, R.id.stone92, R.id.stone93, R.id.stone94, R.id.stone95, R.id.stone96, R.id.stone97, R.id.stone98, R.id.stone99,
							R.id.stone9a, R.id.stone9b, R.id.stone9c, R.id.stone9d, R.id.stone9e, R.id.stone9f, R.id.stone9g, R.id.stone9h, R.id.stone9i, R.id.stone9j},
					{R.id.stonea0, R.id.stonea1, R.id.stonea2, R.id.stonea3, R.id.stonea4, R.id.stonea5, R.id.stonea6, R.id.stonea7, R.id.stonea8, R.id.stonea9,
							R.id.stoneaa, R.id.stoneab, R.id.stoneac, R.id.stonead, R.id.stoneae, R.id.stoneaf, R.id.stoneag, R.id.stoneah, R.id.stoneai, R.id.stoneaj},
					{R.id.stoneb0, R.id.stoneb1, R.id.stoneb2, R.id.stoneb3, R.id.stoneb4, R.id.stoneb5, R.id.stoneb6, R.id.stoneb7, R.id.stoneb8, R.id.stoneb9,
							R.id.stoneba, R.id.stonebb, R.id.stonebc, R.id.stonebd, R.id.stonebe, R.id.stonebf, R.id.stonebg, R.id.stonebh, R.id.stonebi, R.id.stonebj},
					{R.id.stonec0, R.id.stonec1, R.id.stonec2, R.id.stonec3, R.id.stonec4, R.id.stonec5, R.id.stonec6, R.id.stonec7, R.id.stonec8, R.id.stonec9,
							R.id.stoneca, R.id.stonecb, R.id.stonecc, R.id.stonecd, R.id.stonece, R.id.stonecf, R.id.stonecg, R.id.stonech, R.id.stoneci, R.id.stonecj},
					{R.id.stoned0, R.id.stoned1, R.id.stoned2, R.id.stoned3, R.id.stoned4, R.id.stoned5, R.id.stoned6, R.id.stoned7, R.id.stoned8, R.id.stoned9,
							R.id.stoneda, R.id.stonedb, R.id.stonedc, R.id.stonedd, R.id.stonede, R.id.stonedf, R.id.stonedg, R.id.stonedh, R.id.stonedi, R.id.stonedj},
					{R.id.stonee0, R.id.stonee1, R.id.stonee2, R.id.stonee3, R.id.stonee4, R.id.stonee5, R.id.stonee6, R.id.stonee7, R.id.stonee8, R.id.stonee9,
							R.id.stoneea, R.id.stoneeb, R.id.stoneec, R.id.stoneed, R.id.stoneee, R.id.stoneef, R.id.stoneeg, R.id.stoneeh, R.id.stoneei, R.id.stoneej},
					{R.id.stonef0, R.id.stonef1, R.id.stonef2, R.id.stonef3, R.id.stonef4, R.id.stonef5, R.id.stonef6, R.id.stonef7, R.id.stonef8, R.id.stonef9,
							R.id.stonefa, R.id.stonefb, R.id.stonefc, R.id.stonefd, R.id.stonefe, R.id.stoneff, R.id.stonefg, R.id.stonefh, R.id.stonefi, R.id.stonefj},
					{R.id.stoneg0, R.id.stoneg1, R.id.stoneg2, R.id.stoneg3, R.id.stoneg4, R.id.stoneg5, R.id.stoneg6, R.id.stoneg7, R.id.stoneg8, R.id.stoneg9,
							R.id.stonega, R.id.stonegb, R.id.stonegc, R.id.stonegd, R.id.stonege, R.id.stonegf, R.id.stonegg, R.id.stonegh, R.id.stonegi, R.id.stonegj},
					{R.id.stoneh0, R.id.stoneh1, R.id.stoneh2, R.id.stoneh3, R.id.stoneh4, R.id.stoneh5, R.id.stoneh6, R.id.stoneh7, R.id.stoneh8, R.id.stoneh9,
							R.id.stoneha, R.id.stonehb, R.id.stonehc, R.id.stonehd, R.id.stonehe, R.id.stonehf, R.id.stonehg, R.id.stonehh, R.id.stonehi, R.id.stonehj},
					{R.id.stonei0, R.id.stonei1, R.id.stonei2, R.id.stonei3, R.id.stonei4, R.id.stonei5, R.id.stonei6, R.id.stonei7, R.id.stonei8, R.id.stonei9,
							R.id.stoneia, R.id.stoneib, R.id.stoneic, R.id.stoneid, R.id.stoneie, R.id.stoneif, R.id.stoneig, R.id.stoneih, R.id.stoneii, R.id.stoneij},
					{R.id.stonej0, R.id.stonej1, R.id.stonej2, R.id.stonej3, R.id.stonej4, R.id.stonej5, R.id.stonej6, R.id.stonej7, R.id.stonej8, R.id.stonej9,
							R.id.stoneja, R.id.stonejb, R.id.stonejc, R.id.stonejd, R.id.stoneje, R.id.stonejf, R.id.stonejg, R.id.stonejh, R.id.stoneji, R.id.stonejj}
			};

	Chronometer timer;
	TextView player_turn, scores, winner_text, waiting;
	RadioButton ten, fifteen, twenty, standard_radio, free_radio;
	Button rematch_button, exit_button, play_phase2, play_online;
	Typeface tf;
	int player, p1_wins, p2_wins, filled, curr, size, you= 0;
	boolean standard, wait = false;
	boolean gameOver = true;
	String move;
	Integer row, col = 0;
	int screenHeight = 0;

	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;

	public static final String DEVICE_NAME = "device_name";
	public static final String TOAST = "toast";

	private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
	private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
	private static final int REQUEST_ENABLE_BT = 3;

	private ListView lvMainChat;
	private EditText etMain;
	private Button btnSend;

	private String connectedDeviceName = null;
	private ArrayAdapter<String> chatArrayAdapter;

	private StringBuffer outStringBuffer;
	private BluetoothAdapter bluetoothAdapter = null;
	private ChatService chatService = null;

	private Handler handler = new Handler(new Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			switch (msg.what) {
			case MESSAGE_STATE_CHANGE:
				switch (msg.arg1) {
				case ChatService.STATE_CONNECTED:
					setStatus(getString(R.string.title_connected_to,
							connectedDeviceName));
					chatArrayAdapter.clear();
					break;
				case ChatService.STATE_CONNECTING:
					setStatus(R.string.title_connecting);
					break;
				case ChatService.STATE_LISTEN:
				case ChatService.STATE_NONE:
					setStatus(R.string.title_not_connected);
					break;
				}
				break;
			case MESSAGE_WRITE:
				byte[] writeBuf = (byte[]) msg.obj;

				String writeMessage = new String(writeBuf);
				chatArrayAdapter.add("Me:  " + writeMessage);
				break;
			case MESSAGE_READ:
				byte[] readBuf = (byte[]) msg.obj;

				String readMessage = new String(readBuf, 0, msg.arg1);
				chatArrayAdapter.add(connectedDeviceName + ":  " + readMessage);

				if (gameOver) {

					if (readMessage.compareTo("   .   ") == 0) {
						((LinearLayout) findViewById(R.id.phase_one)).setVisibility(View.GONE);
						((LinearLayout) findViewById(R.id.phase_two_b)).setVisibility(View.VISIBLE);
						you = 1;
					}

					if (readMessage.compareTo("mode is standard") == 0) {
						standard = true;
					}
					if (readMessage.compareTo("mode is freestyle") == 0) {
						standard = false;
					}
					if (readMessage.compareTo("size is 10") == 0) {
						size = 10;
					}
					if (readMessage.compareTo("size is 15") == 0) {
						size = 15;
					}
					if (readMessage.compareTo("size is 20") == 0) {
						size = 20;
					}
					if (readMessage.compareTo("begin online match") == 0) {
						((LinearLayout) findViewById(R.id.phase_two_b)).setVisibility(View.GONE);
						((LinearLayout) findViewById(R.id.phase_three)).setVisibility(View.VISIBLE);
						gameOver = false;
						filled = size * size;
						scores.setText("you: "+ p2_wins + "    them: "+ p1_wins);
						player_turn.setText("their Turn");

						//if the size is 15, show the 15X15 buttons
						//if size is 20, show all buttons
						//10X10 is default
						if (size == 10){
							GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
							grid.setPadding(0,(int)(.03 * (screenHeight)), 0, (int)(.03 * (screenHeight)));
							for (int i = 0; i < 10; i++){
								for (int j = 0; j < 10; j++) {
									Button button = (Button) (findViewById(board[i][j]));
									button.setEnabled(false);
									ViewGroup.LayoutParams params = button.getLayoutParams();
									params.width = params.height = (int)(.05 * (screenHeight));
									button.setLayoutParams(params);
								}
							}
						}
						if (size == 15) {
							GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
							grid.setPadding(0,(int)(.01 * (screenHeight)), 0, 0);
							for (int i = 0; i < 15; i++) {
								for (int j = 0; j < 15; j++) {
									Button button = (Button) (findViewById(board[i][j]));
									button.setEnabled(false);
									button.setVisibility(View.VISIBLE);
									ViewGroup.LayoutParams params = button.getLayoutParams();
									params.width = params.height = (int)(.035 * (screenHeight));
									button.setLayoutParams(params);
								}
							}
						}
						if (size > 15) {
							GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
							grid.setPadding(0,(int)(.01 * (screenHeight)), 0, 0);
							for (int i = 0; i < 20; i++) {
								for (int j = 0; j < 20; j++) {
									Button button = (Button) (findViewById(board[i][j]));
									button.setEnabled(false);
									button.setVisibility(View.VISIBLE);
									ViewGroup.LayoutParams params = button.getLayoutParams();
									params.width = params.height = (int)(.027 * (screenHeight));
									button.setLayoutParams(params);
								}
							}
						}
					}
					if (readMessage.compareTo("restart the game please!") == 0){
						gameOver = false;
						curr = 0;
						winner_text.setVisibility(View.GONE);
						rematch_button.setVisibility(View.GONE);
						for (int i = 0; i < size; i++)
							for (int j = 0; j < size; j++) {
								((Button) findViewById(board[i][j])).setText("");
								((Button) findViewById(board[i][j])).setBackgroundResource(R.drawable.metal_board);
							}
					}
					if (readMessage.compareTo("I'm done playing thanks very much") == 0){
						finish();
					}
				}
				else if (!gameOver) {
					if (readMessage.compareTo("I'm done playing thanks very much") == 0){
						finish();
					}
					else {
						move = readMessage;
						System.out.print("\n\n\n\n\n\n" + move);
						row = Integer.parseInt(move.split(",", 2)[0]);
						col = Integer.parseInt(move.split(",", 2)[1]);

						onButtonClicked((Button) findViewById(board[row][col]));
//						for (int i = 0; i < size; i++)
//							for (int j = 0; j < size; j++)
//								((Button)findViewById(board[i][j])).setEnabled(true);
					}
				}
				break;

			case MESSAGE_DEVICE_NAME:

				connectedDeviceName = msg.getData().getString(DEVICE_NAME);
				Toast.makeText(getApplicationContext(),
						"Connected to " + connectedDeviceName,
						Toast.LENGTH_SHORT).show();
				break;
			case MESSAGE_TOAST:
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(TOAST), Toast.LENGTH_SHORT)
						.show();
				break;
			}
			return false;
		}
	});

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		getWidgetReferences();
		bindEventHandler();
		setTitle("Gomoku Lobby");
		if (bluetoothAdapter == null) {
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			finish();
			return;
		}
	}

	private void getWidgetReferences() {
		lvMainChat = (ListView) findViewById(R.id.lvMainChat);
		etMain = (EditText) findViewById(R.id.etMain);
		btnSend = (Button) findViewById(R.id.btnSend);

		timer = (Chronometer) findViewById(R.id.timer_display);
		player_turn = (TextView)findViewById(R.id.player_turn_text);
		scores = (TextView)findViewById(R.id.scores_text);
		rematch_button = (Button)findViewById(R.id.rematch_button);
		winner_text = (TextView)findViewById(R.id.winner_text);
		exit_button = (Button)findViewById(R.id.exit_button);
		waiting = (TextView)findViewById(R.id.waiting);
		ten = (RadioButton)findViewById(R.id.TenByTen);
		fifteen = (RadioButton)findViewById(R.id.FifteenByFifteen);
		twenty = (RadioButton)findViewById(R.id.TwentyByTwenty);
		standard_radio = (RadioButton)findViewById(R.id.Standard);
		free_radio = (RadioButton)findViewById(R.id.Freestyle);
		play_phase2 = (Button)findViewById(R.id.play_button);
		play_online = (Button)findViewById(R.id.OnlinePlay);


		tf = Typeface.createFromAsset(getAssets(), "fonts/DIRTYEGO.TTF");
		timer.setTypeface(tf);
		player_turn.setTypeface(tf);
		scores.setTypeface(tf);
		rematch_button.setTypeface(tf);
		winner_text.setTypeface(tf);
		exit_button.setTypeface(tf);
		waiting.setTypeface(tf);
		ten.setTypeface(tf);
		fifteen.setTypeface(tf);
		twenty.setTypeface(tf);
		standard_radio.setTypeface(tf);
		free_radio.setTypeface(tf);
		play_phase2.setTypeface(tf);

		//set sizing of the widgets

		//get the screen size so that we can size the text
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenWidth = displaymetrics.widthPixels;
		screenHeight = displaymetrics.heightPixels;

		// Get the screen's density scale
		float scale = getResources().getDisplayMetrics().density;

		//set sizes of the text fields
		waiting.setTextSize((int)(.35 * (screenWidth/scale)));

		ten.setTextSize((int)(.1 * (screenWidth/scale)));
		fifteen.setTextSize((int)(.1 * (screenWidth/scale)));
		twenty.setTextSize((int)(.1 * (screenWidth/scale)));
		standard_radio.setTextSize((int)(.1 * (screenWidth/scale)));
		free_radio.setTextSize((int)(.1 * (screenWidth/scale)));
		play_phase2.setTextSize((int)(.2 * (screenWidth/scale)));


		timer.setTextSize((int)(.13 * (screenWidth/scale)));
		player_turn.setTextSize((int)(.13 * (screenWidth/scale)));
		scores.setTextSize((int) (.13 * (screenWidth/scale)));
		rematch_button.setTextSize((int)(.1 * (screenWidth/scale)));
		exit_button.setTextSize((int) (.1 * (screenWidth/scale)));
		winner_text.setTextSize((int)(.13 * (screenWidth/scale)));




	}

	private void bindEventHandler() {
		etMain.setOnEditorActionListener(mWriteListener);


		btnSend.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String message = etMain.getText().toString();
				sendMessage(message);
			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_CONNECT_DEVICE_SECURE:
			if (resultCode == Activity.RESULT_OK) {
				connectDevice(data, true);
			}
			break;
		case REQUEST_CONNECT_DEVICE_INSECURE:
			if (resultCode == Activity.RESULT_OK) {
				connectDevice(data, false);
			}
			break;
		case REQUEST_ENABLE_BT:
			if (resultCode == Activity.RESULT_OK) {
				setupChat();
			} else {
				Toast.makeText(this, R.string.bt_not_enabled_leaving,
						Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}

	private void connectDevice(Intent data, boolean secure) {
		String address = data.getExtras().getString(
				DeviceListActivity.DEVICE_ADDRESS);
		BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
		chatService.connect(device, secure);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.option_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent serverIntent = null;
		switch (item.getItemId()) {
		case R.id.secure_connect_scan:
			serverIntent = new Intent(this, DeviceListActivity.class);
			startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_SECURE);
			return true;
		case R.id.insecure_connect_scan:
			serverIntent = new Intent(this, DeviceListActivity.class);
			startActivityForResult(serverIntent,
					REQUEST_CONNECT_DEVICE_INSECURE);
			return true;
		case R.id.discoverable:
			ensureDiscoverable();
			return true;
		}
		return false;
	}

	private void ensureDiscoverable() {
		if (bluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
			Intent discoverableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			discoverableIntent.putExtra(
					BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
			startActivity(discoverableIntent);
		}
	}

	private void sendMessage(String message) {
		if (chatService.getState() != ChatService.STATE_CONNECTED) {
			Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT)
					.show();
			return;
		}

		if (message.length() > 0) {
			byte[] send = message.getBytes();
			chatService.write(send);

			outStringBuffer.setLength(0);
			etMain.setText(outStringBuffer);
		}
	}

	private TextView.OnEditorActionListener mWriteListener = new TextView.OnEditorActionListener() {
		public boolean onEditorAction(TextView view, int actionId,
				KeyEvent event) {
			if (actionId == EditorInfo.IME_NULL
					&& event.getAction() == KeyEvent.ACTION_UP) {
				String message = view.getText().toString();
				sendMessage(message);
			}
			return true;
		}
	};

	private final void setStatus(int resId) {
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setSubtitle(resId);
	}

	private final void setStatus(CharSequence subTitle) {
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setSubtitle(subTitle);
	}

	private void setupChat() {
		chatArrayAdapter = new ArrayAdapter<String>(this, R.layout.message);
		lvMainChat.setAdapter(chatArrayAdapter);

		chatService = new ChatService(this, handler);

		outStringBuffer = new StringBuffer("");
	}

	@Override
	public void onStart() {
		super.onStart();

		if (!bluetoothAdapter.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
		} else {
			if (chatService == null)
				setupChat();
		}
	}

	@Override
	public synchronized void onResume() {
		super.onResume();

		if (chatService != null) {
			if (chatService.getState() == ChatService.STATE_NONE) {
				chatService.start();
			}
		}
	}

	@Override
	public synchronized void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	public void PlayOnline(View view){
		int num_players, board_size = 0;
		((LinearLayout)findViewById(R.id.phase_one)).setVisibility(view.GONE);
		((LinearLayout)findViewById(R.id.phase_two)).setVisibility(view.VISIBLE);
		sendMessage("   .   ");
		you = 0;
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (chatService != null)
			chatService.stop();
	}

//This is the stuff from the selection screen



	//this is the play button from the selection screen
	//could have special string codes for these, but since we only have a short time
	//to complete, we can re-examine that later if we want.  The issue with no codes is
	//that if the player types these messages in the chat lobby, that will show up for the
	//person on the other side.
	public void GoToPlayScreen(View view) {
//		if (standard)
//			sendMessage("mode is standard");
//			//move += "mode is standard";
//		else sendMessage("mode is freestyle");
//
//		if (size == 10)
//			sendMessage("size is 10");
//			//move += ",size is 10";
//		else if (size == 15)
//			sendMessage("size is 15");
//		    //move += ",size is 15";
//		else sendMessage("size is 20");
//		    //move += ",size is 20";

		sendMessage("begin online match");

		((LinearLayout)findViewById(R.id.phase_two)).setVisibility(view.GONE);
		((LinearLayout)findViewById(R.id.phase_three)).setVisibility(view.VISIBLE);
		gameOver = false;
		filled = size * size;
		scores.setText("you: "+ p1_wins + "    them: "+ p2_wins);
		player_turn.setText("your turn");

		//if the size is 15, show the 15X15 buttons
		//if size is 20, show all buttons
		//10X10 is default
		if (size == 10){
			GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
			grid.setPadding(0,(int)(.03 * (screenHeight)), 0, (int)(.03 * (screenHeight)));
			for (int i = 0; i < 10; i++){
				for (int j = 0; j < 10; j++) {
					Button button = (Button) (findViewById(board[i][j]));
					ViewGroup.LayoutParams params = button.getLayoutParams();
					params.width = params.height = (int)(.05 * (screenHeight));
					button.setLayoutParams(params);
				}
			}
		}
		if (size == 15) {
			GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
			grid.setPadding(0,(int)(.01 * (screenHeight)), 0, 0);
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					Button button = (Button) (findViewById(board[i][j]));
					button.setVisibility(View.VISIBLE);
					ViewGroup.LayoutParams params = button.getLayoutParams();
					params.width = params.height = (int)(.035 * (screenHeight));
					button.setLayoutParams(params);
				}
			}
		}
		if (size > 15) {
			GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
			grid.setPadding(0,(int)(.01 * (screenHeight)), 0, 0);
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					Button button = (Button) (findViewById(board[i][j]));
					button.setVisibility(View.VISIBLE);
					ViewGroup.LayoutParams params = button.getLayoutParams();
					params.width = params.height = (int)(.027 * (screenHeight));
					button.setLayoutParams(params);
				}
			}
		}

	}

	public void SelectMode(View view) {
		boolean button_checked = ((RadioButton) view).isChecked();

		switch (view.getId())
		{
			case R.id.Standard:
				if(button_checked) {
					standard = true;
					sendMessage("mode is standard");
					break;
				}
			case R.id.Freestyle:
				if (button_checked)
				{
					standard = false;
					sendMessage("mode is freestyle");
					break;
				}
		}
	}

	public void SelectSize(View view) {
		boolean button_checked = ((RadioButton) view).isChecked();

		switch (view.getId())
		{
			case R.id.TenByTen:
				if(button_checked) {
					size = 10;
					sendMessage("size is 10");
					break;
				}
			case R.id.FifteenByFifteen:
				if (button_checked)
				{
					size = 15;
					sendMessage("size is 15");
					break;
				}
			case R.id.TwentyByTwenty:
				if (button_checked)
				{
					size = 20;
					sendMessage("size is 20");
					break;
				}
		}
	}


	//here is for the actual game
	public void onButtonClicked(View view) {
System.out.print("1");
		if (gameOver) return;
		Button stone = (Button) view;
		TextView winner_text = (TextView) findViewById(R.id.winner_text);
		Button rematch_button = (Button) findViewById(R.id.rematch_button);

		if (stone.getText().toString().compareTo("") == 0) {
			{
				if ((player == 0) && (you == 0)) {
					player = 1;
					player_turn.setText("their Turn");
					stone.setBackgroundResource(R.drawable.black_board);
					stone.setTextColor(0);
					stone.setText("G");
					curr++;
					for (int i = 0; i < size; i++)
						for (int j = 0; j < size; j++)
							findViewById(board[i][j]).setEnabled(false);
					o:
					for (int i = 0; i < size; i++)
						for (int j = 0; j < size; j++)
							if (stone == findViewById(board[i][j])) {
								sendMessage(i + "," + j);
								break o;
							}

					timer.setBase(SystemClock.elapsedRealtime());
					timer.start();

				}
				else if ((player == 1) && (you == 0)){
//					row = Integer.parseInt(move.split(",", 2)[0]);
//					col = Integer.parseInt(move.split(",", 2)[1]);
					Button theirMove = (Button) view; //findViewById(board[row][col]);
					theirMove.setBackgroundResource(R.drawable.white_board);
					theirMove.setTextColor(Color.rgb(255, 255, 255));
					theirMove.setText("R");
					for (int i = 0; i < size; i++)
						for (int j = 0; j < size; j++)
							findViewById(board[i][j]).setEnabled(true);
					player = 0;
					player_turn.setText("your turn");
					curr++;
					timer.setBase(SystemClock.elapsedRealtime());
					timer.start();
				}


				else if ((player == 0) && (you == 1)) {
//					row = Integer.parseInt(move.split(",", 2)[0]);
//					col = Integer.parseInt(move.split(",", 2)[1]);
					Button theirMove = (Button) view;//findViewById(board[row][col]);
					theirMove.setBackgroundResource(R.drawable.black_board);
					theirMove.setTextColor(0);
					theirMove.setText("G");
					for (int i = 0; i < size; i++)
						for (int j = 0; j < size; j++)
							findViewById(board[i][j]).setEnabled(true);
					player = 1;
					player_turn.setText("your turn");
					curr++;
					timer.setBase(SystemClock.elapsedRealtime());
					timer.start();
				}

				else if ((player == 1) && (you == 1)){
					player = 0;
					player_turn.setText("Their Turn");
					stone.setBackgroundResource(R.drawable.white_board);
					stone.setTextColor(Color.rgb(255, 255, 255));
					stone.setText("R");
					curr++;
					for (int i = 0; i < size; i++)
						for (int j = 0; j < size; j++)
							findViewById(board[i][j]).setEnabled(false);
					o:
					for (int i = 0; i < size; i++)
						for (int j = 0; j < size; j++)
							if (stone == findViewById(board[i][j])) {
								sendMessage(i + "," + j);
								break o;
							}

					timer.setBase(SystemClock.elapsedRealtime());
					timer.start();
				}
			}

		}


		if(!standard) {
			if (AnalyzeThis.analyzer("G", makeboard(board))) {
				System.out.println("GREEN WINS!");
				p1_wins++;
				if (you == 0) {
					scores.setText("you: " + p1_wins + "    them: " + p2_wins);
					winner_text.setText("you win");
				}
				else {
					scores.setText("you: " + p2_wins + "    them: "+ p1_wins);
					winner_text.setText("they win");
				}
				rematch_button.setVisibility(view.VISIBLE);
				gameOver = true;
				timer.stop();

			} else if (AnalyzeThis.analyzer("R", makeboard(board))) {
				System.out.println("RED WINS!");
				p2_wins++;
				if (you == 0) {
					scores.setText("you: " + p1_wins + "    them: " + p2_wins);
					winner_text.setText("they win");
				}
				else {
					scores.setText("you: " + p2_wins + "    them: "+ p1_wins);
					winner_text.setText("you win");
				}
				rematch_button.setVisibility(view.VISIBLE);
				gameOver = true;
				timer.stop();
			}

			else if(curr == filled){
				winner_text.setText("Stalemate");
				rematch_button.setVisibility(view.VISIBLE);
				gameOver = true;
				timer.stop();
			}
		}
		else{
			if (AnalyzeThis.analyzed("G", makeboard(board), size)) {
				System.out.println("GREEN WINS!");
				p1_wins++;
				if (you == 0) {
					scores.setText("you: " + p1_wins + "    them: " + p2_wins);
					winner_text.setText("you win");
				}
				else {
					scores.setText("you: " + p2_wins + "    them: "+ p1_wins);
					winner_text.setText("they win");
				}
				rematch_button.setVisibility(view.VISIBLE);
				gameOver = true;
				timer.stop();

			} else if (AnalyzeThis.analyzed("R", makeboard(board), size)) {
				System.out.println("RED WINS!");
				p2_wins++;
				if (you == 0) {
					scores.setText("you: " + p1_wins + "    them: " + p2_wins);
					winner_text.setText("they win");
				}
				else {
					scores.setText("you: " + p2_wins + "    them: "+ p1_wins);
					winner_text.setText("you win");
				}
				rematch_button.setVisibility(view.VISIBLE);
				gameOver = true;
				timer.stop();
			}

			else if(curr == filled){
				winner_text.setText("Stalemate");
				rematch_button.setVisibility(view.VISIBLE);
				gameOver = true;
				timer.stop();
			}
		}

	}

	public void resetGame(View view) {
		gameOver = false;
		curr = 0;
		winner_text.setVisibility(view.GONE);
		rematch_button.setVisibility(view.GONE);
		sendMessage("restart the game please!");
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				((Button) findViewById(board[i][j])).setText("");
				((Button) findViewById(board[i][j])).setBackgroundResource(R.drawable.metal_board);
			}
	}

	public void finish(View view) {
		sendMessage("I'm done playing thanks very much");
		finish();
	}

	public String[][] makeboard(int[][] board) {
		String[][] stoneBoard = new String[20][20];
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++) {
				stoneBoard[i][j] = String.valueOf(((Button) findViewById(board[i][j])).getText());
				if (stoneBoard[i][j].compareTo("") == 0) stoneBoard[i][j] = " ";
			}
		return stoneBoard;
	}


}
