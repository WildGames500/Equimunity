package net.equimunity;

import org.bukkit.*;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;
import static net.equimunity.Events.collection;

public class HorseGUI implements Listener {
    private equimunity plugin;
    public HorseGUI(equimunity plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID uuid = player.getUniqueId();
        UUID euid = collection.get(uuid);
        World world = player.getWorld();
        int slot = 0;
        for (Entity ent : world.getEntities()) {
            if (ent instanceof Horse) {
                UUID h = ent.getUniqueId();
                if (euid.equals(h)) {
                    String name = ent.getCustomName();
                    if (e.getView().getTitle().equals(name + "'s Info")) {
                        if (e.getSlot() == 31) {
                            Inventory br = getServer().createInventory(null, 27, "Trusted Players");
                            for (OfflinePlayer p : Bukkit.getServer().getOfflinePlayers()) {
                                UUID puuid = p.getUniqueId();
                                String offp = p.getName();
                                if (ent.getScoreboardTags().contains("Trusted:" + puuid)) {
                                    ItemStack ref1 = new ItemStack(Material.PAPER);
                                    ItemMeta metaref1 = ref1.getItemMeta();
                                    ref1.setItemMeta(metaref1);
                                    metaref1.setDisplayName(offp);
                                    ref1.setItemMeta(metaref1);
                                    br.setItem(slot, ref1);
                                    slot += 1;
                                }
                                player.openInventory(br);
                                e.setCancelled(true);
                            }

                        } else {
                            e.setCancelled(true);
                        }
                    }
                }
            } if (ent instanceof Donkey) {
                UUID h = ent.getUniqueId();
                if (euid.equals(h)) {
                    String name = ent.getCustomName();
                    if (e.getView().getTitle().equals(name + "'s Info")) {
                        if (e.getSlot() == 31) {
                            Inventory br = getServer().createInventory(null, 27, "Trusted Players");
                            for (OfflinePlayer p : Bukkit.getServer().getOfflinePlayers()) {
                                UUID puuid = p.getUniqueId();
                                String offp = p.getName();
                                if (ent.getScoreboardTags().contains("Trusted:" + puuid)) {
                                    ItemStack ref1 = new ItemStack(Material.PAPER);
                                    ItemMeta metaref1 = ref1.getItemMeta();
                                    ref1.setItemMeta(metaref1);
                                    metaref1.setDisplayName(offp);
                                    ref1.setItemMeta(metaref1);
                                    br.setItem(slot, ref1);
                                    slot += 1;
                                }
                                player.openInventory(br);
                                e.setCancelled(true);
                            }

                        } else {
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
