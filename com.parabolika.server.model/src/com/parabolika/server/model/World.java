package com.parabolika.server.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class World {
	private static final World WORLD = new World();

	private final List<Player> players = new ArrayList<Player>();

	public Player getPlayer(UUID uuid) {
		for(Player p : players) {
			if(p.getUUID().equals(uuid)) {
				return p;
			}
		}
		return null;
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public int getNextAvailableIndex() {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i) == null) {
				return i;
			}
		}
		return players.size();
	}

	public static World getWorld() {
		return WORLD;
	}
}
