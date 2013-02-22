package tschrock.mc.skypecraft;

import com.skype.ContactList;
import com.skype.Friend;
import com.skype.Skype;
import com.skype.SkypeException;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class Command_SList  extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "slist";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments)
    {
    	sender.sendChatToPlayer("1");
    	//Getting all the contact list for log in Skype
        ContactList list;
        String skypefriends;
        skypefriends = "";
    	sender.sendChatToPlayer("2");
		try {
			list = Skype.getContactList();
	    	sender.sendChatToPlayer("3");
	        Friend fr[] = list.getAllFriends();
	    	sender.sendChatToPlayer("4");
	        //Printing the no of friends Skype have
	        sender.sendChatToPlayer("§6[SK] You Have §5" + fr.length + "§6 Friends:");
	        //Iterating through friends list
	        for(int i=0; i < fr.length; i++)
	        {
	          Friend f = fr[i];
	          //Getting the friend ID
	          skypefriends += "§2" + f.getFullName() + " (§a" + f.getId() +"§2), ";
	         }
    	sender.sendChatToPlayer(skypefriends);
		} catch (SkypeException e) {
	    	sender.sendChatToPlayer("Could not get List: " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        //sender.sendChatToPlayer("This hasn't been implemented yet!");
    }
}
