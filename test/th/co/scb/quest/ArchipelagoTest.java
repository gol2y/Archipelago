package th.co.scb.quest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchipelagoTest {

	@Test
	public void when_create_10_island_has_correct_size_island() {
		Archipelago archipelago = new Archipelago();
		archipelago.createIslands(10);
		assertEquals(10, archipelago.getIslands().length);
	}
	
	@Test
	public void when_create_21_island_has_correct_size_island() {
		Archipelago archipelago = new Archipelago();
		archipelago.createIslands(21);
		assertEquals(21, archipelago.getIslands().length);
	}
	
	@Test
	public void when_set_day_choose_have_correct_day() {
		Archipelago archipelago = new Archipelago();
		archipelago.setDay(15);
		assertEquals(15, archipelago.getDay());
	}

}
