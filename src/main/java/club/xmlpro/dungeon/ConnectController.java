package club.xmlpro.dungeon;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ConnectController {
    @MessageMapping("/dungeon")
    @SendTo("/queue/connect")
    public boolean connect(){
        return true;
    }
}
