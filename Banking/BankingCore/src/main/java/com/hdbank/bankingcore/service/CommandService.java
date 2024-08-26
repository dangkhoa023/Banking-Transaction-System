package com.hdbank.bankingcore.service;

public interface CommandService<T> {
    void save(T object);


}
