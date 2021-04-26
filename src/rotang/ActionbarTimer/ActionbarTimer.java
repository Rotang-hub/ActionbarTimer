package rotang.ActionbarTimer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import rotang.ActionbarTimer.manager.Manager;

public class ActionbarTimer extends JavaPlugin
{
	private Manager manager;
	
	@Override
	public void onEnable() 
	{
		if(manager == null)
			manager = new Manager();
		
		getCommand("atimer").setTabCompleter(new CommandTab());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(label.equalsIgnoreCase("atimer"))
		{
			if(args[0].equalsIgnoreCase("settime"))
			{
				int hour = Integer.parseInt(args[1]);
				int minute = Integer.parseInt(args[2]);
				int second = Integer.parseInt(args[3]);
				
				manager.setTime(hour, minute, second);
				
				sender.sendMessage(ChatColor.GREEN + "[Actionbar Timer] 타이머를 " + ChatColor.YELLOW 
						+ hour + "시간 " + minute + "분 " + second + ChatColor.GREEN + "초로 설정했습니다.");
			}
			
			if(args[0].equalsIgnoreCase("start"))
			{
				manager.start();
			}
			
			if(args[0].equalsIgnoreCase("stop"))
			{
				manager.stop();
			}
		}
		
		return false;
	}
}
