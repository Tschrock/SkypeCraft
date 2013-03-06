package tschrock.mc.skypecraft.chatformatter;

public class HelpFormatter {
	
	public static String formatList(String tag, String msg, String[][] commands) {
		
		String chtMsg = ChatFormats.GOLD + "[" + tag + "] " + msg + ":" + ChatFormats.NEWLINE;
		
		for (String[] parts : commands) {
			if(parts.length == 3){
				chtMsg += "    " + ChatFormats.YELLOW + "/" + parts[0] + ":" + 
						ChatFormats.GOLD + parts[2] + ChatFormats.RESET + ChatFormats.NEWLINE;
			}
		}
		
		return chtMsg;
		
	}
	
	public static String formatCommand(String tag, String msg, String[] cmnd) {

		String chtMsg = ChatFormats.GOLD + "[" + tag + "] " + msg + ": " + ChatFormats.YELLOW +
				" /" + cmnd[0] + ChatFormats.RESET + ChatFormats.NEWLINE;
		
		chtMsg += ChatFormats.GOLD + "   Usage: " + cmnd[1] + ChatFormats.NEWLINE;
		chtMsg += "   " + cmnd[2] + ChatFormats.NEWLINE;
		
		return chtMsg;
		
	}

}
