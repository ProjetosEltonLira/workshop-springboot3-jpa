package br.com.portifolioLira.curso.entities.enums;

public enum OrderStatus {

    WAITING_PAIMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    //para colocar os números, precisa criar o construtor.

    private int code;
    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static  OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código do status do pedido inválido");
    }
}
