package craftagious.vehicleManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VehicleRemover
{
	@SuppressWarnings("deprecation")
	public VehicleRemover(Entity e, Player p)
	{
		int pos = 0;
		
		if( e instanceof Minecart )
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
			
		if(e instanceof Boat)
		{
			e.remove();	
			pos = p.getInventory().firstEmpty();
				
			if(pos != -1) //if there is a space
			{
				p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.BLUE + "Boat added to first empty slot");
				p.getInventory().setItem(pos, new ItemStack(Material.BOAT, 1));
				p.getPlayer().updateInventory() ;
			}
				
			else //if there is no space
			{
				p.sendMessage(ChatColor.GREEN + "[CVM]" + ChatColor.BLUE + "Inventory full, boat dropped on ground");
				p.getLocation().getWorld().dropItem(p.getLocation(), new ItemStack(Material.BOAT, 1));
			}
		}
	}


	
	
}
