package tschrock.mc.skypecraft.commands;

import tschrock.mc.skypecraft.SkypeCraft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import com.skype.Call;
import com.skype.Skype;
import com.skype.SkypeException;


public class Sanswer extends CommandBase
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
			if (SkypeCraft.getRingingCall().getStatus() == Call.Status.RINGING){
				SkypeCraft.getRingingCall().answer();
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
