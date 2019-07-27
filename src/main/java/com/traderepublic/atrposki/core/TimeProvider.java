package com.traderepublic.atrposki.core;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import java.sql.Timestamp;

public interface TimeProvider {
    Timestamp now();

    Timestamp beforeMinutes(int minutes);
}
