package tschrock.mc.skypecraft;

import com.skype.Call;
import com.skype.CallAdapter;
import com.skype.ChatMessage;
import com.skype.ChatMessageAdapter;
import com.skype.Skype;
import com.skype.SkypeException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;

@Mod(modid = "SkypeCraft", name="SkypeCraft", version="0.1")
public class SkypeCraft
{
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {

        }

        @Init
        public void load(FMLInitializationEvent event) {
        	
        	//register commands        	
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Command_SHelp());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Command_SList());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Command_STell());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Command_SCall());
        	
        	//set up event listeners
        	try {
				Skype.addChatMessageListener(new ChatMessageAdapter() {
					public void chatMessageReceived(ChatMessage received){
						try {
							if (received.getType().equals(ChatMessage.Type.SAID)) {
								if (Minecraft.getMinecraft().inGameHasFocus){
									Minecraft.getMinecraft().thePlayer.sendChatToPlayer("§6" + "[SK] [§a" + received.getSenderId() + 
											"§6]: " + received.getContent());
					        	}
					        }
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			} catch (SkypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	try {
				Skype.addCallListener(new CallAdapter() {
					
					@Override
					public void callReceived(Call arg0) throws SkypeException {
						if (Minecraft.getMinecraft().inGameHasFocus){
							Minecraft.getMinecraft().thePlayer.sendChatToPlayer("§6" + "[SK] §a" + arg0.getPartnerDisplayName() + 
									"§6 is calling you. /sanswer to answer this call.");
			        	}
						ringingCall = arg0;
					}
					
					@Override
					public void callMaked(Call arg0) throws SkypeException {
						if (Minecraft.getMinecraft().inGameHasFocus){
							Minecraft.getMinecraft().thePlayer.sendChatToPlayer("§6" + "[SK] Call success!");
			        	}
					}
				});
			} catch (SkypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                
        }
        
        static Call ringingCall;
        
         final String COLOR_GEN = "§6";
         final String COLOR_NAME = "§2";
         final String COLOR_NAME2 = "§a";
         final String COLOR_NUM = "§5";
        
}