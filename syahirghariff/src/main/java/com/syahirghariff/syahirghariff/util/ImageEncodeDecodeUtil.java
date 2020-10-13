/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.util;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author syahirghariff
 */
public class ImageEncodeDecodeUtil {

    public static Blob base64ToBlob(String base64Img) {

        try {
            byte[] decodeByte = Base64.getDecoder().decode(base64Img);
            Blob blob = new SerialBlob(decodeByte);
            return blob;
        } catch (SQLException ex) {
            Logger.getLogger(ImageEncodeDecodeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static String blobToBase64(Blob image) {

        try {
            
            byte[] bytes = image.getBytes(1, (int) image.length());
            String encodedImage = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(bytes);
            image.free();
            
            return encodedImage;

        } catch (SQLException ex) {
            Logger.getLogger(ImageEncodeDecodeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }

}
