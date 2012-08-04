package craftagious.vehicleManager;


import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.plugin.Plugin;


public class VehicleExitListener implements Listener
{
	public Plugin plugin;
	public VehicleExitListener(Plugin instance)
	{
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void RemoveCart(final VehicleExitEvent event )
	{	
		Entity e = event.getVehicle();
		Player p = (Player) event.getExited();
		
		new VehicleRemover(e, p);
	}
}
