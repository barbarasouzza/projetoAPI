package com.example.tf.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.tf.enums.PedidoStatus;

@Converter
public class PedidoStatusConverter implements AttributeConverter<PedidoStatus, Integer>{

	 @Override
	    public Integer convertToDatabaseColumn(PedidoStatus pedidoStatus) {
	        if (pedidoStatus==null) {
	            return null;
	        }
	        return pedidoStatus.getPedidoStatusCode();
	    }

	    @Override
	    public PedidoStatus convertToEntityAttribute(Integer pedidoStatusCode) {
	        if (pedidoStatusCode==null) {
	            return null;
	        }

	        for(PedidoStatus status: PedidoStatus.values()) {
	            if (status.getPedidoStatusCode()==pedidoStatusCode.intValue()) {
	                return status;
	            }
	        }
	        throw new IllegalArgumentException();
	    }


	}
