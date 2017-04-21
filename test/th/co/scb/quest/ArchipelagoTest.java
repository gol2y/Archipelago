package th.co.scb.quest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchipelagoTest {

	private Archipelago archipelago = new Archipelago();
	
	@Test
	public void when_create_10_island_has_correct_size_island() {
		archipelago.createIslands(10);
		assertEquals(10, archipelago.getIslands().length);
	}
	
	@Test
	public void when_create_21_island_has_correct_size_island() {
		archipelago.createIslands(21);
		assertEquals(21, archipelago.getIslands().length);
	}
	
	@Test
	public void when_set_day_choose_have_correct_day() {
		archipelago.setDay(15);
		assertEquals(15, archipelago.getDay());
	}
	
	@Test
	public void when_initial_world_choose_have_correct_island_and_day() {
		archipelago.initialWorld("6 5");
		assertEquals(6, archipelago.getIslands().length);
		assertEquals(5, archipelago.getDay());
	}

}
