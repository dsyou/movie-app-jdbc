package pl.dsyou.handler;

public interface CmdHandler<T> {
    void handle(T command);
}
