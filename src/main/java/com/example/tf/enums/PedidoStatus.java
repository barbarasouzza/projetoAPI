package com.example.tf.enums;

public enum PedidoStatus {

	AGUARDANDO_PAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO(5);

    private int pedidoStatusCode;

    private PedidoStatus(int pedidoStatusCode) {
        this.pedidoStatusCode = pedidoStatusCode;
    }

    public int getPedidoStatusCode() {
        return pedidoStatusCode;
    }

    public static PedidoStatus valueOf(int pedidoStatusCode) {
        for (PedidoStatus value : PedidoStatus.values()) {
            if (value.getPedidoStatusCode() == pedidoStatusCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Esse código é invalido para o status do pedido");
    }
}
