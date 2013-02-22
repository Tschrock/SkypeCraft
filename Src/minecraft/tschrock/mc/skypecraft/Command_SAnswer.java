package tschrock.mc.skypecraft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import com.skype.Call;
import com.skype.Skype;
import com.skype.SkypeException;


public class Command_SAnswer  extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "sanswer";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	try {
			if (SkypeCraft.ringingCall.getStatus() == Call.Status.RINGING){
				SkypeCraft.ringingCall.answer();
			}
			else {
    			sender.sendChatToPlayer("No call to answer!");				
			}
		} catch (SkypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
