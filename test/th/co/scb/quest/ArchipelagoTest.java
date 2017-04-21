package th.co.scb.quest;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class ArchipelagoTest {
	
	private Archipelago archipelago;
	
	@Before
	public void initialArchipelago(){
		archipelago = new Archipelago();
		archipelago.initialWorld("10 10");
	}
	
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
	public void when_initial_world_choose_have_correct_island_and_day_6_5() {
		archipelago.initialWorld("6 5");
		assertEquals(6, archipelago.getIslands().length);
		assertEquals(5, archipelago.getDay());
	}
	
	@Test
	public void when_initial_world_choose_have_correct_island_and_day_16_20() {
		archipelago.initialWorld("16 20");
		assertEquals(16, archipelago.getIslands().length);
		assertEquals(20, archipelago.getDay());
	}
	
	@Test
	public void islands_need_to_be_island_class() {
		assertEquals(Island[].class , archipelago.getIslands().getClass());
	}
	
	@Test
	public void when_initial_every_island_has_empty_bridge_list() {
		assertEquals(new LinkedList<Bridge>(), archipelago.getIslands()[0].getBridges());
	}

}
