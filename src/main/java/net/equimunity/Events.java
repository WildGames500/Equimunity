package net.equimunity;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static org.bukkit.Bukkit.getOfflinePlayers;
import static org.bukkit.Bukkit.getServer;

public class Events implements Listener {
    public static HashMap<UUID, UUID> collection = new HashMap<UUID, UUID>();
    private equimunity plugin;
    public Events(equimunity plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        if (e.getEntityType() == EntityType.HORSE) {
            if (!e.getEntity().getScoreboardTags().contains("CS")) {
                ((Horse) e.getEntity()).setTamed(true);
                e.getEntity().addScoreboardTag("f100");
                e.getEntity().addScoreboardTag("t100");
                e.getEntity().addScoreboardTag("CS");
                List<String> list = plugin.getBreedsConfig().getStringList("Breeds");
                int index = new Random().nextInt(list.size());
                String brds = list.get(index);
                e.getEntity().addScoreboardTag("Breed:" + brds);
                List<String> list2 = plugin.getBreedsConfig().getStringList("Genders");
                int indexs = new Random().nextInt(list2.size());
                String grds = list2.get(indexs);
                e.getEntity().addScoreboardTag("Gender:" + grds);
                e.getEntity().addScoreboardTag("Age: 4years");
                double min = 0.00;
                double max = 5.99;
                Random r = new Random();
                double randomValue = min + (max - min) * r.nextDouble();
                BigDecimal roundOff = new BigDecimal(randomValue).setScale(2, RoundingMode.HALF_DOWN);
                e.getEntity().addScoreboardTag("jump:" + roundOff);
                double min1 = 0.00;
                double max1 = 15.99;
                Random r1 = new Random();
                double randomValue1 = min1 + (max1 - min1) * r1.nextDouble();
                BigDecimal roundOff1 = new BigDecimal(randomValue1).setScale(2, RoundingMode.HALF_DOWN);
                e.getEntity().addScoreboardTag("speed:" + roundOff1);
                double sp = randomValue1 * .030;
                ((Horse) e.getEntity()).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(sp);
                if (randomValue <= 0.99) {
                    if (randomValue >= 0.50) {
                        double j = randomValue * 0.34;
                        ((Horse) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 0.49) {
                        double j = randomValue * 0.32;
                        ((Horse) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 1.99) {
                    if (randomValue >= 1.50) {
                        double j = randomValue * 0.34;
                        ((Horse) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 1.49) {
                        double j = randomValue * 0.30;
                        ((Horse) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 2.99) {
                    if (randomValue >= 2.50) {
                        double j = randomValue * 0.26;
                        ((Horse) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 2.49) {
                        double j = randomValue * 0.24;
                        ((Horse) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 3.99) {
                    if (randomValue >= 3.50) {
                        double j = randomValue * 0.24;
                        ((Horse) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 3.49) {
                        double j = randomValue * 0.22;
                        ((Horse) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 4.99) {
                    if (randomValue >= 4.50) {
                        double j = randomValue * 0.22;
                        ((Horse) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 4.49) {
                        double j = randomValue * 0.22;
                        ((Horse) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 5.99) {
                    if (randomValue >= 5.50) {
                        double j = randomValue * 0.20;
                        ((Horse) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 5.49) {
                        double j = randomValue * 0.20;
                        ((Horse) e.getEntity()).setJumpStrength(j);
                    }
                }
            }
        }if (e.getEntityType() == EntityType.DONKEY) {
            if (!e.getEntity().getScoreboardTags().contains("CS")) {
                ((Donkey) e.getEntity()).setTamed(true);
                e.getEntity().addScoreboardTag("f100");
                e.getEntity().addScoreboardTag("t100");
                e.getEntity().addScoreboardTag("CS");
                e.getEntity().addScoreboardTag("Breed:Donkey");
                List<String> list2 = plugin.getBreedsConfig().getStringList("Genders");
                int indexs = new Random().nextInt(list2.size());
                String grds = list2.get(indexs);
                e.getEntity().addScoreboardTag("Gender:" + grds);
                e.getEntity().addScoreboardTag("Age: 4years");
                double min = 0.00;
                double max = 5.99;
                Random r = new Random();
                double randomValue = min + (max - min) * r.nextDouble();
                BigDecimal roundOff = new BigDecimal(randomValue).setScale(2, RoundingMode.HALF_DOWN);
                e.getEntity().addScoreboardTag("jump:" + roundOff);
                double min1 = 0.00;
                double max1 = 15.99;
                Random r1 = new Random();
                double randomValue1 = min1 + (max1 - min1) * r1.nextDouble();
                BigDecimal roundOff1 = new BigDecimal(randomValue1).setScale(2, RoundingMode.HALF_DOWN);
                e.getEntity().addScoreboardTag("speed:" + roundOff1);
                double sp = randomValue1 * .030;
                ((Donkey) e.getEntity()).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(sp);
                if (randomValue <= 0.99) {
                    if (randomValue >= 0.50) {
                        double j = randomValue * 0.34;
                        ((Donkey) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 0.49) {
                        double j = randomValue * 0.32;
                        ((Donkey) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 1.99) {
                    if (randomValue >= 1.50) {
                        double j = randomValue * 0.34;
                        ((Donkey) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 1.49) {
                        double j = randomValue * 0.30;
                        ((Donkey) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 2.99) {
                    if (randomValue >= 2.50) {
                        double j = randomValue * 0.26;
                        ((Donkey) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 2.49) {
                        double j = randomValue * 0.24;
                        ((Donkey) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 3.99) {
                    if (randomValue >= 3.50) {
                        double j = randomValue * 0.24;
                        ((Donkey) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 3.49) {
                        double j = randomValue * 0.22;
                        ((Donkey) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 4.99) {
                    if (randomValue >= 4.50) {
                        double j = randomValue * 0.22;
                        ((Donkey) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 4.49) {
                        double j = randomValue * 0.22;
                        ((Donkey) e.getEntity()).setJumpStrength(j);
                    }
                }
                if (randomValue <= 5.99) {
                    if (randomValue >= 5.50) {
                        double j = randomValue * 0.20;
                        ((Donkey) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 5.49) {
                        double j = randomValue * 0.20;
                        ((Donkey) e.getEntity()).setJumpStrength(j);
                    }
                }
            }
        } if (e.getEntityType() == EntityType.MULE) {
            if (!e.getEntity().getScoreboardTags().contains("CS")) {
                ((Mule) e.getEntity()).setTamed(true);
                e.getEntity().addScoreboardTag("f100");
                e.getEntity().addScoreboardTag("t100");
                e.getEntity().addScoreboardTag("CS");
                e.getEntity().addScoreboardTag("Breed:Mule");
                List<String> list2 = plugin.getBreedsConfig().getStringList("Genders");
                int indexs = new Random().nextInt(list2.size());
                String grds = list2.get(indexs);
                e.getEntity().addScoreboardTag("Gender:" + grds);
                e.getEntity().addScoreboardTag("Age: 4years");
                double min = 0.00;
                double max = 5.99;
                Random r = new Random();
                double randomValue = min + (max - min) * r.nextDouble();
                BigDecimal roundOff = new BigDecimal(randomValue).setScale(2, RoundingMode.HALF_DOWN);
                e.getEntity().addScoreboardTag("jump:" + roundOff);
                double min1 = 0.00;
                double max1 = 15.99;
                Random r1 = new Random();
                double randomValue1 = min1 + (max1 - min1) * r1.nextDouble();
                BigDecimal roundOff1 = new BigDecimal(randomValue1).setScale(2, RoundingMode.HALF_DOWN);
                e.getEntity().addScoreboardTag("speed:" + roundOff1);
                double sp = randomValue1 * .030;
                ((Mule) e.getEntity()).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(sp);
                if (randomValue <= 0.99) {
                    if (randomValue >= 0.50) {
                        double j = randomValue * 0.34;
                        ((Mule) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 0.49) {
                        double j = randomValue * 0.32;
                        ((Mule) e.getEntity()).setJumpStrength(j);
                    }
                } if (randomValue <= 1.99) {
                    if (randomValue >= 1.50) {
                        double j = randomValue * 0.34;
                        ((Mule) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 1.49) {
                        double j = randomValue * 0.30;
                        ((Mule) e.getEntity()).setJumpStrength(j);
                    }
                } if (randomValue <= 2.99) {
                    if (randomValue >= 2.50) {
                        double j = randomValue * 0.26;
                        ((Mule) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 2.49) {
                        double j = randomValue * 0.24;
                        ((Mule) e.getEntity()).setJumpStrength(j);
                    }
                } if (randomValue <= 3.99) {
                    if (randomValue >= 3.50) {
                        double j = randomValue * 0.24;
                        ((Mule) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 3.49) {
                        double j = randomValue * 0.22;
                        ((Mule) e.getEntity()).setJumpStrength(j);
                    }
                } if (randomValue <= 4.99) {
                    if (randomValue >= 4.50) {
                        double j = randomValue * 0.22;
                        ((Mule) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 4.49) {
                        double j = randomValue * 0.22;
                        ((Mule) e.getEntity()).setJumpStrength(j);
                    }
                } if (randomValue <= 5.99) {
                    if (randomValue >= 5.50) {
                        double j = randomValue * 0.20;
                        ((Mule) e.getEntity()).setJumpStrength(j);

                    }
                    if (randomValue >= 5.49) {
                        double j = randomValue * 0.20;
                        ((Mule) e.getEntity()).setJumpStrength(j);
                    }
                }
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onMount(PlayerInteractEntityEvent e) {
        Entity h = e.getRightClicked();
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        if (h.getScoreboardTags().contains("Owner:" + uuid)) {
            if (p.getItemInHand().getType() == Material.WHEAT) {
                for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                    if (h.getScoreboardTags().contains("f" + brds)) {
                        if (Integer.parseInt(brds) > 100) {
                            int hunger = Integer.parseInt(brds) + 10;
                            h.removeScoreboardTag("f" + brds);
                            h.addScoreboardTag("f" + hunger);
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+10 Hunger");
                            p.getInventory().remove(Material.WHEAT);
                            e.setCancelled(true);

                        } else {
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            } if (p.getItemInHand().getType() == Material.HAY_BLOCK) {
                for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                    if (h.getScoreboardTags().contains("f" + brds)) {
                        if (Integer.parseInt(brds) < 100) {
                            int hunger = Integer.parseInt(brds) + 20;
                            if (hunger > 100) {
                                h.removeScoreboardTag("f" + brds);
                                h.addScoreboardTag("f" + 100);
                            } else {
                                h.removeScoreboardTag("f" + brds);
                                h.addScoreboardTag("f" + hunger);
                            }
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+20 Hunger");
                            p.getInventory().remove(Material.HAY_BLOCK);
                            e.setCancelled(true);

                        } else {
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            } if (p.getItemInHand().getType() == Material.WATER_BUCKET) {
                for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                    if (h.getScoreboardTags().contains("t" + brds)) {
                        if (Integer.parseInt(brds) > 100) {
                            int hunger = Integer.parseInt(brds) + 10;
                            h.removeScoreboardTag("t" + brds);
                            h.addScoreboardTag("t" + hunger);
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+10 Thirst");
                            p.getInventory().remove(Material.WATER_BUCKET);
                            e.setCancelled(true);

                        } else {
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            }
        } if (h.getScoreboardTags().contains("Trusted:" + uuid)) {
            if (p.getItemInHand().getType() == Material.WHEAT) {
                for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                    if (h.getScoreboardTags().contains("f" + brds)) {
                        if (Integer.parseInt(brds) > 100) {
                            int hunger = Integer.parseInt(brds) + 10;
                            h.removeScoreboardTag("f" + brds);
                            h.addScoreboardTag("f" + hunger);
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+10 Hunger");
                            p.getInventory().remove(Material.WHEAT);
                            e.setCancelled(true);

                        } else {
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            } if (p.getItemInHand().getType() == Material.HAY_BLOCK) {
                for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                    if (h.getScoreboardTags().contains("f" + brds)) {
                        if (Integer.parseInt(brds) < 100) {
                            int hunger = Integer.parseInt(brds) + 20;
                            if (hunger > 100) {
                                h.removeScoreboardTag("f" + brds);
                                h.addScoreboardTag("f" + 100);
                            } else {
                                h.removeScoreboardTag("f" + brds);
                                h.addScoreboardTag("f" + hunger);
                            }
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+20 Hunger");
                            p.getInventory().remove(Material.HAY_BLOCK);
                            e.setCancelled(true);

                        } else {
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            } if (p.getItemInHand().getType() == Material.WATER_BUCKET) {
                for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                    if (h.getScoreboardTags().contains("t" + brds)) {
                        if (Integer.parseInt(brds) > 100) {
                            int hunger = Integer.parseInt(brds) + 10;
                            h.removeScoreboardTag("t" + brds);
                            h.addScoreboardTag("t" + hunger);
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+10 Thirst");
                            p.getInventory().remove(Material.WATER_BUCKET);
                            e.setCancelled(true);

                        } if (Integer.parseInt(brds) == 100) {
                            h.removeScoreboardTag("Thirst");
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            }
        } if (p.hasPermission("h.op")) {
            if (p.getItemInHand().getType() == Material.WHEAT) {
                for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                    if (h.getScoreboardTags().contains("f" + brds)) {
                        if (Integer.parseInt(brds) > 100) {
                            int hunger = Integer.parseInt(brds) + 10;
                            h.removeScoreboardTag("f" + brds);
                            h.addScoreboardTag("f" + hunger);
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+10 Hunger");
                            p.getInventory().remove(Material.WHEAT);
                            e.setCancelled(true);

                        } if (Integer.parseInt(brds) == 100) {
                            h.removeScoreboardTag("Hunger");
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            } if (p.getItemInHand().getType() == Material.HAY_BLOCK) {
                for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                    if (h.getScoreboardTags().contains("f" + brds)) {
                        if (Integer.parseInt(brds) < 100) {
                            int hunger = Integer.parseInt(brds) + 20;
                            if (hunger > 100) {
                                h.removeScoreboardTag("f" + brds);
                                h.addScoreboardTag("f" + 100);
                            } else {
                                h.removeScoreboardTag("f" + brds);
                                h.addScoreboardTag("f" + hunger);
                            }
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+20 Hunger");
                            p.getInventory().remove(Material.HAY_BLOCK);
                            e.setCancelled(true);

                        }
                    }
                }
            } if (p.getItemInHand().getType() == Material.WATER_BUCKET) {
                for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                    if (h.getScoreboardTags().contains("t" + brds)) {
                        if (Integer.parseInt(brds) > 100) {
                            int hunger = Integer.parseInt(brds) + 10;
                            h.removeScoreboardTag("t" + brds);
                            h.addScoreboardTag("t" + hunger);
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "+10 Thirst");
                            p.getInventory().remove(Material.WATER_BUCKET);
                            e.setCancelled(true);

                        } if (Integer.parseInt(brds) == 100) {
                            h.removeScoreboardTag("Thirst");
                            p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "Your horse is full!");
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {

        if (e.getEntityType() == EntityType.HORSE) {
            Player player = ((Player) e.getDamager()).getPlayer();
            if (player.isSneaking()) {
                UUID uuid = player.getUniqueId();
                String name = e.getEntity().getCustomName();
                if (e.getEntity().getScoreboardTags().contains("Owner:" + uuid)) {
                    collection.put(player.getUniqueId(), e.getEntity().getUniqueId());
                    Inventory menu = getServer().createInventory(null, 45, name + "'s Info");

                    ItemStack ref1 = new ItemStack(Material.HORSE_SPAWN_EGG);
                    ItemStack ref2 = new ItemStack(Material.NETHER_STAR);
                    ItemStack ref3 = new ItemStack(Material.HAY_BLOCK);
                    ItemStack ref4 = new ItemStack(Material.GREEN_CONCRETE);
                    ItemStack ref5 = new ItemStack(Material.SADDLE);

                    ItemMeta metaref1 = ref1.getItemMeta();
                    ItemMeta metaref2 = ref2.getItemMeta();
                    ItemMeta metaref3 = ref3.getItemMeta();
                    ItemMeta metaref4 = ref4.getItemMeta();
                    ItemMeta metaref5 = ref5.getItemMeta();

                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);
                    for (double brds = 0; brds <= 5.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("jump:" + roundOff)) {
                            metaref5.setLore(Collections.singletonList(roundOff + "ft"));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                        if (e.getEntity().getScoreboardTags().contains("t" + brds)) {
                            metaref3.setLore(Collections.singletonList(ChatColor.AQUA + "Thirst: " + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                        if (e.getEntity().getScoreboardTags().contains("Gender:" + brds)) {
                            metaref1.setLore(Collections.singletonList(ChatColor.AQUA + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Ages")) {
                        if (e.getEntity().getScoreboardTags().contains("Age: " + brds)) {
                            metaref2.setDisplayName(ChatColor.AQUA + brds);
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Breeds")) {
                        if (e.getEntity().getScoreboardTags().contains("Breed:" + brds)) {
                            System.out.println("Yes");
                            metaref1.setDisplayName(ChatColor.YELLOW + brds);
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                        if (e.getEntity().getScoreboardTags().contains("f" + brds)) {
                            metaref3.setDisplayName(ChatColor.YELLOW + "Hunger: " + brds);
                        }
                    }
                    for (double brds = 0; brds <= 15.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("speed:" + roundOff)) {
                            metaref5.setDisplayName(roundOff + "mph");
                        }
                    }
                    metaref4.setDisplayName(ChatColor.YELLOW + "Trusted Players");
                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);

                    menu.setItem(12, ref1);
                    menu.setItem(14, ref2);
                    menu.setItem(29, ref3);
                    menu.setItem(31, ref4);
                    menu.setItem(33, ref5);
                    player.openInventory(menu);
                } if (player.hasPermission("h.op")) {
                    collection.put(player.getUniqueId(), e.getEntity().getUniqueId());
                    Inventory menu = getServer().createInventory(null, 45, name + "'s Info");

                    ItemStack ref1 = new ItemStack(Material.HORSE_SPAWN_EGG);
                    ItemStack ref2 = new ItemStack(Material.NETHER_STAR);
                    ItemStack ref3 = new ItemStack(Material.HAY_BLOCK);
                    ItemStack ref4 = new ItemStack(Material.GREEN_CONCRETE);
                    ItemStack ref5 = new ItemStack(Material.SADDLE);

                    ItemMeta metaref1 = ref1.getItemMeta();
                    ItemMeta metaref2 = ref2.getItemMeta();
                    ItemMeta metaref3 = ref3.getItemMeta();
                    ItemMeta metaref4 = ref4.getItemMeta();
                    ItemMeta metaref5 = ref5.getItemMeta();

                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);
                    for (OfflinePlayer offp : Bukkit.getOfflinePlayers()) {
                        UUID uuid1 = offp.getUniqueId();
                        if (e.getEntity().getScoreboardTags().contains("Owner:" + uuid1)) {
                            String name2 = offp.getName();
                            metaref2.setLore(Collections.singletonList("Owner: " + name2));
                        }
                    }
                    for (double brds = 0; brds <= 5.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("jump:" + roundOff)) {
                            metaref5.setLore(Collections.singletonList(roundOff + "ft"));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                        if (e.getEntity().getScoreboardTags().contains("t" + brds)) {
                            metaref3.setLore(Collections.singletonList(ChatColor.AQUA + "Thirst: " + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                        if (e.getEntity().getScoreboardTags().contains("Gender:" + brds)) {
                            metaref1.setLore(Collections.singletonList(ChatColor.AQUA + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Ages")) {
                        if (e.getEntity().getScoreboardTags().contains("Age: " + brds)) {
                            metaref2.setDisplayName(ChatColor.AQUA + brds);
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Breeds")) {
                        if (e.getEntity().getScoreboardTags().contains("Breed:" + brds)) {
                            metaref1.setDisplayName(ChatColor.YELLOW + brds);
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                        if (e.getEntity().getScoreboardTags().contains("f" + brds)) {
                            metaref3.setDisplayName(ChatColor.YELLOW + "Hunger: " + brds);
                        }
                    }
                    for (double brds = 0; brds <= 15.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("speed:" + roundOff)) {
                            metaref5.setDisplayName(roundOff + "mph");
                        }
                    }
                    metaref4.setDisplayName(ChatColor.YELLOW + "Trusted Players");
                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);

                    menu.setItem(12, ref1);
                    menu.setItem(14, ref2);
                    menu.setItem(29, ref3);
                    menu.setItem(31, ref4);
                    menu.setItem(33, ref5);
                    player.openInventory(menu);
                }


            }
        } if (e.getEntityType() == EntityType.DONKEY) {
            Player player = ((Player) e.getDamager()).getPlayer();
            if (player.isSneaking()) {
                UUID uuid = player.getUniqueId();
                String name = e.getEntity().getCustomName();
                if (e.getEntity().getScoreboardTags().contains("Owner:" + uuid)) {
                    collection.put(player.getUniqueId(), e.getEntity().getUniqueId());
                    Inventory menu = getServer().createInventory(null, 45, name + "'s Info");

                    ItemStack ref1 = new ItemStack(Material.HORSE_SPAWN_EGG);
                    ItemStack ref2 = new ItemStack(Material.NETHER_STAR);
                    ItemStack ref3 = new ItemStack(Material.HAY_BLOCK);
                    ItemStack ref4 = new ItemStack(Material.GREEN_CONCRETE);
                    ItemStack ref5 = new ItemStack(Material.SADDLE);

                    ItemMeta metaref1 = ref1.getItemMeta();
                    ItemMeta metaref2 = ref2.getItemMeta();
                    ItemMeta metaref3 = ref3.getItemMeta();
                    ItemMeta metaref4 = ref4.getItemMeta();
                    ItemMeta metaref5 = ref5.getItemMeta();

                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);
                    for (double brds = 0; brds <= 5.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("jump:" + roundOff)) {
                            metaref5.setLore(Collections.singletonList(roundOff + "ft"));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                        if (e.getEntity().getScoreboardTags().contains("t" + brds)) {
                            metaref3.setLore(Collections.singletonList(ChatColor.AQUA + "Thirst: " + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                        if (e.getEntity().getScoreboardTags().contains("Gender:" + brds)) {
                            metaref1.setLore(Collections.singletonList(ChatColor.AQUA + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Ages")) {
                        if (e.getEntity().getScoreboardTags().contains("Age: " + brds)) {
                            metaref2.setDisplayName(ChatColor.AQUA + brds);
                        }
                    }
                    if (e.getEntity().getScoreboardTags().contains("Breed:Donkey")) {
                        metaref1.setDisplayName(ChatColor.YELLOW + "Donkey");
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                        if (e.getEntity().getScoreboardTags().contains("f" + brds)) {
                            metaref3.setDisplayName(ChatColor.YELLOW + "Hunger: " + brds);
                        }
                    }
                    for (double brds = 0; brds <= 15.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("speed:" + roundOff)) {
                            metaref5.setDisplayName(roundOff + "mph");
                        }
                    }
                    metaref4.setDisplayName(ChatColor.YELLOW + "Trusted Players");
                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);

                    menu.setItem(12, ref1);
                    menu.setItem(14, ref2);
                    menu.setItem(29, ref3);
                    menu.setItem(31, ref4);
                    menu.setItem(33, ref5);
                    player.openInventory(menu);
                } if (player.hasPermission("h.op")) {
                    collection.put(player.getUniqueId(), e.getEntity().getUniqueId());
                    Inventory menu = getServer().createInventory(null, 45, name + "'s Info");

                    ItemStack ref1 = new ItemStack(Material.HORSE_SPAWN_EGG);
                    ItemStack ref2 = new ItemStack(Material.NETHER_STAR);
                    ItemStack ref3 = new ItemStack(Material.HAY_BLOCK);
                    ItemStack ref4 = new ItemStack(Material.GREEN_CONCRETE);
                    ItemStack ref5 = new ItemStack(Material.SADDLE);

                    ItemMeta metaref1 = ref1.getItemMeta();
                    ItemMeta metaref2 = ref2.getItemMeta();
                    ItemMeta metaref3 = ref3.getItemMeta();
                    ItemMeta metaref4 = ref4.getItemMeta();
                    ItemMeta metaref5 = ref5.getItemMeta();

                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);
                    for (double brds = 0; brds <= 5.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("jump:" + roundOff)) {
                            metaref5.setLore(Collections.singletonList(roundOff + "ft"));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                        if (e.getEntity().getScoreboardTags().contains("t" + brds)) {
                            metaref3.setLore(Collections.singletonList(ChatColor.AQUA + "Thirst: " + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                        if (e.getEntity().getScoreboardTags().contains("Gender:" + brds)) {
                            metaref1.setLore(Collections.singletonList(ChatColor.AQUA + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Ages")) {
                        if (e.getEntity().getScoreboardTags().contains("Age: " + brds)) {
                            metaref2.setDisplayName(ChatColor.AQUA + brds);
                        }
                    }
                    if (e.getEntity().getScoreboardTags().contains("Breed:Donkey")) {
                        metaref1.setDisplayName(ChatColor.YELLOW + "Donkey");
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                        if (e.getEntity().getScoreboardTags().contains("f" + brds)) {
                            metaref3.setDisplayName(ChatColor.YELLOW + "Hunger: " + brds);
                        }
                    }
                    for (double brds = 0; brds <= 15.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("speed:" + roundOff)) {
                            metaref5.setDisplayName(roundOff + "mph");
                        }
                    }
                    metaref4.setDisplayName(ChatColor.YELLOW + "Trusted Players");
                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);

                    menu.setItem(12, ref1);
                    menu.setItem(14, ref2);
                    menu.setItem(29, ref3);
                    menu.setItem(31, ref4);
                    menu.setItem(33, ref5);
                    player.openInventory(menu);
                }


            }
        } if (e.getEntityType() == EntityType.MULE) {
            Player player = ((Player) e.getDamager()).getPlayer();
            if (player.isSneaking()) {
                UUID uuid = player.getUniqueId();
                String name = e.getEntity().getCustomName();
                if (e.getEntity().getScoreboardTags().contains("Owner:" + uuid)) {
                    collection.put(player.getUniqueId(), e.getEntity().getUniqueId());
                    Inventory menu = getServer().createInventory(null, 45, name + "'s Info");

                    ItemStack ref1 = new ItemStack(Material.HORSE_SPAWN_EGG);
                    ItemStack ref2 = new ItemStack(Material.NETHER_STAR);
                    ItemStack ref3 = new ItemStack(Material.HAY_BLOCK);
                    ItemStack ref4 = new ItemStack(Material.GREEN_CONCRETE);
                    ItemStack ref5 = new ItemStack(Material.SADDLE);

                    ItemMeta metaref1 = ref1.getItemMeta();
                    ItemMeta metaref2 = ref2.getItemMeta();
                    ItemMeta metaref3 = ref3.getItemMeta();
                    ItemMeta metaref4 = ref4.getItemMeta();
                    ItemMeta metaref5 = ref5.getItemMeta();

                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);
                    for (double brds = 0; brds <= 5.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("jump:" + roundOff)) {
                            metaref5.setLore(Collections.singletonList(roundOff + "ft"));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                        if (e.getEntity().getScoreboardTags().contains("t" + brds)) {
                            metaref3.setLore(Collections.singletonList(ChatColor.AQUA + "Thirst: " + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                        if (e.getEntity().getScoreboardTags().contains("Gender:" + brds)) {
                            metaref1.setLore(Collections.singletonList(ChatColor.AQUA + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Ages")) {
                        if (e.getEntity().getScoreboardTags().contains("Age :" + brds)) {
                            metaref2.setDisplayName(ChatColor.AQUA + brds);
                        }
                    }
                    if (e.getEntity().getScoreboardTags().contains("Breed:Mule")) {
                        metaref1.setDisplayName(ChatColor.YELLOW + "Mule");
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                        if (e.getEntity().getScoreboardTags().contains("f" + brds)) {
                            metaref3.setDisplayName(ChatColor.YELLOW + "Hunger: " + brds);
                        }
                    }
                    for (double brds = 0; brds <= 15.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("speed:" + roundOff)) {
                            metaref5.setDisplayName(roundOff + "mph");
                        }
                    }
                    metaref4.setDisplayName(ChatColor.YELLOW + "Trusted Players");
                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);

                    menu.setItem(12, ref1);
                    menu.setItem(14, ref2);
                    menu.setItem(29, ref3);
                    menu.setItem(31, ref4);
                    menu.setItem(33, ref5);
                    player.openInventory(menu);
                } if (player.hasPermission("h.op")) {
                    collection.put(player.getUniqueId(), e.getEntity().getUniqueId());
                    Inventory menu = getServer().createInventory(null, 45, name + "'s Info");

                    ItemStack ref1 = new ItemStack(Material.HORSE_SPAWN_EGG);
                    ItemStack ref2 = new ItemStack(Material.NETHER_STAR);
                    ItemStack ref3 = new ItemStack(Material.HAY_BLOCK);
                    ItemStack ref4 = new ItemStack(Material.GREEN_CONCRETE);
                    ItemStack ref5 = new ItemStack(Material.SADDLE);

                    ItemMeta metaref1 = ref1.getItemMeta();
                    ItemMeta metaref2 = ref2.getItemMeta();
                    ItemMeta metaref3 = ref3.getItemMeta();
                    ItemMeta metaref4 = ref4.getItemMeta();
                    ItemMeta metaref5 = ref5.getItemMeta();

                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);
                    for (double brds = 0; brds <= 5.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("jump:" + roundOff)) {
                            metaref5.setLore(Collections.singletonList(roundOff + "ft"));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Thirst")) {
                        if (e.getEntity().getScoreboardTags().contains("t" + brds)) {
                            metaref3.setLore(Collections.singletonList(ChatColor.AQUA + "Thirst: " + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                        if (e.getEntity().getScoreboardTags().contains("Gender:" + brds)) {
                            metaref1.setLore(Collections.singletonList(ChatColor.AQUA + brds));
                        }
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Ages")) {
                        if (e.getEntity().getScoreboardTags().contains("Age: " + brds)) {
                            metaref2.setDisplayName(ChatColor.AQUA + brds);
                        }
                    }
                    if (e.getEntity().getScoreboardTags().contains("Breed:Mule")) {
                        metaref1.setDisplayName(ChatColor.YELLOW + "Mule");
                    }
                    for (String brds : plugin.getBreedsConfig().getStringList("Hunger")) {
                        if (e.getEntity().getScoreboardTags().contains("f" + brds)) {
                            metaref3.setDisplayName(ChatColor.YELLOW + "Hunger: " + brds);
                        }
                    }
                    for (double brds = 0; brds <= 15.99; brds += 0.01) {
                        BigDecimal roundOff=new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                        if (e.getEntity().getScoreboardTags().contains("speed:" + roundOff)) {
                            metaref5.setDisplayName(roundOff + "mph");
                        }
                    }
                    metaref4.setDisplayName(ChatColor.YELLOW + "Trusted Players");
                    ref1.setItemMeta(metaref1);
                    ref2.setItemMeta(metaref2);
                    ref3.setItemMeta(metaref3);
                    ref4.setItemMeta(metaref4);
                    ref5.setItemMeta(metaref5);

                    menu.setItem(12, ref1);
                    menu.setItem(14, ref2);
                    menu.setItem(29, ref3);
                    menu.setItem(31, ref4);
                    menu.setItem(33, ref5);
                    player.openInventory(menu);
                }


            }
        }
    }


    @EventHandler
    public void AllDamage(EntityDamageEvent d) {
        if (d.getEntityType() == EntityType.HORSE) {
            d.setCancelled(true);
        } if (d.getEntityType() == EntityType.DONKEY) {
            d.setCancelled(true);
        } if (d.getEntityType() == EntityType.MULE) {
            d.setCancelled(true);
        }
    }
}
