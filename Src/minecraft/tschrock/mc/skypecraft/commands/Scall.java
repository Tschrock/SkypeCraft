package tschrock.mc.skypecraft.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import com.skype.ContactList;
import com.skype.Friend;
import com.skype.Skype;
import com.skype.SkypeException;

public class Scall   extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "scall";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	if (arguments.length > 0){
    		if (arguments[0] == "add") {
    			sender.sendChatToPlayer("This hasn't been implemented yet!");
    		}
    		else {
    			try {
    				Skype.call(arguments);
    			sender.sendChatToPlayer("Calling...");
    			} catch (SkypeException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	}
    	
    }

}
