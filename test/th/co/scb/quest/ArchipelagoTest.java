package th.co.scb.quest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchipelagoTest {

	@Test
	public void when_create_island_has_correct_size_island() {
		Archipelago archipelago = new Archipelago();
		archipelago.createIslands(10);
		assertEquals(10, archipelago.getIslands().length);
	}

}
