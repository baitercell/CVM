package craftagious.vehicleManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class VehicleColisionListener implements Listener
{
	public Plugin plugin;
	public VehicleColisionListener(Plugin instance)
	{
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}


	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
	public void MoveCart(final VehicleBlockCollisionEvent event )
	{	
		Block b = event.getBlock();
		Entity e = event.getVehicle();
		
		Player p = null;
		int pos;
		
		p = (Player) event.getVehicle().getPassenger();
		
		
		if( e instanceof Minecart )
		{ 
			if(b.getType() == Material.OBSIDIAN)
			{
				e.remove();	
				pos = p.getInventory().firstEmpty();
				
				if(pos != -1) //if there is a space
				{
					p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.BLUE + "Cart added to first empty slot");
					p.getInventory().setItem(pos, new ItemStack(Material.MINECART, 1));
					p.getPlayer().updateInventory() ;
				}
				else //if there is no space
				{
					p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.BLUE + "Inventory full, cart dropped on ground");
					p.getLocation().getWorld().dropItem(p.getLocation(), new ItemStack(Material.MINECART, 1));
				}
			}			
		}	
	}	
}