package tschrock.mc.skypecraft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import com.skype.Skype;
import com.skype.SkypeException;

public class Command_STell  extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "stell";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	String msg;
    	msg = "";
    	for(int mi = 1; mi < arguments.length; mi++){
    	msg += arguments[mi] + " ";
    	}
    	try {
			Skype.chat(arguments[0]).send(msg);
			sender.sendChatToPlayer("§6[SK] Sent §e\"" + msg + "\"§6 to §a" + arguments[0]);
		} catch (SkypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // sender.sendChatToPlayer("This hasn't been implemented yet!");
    }
}
