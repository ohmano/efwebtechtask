package com.mracz.efwebtechtask;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WebTechTaskTests {
		private WebTechTaskDriver driver;
		private String baseUrl="http://176.34.94.213:8888/staticqa/index.html";
		private StringBuffer verificationErrors = new StringBuffer();
		
		@Before
		public void setUp() throws Exception {
			driver = new WebTechTaskDriver();
		}

		@Test
		public void disableSpeedUpdate() throws Exception {
			driver.get(baseUrl);
			
			driver.setQAControlState(driver.getSpeedUpdateControl(), "OFF");
			Assert.assertFalse(driver.isRenderUpdateOn(driver.getSpeedGauge()));
			
		}
		
		@Test
		public void enableSpeedUpdateAfterDisabled() throws Exception {
			driver.get(baseUrl);
			
			driver.setQAControlState(driver.getSpeedUpdateControl(), "OFF");
			Assert.assertFalse(driver.isRenderUpdateOn(driver.getSpeedGauge()));
			
			Thread.sleep(1000);
			
			driver.setQAControlState(driver.getSpeedUpdateControl(), "ON");
			Assert.assertTrue(driver.isRenderUpdateOn(driver.getSpeedGauge()));
			
		}
		
		@Test
		public void disableAltitudeUpdate() throws Exception {
			driver.get(baseUrl);
			
			driver.setQAControlState(driver.getAltitudeUpdateControl(), "OFF");
			Assert.assertFalse(driver.isRenderUpdateOn(driver.getAltitudeGauge()));
		}
		
		@Test
		public void enableAltitudeUpdateAfterDisabled() throws Exception {
			driver.get(baseUrl);
			
			driver.setQAControlState(driver.getAltitudeUpdateControl(), "OFF");
			Assert.assertFalse(driver.isRenderUpdateOn(driver.getAltitudeGauge()));
			
			Thread.sleep(1000);
			
			driver.setQAControlState(driver.getAltitudeUpdateControl(), "ON");
			Assert.assertTrue(driver.isRenderUpdateOn(driver.getAltitudeGauge()));
		}
		
		@Test
		public void disableReconnect() throws Exception {
			driver.get(baseUrl);

			driver.setQAControlState(driver.getReconnectControl(), "OFF");
			driver.waitUntilConnectionClosed();
			
			Assert.assertFalse(driver.isReconnected());
		}
		
		@Test
		public void switchBetweenTelemetrySummaryAndGraph() throws Exception {
			driver.get(baseUrl);
			
			driver.getSummaryVsGraphControl().click();
			Thread.sleep(1000);
			Assert.assertTrue(driver.isGraphVisible());
			Assert.assertFalse(driver.isTelemetrySummaryVisible());
			driver.getSummaryVsGraphControl().click();
			Thread.sleep(1000);
			Assert.assertFalse(driver.isGraphVisible());
			Assert.assertTrue(driver.isTelemetrySummaryVisible());
	
		}
		
		@After
		public void tearDown() throws Exception {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
		}

	}   