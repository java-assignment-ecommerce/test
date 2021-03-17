package com.cybage.bookings.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoryId;
	private String inventoryName;
	private Integer inventoryQuantity;	
//	@Column(nullable = false)
	private LocalDateTime createTime;
//	@Column(nullable = false)
	private LocalDateTime updateTime;

	public Inventory() {
		super();
	}
	public Inventory(Integer inventoryId, String inventoryName, Integer inventoryQuantity, LocalDateTime createTime,
			LocalDateTime updateTime) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.inventoryQuantity = inventoryQuantity;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public Integer getInventoryQuantity() {
		return inventoryQuantity;
	}
	public void setInventoryQuantity(Integer inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}
	public LocalDateTime getcreateTime() {
		return createTime;
	}
	public void setcreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", inventoryQuantity="
				+ inventoryQuantity + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
