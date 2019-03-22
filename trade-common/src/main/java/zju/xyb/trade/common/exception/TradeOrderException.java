package zju.xyb.trade.common.exception;

public class TradeOrderException extends RuntimeException {

    private static final long serialVersionUID = -6644876343561864131L;

    public TradeOrderException() {
        super();
    }

    public TradeOrderException(String message) {
        super(message);
    }
}
