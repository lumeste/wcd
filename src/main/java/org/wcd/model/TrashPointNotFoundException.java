package org.wcd.model;


import org.springframework.dao.EmptyResultDataAccessException;

public class TrashPointNotFoundException extends EmptyResultDataAccessException {

    private static final int EXPECTED_SIZE = 1;

    public TrashPointNotFoundException(String msg) {
        super(msg, EXPECTED_SIZE);
    }

}
