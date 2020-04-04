package com.company.Lib.Dao;

import java.util.List;

public interface RepositoryInterface<E>
{
    E take();
    List<E> takeList(int limit);
}