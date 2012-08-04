package craftagious.vehicleManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.plugin.Plugin;

public class VehicleColisionListener implements Listener
{
	public Plugin plugin;
	public VehicleColisionListener(Plugin instance)
	{
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}


	@EventHandler(priority = EventPriority.NORMAL)
	public void MoveCart(final VehicleBlockCollisionEvent event )
	{	
		Block b = event.getBlock();
		Entity e = event.getVehicle();
		Player p = (Player) event.getVehicle().getPassenger();
		
		
		if(b.getType() == Material.OBSIDIAN)
		{
			new VehicleRemover(e, p);
		}
	}	
}