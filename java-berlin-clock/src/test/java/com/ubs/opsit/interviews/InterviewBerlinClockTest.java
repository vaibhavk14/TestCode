package com.ubs.opsit.interviews;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class InterviewBerlinClockTest {

	InterviewBerlinTimeConverter berlinClockConv = new InterviewBerlinTimeConverter();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testNotNullOutputofBerlinClockConverter() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.convertTime("09:54:54"));
	}
	
	@Test
	void testFirstRowHoursNotNull() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getFirstRowHours(9));
		assertEquals("ROOO",berlinClockConv.getFirstRowHours(9));
	}
	
	@Test
	void testFirstRowHoursStatus() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getFirstRowStatus(9));
		assertEquals(new Integer(1), berlinClockConv.getFirstRowStatus(9));
	}

	@Test
	void testSecondHoursNotNull() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getSecondRowHours(9));
		assertEquals("RRRR",berlinClockConv.getSecondRowHours(9));
	}
	
	@Test
	void testSecondRowHoursStatus() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getSecondRowHoursStatus(9));
	
	}
	
	@Test
	void testSecondRowMinutesMinutesNotNull() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getSecondRowMinutes(54));
		assertEquals("YYYY",berlinClockConv.getSecondRowMinutes(54));
	}
	
	
	@Test
	void testFirstRowMinutesMinutesNotNull() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getFirstRowMinutes(54));
		assertEquals("YYYYYYYYYYO",berlinClockConv.getFirstRowMinutes(54));
	}
	
	@Test
	void testSingleRowSecondsMinutesNotNull() {
		//fail("Not yet implemented");
		assertNotNull(berlinClockConv.getBerlinClockLightsForSeconds(54));
		assertEquals("Y",berlinClockConv.getBerlinClockLightsForSeconds(54));
	}
	@Test
	void testOutputofBerlinClockConverter() {
		//fail("Not yet implemented");
		assertEquals("YROOORRRRYYYYYYYYYYOYYYY",berlinClockConv.convertTime("09:54:54"));
	}
}
