package Handlers.Contract;

public interface HandlerContract<a, b> {
    a handle(b input);
}
