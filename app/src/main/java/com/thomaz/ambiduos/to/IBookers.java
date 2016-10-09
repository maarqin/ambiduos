package com.thomaz.ambiduos.to;

import java.io.Serializable;

/**
 * Created by thomaz on 30/09/16.
 */
public interface IBookers extends Serializable {

    /**
     * @return int
     */
    int getId();

    /**
     * @return String
     */
    String getName();

    /**
     * @return String
     */
    String getSubTitle();

    /**
     * @return float
     */
    float getValue();

    /**
     * @return String
     */
    String getDescription();

}
