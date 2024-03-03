package org.mipams.jumbf.demo.services.jumbf;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.PaddingBox;
import org.mipams.jumbf.util.MipamsException;

import org.springframework.stereotype.Service;

@Service
public class PaddingBoxParser extends BmffBoxParser<PaddingBox> {

    @Override
    protected void populateBox(PaddingBox paddingBox, ObjectNode input) throws MipamsException {
        long payloadSize = input.get("size").asLong();
        paddingBox.setPaddingSize(payloadSize);
    }

    @Override
    protected PaddingBox initializeBox() {
        return new PaddingBox();
    }
}
