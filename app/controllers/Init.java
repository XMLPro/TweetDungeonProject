package controllers;

import play.*;
import play.mvc.*;
import play.jobs.*;

import models.*;
import models.hashGet.*;
//import models.maze.*;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@OnApplicationStart
public class Init extends Job{
    //    public void mazeGenerate(){
    //		MazeGenerate maze1 = new MazeGenerate();
    //		Player player1 = new Player();
    //		maze1.init(maze1, player1, 9);// 迷路初期化
    //    }
    public static MazeGenerate maze1;
    public static Player player1;
    public void doJob() {
        Logger.info("STARTING:::");
        maze1 = new MazeGenerate();
        player1 = new Player();
        System.out.println("px: " + player1.getPlayerX());
        System.out.println("py: " + player1.getPlayerY());
        maze1.init(maze1, player1, 9);
        //MyStatusListener lisner = new MyStatusListener();
        Tw listener = new Tw();
        TwitterStream stream = listener.getTwitterStreaming();
        //MyStatusListener listener = new MyStatusListener();
        // 大人数時の投票システム
//        Thread t1 = new Thread(listener);
//        t1.start();
//        // ハッシュタグのツイート取得
//        TwitterStream get_twitterStreaming = listener.getTwitterStreaming();
//
        Logger.info("STARTED:::");
    }

}

