package tschrock.mc.skypecraft.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import com.skype.Call;
import com.skype.Skype;
import com.skype.Profile;
import com.skype.SkypeException;

public class Sstatus extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "sstatus";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	Profile.Status thestatus = null;
    	if (arguments.length > 0){
    		if(arguments[0].toLowerCase().equals("online")) thestatus = Profile.Status.ONLINE;
    		if(arguments[0].toLowerCase().equals("away")) thestatus = Profile.Status.AWAY;
    		if(arguments[0].toLowerCase().equals("invisible")) thestatus = Profile.Status.INVISIBLE;
    		if(arguments[0].toLowerCase().equals("offline")) thestatus = Profile.Status.OFFLINE;
    		if(arguments[0].toLowerCase().equals("dnd")) thestatus = Profile.Status.DND;

        	if (arguments.length > 2){
        		if((arguments[0] + " " + arguments[1] + " " + arguments[2]).toLowerCase() == "do not disturb") thestatus = Profile.Status.DND;
        	}
    	}
    	if(thestatus == null) {
    		sender.sendChatToPlayer("§6" + "[SK] Help for /sstatus: " + "§6\n" +
    				"Usage: /sstatus {online|away|do not disturb|invisible|offline}"+ "\n"+
    				"Changes you skype status.");
    	}
    	else {
    		try {
    			Skype.getProfile().setStatus(thestatus);
    			sender.sendChatToPlayer("Your status is " + Skype.getProfile().getStatus().toString().toLowerCase());
    		} catch (SkypeException e) {
    			e.printStackTrace();
    		}
    	}
    }   
}
