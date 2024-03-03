package org.mipams.jumbf.demo.services.jumbf;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.FileBox;
import org.mipams.jumbf.util.BadRequestException;
import org.mipams.jumbf.util.CoreUtils;
import org.mipams.jumbf.util.MipamsException;
import org.springframework.beans.factory.annotation.Value;

public abstract class FileBoxParser<T extends FileBox> extends BmffBoxParser<T> {

    @Value("${org.mipams.jumbf.demo.image_folder}")
    String ASSET_DIRECTORY;

    @Override
    protected void populateBox(T fileBox, ObjectNode input) throws MipamsException {

        if (input == null) {
            throw new BadRequestException(
                    "Expected input for box type " + fileBox.getType() + " but nothing found");
        }

        String fileName = input.get("fileName").asText();

        if (fileName == null) {
            throw new BadRequestException("Path is not specified");
        }

        String path = CoreUtils.getFullPath(ASSET_DIRECTORY, fileName);

        fileBox.setFileUrl(path);
    }
}
