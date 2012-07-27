package craftagious.vehicleManager;

import java.util.logging.Logger;

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
}