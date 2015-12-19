package models;
import java.util.*;

public class CheckSt{
	private static CheckSt cs = new CheckSt();
	private	List<String> twis = new ArrayList<String>();
	private boolean flag;
	private List<String> connections = new ArrayList<String>();

	// コンストラクタ
	public CheckSt(){
		flag = false;
		//connections = 0;
	}

	//Instanceを返す
	public static CheckSt getInstance(){
		return cs;
	}

	public void connect(String id){
		connections.add(id);
	}
	public void disconnect(String id){
		connentions.remove(connections.indexOf(id));
	}

	// Tweetを受け取りフラグを立てるクラス
	public void postSt(String twi){
		twis.add(twi);
		cs.UpFlag();
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
