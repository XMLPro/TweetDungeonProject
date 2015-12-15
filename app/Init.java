
import play.*;
import play.mvc.*;
import play.jobs.*;

import models.*;
import models.hashGet.*;
import models.maze.*;

public class Init {
    public void mazeGenerate(){
		MazeGenerate maze1 = new MazeGenerate();
		Player player1 = new Player();
		maze1.init(maze1, player1, 9);// 迷路初期化
    }
    public void doJob() {
        System.out.println("doJob");
        Tw t = new Tw();
        t.kidou();
        mazeGenerate();
    }

}

