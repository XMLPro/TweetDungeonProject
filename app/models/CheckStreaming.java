package models;
import java.util.*;

public class CheckStreaming{
	private static CheckStreaming cs = new CheckStreaming();
	private	List<String> twis = new ArrayList<String>();
	private boolean flag;
	private List<String> connections = new ArrayList<String>();

	// コンストラクタ
	public CheckStreaming(){
		flag = false;
		//connections = 0;
	}

	//Instanceを返す
	public static CheckStreaming getInstance(){
		return cs;
	}

	public void connect(String id){
		connections.add(id);
	}
	public void disconnect(String id){
		connections.remove(connections.indexOf(id));
	}

	// Tweetを受け取りフラグを立てるクラス
	public void postSt(String twi){
		twis.add(twi);
		cs.upFlag();
	}

	// falgをたてます
	public void upFlag(){
		flag = true;
	}

	// flagを返す
	public boolean getFalg(){
		return cs.flag;
	}

	// tweetを貯めたlistを返す
	public List<String> getTwis(){
		List<String> tmp = cs.twis;
		flag = false;
		cs.twis = new ArrayList<String>();
		return tmp;
	}
}
