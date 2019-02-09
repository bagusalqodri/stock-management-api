package bsp.stock.api.stock.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import bsp.stock.api.stock.models.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, String>{

	Stock findBySymbol(String upperCase);
	void deleteDistinctBySymbol(String symbol);
}
