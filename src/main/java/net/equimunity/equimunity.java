package net.equimunity;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Mule;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


import java.io.File;
import java.io.IOException;
import java.util.Random;

public class equimunity extends JavaPlugin {
    private File configConfigFile;
    private FileConfiguration configConfig;


    @Override
    public void onEnable() {
        drinkLoop1(this);
        hungerLoop(this);
        thirstLoop(this);
        eatLoop1(this);
        drinkLoop2(this);
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getServer().getPluginManager().registerEvents(new HorseGUI(this), this);
        this.getCommand("h").setExecutor(new Commands(this));
        createCustomConfig();
        getLogger().info(ChatColor.GREEN + "Plugin Has Been Enabled!");

    }

    public void hungerLoop(Plugin plugin) {
        new BukkitRunnable() {
            public void run() {
                World world = getServer().getWorld("world");
                for (Entity e : world.getEntities()) {
                    Random rnd = new Random();
                    int i = rnd.nextInt(100);
                    if (e instanceof Horse) {
                        if (i <= 10) {
                            for (String brds : configConfig.getStringList("Hunger")) {
                                if (e.getScoreboardTags().contains("f" + brds)) {
                                    int hunger = Integer.parseInt(brds) - 10;
                                    if (Integer.parseInt(brds) <= 0) {
                                        ((Horse) e).setHealth(0);
                                        break;
                                    } else {
                                        e.removeScoreboardTag("f" + brds);
                                        e.addScoreboardTag("f" + hunger);
                                        if (!e.getScoreboardTags().contains("Hunger")) {
                                            e.addScoreboardTag("Hunger");
                                            break;
                                        }
                                    }

                                }
                            }

                        } break;
                    } if (e instanceof Donkey) {
                        if (i <= 10) {
                            for (String brds : configConfig.getStringList("Hunger")) {
                                if (e.getScoreboardTags().contains("f" + brds)) {
                                    int hunger = Integer.parseInt(brds) - 10;
                                    if (Integer.parseInt(brds) <= 0) {
                                        ((Donkey) e).setHealth(0);
                                        break;
                                    } else {
                                        e.removeScoreboardTag("f" + brds);
                                        e.addScoreboardTag("f" + hunger);
                                        if (!e.getScoreboardTags().contains("Hunger")) {
                                            e.addScoreboardTag("Hunger");
                                            break;
                                        }
                                    }

                                }
                            }

                        } break;
                    } if (e instanceof Mule) {
                        if (i <= 10) {
                            for (String brds : configConfig.getStringList("Hunger")) {
                                if (e.getScoreboardTags().contains("f" + brds)) {
                                    int hunger = Integer.parseInt(brds) - 10;
                                    if (Integer.parseInt(brds) <= 0) {
                                        ((Mule) e).setHealth(0);
                                        break;
                                    } else {
                                        e.removeScoreboardTag("f" + brds);
                                        e.addScoreboardTag("f" + hunger);
                                        if (!e.getScoreboardTags().contains("Hunger")) {
                                            e.addScoreboardTag("Hunger");
                                            break;
                                        }
                                    }

                                }
                            }

                        }
                    } break;
                }
            }
        }.runTaskTimer(plugin, 40000, 40000);
    }

    public void thirstLoop(Plugin plugin) {
        new BukkitRunnable() {
            public void run() {
                World world = getServer().getWorld("world");
                for (Entity e : world.getEntities()) {
                    Random rnd = new Random();
                    int i = rnd.nextInt(100);
                    if (e instanceof Horse) {
                        if (i <= 10) {
                            for (String brds : configConfig.getStringList("Thirst")) {
                                if (e.getScoreboardTags().contains("t" + brds)) {
                                    int hunger = Integer.parseInt(brds) - 10;
                                    if (Integer.parseInt(brds) <= 0) {
                                        ((Horse) e).setHealth(0);
                                        break;
                                    } else {
                                        e.removeScoreboardTag("t" + brds);
                                        e.addScoreboardTag("t" + hunger);
                                        if (!e.getScoreboardTags().contains("Thirst")) {
                                            e.addScoreboardTag("Thirst");
                                            break;
                                        }
                                    }

                                }
                            }

                        } break;
                    } if (e instanceof Donkey) {
                        if (i <= 10) {
                            for (String brds : configConfig.getStringList("Thirst")) {
                                if (e.getScoreboardTags().contains("t" + brds)) {
                                    int hunger = Integer.parseInt(brds) - 10;
                                    if (Integer.parseInt(brds) <= 0) {
                                        ((Donkey) e).setHealth(0);
                                        break;
                                    } else {
                                        e.removeScoreboardTag("t" + brds);
                                        e.addScoreboardTag("t" + hunger);
                                        if (!e.getScoreboardTags().contains("Thirst")) {
                                            e.addScoreboardTag("Thirst");
                                            break;
                                        }
                                    }

                                }
                            }

                        } break;
                    } if (e instanceof Mule) {
                        if (i <= 10) {
                            for (String brds : configConfig.getStringList("Thirst")) {
                                if (e.getScoreboardTags().contains("t" + brds)) {
                                    int hunger = Integer.parseInt(brds) - 10;
                                    if (Integer.parseInt(brds) <= 0) {
                                        ((Mule) e).setHealth(0);
                                        break;
                                    } else {
                                        e.removeScoreboardTag("t" + brds);
                                        e.addScoreboardTag("t" + hunger);
                                        if (!e.getScoreboardTags().contains("Thirst")) {
                                            e.addScoreboardTag("Thirst");
                                            break;
                                        }
                                    }

                                }
                            }

                        }
                    }break;
                }
            }
        }.runTaskTimer(plugin, 20000, 20000);
    }
    public void drinkLoop2(Plugin plugin) {
        new BukkitRunnable() {
            public void run() {
                World world = getServer().getWorld("world");
                for (Entity e : world.getEntities()) {
                    if (e instanceof Horse) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Thirst")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.CAULDRON) {
                                            System.out.println("Cauldron");
                                            Levelled c = (Levelled) block.getBlockData();
                                            if (c.getLevel() == 3) {
                                                System.out.println("Cauldron full");
                                                ((Horse) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        System.out.println("Drank C");
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    e.addScoreboardTag("t100");
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(2);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            } if (c.getLevel() == 2) {
                                                ((Horse) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    e.addScoreboardTag("t100");
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(1);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            } if (c.getLevel() == 1) {
                                                ((Horse) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    e.addScoreboardTag("t100");
                                                    if (i <= 35) {
                                                        c.setLevel(0);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } if (e instanceof Donkey) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Thirst")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.CAULDRON) {
                                            System.out.println("Cauldron");
                                            Levelled c = (Levelled) block.getBlockData();
                                            if (c.getLevel() == 3) {
                                                System.out.println("Cauldron full");
                                                ((Donkey) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    e.addScoreboardTag("t100");
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(2);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            } if (c.getLevel() == 2) {
                                                ((Donkey) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.addScoreboardTag("t100");
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(1);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            } if (c.getLevel() == 1) {
                                                ((Donkey) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.addScoreboardTag("t100");
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(0);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } if (e instanceof Mule) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Thirst")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.CAULDRON) {
                                            System.out.println("Cauldron");
                                            Levelled c = (Levelled) block.getBlockData();
                                            if (c.getLevel() == 3) {
                                                System.out.println("Cauldron full");
                                                ((Mule) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.addScoreboardTag("t100");
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(2);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            } if (c.getLevel() == 2) {
                                                ((Mule) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.addScoreboardTag("t100");
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(1);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            } if (c.getLevel() == 1) {
                                                ((Mule) e).getPathfinder().findPath(loc2);
                                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                    for (String brds : configConfig.getStringList("Thirst")) {
                                                        e.removeScoreboardTag("t" + brds);
                                                        e.addScoreboardTag("t100");
                                                        e.removeScoreboardTag("Thirst");
                                                    }
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 35) {
                                                        c.setLevel(0);
                                                        block.setBlockData(c);
                                                    }

                                                }, 100);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 600);
    }

    public void drinkLoop1(Plugin plugin) {
        new BukkitRunnable() {
            public void run() {
                World world = getServer().getWorld("world");
                for (Entity e : world.getEntities()) {
                    if (e instanceof Horse) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Thirst")) {
                            String name = e.getCustomName();
                            Location loca = e.getLocation();
                            System.out.println(name + " Has thirst");
                            System.out.println(loca);
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.WATER) {
                                            System.out.println("Water");
                                            ((Horse) e).getPathfinder().findPath(loc2);
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                for (String brds : configConfig.getStringList("Thirst")) {
                                                    e.removeScoreboardTag("t" + brds);
                                                    e.addScoreboardTag("t100");
                                                    e.removeScoreboardTag("Thirst");
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 25) {
                                                        block.setType(Material.AIR);
                                                    }
                                                    System.out.println("Drank");
                                                    break;
                                                }

                                            }, 100);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } if (e instanceof Donkey) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Thirst")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.WATER) {
                                            ((Donkey) e).getPathfinder().findPath(loc2);
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                for (String brds : configConfig.getStringList("Thirst")) {
                                                    e.removeScoreboardTag("t" + brds);
                                                    e.addScoreboardTag("t100");
                                                    e.removeScoreboardTag("Thirst");
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 25) {
                                                        block.setType(Material.AIR);
                                                    }
                                                    break;
                                                }

                                            }, 100);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } if (e instanceof Mule) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Thirst")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.WATER) {
                                            ((Mule) e).getPathfinder().findPath(loc2);
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                for (String brds : configConfig.getStringList("Thirst")) {
                                                    e.removeScoreboardTag("t" + brds);
                                                    e.addScoreboardTag("t100");
                                                    e.removeScoreboardTag("Thirst");
                                                    Random rnd = new Random();
                                                    int i = rnd.nextInt(100);
                                                    if (i <= 25) {
                                                        block.setType(Material.AIR);
                                                    }
                                                    break;
                                                }

                                            }, 100);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 500);
    }

    public void eatLoop1(Plugin plugin) {
        new BukkitRunnable() {
            public void run() {
                World world = getServer().getWorld("world");
                for (Entity e : world.getEntities()) {
                    if (e instanceof Horse) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Hunger")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.HAY_BLOCK) {
                                            ((Horse) e).getPathfinder().findPath(loc2);
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                for (String brds : configConfig.getStringList("Hunger")) {
                                                    e.removeScoreboardTag("f" + brds);
                                                    e.addScoreboardTag("f100");
                                                    e.removeScoreboardTag("Hunger");
                                                    block.setType(Material.AIR);
                                                    break;
                                                }

                                            }, 100);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } if (e instanceof Donkey) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Hunger")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.HAY_BLOCK) {
                                            ((Donkey) e).getPathfinder().findPath(loc2);
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                for (String brds : configConfig.getStringList("Hunger")) {
                                                    e.removeScoreboardTag("f" + brds);
                                                    e.addScoreboardTag("f100");
                                                    e.removeScoreboardTag("Hunger");
                                                    block.setType(Material.AIR);
                                                    break;
                                                }

                                            }, 100);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } if (e instanceof Mule) {
                        Location loc = e.getLocation();
                        int radius = 4;
                        if (e.getScoreboardTags().contains("Hunger")) {
                            for (int x = -radius; x <= radius; x++) {
                                for (int y = -radius; y <= radius; y++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        Block block = world.getBlockAt(loc.getBlockX() + x, loc.getBlockY() + y, loc.getBlockZ() + z);
                                        Location loc2 = block.getLocation();
                                        Material bt = block.getType();
                                        if (bt == Material.HAY_BLOCK) {
                                            ((Mule) e).getPathfinder().findPath(loc2);
                                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                                for (String brds : configConfig.getStringList("Hunger")) {
                                                    e.removeScoreboardTag("f" + brds);
                                                    e.addScoreboardTag("f100");
                                                    e.removeScoreboardTag("Hunger");
                                                    block.setType(Material.AIR);
                                                    break;
                                                }

                                            }, 100);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 500);
    }

    public FileConfiguration getBreedsConfig() {
        return this.configConfig;
    }

    private void createCustomConfig() {
        configConfigFile = new File(getDataFolder(), "Config.yml");
        if (!configConfigFile.exists()) {
            configConfigFile.getParentFile().mkdirs();
            saveResource("Config.yml", false);
        }
        configConfig = new YamlConfiguration();
        try {
            configConfig.load(configConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void onDisable() {
        getLogger().info("Plugin Has Been Disabled!  Good Bye!");
    }
}
