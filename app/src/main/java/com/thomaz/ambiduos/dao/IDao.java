package com.thomaz.ambiduos.dao;

import java.util.List;

/**
 * Created by thomaz on 30/09/16.
 */

public interface IDao<T, PK> {

    /**
     * @return T
     */
    List<T> all();


    /**
     * @param pk PK
     * @return T
     */
    T findById(PK pk);
}
