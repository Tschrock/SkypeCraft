package tschrock.mc.skypecraft;

import tschrock.mc.skypecraft.commands.*;

import com.skype.Call;
import com.skype.CallAdapter;
import com.skype.ChatMessage;
import com.skype.ChatMessageAdapter;
import com.skype.CommandFailedException;
import com.skype.Skype;
import com.skype.SkypeClient;
import com.skype.SkypeException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.ServerStopping;
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
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Shelp());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Slist());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Stell());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Scall());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Sstatus());
        	tschrock.mc.clientcommands.mod_ClientCommands.getInstance().registerCommand(new Sanswer());
        	
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
						setRingingCall(arg0);
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
        
        @ServerStarting
        public void serverStarting(FMLServerStartingEvent event) {
        	
        	//Try to enable silent mode to prevent popups - !This only works on Windows!
        	try {
				SkypeClient.setSilentMode(true);
			} catch (CommandFailedException cfe) {
				
			} catch (SkypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
        }

        @ServerStopping
        public void serverStopping(FMLServerStoppingEvent event) {
        	
        	//Try to disable silent mode to allow popups - !This only works on Windows!
        	try {
				SkypeClient.setSilentMode(false);
			} catch (CommandFailedException cfe) {
				
			} catch (SkypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
        }
        
        
        
        
        /**
		 * @return the ringingCall
		 */
		public static Call getRingingCall() {
			return ringingCall;
		}

		/**
		 * @param ringingCall the ringingCall to set
		 */
		public static void setRingingCall(Call ringingCall) {
			SkypeCraft.ringingCall = ringingCall;
		}

		private static Call ringingCall;
        
}