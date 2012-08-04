package craftagious.vehicleManager;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	Logger log;
	
	public void onDisable()
	{
		log.info("Disabled Craftagious Vehicle Manager");
	}
	public void onEnable()
	{
		log = this.getLogger();
		log.info("Craftagious Vehicle Manager has been enabled, ride away!");
		new VehicleExitListener(this);
		new VehicleEnterListener(this);
		new VehicleMoveListener(this);	
		new VehicleColisionListener(this);
	}
	
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
    	Player p = null;
    	
    	if (sender instanceof Player)
    	{
    		p = (Player) sender;
    	}
    	
    	if(cmd.getName().equalsIgnoreCase("cvm")) // If the player typed /cvm
    	{
    		if(p == null)
    		{
    			sender.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " CVM Help can only be run by a player");
    		}
    		else
    		{
    			p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " Craftagious Vehicle Manager Help");
    			p.sendMessage(" ");
    			p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " How to use:");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " Just get into a cart looking the direction you");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " want to go and CVM will make you move.");
	    		p.sendMessage(" ");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " Exiting a Cart:");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " If the rail track you are on does not have");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " obsidian at the end of the rail, just get out normally and");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " CVM will sort the cart out.");  		
	    		p.sendMessage(" ");	
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " CVM will also remove those glitchy boats!");	
	    		p.sendMessage(" ");
	    		p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.GOLD + " Thanks for using CVM");
	    		return true;
    		}
    	}
    	return false; 
    }  
}