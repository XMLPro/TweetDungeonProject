package controllers.hashGet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;


class MyStatusListener implements  Runnable, StatusListener {

	private static final String CONSUMER_KEY        = Key.CONSUMER_KEY;
	private static final String CONSUMER_SECRET     = Key.CONSUMER_SECRET;
	private static final String ACCESS_TOKEN        = Key.ACCESS_TOKEN;
	private static final String ACCESS_TOKEN_SECRET = Key.ACCESS_TOKEN_SECRET;
	// 取得するハッシュタグ
	private static String[] track = { "#はっしゅてすと" };
	// 大人数のときのツイートを入れるリスト
	private List buf = new ArrayList();
	// 前のツイートの時間（大人数との切り替え）
	Date before = new Date();

	public static String getKey() {
		return CONSUMER_KEY;
	}

	public static String getSecret() {
		return CONSUMER_SECRET;
	}

	public static String getToken() {
		return ACCESS_TOKEN;
	}

	public static String getTokenSecret() {
		return ACCESS_TOKEN_SECRET;
	}

	public static String[] hash() {
		return track;
	}

	// ハッシュタグのツイート取得
	// ツイートされたときに通知
	public void onStatus(Status status) {
		// ツイート本文
		String text = status.getText();
        for(String tag: track)
		    text = text.replace(tag, "");
		text = text.replaceAll("\n", "");

		// 時間取得
		String time;
		Date getTime = status.getCreatedAt();
		SimpleDateFormat sdf = new SimpleDateFormat("HH時mm分ss秒");
		time = sdf.format(getTime);
		String[] vote = { text, time };

		// 5秒以内に次のツイートがあった場合に投票になる
		if (before.getTime() - getTime.getTime() < 5 * 1000) {
			Date c = new Date();
			buf.add(vote.clone());
		} else {
			// ツイート内容表示
			System.out.println("テキスト:" + text);
			// Commandクラスでツイート内容を整形
			Command cm = new Command();
			cm.com(text, time);
		}
		before = getTime;
	}

	// 大人数時の投票システム実行
	public void run() {
		while (true) {
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String str = this.countCommand();
			System.out.println(str);
		}
	}

	// Bufferリストをコピー
	public List copyBuffer(List buf) {
		return new ArrayList(buf);
	}

	// 大人数時の投票をカウント
	public String countCommand() {
		// カウントを保存
		Map<String, Integer> count = new LinkedHashMap<>();
		// カウントリストの初期化
		count.put("みぎ", 0);
		count.put("ひだり", 0);
		count.put("うえ", 0);
		count.put("した", 0);

		// コマンドリストをコピー
		List command = this.copyBuffer(buf);
		// コマンドリストの項目を消去
		buf.clear();

		// コマンドをカウント
		for (Object text : command) {
			String txt = (String) text;
			int cnt = count.get(txt);
			count.put(txt, cnt + 1);
		}

		// ソート
		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(
				count.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1,
					Entry<String, Integer> entry2) {
				return ((Integer) entry2.getValue()).compareTo((Integer) entry1
						.getValue());
			}
		});

		// 最大のvalueのkeyを取得
		for (Map.Entry<String, Integer> e : entries) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		System.out.println(entries.iterator().next().getKey());

		return entries.iterator().next().getKey();
	}

	public TwitterStream getTwitterStreaming() {
		// 認証情報
		Configuration configuration = new ConfigurationBuilder()
				.setOAuthConsumerKey(MyStatusListener.getKey())
				.setOAuthConsumerSecret(MyStatusListener.getSecret())
				.setOAuthAccessToken(MyStatusListener.getToken())
				.setOAuthAccessTokenSecret(MyStatusListener.getTokenSecret())
				.build();

		// TwitterStreamのインスタンス作成
		TwitterStream twStream = new TwitterStreamFactory(configuration)
				.getInstance();
		// リスナーを登録
		twStream.addListener(new MyStatusListener());
		// 検索のフィルター作成
		FilterQuery filter = new FilterQuery();
		// ハッシュタグ指定
		String[] track = MyStatusListener.hash();
		filter.track(track);
		// ハッシュタグでフィルター
		twStream.filter(filter);
		return twStream;
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice sdn) {
		// ツイート削除されたときの通知
		// System.out.println("onDeletionNotice.");
	}

	@Override
	public void onTrackLimitationNotice(int i) {
		// トラックの制限が変わったときの通知
		// System.out.println("onTrackLimitationNotice.(" + i + ")");
	}

	@Override
	public void onScrubGeo(long lat, long lng) {
		// 位置情報が削除されたときの通知
		// System.out.println("onScrubGeo.(" + lat + ", " + lng + ")");
	}

	@Override
	public void onException(Exception excptn) {
		// 例外が発生したときの通知
		// System.out.println("onException.");
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// 使わない何かの通知
		// TODO Auto-generated method stub
	}
}
