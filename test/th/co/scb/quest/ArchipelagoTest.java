package th.co.scb.quest;

import static org.junit.Assert.*;

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
	
	@Test
	public void when_build_bridge_1_2_island_1_2_has_new_bridge(){
		archipelago.buildBridge(1,"1 2");
		Bridge expectedBridge = new Bridge(1,1,2);
		assertIslandHasThisBridge(expectedBridge, 1,2);
	}
	
	@Test
	public void when_build_bridge_2_3_island_2_3_has_new_correct_bridge(){
		archipelago.buildBridge(1,"2 3");
		Bridge expectedBridge = new Bridge(1,2,3);
		assertIslandHasThisBridge(expectedBridge, 2,3);
	}
	
	@Test
	public void when_build_bridge_8_4_island_8_4_has_new_correct_bridge(){
		archipelago.buildBridge(1,"8 4");
		Bridge expectedBridge = new Bridge(1,8,4);
		assertIslandHasThisBridge(expectedBridge, 8,4);
	}
	
	@Test
	public void build_bridge_1_2_on_day_1_and_check_1_2_should_YES_1(){
		archipelago.buildBridge(1,"1 2");
		assertEquals("YES 1", archipelago.check("1 2"));
	}
	
	@Test
	public void build_bridge_2_5_on_day_2_and_check_2_5_should_YES_2(){
		archipelago.buildBridge(2,"2 5");
		assertEquals("YES 2", archipelago.check("2 5"));
	}
	
	@Test
	public void build_bridge_3_6_on_day_3_and_check_3_6_should_YES_3(){
		archipelago.buildBridge(3,"3 6");
		assertEquals("YES 3", archipelago.check("3 6"));
	}
	
	@Test
	public void build_bridge_3_6_on_day_3_and_check_4_6_should_NO(){
		archipelago.buildBridge(3,"3 6");
		assertEquals("NO", archipelago.check("4 6"));
	}
	
	@Test
	public void build_bridge_3_6_and_4_5_on_day_2_3_and_check_5_4_should_YES_3(){
		archipelago.buildBridge(2,"3 6");
		archipelago.buildBridge(3,"4 5");
		assertEquals("YES 3", archipelago.check("5 4"));
	}
	
	@Test
	public void build_bridge_3_4_after_check_3_4_should_remove_this_bridge(){
		archipelago.buildBridge(1,"3 4");
		Bridge expectedBridge = new Bridge(1,3,4);
		assertEquals("YES 1", archipelago.check("3 4"));
		assertAllIslandNotHasThisBridge(expectedBridge, 3, 4);
	}
	
	private void assertIslandHasThisBridge(Bridge expected, int... islands){
		for(int island : islands){
			Island i = archipelago.getIsland(island);
			assertTrue("Island not contain bridge", i.getBridges().contains(expected));
		}
	}
	
	private void assertAllIslandNotHasThisBridge(Bridge expected, int... islands){
		for(int island : islands){
			Island i = archipelago.getIsland(island);
			assertFalse("Island contain bridge", i.getBridges().contains(expected));
		}
	}

}
