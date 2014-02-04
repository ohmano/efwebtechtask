package com.mracz.efwebtechtask;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTechTaskDriver extends FirefoxDriver{

	public WebTechTaskDriver() {
		super();
		manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public WebElement getSpeedUpdateControl() {
		return findElement(By.xpath("//div[@id='QA-render-airspeed']/div[2]/label"));
	}

	public WebElement getSpeedGauge() {
		return findElement(By.id("speed-gauge-canvas"));
	}
	
	public WebElement getAltitudeUpdateControl(){
		return findElement(By.xpath("//div[@id='QA-render-altitude']/div[2]/label"));
	}
	public WebElement getAltitudeGauge(){
		return findElement(By.id("altitude-gauge-canvas"));
	}
	
	public WebElement getReconnectControl(){
		return findElement(By.xpath("//div[@id='QA-reconnect']/div[2]/label"));
	}
	
	public WebElement getSummaryVsGraphControl(){
		return findElement(By.xpath("//div[@id='summary-graph-picker']/label"));
	}
	
	public void setQAControlState(WebElement control, String state) {
		if (!(getControlState(control).equals(state))){
			control.click();
		}
	}
	
	public void waitUntilConnectionClosed() throws InterruptedException {
		Boolean isConnectionAlive=true;
		do{
			isConnectionAlive = (getConnectionStatus().equals("Closed"))? false: true;
			Thread.sleep(1000);
		}while(isConnectionAlive);
	}
	
	public Boolean isReconnected() throws InterruptedException {
		Thread.sleep(1000);
		return (getConnectionStatus().equals("Connecting") || getConnectionStatus().equals("Connected")) ? true: false;	
	}
	
	public Boolean isRenderUpdateOn(WebElement gauge) {
		return Boolean.valueOf(gauge.getAttribute("render-updates"));
	}
	
	public Boolean isGraphVisible() {
		return findElement(By.id("speed-history-graph")).isDisplayed();
	}
	
	public Boolean isTelemetrySummaryVisible() {
		return (findElement(By.id("speed-history-summary")).isDisplayed() && findElement(By.id("altitude-history-summary")).isDisplayed());
	}
	
	private String getControlState(WebElement control) {
		return control.getText();
	}
	
	private String getConnectionStatus(){
		List<WebElement> statusElementList = findElements(By.className("status-description"));
		
		for (WebElement statusElement: statusElementList){
			if(statusElement.isDisplayed()){
				return statusElement.getText();
			}
		}
		return "";
	}
}
