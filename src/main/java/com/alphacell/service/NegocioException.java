package com.alphacell.service;

/**
 * Created by luis on 15/08/16.
 */
public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NegocioException(String msg) {
        super(msg);
    }

}
