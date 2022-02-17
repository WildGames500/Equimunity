package net.equimunity;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class Commands implements CommandExecutor {
    private final equimunity plugin;
    public Commands(equimunity plugin) {
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("h")) {
            if (args[0].equalsIgnoreCase("kill")) {
                if (sender.hasPermission("h.op")) {
                    Player player = (Player) sender;
                    if (player.getVehicle().getType() == EntityType.HORSE) {
                        Entity e = player.getVehicle();
                        ((Horse) e).setHealth(0);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have killed this horse!");
                        return true;
                    } if (player.getVehicle().getType() == EntityType.DONKEY) {
                        Entity e = player.getVehicle();
                        ((Donkey) e).setHealth(0);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have killed this horse!");
                        return true;
                    } if (player.getVehicle().getType() == EntityType.MULE) {
                        Entity e = player.getVehicle();
                        ((Mule) e).setHealth(0);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have killed this horse!");
                        return true;
                    }
                }
            }else if (args[0].equalsIgnoreCase("transfer")) {
                if (args.length >= 2) {
                    Player p2 = plugin.getServer().getPlayer(args[1]);
                    Player player = (Player) sender;
                    String name = sender.getName();
                    UUID uuid = player.getUniqueId();
                    UUID uuid2 = p2.getUniqueId();
                    if (player.getVehicle().getType() == EntityType.HORSE) {
                        Entity e = player.getVehicle();
                        if (e.getScoreboardTags().contains("Owner:" + uuid)) {
                            e.removeScoreboardTag("Owner:" + uuid);
                            e.addScoreboardTag("Owner:" + uuid2);
                            p2.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have transfered this horse to" + args[1] + "!");
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have been transfered a hosre from" + name + "!");
                            return true;
                        }
                    } if (player.getVehicle().getType() == EntityType.DONKEY) {
                        Entity e = player.getVehicle();
                        if (e.getScoreboardTags().contains("Owner:" + uuid)) {
                            e.removeScoreboardTag("Owner:" + uuid);
                            e.addScoreboardTag("Owner:" + uuid2);
                            p2.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have transfered this horse to" + args[1] + "!");
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have been transfered a hosre from" + name + "!");
                            return true;
                        }
                    } if (player.getVehicle().getType() == EntityType.MULE) {
                        Entity e = player.getVehicle();
                        if (e.getScoreboardTags().contains("Owner:" + uuid)) {
                            e.removeScoreboardTag("Owner:" + uuid);
                            e.addScoreboardTag("Owner:" + uuid2);
                            p2.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have transfered this horse to" + args[1] + "!");
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have been transfered a hosre from" + name + "!");
                            return true;
                        }
                    }
                }

            } if (args[0].equalsIgnoreCase("name")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    UUID uuid = player.getUniqueId();
                    Entity h = player.getVehicle();
                    if (h.getScoreboardTags().contains("Owner:" + uuid)) {
                        h.setCustomName(args[1]);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.YELLOW + "You have named this horse!");
                        return true;
                    }
                }

            } if (args[0].equalsIgnoreCase("claim")) {
                Player player = (Player) sender;
                UUID uuid = player.getUniqueId();
                Entity h = player.getVehicle();
                if (!h.getScoreboardTags().contains("Owned")) {
                    h.addScoreboardTag("Owned");
                    h.addScoreboardTag("Owner:" + uuid);
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "You have claimed this horse!");
                    return true;

                } else {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.RED + "This horse has already been claimed!");
                    return true;
                }

            } if (args[0].equalsIgnoreCase("trust")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    UUID uuid = player.getUniqueId();
                    Entity h = player.getVehicle();
                    Player p2 = plugin.getServer().getPlayer(args[1]);
                    String name = p2.getName();
                    UUID uuid2 = p2.getUniqueId();
                    if (h.getScoreboardTags().contains("Owner:" + uuid)) {
                        h.addScoreboardTag("Trusted:" + uuid2);
                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "You have trusted" + name + " to this horse!");
                        return true;
                    }
                }
            } if (args[0].equalsIgnoreCase("setcolor")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    Entity h = player.getVehicle();
                    if (player.hasPermission("h.op")) {
                        if (args[1].equalsIgnoreCase("black")) {
                            ((Horse) h).setColor(Horse.Color.BLACK);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("gray")) {
                            ((Horse) h).setColor(Horse.Color.GRAY);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("white")) {
                            ((Horse) h).setColor(Horse.Color.WHITE);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("brown")) {
                            ((Horse) h).setColor(Horse.Color.BROWN);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("darkbrown")) {
                            ((Horse) h).setColor(Horse.Color.DARK_BROWN);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("chestnut")) {
                            ((Horse) h).setColor(Horse.Color.CHESTNUT);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("creamy")) {
                            ((Horse) h).setColor(Horse.Color.CREAMY);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse color changed!");
                            return true;
                        }
                    }

                }
            } if (args[0].equalsIgnoreCase("setgender")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    Entity h = player.getVehicle();
                    if (player.hasPermission("h.op")) {
                        for (String brds : plugin.getBreedsConfig().getStringList("Genders")) {
                            System.out.println(args[1]);
                            if (args[1].equalsIgnoreCase(brds)) {
                                System.out.println("Test3");
                                for (String brds2 : plugin.getBreedsConfig().getStringList("Genders")) {
                                    System.out.println("Test4");
                                    if (h.getScoreboardTags().contains("Gender:" + brds2)) {
                                        h.removeScoreboardTag("Gender:" + brds2);
                                        h.addScoreboardTag("Gender:" + brds);
                                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse gender changed to " + brds + "!");
                                        return true;

                                    }
                                }
                            }
                        }
                    }
                }
            }if (args[0].equalsIgnoreCase("setbreed")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    Entity h = player.getVehicle();
                    if (player.hasPermission("h.op")) {
                        if (args.length == 3) {
                            String name = args[1] + " " + args[2];
                            for (String brds : plugin.getBreedsConfig().getStringList("Breeds")) {
                                if (name.equalsIgnoreCase(brds)) {
                                    for (String brds2 : plugin.getBreedsConfig().getStringList("Breeds")) {
                                        if (h.getScoreboardTags().contains("Breed:" + brds2)) {
                                            h.removeScoreboardTag("Breed:" + brds2);
                                            h.addScoreboardTag("Breed:" + brds);
                                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse breed changed to " + brds + "!");
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                        if (args.length == 2) {
                            for (String brds : plugin.getBreedsConfig().getStringList("Breeds")) {
                                String name = args[1];
                                if (name.equalsIgnoreCase(brds)) {
                                    for (String brds2 : plugin.getBreedsConfig().getStringList("Breeds")) {
                                        if (h.getScoreboardTags().contains("Breed:" + brds2)) {
                                            h.removeScoreboardTag("Breed:" + brds2);
                                            h.addScoreboardTag("Breed:" + brds);
                                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse breed changed to " + brds + "!");
                                            return true;
                                        }
                                    }
                                }

                            }
                        }
                        if (args.length == 4) {
                            for (String brds : plugin.getBreedsConfig().getStringList("Breeds")) {
                                String name = args[1] + " " + args[2] + " " + args[3];
                                if (name.equalsIgnoreCase(brds)) {
                                    for (String brds2 : plugin.getBreedsConfig().getStringList("Breeds")) {
                                        if (h.getScoreboardTags().contains("Breed:" + brds2)) {
                                            h.removeScoreboardTag("Breed:" + brds2);
                                            h.addScoreboardTag("Breed:" + brds);
                                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse breed changed to " + brds + "!");
                                            return true;
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            } if (args[0].equalsIgnoreCase("setstyle")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    Entity h = player.getVehicle();
                    if (player.hasPermission("h.op")) {
                        if (args[1].equalsIgnoreCase("blaze")) {
                            ((Horse) h).setStyle(Horse.Style.WHITE);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse style changed!");
                            return true;
                        } if (args[1].equalsIgnoreCase("Whitedots")) {
                            ((Horse) h).setStyle(Horse.Style.WHITE_DOTS);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse style changed!");
                            return true;
                        } if (args[1].equalsIgnoreCase("none")) {
                            ((Horse) h).setStyle(Horse.Style.NONE);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse style changed!");
                            return true;
                        }if (args[1].equalsIgnoreCase("blackdots")) {
                            ((Horse) h).setStyle(Horse.Style.BLACK_DOTS);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse style changed!");
                            return true;
                        }if (args[1].equalsIgnoreCase("paint")) {
                            ((Horse) h).setStyle(Horse.Style.WHITEFIELD);
                            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse style changed!");
                            return true;
                        }
                    }

                }
            } if (args[0].equalsIgnoreCase("setjump")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    Entity h = player.getVehicle();
                    if (player.hasPermission("h.op")) {
                        for (double brds = 0; brds <= 5.99; brds += 0.01) {
                            BigDecimal roundOff = new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                            if (Double.parseDouble(args[1]) == Double.parseDouble(String.valueOf(roundOff))) {
                                for (double brds2 = 0; brds2 <= 5.99; brds2 += 0.01) {
                                    BigDecimal roundOff2 = new BigDecimal(brds2).setScale(2, RoundingMode.HALF_DOWN);
                                    if (h.getScoreboardTags().contains("jump:" + roundOff2)) {
                                        h.removeScoreboardTag("jump:" + roundOff2);
                                        h.addScoreboardTag("jump:" + args[1]);
                                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse jump changed!");
                                        return true;
                                    }
                                }
                                if (brds <= 0.99) {
                                    if (brds >= 0.50) {
                                        double j = brds * 0.34;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }

                                    }
                                    if (brds >= 0.49) {
                                        double j = brds * 0.32;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }
                                    }
                                }
                                if (brds <= 1.99) {
                                    if (brds >= 1.50) {
                                        double j = brds * 0.34;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }

                                    }
                                    if (brds >= 1.49) {
                                        double j = brds * 0.30;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }
                                    }
                                }
                                if (brds <= 2.99) {
                                    if (brds >= 2.50) {
                                        double j = brds * 0.26;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }

                                    }
                                    if (brds >= 2.49) {
                                        double j = brds * 0.24;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }
                                    }
                                }
                                if (brds <= 3.99) {
                                    if (brds >= 3.50) {
                                        double j = brds * 0.24;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }

                                    }
                                    if (brds >= 3.49) {
                                        double j = brds * 0.22;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }
                                    }
                                }
                                if (brds <= 4.99) {
                                    if (brds >= 4.50) {
                                        double j = brds * 0.22;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }

                                    }
                                    if (brds >= 4.49) {
                                        double j = brds * 0.22;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }
                                    }
                                }
                                if (brds <= 5.99) {
                                    if (brds >= 5.50) {
                                        double j = brds * 0.20;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }

                                    }
                                    if (brds >= 5.49) {
                                        double j = brds * 0.20;
                                        if (h.getType() == EntityType.HORSE) {
                                            ((Horse) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.DONKEY) {
                                            ((Donkey) h).setJumpStrength(j);
                                        } if (h.getType() == EntityType.MULE) {
                                            ((Mule) h).setJumpStrength(j);
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            } if (args[0].equalsIgnoreCase("setspeed")) {
                if (args.length >= 2) {
                    Player player = (Player) sender;
                    Entity h = player.getVehicle();
                    if (player.hasPermission("h.op")) {
                        for (double brds = 0; brds <= 15.99; brds += 0.01) {
                            BigDecimal roundOff = new BigDecimal(brds).setScale(2, RoundingMode.HALF_DOWN);
                            double speed = brds * .030;
                            if (h.getType() == EntityType.HORSE) {
                                ((Horse) h).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            } if (h.getType() == EntityType.MULE) {
                                ((Mule) h).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            } if (h.getType() == EntityType.DONKEY) {
                                ((Donkey) h).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }
                            if (Double.parseDouble(args[1]) == Double.parseDouble(String.valueOf(roundOff))) {
                                for (double brds2 = 0; brds2 <= 15.99; brds2 += 0.01) {
                                    BigDecimal roundOff2 = new BigDecimal(brds2).setScale(2, RoundingMode.HALF_DOWN);
                                    if (h.getScoreboardTags().contains("speed:" + roundOff2)) {
                                        h.removeScoreboardTag("speed:" + roundOff2);
                                        h.addScoreboardTag("speed:" + args[1]);
                                        player.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "Horse" + ChatColor.GRAY + "] >> " + ChatColor.GREEN + "Horse speed changed!");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return false;
    }
}
