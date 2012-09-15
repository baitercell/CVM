package craftagious.vehicleManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.plugin.Plugin;

public class VehicleDamageListener  implements Listener
{
	public Plugin plugin;
	public VehicleDamageListener(Plugin instance)
	{
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void damageCart(final VehicleDamageEvent event )
	{	
		Entity e = event.getVehicle();
		Player p = (Player) event.getAttacker();
		event.setDamage(0);
		
		new VehicleRemover(e, p);
	}
}