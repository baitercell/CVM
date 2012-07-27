package craftagious.vehicleManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class VehicleMoveListener implements Listener
{
	public Plugin plugin;
	public VehicleMoveListener(Plugin instance)
	{
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}


	@EventHandler(priority = EventPriority.NORMAL)
	public void MoveCart(final VehicleMoveEvent event )
	{	
		//System.out.println("Move speed " + event.getVehicle().getVelocity().length());
		//Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say " + "Move speed " + event.getVehicle().getVelocity().length()); 
		
		Entity e = event.getVehicle();
		Vector v = e.getVelocity();	
		if(e instanceof Minecart)
		{
			if(e.getVelocity().length() < 0.3) //if its slow, stop the cart
			{
				e.setVelocity(v.add(v.multiply(0)));
			}	
			else if(e.getVelocity().length() < 0.4) //if it is moving, keep it moving
			{
				//System.out.println("less than 1 speed " + event.getVehicle().getVelocity().length());
				//Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say " + "less than 1 speed " + event.getVehicle().getVelocity().length());   	
				
				
				e.setVelocity(v.add(v.multiply(1)));	
			}	
			else if (e.getVelocity().length() > 1)
			{
				//System.out.println("over speed " + event.getVehicle().getVelocity().length());
				//Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "say " + "over speed " + event.getVehicle().getVelocity().length());   	
				
				e.setVelocity(v.add(v.multiply(-0.4)));
			}
		}	
	}
}
