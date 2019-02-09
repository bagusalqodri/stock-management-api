package bsp.stock.api.stock.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
public class Stock {
	@Id
    String symbol;
    String name;
    String description;
    Double price;
    String CreatedBy;
    String UpdatedBy;
	LocalDateTime CreatedDt;
    LocalDateTime UpdatedDt;

	public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDt() {
		return CreatedDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		CreatedDt = createdDt;
	}
    
    public LocalDateTime getUpdatedDt() {
		return UpdatedDt;
	}

	public void setUpdatedDt(LocalDateTime updatedDt) {
		UpdatedDt = updatedDt;
	}
}