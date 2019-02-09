package bsp.stock.api.stock;

import org.springframework.web.bind.annotation.*;

import bsp.stock.api.stock.models.Stock;
import bsp.stock.api.stock.models.StocksResponse;
import bsp.stock.api.stock.repositories.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1")
public class StockController {
	
	@Autowired
    private StockRepository stockRepository;
	
	@ApiOperation(value = "Index API")
	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
    public String index() {
		return "Welcome to Stock API 1.0";
    }
	
	@ApiOperation(value = "Get all stocks")
	@RequestMapping(value = "/stocks", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
    public StocksResponse getStocks() {
		return new StocksResponse(stockRepository.findAll());
    }
	
	@ApiOperation(value = "Get a stock object by symbol")
    @RequestMapping(value = "/stocks/{symbol}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Stock getStockBySymbol(
            @ApiParam(value = "A stock symbol", required = true)
            @PathVariable String symbol) {
        //Stock stockObj = stockRepository.findBySymbol(symbol.toUpperCase());
        return stockRepository.findBySymbol(symbol.toUpperCase());
    }
	
	@ApiOperation(value = "Create a new stock")
    @RequestMapping(value = "/stocks", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Stock createStock(
            @ApiParam(value = "New stock object", required = true)
            @RequestBody Stock newStock) {
        newStock.setSymbol(newStock.getSymbol().toUpperCase());
        return stockRepository.save(newStock);
    }
	
	@ApiOperation(value = "Update an existing stock by symbol")
    @RequestMapping(value = "/stocks/{symbol}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Stock updateStockBySymbol(
            @ApiParam(value = "A stock symbol", required = true)
            @PathVariable String symbol,
            @ApiParam(value = "Updated stock object", required = true)
            @RequestBody Stock updatedStock) {
        Stock foundStock = stockRepository.findBySymbol(symbol.toUpperCase());
        foundStock.setName(updatedStock.getName());
        foundStock.setDescription(updatedStock.getDescription());
        foundStock.setPrice(updatedStock.getPrice());
        foundStock.setCreatedBy(updatedStock.getCreatedBy());
        foundStock.setUpdatedBy(updatedStock.getUpdatedBy());
        foundStock.setCreatedDt(updatedStock.getCreatedDt());
        foundStock.setUpdatedDt(updatedStock.getUpdatedDt());
        return stockRepository.save(foundStock);
    }
	
	@ApiOperation(value = "Delete a stock by symbol")
    @RequestMapping(value = "/stocks/{symbol}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStockBySymbol(
            @ApiParam(value = "A stock symbol", required = true)
            @PathVariable String symbol) {
        stockRepository.deleteDistinctBySymbol(symbol.toUpperCase());
    }
}
