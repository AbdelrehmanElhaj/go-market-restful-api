package dev.hdrelhaj.go_market.order;

public class OrderNotFoundException extends RuntimeException {
    
    public OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }

}
