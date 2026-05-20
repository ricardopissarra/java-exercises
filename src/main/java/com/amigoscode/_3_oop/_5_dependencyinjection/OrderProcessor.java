package com.amigoscode._3_oop._5_dependencyinjection;


/**
 * Exercise: Dependency Injection - Order Processing
 *
 * Build an order processing system where OrderProcessor depends on
 * abstractions (interfaces) rather than concrete classes. The payment
 * gateway and order repository are injected through the constructor.
 *
 * Key concepts:
 * - Multiple dependencies injected via constructor
 * - Separating concerns (payment vs persistence)
 * - Easy to swap implementations (e.g., test doubles)
 * - Clean, testable architecture
 */


interface PaymentGateway {
    boolean charge(double amount);
}

class StripeGateway implements PaymentGateway {

    @Override
    public boolean charge(double amount) {
        System.out.println("[Stripe] charging $%.2f".formatted(amount));
        return true;
    }
}

// TODO: 2 - Create an OrderRepository interface with:
//   void save(Order order)
//   Also create a concrete InMemoryOrderRepository class that implements it.
//   In save(), print "[Repository] Order saved: <order>"
interface OrderRepository {
    void save(Order order);
}

class InMemoryOrderRepository implements OrderRepository {

    @Override
    public void save(Order order) {
        System.out.println("[Repository] Order saved: %s".formatted(order));
    }
}

record Order(String id, String item, double amount) {}

public class OrderProcessor {
    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;

    public OrderProcessor(PaymentGateway paymentGateway, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
    }

    public boolean processOrder(Order order) {
        if (paymentGateway.charge(order.amount())) {
            orderRepository.save(order);
            return true;
        }
        System.out.println("Payment failed for order: %s".formatted(order.id()));
        return false;
    }
}


class OrderProcessorDemo {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new StripeGateway();
        OrderRepository orderRepository = new InMemoryOrderRepository();
        OrderProcessor op = new OrderProcessor(paymentGateway, orderRepository);
        Order order = new Order("ORD-001", "Java Course", 29.99);
        op.processOrder(order);
    }
}
