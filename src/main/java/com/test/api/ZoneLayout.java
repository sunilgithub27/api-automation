package com.test.api;

import java.util.UUID;

import org.apache.juneau.annotation.Beanc;

public class ZoneLayout {

	
	private String zoneId;
	private String zoneName;
	private String zoneType;
	private String floorId;
	private String siteId;
	private String dateCreated;
	private String dateUpdated;

	@Beanc(properties="zoneId,zoneName,zoneType,floorId,siteId,dateCreated,dateUpdated")
	public ZoneLayout(String zoneId,String zoneName, String zoneType, String floorId,String siteId, String dateCreated, String dateUpdated ) {
		super();
		this.zoneId= zoneId;
		this.zoneName= zoneName;
		this.zoneType= zoneType;
		this.floorId = floorId;
		this.siteId = siteId;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneType() {
		return zoneType;
	}

	public void setZoneType(String zoneType) {
		this.zoneType = zoneType;
	}


	public String getFloorId() {
		return floorId;
	}

	public void setfloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "ZoneLayout [zoneId=" + zoneId + ", zoneName=" + zoneName + ", zoneType=" + zoneType + "]";
	}

}
