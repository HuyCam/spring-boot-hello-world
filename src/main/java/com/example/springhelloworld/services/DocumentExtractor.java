package com.example.springhelloworld.services;

import com.example.springhelloworld.HelloWorldCommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.text.html.HTMLDocument;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DocumentExtractor {

    Logger logger = LoggerFactory.getLogger(DocumentExtractor.class);

    @Value("${input.path}")
    String inputPath;

    @Value("${output.path}")
    String outputPath;

    public String getDocument(String id) {
        logger.info("Extracting some document mock");
        logger.info("Extracting finished");
         return "Document here: " + id;
    }

    public boolean convertDocument(String documentName) throws IOException {
        File inputFile = new File(inputPath + documentName);
        File outputFile = new File(outputPath + "somename");
        Iterator iterator = ImageIO.getImageReadersByFormatName("TIF");

        List<BufferedImage> images = new ArrayList<BufferedImage>();
        while (iterator.hasNext()) {
            images.add((BufferedImage) iterator.next());
        }

        // Obtain a TIFF writer
        ImageWriter writer = ImageIO.getImageWritersByFormatName("PNG").next();

        try (ImageOutputStream output = ImageIO.createImageOutputStream(outputFile)) {
            writer.setOutput(output);

            ImageWriteParam params = writer.getDefaultWriteParam();
            params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            params.setCompressionType("None");

            //error here: java.lang.UnsupportedOperationException: Unsupported write variant!
            writer.prepareWriteSequence(null);

            for (int i = 0; i < images.size(); i++){
                writer.writeToSequence(new IIOImage(images.get(i), null, null), params);
            }

            // We're done
            writer.endWriteSequence();
        }

        return true;
    }
}
