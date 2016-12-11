/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author camm
 */
public class Utils {

    /**
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }
}
