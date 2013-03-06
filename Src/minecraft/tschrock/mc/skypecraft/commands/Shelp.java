package tschrock.mc.skypecraft.commands;

import java.util.Collection;

import tschrock.mc.skypecraft.chatformatter.HelpFormatter;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import com.skype.Skype;
import com.skype.SkypeException;

public class Shelp  extends CommandBase
{
		
	String[][] cmnds = {
			{"shelp","/shelp {command}","Displays a help message, or help for a command."},
			{"slist","/slist","Displays a list of all friends."},
			{"stell","/stell [friend] [message]","Sends a message to a player. Warning: Use Skype Ids, not names!"},
			{"scall","/scall [friend1], [friend2]...","Starts a call with friend(s). Warning: Use Skype Ids, not names!"},
			{"sanswer","/sanswer","Answers an incoming call."},
			{"sstatus","/sstatus {online | away | do not disturb (dnd) |invisible |offline}","Changes your status."}
			};
    		
    @Override
    public String getCommandName() {
        return "shelp";
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	if(arguments.length == 0){
    		
    		sender.sendChatToPlayer(HelpFormatter.formatList("SC", "Help", cmnds));
    		
    	}
    	
    	
    	if(arguments.length >= 1){
    		boolean found = false;
    		for (String[] prts : cmnds) {
				if(arguments[0].toLowerCase().equals(prts[0])){
					sender.sendChatToPlayer(HelpFormatter.formatCommand("SC", "Help", prts));
					found = true;
					break;
				}
			}
    		if(!found){
    			sender.sendChatToPlayer("§6" + "[SK] Could not find help message for " + arguments[0] + ".\n" +
    					"Use /shelp for list of available commands.");
    		}
    	}
    }
}
