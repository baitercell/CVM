package craftagious.vehicleManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class VehicleEnterListener implements Listener
{
	public Plugin plugin;
	public VehicleEnterListener(Plugin instance)
	{
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void EnterCart(final VehicleEnterEvent event )
	{	
		Entity e = event.getVehicle(); //get the vehicle
		Vector dir = event.getEntered().getLocation().getDirection(); //get who entered it and what direction they were looking

		if( e instanceof Minecart)
		{
			e.setVelocity(dir.multiply(1));
		}
		
	}

}
