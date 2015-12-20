package models.hashGet;

import java.util.LinkedHashSet;
import java.util.Set;

public enum Command {
    UP, DOWN, LEFT, RIGHT;
}
//public class Command {
//	private Set<String> commandList = new LinkedHashSet<>();
//
//	enum comList{
//
//	}
//
//	enum rightList{
//		みぎ,右,right;
//
//		private String rightCom;
//	}
//
//	enum leftList{
//
//	}
//
//	enum upList{
//
//	}
//
//	enum downList{
//
//	}
//
//	public Command() {
//		this.addCommand();
//	}
//
//	// ツイート内容をなげる
//	public void com(String tweet, String time) {
//		String command = this.searchCommand(tweet);
//		if (command.isEmpty()) {
//			// コメント
//			System.out.println(time + ":" + tweet);
//		} else {
//			// コマンド
//			System.out.println(time + ":" + tweet);
//			System.out.println(time + "：" + command + "(command)");
//		}
//	}
//
//	public void addCommand() {
//		commandList.add("みぎ");
//		commandList.add("ひだり");
//		commandList.add("うえ");
//		commandList.add("した");
//	}
//
//	// コマンド抜き出し
//	public String searchCommand(String tweet) {
//		for (String s : commandList) {
//			int num = tweet.indexOf(s);
//			if (num == -1) {
//				continue;
//			} else {
//				return tweet.substring(num, num + s.length());
//			}
//		}
//		return "";
//	}
//}
