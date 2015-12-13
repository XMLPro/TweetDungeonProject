package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void mazeGenerate(){
		MazeGenerate maze1 = new MazeGenerate();
		Player player1 = new Player();
		maze1.init(maze1, player1, 9);// 迷路初期化
    }

}
