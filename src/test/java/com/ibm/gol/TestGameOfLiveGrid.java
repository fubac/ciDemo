package com.ibm.gol;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGameOfLiveGrid {

	private Grid grid;

	@Before
	public void setUp() throws Exception {
		grid = new Grid();
	}

	@Test
	public void testGridXDimension() {
		assertEquals(4, grid.getXDimension());
	}
	
	@Test
	public void testGridYDimension() throws Exception {
		assertEquals(8, grid .getYDimension());
	}
	
	@Test
	public void testAliveCell() throws Exception {
		assertTrue(grid.isAlive(1, 4));
	}
	
	@Test
	public void testDeadCell() throws Exception {
		assertFalse(grid.isAlive(1, 3));
	}
	
	@Test
	public void testInitialGeneration() throws Exception {
		String output = 
		"........\n"+
		"....*...\n"+
		"...**...\n"+
		"........\n";
		assertEquals(output, grid.toString());
	}
	
	@Test
	public void testCountAliveNeighbours() throws Exception {
		assertEquals(3, grid.countAliveNeighbours(1,3));
	}
	
	@Test
	public void testCountAliveNeighbours2() throws Exception {
		assertEquals(2, grid.countAliveNeighbours(2, 3));
	}
	
	@Test
	public void testCountAliveNeighboursInEdge() throws Exception {
		assertEquals(0, grid.countAliveNeighbours(0, 0));
	}
	
	@Test
	public void testNextGeneration() throws Exception {
		assertTrue(grid.isAliveInNextGeneration(1,3));
	}
	
	@Test
	public void testNextGeneration2() throws Exception {
		assertFalse(grid.isAliveInNextGeneration(0, 0));
	}
	
	@Test
	public void testNextGeneration3() throws Exception {
		assertFalse(grid.isAliveInNextGeneration(1, 5));
	}
	
	@Test
	public void testCalculateNextGen() throws Exception {
		String output = 
		"........\n"+
		"...**...\n"+
		"...**...\n"+
		"........\n";
		grid.calculateNextGeneration();
		assertEquals(output, grid.toString());
	}

}
