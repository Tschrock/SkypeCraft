package tschrock.mc.skypecraft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import com.skype.Skype;
import com.skype.SkypeException;

public class Command_SHelp  extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "shelp";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	if(arguments.length == 0){
    		sender.sendChatToPlayer("§6" + "[SK] Help:\n" + 
    				"§n" + "/shelp: " + "§6" + " Displays this help message.\n" + 
    				"§n" + "/slist: " + "§6" + " Displays a list of all friends.\n" + 
    				"§n" + "/stell: " + "§6" + " Sends a message to a player.\n" + 
    				"§n" + "/scall: " + "§6" + " Starts a call with player(s). §4!untested!\n");
    	}
    	else if("shelp".equals(arguments[0])){
    		sender.sendChatToPlayer("§6" + "[SK] Help: " + "§n" + "shelp:" + "§6\n" +
    				"Usage: /shelp {command}"+ "\n"+
    				"Displays a help message, or help for {command}");
    	}
    	else if(arguments[0].equals("slist")){
    		sender.sendChatToPlayer("§6" + "[SK] Help: " + "§n" + "slist:" + "§6\n" +
    				"Usage: /slist"+ "\n"+
    				"Displays a list of all friends.");    		
    	}
    	else if(arguments[0].equals("stell")){
    		sender.sendChatToPlayer("§6" + "[SK] Help: " + "§n" + "stell:" + "§6\n" +
    				"Usage: /stell [friend] [message]"+ "\n"+
    				"Sends [message] to [friend]." + "\n" +
    				"[friend] must be the Skype Id, not the name!");    		
    	}
    	else if(arguments[0].equals("scall")){
    		sender.sendChatToPlayer("§6" + "[SK] Help: " + "§n" + "stell:" + "§6\n" +
    				"Usage: /scall [friend1], [friend2..."+ "\n"+
    				"Calls [friend1...]" + "\n" +
    				"[friend] must be the Skype Id, not the name!   §4!untested!");    		
    	}
    	else{
    		sender.sendChatToPlayer("§6" + "[SK] Could not find help message for " + arguments[0] + ".\n" +
    				"Use /shelp for list of available commands.");
    	}
    }
}
